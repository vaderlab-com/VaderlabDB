package vaderlab.db.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import vaderlab.db.core.event.EventDispatcherService;
import vaderlab.db.core.module.Module;
import vaderlab.db.core.module.ModuleException;

import java.util.Arrays;

/**
 * Created by kost on 3.6.16.
 */
public class AppKernel extends Kernel {

    public AppKernel(ApplicationContext context, String environment) throws ModuleException
    {
        super(context, environment);

        // Register modules
        Module[] modules= {
        };

        registerModules(Arrays.asList(modules));
    }

}
