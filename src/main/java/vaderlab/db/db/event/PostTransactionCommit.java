package vaderlab.db.db.event;

import vaderlab.db.db.core.TransactionInterface;

public class PostTransactionCommit extends AbstractTransactionEvent {
    public PostTransactionCommit(TransactionInterface transaction) {
        super(transaction);
    }
}
