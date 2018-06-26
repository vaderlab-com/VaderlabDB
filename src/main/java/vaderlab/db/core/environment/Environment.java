package vaderlab.db.core.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration("environment")
@ComponentScan
public class Environment {

    public static final String E_LOGGER_TYPE = "VADERLAB_DB_LOGGER_TYPE";

    /**
     * @return
     */
    public Map<String, String> getEnv() {
        return System.getenv();
    }

    /**
     * @param env
     * @return
     */
    public String getEnv( String env ) {
        return System.getenv( env );
    }

    /**
     * @param env
     * @return
     */
    public String getEnv( String env, String def ) {
        String e = this.getEnv( env );

        if( e != null  && !e.equals( "" )) {
            return e;
        }

        return def;
    }
}
