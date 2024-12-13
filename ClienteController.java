import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ClienteController {
    
    public List<Cliente> clientes = new ArrayList<Cliente>();
    
    private static ClienteController instancia;
    
    private ClienteController() {}
    
    public static ClienteController getInstancia() {
        
        if(instancia == null) instancia = new ClienteController();
        
        return instancia;
    }
    
    public Cliente cadastrarCliente(String nome, String dataNascimento, long cpf, String endereco) {
        
        Random rand = new Random();
        
        Cliente c = new Cliente();
        
        c.setId(rand.nextLong(100000));
        c.setNome(nome);
        c.setDataNascimento(dataNascimento);
        c.setCpf(cpf);
        c.setEndereco(endereco);
        
        clientes.add(c);
        
        return c;
    }
    
    public Cliente buscarCliente(long id) {
        
        Cliente encontrado = null;
        
        for(Cliente buscado : clientes) if(buscado.getId() == id) encontrado = buscado;
        
        return encontrado;
    }
    
}
