package vaderlab.db.db.model;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;
import com.sun.org.apache.bcel.internal.generic.IFNULL;
import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

import static com.sleepycat.persist.model.DeleteAction.NULLIFY;

@Entity
public class Relation extends AbstractModel {

    final public static Integer DIRECTIONAL_UNI = 1;

    final public static Integer DIRECTIONAL_BI = 2;

    @PrimaryKey()
    private String id;

    @SecondaryKey( relate=Relationship.MANY_TO_ONE )
    private Integer directional = DIRECTIONAL_UNI;

    @SecondaryKey(
        relate = Relationship.MANY_TO_ONE,
        relatedEntity = Node.class,
        onRelatedEntityDelete = NULLIFY
    )
    private String nodeParent;

    @SecondaryKey(
            relate = Relationship.MANY_TO_ONE,
            relatedEntity = Node.class,
            onRelatedEntityDelete = NULLIFY
    )
    private String nodeChild;

    private HashMap<String, String> properties = new HashMap<>();

    @Override
    public String getId() {
        return id;
    }

    public Relation setParent( String nodeId ) {
        this.nodeParent = nodeId;

        return this;
    }

    public String getParent() {
        return nodeParent;
    }

    public Relation setChild( String nodeId ) {
        this.nodeChild = nodeId;

        return this;
    }

    public String getChild() {
        return nodeChild;
    }

    @Override
    public String _get( String key ) {
        return properties.get( key );
    }

    @Override
    public ModelInterface _set( String key, String value ) {
        properties.put( key, value );

        return this;
    }

    public Integer getDirectional() {
        return directional;
    }

    public Relation setDirectional(Integer directional) {
        this.directional = directional;

        return this;
    }
}
