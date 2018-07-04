package vaderlab.db.db.provider.berkeley;

import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vaderlab.db.db.throwable.DatabaseInvalidPath;

import java.io.File;

@Configuration("database.provider.berkeley.environment")
@ComponentScan
public class EnvironmentFactory {

    public Environment createEnvironment( File dbPath ) throws DatabaseInvalidPath {

        checkPath( dbPath );

        EnvironmentConfig envCfg = new EnvironmentConfig();

        envCfg.setAllowCreate( true );
        envCfg.setTransactional( true );
        envCfg.setCacheSize( 1000000 );

        Environment env = new Environment( dbPath, envCfg );

        return env;
    }


    protected void checkPath( File dbPath ) throws DatabaseInvalidPath {
        Integer code = 0;

        /** @todo: Invalid */
        if( !dbPath.exists() && !dbPath.mkdirs() ) {

            throw new DatabaseInvalidPath( DatabaseInvalidPath.E_NO_EXISTS, dbPath );
        }

        if( !dbPath.isDirectory() ) {
            code |= DatabaseInvalidPath.E_IS_FILE;
        }

        if( !dbPath.canWrite() ) {
            code |= DatabaseInvalidPath.E_NO_WRITABLE;
        }

        if( !dbPath.canRead() ) {
            code |= DatabaseInvalidPath.E_NO_WRITABLE;
        }

        if( code == 0 ) {
            return;
        }

        throw new DatabaseInvalidPath( code, dbPath );
    }
}
