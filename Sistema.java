public class Sistema {
    
    private static Sistema sistema;
    
    private Sistema() {
    }
    
    public static Sistema getInstance() {
        
        if(sistema == null) sistema = new Sistema();
        
        return sistema;
    }
    
}
