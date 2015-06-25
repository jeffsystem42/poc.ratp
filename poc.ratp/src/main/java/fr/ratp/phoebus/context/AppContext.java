package fr.ratp.phoebus.context;

import org.springframework.context.ApplicationContext;

/**
 * Classe permettant de r�cup�rer l'ApplicationContext de mani�re statique
 */
public class AppContext {

private static ApplicationContext ctx;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        return ctx;
    }



}
