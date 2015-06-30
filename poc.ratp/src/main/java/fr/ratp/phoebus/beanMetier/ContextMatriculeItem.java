package fr.ratp.phoebus.beanMetier;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Bean contenant les informations sur un agent passées d'itemProcessor en itemProcessor
 */
public class ContextMatriculeItem {

    private String matricule;
    private Date dateTrt;
    private int prime1;
    private int prime2;
    private int prime3;
    private PrimeT primeT;
    
    public BigDecimal getCompteurA() {
		return compteurA;
	}

	public void setCompteurA(BigDecimal compteurA) {
		this.compteurA = compteurA;
	}

	public BigDecimal getCompteurB() {
		return compteurB;
	}

	public void setCompteurB(BigDecimal compteurB) {
		this.compteurB = compteurB;
	}

	private BigDecimal compteurA;
    private BigDecimal compteurB;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateTrt() {
        return dateTrt;
    }

    public void setDateTrt(Date dateTrt) {
        this.dateTrt = dateTrt;
    }

    public int getPrime1() {
        return prime1;
    }

    public void setPrime1(int prime1) {
        this.prime1 = prime1;
    }

    public int getPrime2() {
        return prime2;
    }

    public void setPrime2(int prime2) {
        this.prime2 = prime2;
    }

    public int getPrime3() {
        return prime3;
    }

    public void setPrime3(int prime3) {
        this.prime3 = prime3;
    }

	public PrimeT getPrimeT() {
		return primeT;
	}

	public void setPrimeT(PrimeT primeT) {
		this.primeT = primeT;
	}


}
