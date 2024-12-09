import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void Main() {
        
        JSONObject json = new JSONObject();
        
        JSONHandler handler = new JSONHandler();
        
        /**JSONArray array = new JSONArray();
        
        JSONParser parser = new JSONParser();**/
        
        json.put("Nome", "Jean");
        json.put("Idade", 20);
        
        long aaaa = 00001;
        
        if(handler.locate(aaaa, "clientes.json") != null) {
            
            System.out.print("Cliente já existe.");
            
        }
        else System.out.print("Não existe.");
        
        /**array.add(json);
        
        try(BufferedWriter clientes = new BufferedWriter(new FileWriter("clientes.json", true))) {
            
            clientes.write(array.toJSONString());
            clientes.newLine();
            
            System.out.print("Cliente inserido com sucesso.\n");
        }
        
        catch(IOException e) {
            e.printStackTrace();
        }
        
        try {
            
            JSONArray clientel = (JSONArray) parser.parse(new FileReader("clientes.json"));
            
            for(Object obj : clientel) {
                
                JSONObject fufufu = (JSONObject) obj;
                
                System.out.println((String) fufufu.get("Nome"));
                
            }
            
            JSONObject jsonObj = (JSONObject) obj;
            
            String name = (String) jsonObj.get("Nome");
            long age = (long) jsonObj.get("Idade");
            
            System.out.print("Nome: " + name  + "\nIdade: " + age);
        }
        catch (IOException | ParseException e) {e.printStackTrace();}**/
        
    }
    
}
