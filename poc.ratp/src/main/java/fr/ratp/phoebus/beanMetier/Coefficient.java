package fr.ratp.phoebus.beanMetier;

/**
 * Created by vermelinj on 16/06/2015.
 */
public class Coefficient extends AbstractCacheableBean {

    private int id;
    private String nom;
    private int valeur;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String getKey() {
        return getNom();
    }
}
