package vaderlab.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vaderlab.db.core.AppKernel;
import vaderlab.db.core.Kernel;
import vaderlab.db.core.module.ModuleException;
import vaderlab.db.db.DatabaseFactory;
import vaderlab.db.db.DatabaseProvider;


@SpringBootApplication
public class VaderlabDB {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(VaderlabDB.class,args);
        Kernel kernel;
        DatabaseFactory dbp = (DatabaseFactory)context.getBean("database.factory");

        try {
            kernel= new AppKernel(context, "dev");
            kernel.run();

            dbp.database("test");

            kernel.shutdown();
        } catch (ModuleException ex) {
            System.out.println(ex.toString());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
