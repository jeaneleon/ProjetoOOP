public class Cliente {
    
    private long id;
    private String nome;
    private String dataNascimento;
    private long cpf;
    private String endereco;
    
    
    public void setId(long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}
    public void setCpf(long cpf) {this.cpf = cpf;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    
    public long getId() {return this.id;}
}
