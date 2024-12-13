import java.util.List;
import java.util.ArrayList;

public class Atendimento {
    
    private long id;
    
    private Venda venda;
    
    private Servico servico;
    
    private String data;
    
    private Cliente cliente;
    
    private Atendente atendente;
    
    private double valorTotal;
    
    private String status;
    
    
    public void setId(long id) {this.id = id;}

    public void setCliente(Cliente c) {this.cliente = c;}
            
    public void setAtendente(Atendente atendente) {this.atendente = atendente;}
    
    public void setStatus(String status) {this.status = status;}
    
    public long getId() {return this.id;}
    
    public Venda getVenda() {return venda;}
    
    public Servico getServico() {return servico;}
    
    public String getStatus() {return this.status;}
    
}
