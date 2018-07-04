package vaderlab.db.db.event;

import vaderlab.db.db.core.TransactionInterface;

public class PostTransactionAbort extends AbstractTransactionEvent {
    public PostTransactionAbort(TransactionInterface transaction) {
        super(transaction);
    }
}
