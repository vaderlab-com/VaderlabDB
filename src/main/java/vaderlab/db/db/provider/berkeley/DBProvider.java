package vaderlab.db.db.provider.berkeley;

import com.sleepycat.je.Environment;
import com.sleepycat.je.TransactionConfig;
import org.springframework.context.ApplicationContext;
import vaderlab.db.core.event.EventDispatcherService;
import vaderlab.db.db.DatabaseProvider;
import vaderlab.db.db.core.TransactionInterface;
import vaderlab.db.db.throwable.DatabaseInvalidPath;
import vaderlab.db.logger.LoggerService;

import java.io.File;

public class DBProvider implements DatabaseProvider {

    private EnvironmentFactory factory;
    private Environment dbEnv;
    private String name;
    private ApplicationContext applicationContext;

    public DBProvider(
            ApplicationContext applicationContext,
            String name
    ) {
        this.name = name;
        this.applicationContext = applicationContext;

        this.init();
    }

    /**
     * @todo: Exceptions and environment configuration
     */
    private void init() {
        factory = ( EnvironmentFactory ) applicationContext.getBean( "database.provider.berkeley.environment" );
        try {
            dbEnv = factory.createEnvironment( new File("storage/" + name ) );
        } catch ( DatabaseInvalidPath err ) {
            System.out.println( "AAAAaaaAAA " + err.getMessage() + "( " + err.getCode() + " )" );
            System.exit( 1 );
        }
    }

    @Override
    public TransactionInterface createTransaction() {
        TransactionConfig config = new TransactionConfig();
        config.setReadUncommitted(true);

        return new Transaction(
            dbEnv.beginTransaction( null, config),
            ( ( EventDispatcherService ) applicationContext.getBean( "event.dispatcher_service" ) )
        );
    }
}
