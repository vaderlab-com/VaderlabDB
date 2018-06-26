package vaderlab.db.logger;

import java.util.function.Supplier;

public interface LoggerProviderInterface {

    /**
     *
     * @param msg
     */
    void info( String msg );

    /**
     *
     * @param msgSupplier
     */
    void info( Supplier<String> msgSupplier );

    /**
     *
     * @param msg
     */
    void warning( String msg );

    /**
     *
     * @param msgSupplier
     */
    void warning( Supplier<String> msgSupplier );

    /**
     *
     * @param msg
     */
    void fine( String msg );

    /**
     *
     * @param msgSupplier
     */
    void fine( Supplier<String> msgSupplier );

    /**
     *
     * @param msg
     */
    void severe( String msg );

    /**
     *
     * @param msgSupplier
     */
    void severe( Supplier<String> msgSupplier );

    /**
     *
     * @param msg
     */
    void debug( String msg );
}
