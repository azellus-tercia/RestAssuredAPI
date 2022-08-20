package runner;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseProperties {

    private static final String ENV_APP_OPTIONS = "APP_OPTIONS";

    private static Properties properties;
    private static Gson gson;

    private static void initProperties() {
        if (properties == null) {
            properties = new Properties();
            if (isServerRun()) {
                properties.setProperty(ENV_APP_OPTIONS, System.getenv(ENV_APP_OPTIONS));
            } else {
                try {
                    InputStream inputStream = BaseProperties.class.getClassLoader().getResourceAsStream("local.properties");
                    if (inputStream == null) {
                        System.out.println("ERROR: The \u001B[31mlocal.properties\u001B[0m file not found in src/test/resources/ directory.");
                        System.out.println("You need to create it from local.properties.TEMPLATE file.");
                        System.exit(1);
                    }
                    properties.load(inputStream);
                } catch (IOException ignore) {
                }
            }
        }
    }

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    private static void initGson() {
        gson = new Gson();
    }

    static {
        initProperties();
        initGson();
    }

    static Properties getProperties() {
        return properties;
    }

    static Gson getGson() {
        return gson;
    }
}
