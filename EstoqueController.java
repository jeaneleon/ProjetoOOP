import java.util.Random;

public class EstoqueController {
    
    private Estoque estoque;
    
    private static EstoqueController instancia;
    
    private EstoqueController() {}
    
    public static EstoqueController getInstancia() {
        
        if(instancia == null) instancia = new EstoqueController();
        
        return instancia;
    }
    
    public void addNovoProdutoEstoque(String nome, String dataValidade, String descricao) {
        
        Random rand = new Random();
        
        Produto p = new Produto();
        
        p.setNome(nome);
        p.setDescricao(descricao);
        
        ItemEstoque item = new ItemEstoque();
        
        item.setDataValidade(dataValidade);
        item.setId(rand.nextLong());
        
    }
    
    public ItemEstoque buscarProdutoEstoque(long id) {
        
        ItemEstoque produto = null;
        
        for(ItemEstoque item : estoque.getItens()) {
            
            if(item.getId() == id) produto = item;
        }
        return produto;
    }
    
}
