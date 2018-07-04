package vaderlab.db.db.provider.berkeley;

import vaderlab.db.core.event.EventDispatcherService;
import vaderlab.db.db.core.TransactionInterface;
import vaderlab.db.db.event.PostTransactionAbort;
import vaderlab.db.db.event.PostTransactionCommit;
import vaderlab.db.db.event.PreTransactionAbort;
import vaderlab.db.db.event.PreTransactionCommit;


public class Transaction implements TransactionInterface {

    private com.sleepycat.je.Transaction transaction;
    private EventDispatcherService eventDispatcherService;

    public Transaction(
            com.sleepycat.je.Transaction transaction,
            EventDispatcherService eventDispatcherService
    ) {
        this.transaction = transaction;
        this.eventDispatcherService = eventDispatcherService;
    }

    public void commit() {
        this.eventDispatcherService.dispatch( new PreTransactionCommit( this ));
        transaction.commit();
        this.eventDispatcherService.dispatch( new PostTransactionCommit( this ));
    }

    public void abort() {
        this.eventDispatcherService.dispatch( new PreTransactionAbort( this ));
        transaction.abort();
        this.eventDispatcherService.dispatch( new PostTransactionAbort( this ));
    }

    @Override
    public boolean equals( Object obj ) {

        boolean equals = false;

        if( obj instanceof Transaction ) {
            equals = transaction.equals( ( ( Transaction ) obj ).transaction );
        }

        return equals;
    }
}
