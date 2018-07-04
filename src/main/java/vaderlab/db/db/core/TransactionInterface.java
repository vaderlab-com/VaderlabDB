package vaderlab.db.db.core;

public interface TransactionInterface {

    boolean equals( Object obj );

    void commit();

    void abort();
}
