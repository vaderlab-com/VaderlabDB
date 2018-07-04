package vaderlab.db.db;

import vaderlab.db.db.core.TransactionInterface;

public interface DatabaseProvider {

    public TransactionInterface createTransaction();
}
