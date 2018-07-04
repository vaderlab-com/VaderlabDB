package vaderlab.db.db.event;

import vaderlab.db.db.core.TransactionInterface;

public class PreTransactionCommit extends AbstractTransactionEvent {

    public PreTransactionCommit(TransactionInterface transaction) {
        super(transaction);
    }
}
