package fr.ratp.phoebus.beanMetier;

/**
 * Created by vermelinj on 16/06/2015.
 */
public class Regime extends AbstractCacheableBean {

    private int id;
    private String nom;
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String getKey() {
        return getNom();
    }
}
