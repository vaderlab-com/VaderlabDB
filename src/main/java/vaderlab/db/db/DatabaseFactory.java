package vaderlab.db.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vaderlab.db.core.environment.Environment;
import vaderlab.db.core.event.EventDispatcherService;
import vaderlab.db.db.event.DBCreate;
import vaderlab.db.db.event.DBError;
import vaderlab.db.db.throwable.DatabaseAlreadyExists;

import java.util.HashMap;

@Configuration("database.factory")
@ComponentScan
public class DatabaseFactory {

    private HashMap<String, DatabaseProvider> databases;

    private EventDispatcherService eventDispatcherService;

    @Autowired(required=true)
    DatabaseFactory( EventDispatcherService eventDispatcherService ) {

        this.eventDispatcherService = eventDispatcherService;
        this.databases = new HashMap<>();
    }

    public DatabaseProvider database( String name ) {
        if( databaseContains( name ) ) {
            return databases.get( name );
        }

        DatabaseProvider dbp = null;

        try {
            dbp = databaseCreate( name );
        } catch ( DatabaseAlreadyExists e) {
            eventDispatcherService.dispatch( new DBError( DBError.E_ALREADY_EXISTS, name, null ));
        }

        return dbp;
    }

    public DatabaseProvider databaseCreate( String database ) throws DatabaseAlreadyExists {
        if( this.databaseContains( database ) ) {
            throw new DatabaseAlreadyExists( );
        }

        eventDispatcherService.dispatch( new DBCreate( database ));

        return null;
    }

    public boolean databaseContains( String database ) {
        return this.databases.containsKey( database );
    }
}
