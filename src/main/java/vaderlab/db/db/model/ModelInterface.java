package vaderlab.db.db.model;

import java.util.HashMap;

public interface ModelInterface {

    String getId();

    String _get( String key );

    ModelInterface _set( String key, String value );
}
