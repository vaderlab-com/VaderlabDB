package vaderlab.db.logger.provider;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vaderlab.db.logger.LoggerProviderInterface;

import java.util.function.Supplier;
import java.util.logging.Logger;

@Configuration("logger.provider.default")
@ComponentScan
public class DefaultProvider implements LoggerProviderInterface {

    private final Logger logger;

    DefaultProvider() {
        logger = Logger.getGlobal();
    }

    /**
     *
     * @param msg
     */
    public void info( String msg ) {
        logger.info( msg );
    }

    /**
     *
     * @param msgSupplier
     */
    public void info( Supplier<String> msgSupplier ) {
        logger.info( msgSupplier );
    }

    /**
     *
     * @param msg
     */
    public void warning( String msg ) {
        logger.warning( msg );
    }

    /**
     *
     * @param msgSupplier
     */
    public void warning( Supplier<String> msgSupplier ) {
        logger.warning( msgSupplier );
    }

    /**
     *
     * @param msg
     */
    public void fine( String msg ) {
        logger.fine( msg );
    }

    /**
     *
     * @param msgSupplier
     */
    public void fine( Supplier<String> msgSupplier ) {
        logger.fine( msgSupplier );
    }

    /**
     *
     * @param msg
     */
    public void severe( String msg ) {
        logger.severe( msg );
    }

    /**
     *
     * @param msgSupplier
     */
    public void severe( Supplier<String> msgSupplier ) {
        logger.severe( msgSupplier );
    }

    /**
     *
     * @param msg
     */
    public void debug( String msg ) {
        logger.severe( msg );
    }


}
