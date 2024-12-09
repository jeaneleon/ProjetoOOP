import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class JSONController {
    
    public JSONObject locate(Object criteria, String doc) {
        
        if(criteria instanceof String) return locateNome((String) criteria, doc);
        
        else return locateID((long) criteria, doc);
    }
    
    private JSONObject locateNome(String criteria, String doc) {
        
        JSONObject match = null;
        
        try {
            
            JSONParser parser = new JSONParser();
            
            JSONArray file = (JSONArray) parser.parse(new FileReader(doc));
            
            for(Object obj : file) {
                
                JSONObject aux = (JSONObject) obj;
                
                String nome = (String) aux.get("Nome");
                
                if(criteria.equalsIgnoreCase(nome)) match = aux;
                
            } }
            
        catch (IOException | ParseException e) {e.printStackTrace();}
        
        return match;
    }
    
    private JSONObject locateID(long criteria, String doc) {
        
        JSONObject match = null;
        
        try {
            
            JSONParser parser = new JSONParser();
            
            JSONArray file = (JSONArray) parser.parse(new FileReader(doc));
            
            for(Object obj : file) {
                
                JSONObject aux = (JSONObject) obj;
                
                long ID = (long) aux.get("ID");
                
                if(criteria == ID) match = aux;
                
            } }
            
        catch (IOException | ParseException e) {e.printStackTrace();}
        
        return match;
    }
    
    private JSONObject replace(JSONObject novo, String doc) {
        
        int cont = 1;
        
        JSONObject replaced = null;
        
        JSONObject something = locate(novo.get("ID"), doc);
        
        if (something != null) {
            
            try {
                
                JSONParser parser = new JSONParser();
                
                JSONArray file = (JSONArray) parser.parse(new FileReader(doc));
                
                for(Object obj : file) {
                    
                    JSONObject aux = (JSONObject) obj;
                    
                    long ID = (long) aux.get("ID");
                    
                    if((long) novo.get("ID") != ID) cont++;
                    
                    else break;
                }
            }
            catch (IOException | ParseException e) {e.printStackTrace();}
            
            
            
        }
        
        return replaced;
    }
    
    public void delete() {
        
        
    }
    
}
