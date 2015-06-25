package fr.ratp.phoebus.listener;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import fr.ratp.phoebus.dao.MatriculeErrorDao;
import org.springframework.batch.core.SkipListener;

/**
 * Created by vermelinj on 15/06/2015.
 */
public class SkipCalculatorListener implements SkipListener<ContextMatriculeItem, ContextMatriculeItem>{

    private MatriculeErrorDao matriculeErrorDao = null;

    public void setMatriculeErrorDao(MatriculeErrorDao matriculeErrorDao) {
        this.matriculeErrorDao = matriculeErrorDao;
    }

    public void onSkipInRead(Throwable throwable) {
        // Seule les phoebusException sont ignor�es.
        // S'il y a une erreur � la lecture, elle ne sera pas du type phoebusException
        // Donc on ne fait rien
    }

    public void onSkipInWrite(ContextMatriculeItem contextMatriculeItem, Throwable throwable) {
        // Seule les phoebusException sont ignor�es.
        // S'il y a une erreur � l'�criture, elle ne sera pas du type phoebusException
        // Donc on ne fait rien
    }

    public void onSkipInProcess(ContextMatriculeItem contextMatriculeItem, Throwable throwable) {

        // D�s qu'une erreur est ignor�e, alors on ajoute une ligne dans la table
        // des matricules n'ayant pas �t� trait�s
        matriculeErrorDao.insert(contextMatriculeItem.getMatricule(), throwable.getMessage());
    }
}
