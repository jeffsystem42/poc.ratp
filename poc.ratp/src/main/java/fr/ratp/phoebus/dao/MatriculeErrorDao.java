package fr.ratp.phoebus.dao;

/**
 * Expose les m�thodes d'acc�s � la table MATRICULE_ERROR
 */
public interface MatriculeErrorDao {

    /**
     * Ins�re une ligne
     */
    void insert(String matricule, String motif);
}
