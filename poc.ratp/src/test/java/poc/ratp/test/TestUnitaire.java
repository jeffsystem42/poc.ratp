package poc.ratp.test;


public class TestUnitaire  {

    private int id_test;
    private String classe_test;
    private long valeur_before;
    private long valeur_after;
    private String context_json;
    
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

	public long getValeur_before() {
		return valeur_before;
	}

	public void setValeur_before(long valeur_before) {
		this.valeur_before = valeur_before;
	}

	public long getValeur_after() {
		return valeur_after;
	}

	public void setValeur_after(long valeur_after) {
		this.valeur_after = valeur_after;
	}

	public String getContext_json() {
		return context_json;
	}

	public void setContext_json(String context_json) {
		this.context_json = context_json;
	}
   
}
