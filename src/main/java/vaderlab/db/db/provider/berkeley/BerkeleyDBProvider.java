package vaderlab.db.db.provider.berkeley;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vaderlab.db.db.DatabaseProvider;
import vaderlab.db.db.core.TransactionInterface;

@Configuration("database.provider.berkeley")
@ComponentScan
public class BerkeleyDBProvider implements DatabaseProvider {

    @Override
    public TransactionInterface startTransaction() {
        return null;
    }

    @Override
    public void commit() {

    }

    @Override
    public void finishTransaction(TransactionInterface transaction) {

    }
}
