package vaderlab.db.db.event;

import vaderlab.db.db.core.TransactionInterface;

public class PreTransactionAbort extends AbstractTransactionEvent {
    public PreTransactionAbort(TransactionInterface transaction) {
        super(transaction);
    }
}
