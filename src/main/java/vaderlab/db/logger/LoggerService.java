package vaderlab.db.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vaderlab.db.core.environment.Environment;
import vaderlab.db.logger.provider.DefaultProvider;

import java.util.HashMap;

@Configuration("logger")
@ComponentScan
public class LoggerService {

    private Environment env;

    private HashMap<String, LoggerProviderInterface> loggerProviders;

    @Autowired(required=true)
    public LoggerService(
            Environment env,
            DefaultProvider dp
    ) {

        this.env = env;
        this.loggerProviders = new HashMap<>();

        /** @todo: */
        this.loggerProviders.put( "default", dp );
    }

    public LoggerProviderInterface getLogger() {
        return loggerProviders.get( env.getEnv( Environment.E_LOGGER_TYPE, "default" ) );
    }
}
