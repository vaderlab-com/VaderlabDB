package vaderlab.db.db.event;

import vaderlab.db.core.event.Event;
import vaderlab.db.db.core.TransactionInterface;

public abstract class AbstractTransactionEvent extends Event {

    private TransactionInterface transaction;

    public AbstractTransactionEvent(TransactionInterface transaction) {
        super(transaction);

        this.transaction = transaction;
    }

    public TransactionInterface getTransaction() {
        return transaction;
    }
}
