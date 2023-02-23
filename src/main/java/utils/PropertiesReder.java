package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesReder implements IUtils {
    @Override
    public Map<String, String> read(){

        Map<String,String> prop = new HashMap<>();

        try (InputStream inputStream = new FileInputStream("src/main/resources/authorization.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);

            Set<Map.Entry<Object,Object>>entries = properties.entrySet();
            for (Map.Entry<Object,Object> entry: entries){
                prop.put(entry.getKey().toString(),entry.getValue().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}










