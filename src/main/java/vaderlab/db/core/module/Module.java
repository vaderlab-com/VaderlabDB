package vaderlab.db.core.module;

import org.springframework.context.ApplicationContext;

/**
 * Created by kost on 3.6.16.
 */
public class Module {

    public void configure()
    {
    }

    public void dependencyInject(ApplicationContext container)
    {
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean equals(Object o)
    {
        return getClass().getName().equals(o.getClass().getName());
    }
}
