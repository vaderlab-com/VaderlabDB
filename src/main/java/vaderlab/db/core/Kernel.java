package vaderlab.db.core;


import java.util.ArrayList;
import java.util.Collection;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import vaderlab.db.core.event.Event;
import vaderlab.db.core.event.EventDispatcherService;
import vaderlab.db.core.module.Module;
import vaderlab.db.core.module.ModuleAlreadyRegisteredException;
import vaderlab.db.logger.LoggerService;

public class Kernel {

    private EventDispatcherService eventDispatcher;

    private ApplicationContext  container;

    private Collection<Module>  registeredModules;

    private String              environment;

    private boolean             booted;

    private LoggerService       loggerFactory;

    /**
     * @param context
     * @param environment
     */
    public Kernel( ApplicationContext context, String environment ) {
        this.booted             = false;
        this.environment        = environment;
        this.container          = context;
        this.eventDispatcher    = (EventDispatcherService) context.getBean( "event.dispatcher_service" );
        this.registeredModules  = new ArrayList<Module>();
    }

    /**
     * Register modules collection
     * @param modules array with modules
     * @throws ModuleAlreadyRegisteredException
     */
    public void registerModules(Collection<Module> modules) throws ModuleAlreadyRegisteredException
    {
        for (Module module: modules ) {
            registerModule(module);
        }
    }

    /**
     * Register module
     * @param module module instance
     * @throws ModuleAlreadyRegisteredException
     */
    public void registerModule(Module module) throws ModuleAlreadyRegisteredException
    {
        if(registeredModules.contains(module)) {
            throw new ModuleAlreadyRegisteredException();
        }

        module.dependencyInject(container);
        registeredModules.add(module);
    }

    /**
     * @return Registered modules
     */
    public Collection<Module> getRegisteredModules()
    {
        return registeredModules;
    }

    /**
     * @return environment mode
     */
    public String getEnvironment()
    {
        return environment;
    }

    /**
     * @return ApplicationContext|null
     */
    public ApplicationContext getContainer()
    {
        return container;
    }

    /**
     *
     */
    public void run()
    {
        if(booted) {
            return;
        }

        booted              = true;
        eventDispatcher     = (EventDispatcherService)container.getBean("event.dispatcher_service");

        this.registerListeners();
        eventDispatcher.dispatch(new KernelEvent(KernelEvent.EVT_RUN));
    }

    public void shutdown()
    {
        if(!booted) {
            return;
        }

        eventDispatcher.dispatch(new KernelEvent(KernelEvent.EVT_SHUTDOWN));
    }

    protected void registerListeners()
    {
        registerLogger();
    }

    private void registerLogger()
    {
        eventDispatcher.addListener(new ApplicationListener<Event>() {
            @Override
            public void onApplicationEvent(Event event) {
                LoggerService logger = (LoggerService) container.getBean( "logger" );
                logger.getLogger().debug( event.toString() );
            }
        });
    }
}
