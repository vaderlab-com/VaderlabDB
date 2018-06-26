package vaderlab.db.db.model;

public interface NodeInterface<T extends NodeInterface> {

    String getId();

    Object getValue();

    NodeInterface setValue( Object value );

    Integer getType();
}
