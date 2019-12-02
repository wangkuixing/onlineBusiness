import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

public class GlobalConfig {
    public BusConfig bus;

    public static String url="url";

    public static GlobalConfig load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            GlobalConfig config=mapper.readValue(GlobalConfig.class.getResource(path), GlobalConfig.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        GlobalConfig config=GlobalConfig.load("globalConfig.yaml");
        System.out.println(config.bus.url);
    }
}
