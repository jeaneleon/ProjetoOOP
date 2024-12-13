import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class AtendimentoController {
    
    public List<Atendimento> atendimentos = new ArrayList<Atendimento>();
    
    private static AtendimentoController instancia;
    
    private AtendimentoController() {}
    
    public static AtendimentoController getInstancia() {
        
        if(instancia == null) instancia = new AtendimentoController();
        
        return instancia;
    }
    
    public Atendimento novoAtendimento(long clienteId) {
        
        Atendimento a = new Atendimento();
        
        Random rand = new Random();
        
        a.setId(rand.nextLong(100000));
        
        a.setCliente(ClienteController.getInstancia().buscarCliente(clienteId));
        
        a.setAtendente(Sistema.getInstancia().getAtendenteLogado());
        
        a.setStatus("Pendente");
        
        atendimentos.add(a);
        
        return a;
    }
    
    public Atendimento buscarAtendimento(long atendimentoId) {
        
        Atendimento atendimento = null;
        
        for(Atendimento a : atendimentos) {
            
            if(a.getId() == atendimentoId) {
                
                atendimento = a;
                break;
            }
        }
        
        return atendimento;
    }
    
    public void addAtendimentoVenda(long atendimentoId, long produtoId, long quantidade) {
        
        Atendimento atendimento = buscarAtendimento(atendimentoId);
        
        if(atendimento.getVenda() == null) atendimento.getVenda() = new Venda();
        
        ItemVenda item = new ItemVenda();
        
        item.setProduto(TabelaPrecoController.getInstancia().getProduto(produtoId));
        item.setQuantidade(quantidade);
        
        atendimento.getVenda().setItemVenda(item);
        
        EstoqueController.getInstancia().buscarProduto(produtoId).deduzir(quantidade);
    }
    
    public void addAtendimentoServico(long atendimentoId, String tipo, long funcionarioId) {
        
        Atendimento atendimento = buscarAtendimento(atendimentoId);
        
        if(atendimento.getServico() == null) atendimento.getServico() = new Servico();
        
        ItemServico item = new ItemServico();
        
        Random rand = new Random();
        
        item.setId(rand.nextLong());
        item.setTipo(tipo);
        item.setFuncionario(funcionarioId);
        item.setStatus("Pendente");
        
        atendimento.getServico().setItemServico(item);
    }
    
    public void finalizarServico(long atendimentoId, long itemServicoId) {
        
        Atendimento atendimento = buscarAtendimento(atendimentoId);
        
        atendimento.getServico().getItemServico(itemServicoId).setStatus("Finalizado");
        
    }
    
    public void finalizarAtendimento(long atendimentoId) {
        
        Atendimento atendimento = buscarAtendimento(atendimentoId);
        
        int cont = 0;
        
        for(ItemServico item : atendimento.getServicos()) if(item.getStatus().equals("Finalizado")) cont++;
        
        if(cont == atendimento.getServicos().size()-1) atendimento.setStatus("Finalizado");
        
    }
    
}


