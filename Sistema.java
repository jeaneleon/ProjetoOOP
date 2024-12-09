public class Sistema {
    
    private static Sistema instancia;
    
    private ClienteController cliente;
    private AtendimentoController atendimento;
    private EstoqueController estoque;
    private TabelaPrecoController tabelaPreco;
    private JSONController json;
    
    private Sistema() {
        
        this.cliente = new ClienteController();
        this.atendimento = new AtendimentoController();
        this.estoque = new EstoqueController();
        this.tabelaPreco = new TabelaPrecoController();
        this.json = new JSONController();
        
    }
    
    public static Sistema getInstancia() {
        
        if(instancia == null) instancia = new Sistema();
        
        return instancia;
    }
    
    public void login(String login, String senha) {}
    
    public void gerarRelatorio(){}
}
