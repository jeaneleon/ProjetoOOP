public class Atendimento {
    
    private long id;
    
    private String data;
    
    private Cliente cliente;
    
    private User user;
    
    private Venda venda;
    private Servico servico;
    
    private double valorTotal;
    
    
    public double getValorTotal() {
        
        return venda.getValorTotal() + servico.getValorTotal();
    }
}
