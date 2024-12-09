import java.util.List;
import java.util.ArrayList;

public class Venda {
    
    private long id;
    
    private List<ItemVenda> itens = new ArrayList<>();
    
    private double valorTotal;
    
    public double getValorTotal() {
        
        double total = 0;
        
        for(ItemVenda item : itens) total += item.getPreco();
        
        return total;
    }
}
