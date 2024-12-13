import org.json.simple.JSONObject;

public class Sistema {
    
    private static Sistema instancia;
    
    private Sistema() {}
    
    public static Sistema getInstancia() {
        
        if(instancia == null) instancia = new Sistema();
        
        return instancia;
    }
    
    public Cliente cadastrarCliente(String nome, String dataNascimento, long cpf, String endereco) {
        
        return ClienteController.getInstancia().cadastrarCliente(nome, dataNascimento, cpf, endereco);
    }
    
    public Cliente buscarCliente(long id) {
        
        return ClienteController.getInstancia().buscarCliente(id);
    }
    
    private Atendente atendenteLogado;
    
    public Atendente login(String login, String senha) {
    
        atendenteLogado = null;
        
        JSONObject obj = JSONController.getInstancia().locate(login, "atendentes.json");
        
        if (obj.get("Senha").equals(senha)) {
            
            atendenteLogado = new Atendente();
            
            atendenteLogado.setNome((String) obj.get("Nome"));
            
            //a.setOutrosAtributos((tipo) obj.get("OutroAtributo"));
        }
        
        return atendenteLogado;
    }
    
    public Atendente getAtendenteLogado() {return this.atendenteLogado;}
    
    public Atendimento novoAtendimento(long clienteId) {
        
        return AtendimentoController.getInstancia().novoAtendimento(clienteId);
    }
    
    public Atendimento buscarAtendimento(long atendimentoId) {
        
        return AtendimentoController.getInstancia().buscarAtendimento(atendimentoId);
    }
    
    public void addAtendimentoVenda(long atendimentoId, long produtoId, long quantidade) {
        
        AtendimentoController.getInstancia().addAtendimentoVenda(atendimentoId, produtoId, quantidade);
    }
    
    public void addAtendimentoServico(long atendimentoId, String tipo, long funcionarioId) {
        
        AtendimentoController.getInstancia().addAtendimentoServico(atendimentoId, tipo, funcionarioId);
    }
    
    public void finalizarServico(long atendimentoId, long itemServicoId) {
        
        AtendimentoController.getInstancia().finalizarServico(atendimentoId, itemServicoId);
    }
    
    public void finalizarAtendimento(long atendimentoId) {
        
        AtendimentoController.getInstancia().finalizarAtendimento(atendimentoId);
    }
    
    public void addNovoProdutoEstoque(String nome, String dataValidade, String descricao) {
        
        EstoqueController.getInstancia().addNovoProdutoEstoque(nome, dataValidade, descricao);
    }
    
    public ItemEstoque buscarProdutoEstoque(long id) {
        
        EstoqueController.getInstancia().buscarProdutoEstoque(id);
    }
    
    public void gerarRelatorio(){}
}
