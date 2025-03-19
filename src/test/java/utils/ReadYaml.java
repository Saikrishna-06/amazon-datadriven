package utils;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class ReadYaml {
    public Map<String, Object> readYaml(String fileName) {
        Yaml yaml = new Yaml();
        InputStream inputStream = ReadYaml.class.getClassLoader().getResourceAsStream(fileName);
        
        if (inputStream == null) {
            throw new RuntimeException("❌ YAML file not found: " + fileName);
        }
        
        return yaml.load(inputStream);
    }
}
