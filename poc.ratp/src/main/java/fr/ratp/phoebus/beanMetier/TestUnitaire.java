package fr.ratp.phoebus.beanMetier;


public class TestUnitaire  {

    private int id_test;
    private String classe_test;
    private String nom;
    private String valeur;
    private String context_json;
    private String description;
    
    public int getId_test() {
		return id_test;
	}

    public void setId_test(int id_test) {
		this.id_test = id_test;
	}

    public String getClasse_test() {
		return classe_test;
	}

    public void setClasse_test(String classe_test) {
		this.classe_test = classe_test;
	}

	
	public String getContext_json() {
		return context_json;
	}

	public void setContext_json(String context_json) {
		this.context_json = context_json;
	}

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

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
   
}
