package fr.ratp.phoebus.utils;

/**
 * Created by vermelinj on 17/06/2015.
 */
public class PhoebusUtils {

    /**
     * Renvoie la date du jour au format SQL
     * @return la date du jour au format SQL
     */
    public static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
}
