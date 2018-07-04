package vaderlab.db.db.throwable;

import java.io.File;

public class DatabaseInvalidPath extends Throwable {

    public final static Integer E_NO_EXISTS     = 1;
    public final static Integer E_IS_FILE       = 2;
    public final static Integer E_NO_WRITABLE   = 4;
    public final static Integer E_NO_READABLE   = 8;

    private int code;

    public DatabaseInvalidPath( Integer code, File path ) {
        super( path.getAbsolutePath() );

        this.code  = code;
    }

    public Integer getCode() {
        return code;
    }

}
