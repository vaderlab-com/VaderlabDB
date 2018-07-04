package vaderlab.db.db.model;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;
import com.sleepycat.persist.model.Relationship;
import com.sleepycat.persist.model.SecondaryKey;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Node extends AbstractModel {

    @PrimaryKey()
    private String id;

    @SecondaryKey(
            relate = Relationship.ONE_TO_MANY,
            relatedEntity = Relation.class
    )
    private Set<String> relations = new HashSet<>();

    public Set<String> getRelations() {
        return this.relations;
    }

    public Node putRelation( String relation ) {
        if( relations.contains( relation ) ) {
            return this;
        }

        relations.add( relation );

        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public HashMap<String, String> _get(String key) {
        return null;
    }

    @Override
    public ModelInterface _set(String key, String value) {
        return null;
    }
}
