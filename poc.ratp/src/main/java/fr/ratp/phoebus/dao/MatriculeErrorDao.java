package fr.ratp.phoebus.dao;

/**
 * Expose les méthodes d'accès à la table MATRICULE_ERROR
 */
public interface MatriculeErrorDao {

    /**
     * Insère une ligne
     */
    void insert(String matricule, String motif);
}
