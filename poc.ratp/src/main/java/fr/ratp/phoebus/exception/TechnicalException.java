package fr.ratp.phoebus.exception;

/**
 * Classe des exceptions techniques
 */
public class TechnicalException extends Exception {

    /**
     * Crée une nouvelle PhoebusException avec un message d'erreur.
     *
     * @param message Le message décrivant l'erreur
     */
    public TechnicalException(String message)
    {
        super(message);
    }

    /**
     * Crée une nouvelle PhoebusException encapsulant un throwable
     *
     * @param cause La cause de l'erreur
     */
    public TechnicalException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Crée une nouvelle PhoebusException avec un message d'erreur et encapsulant un throwable
     *
     * @param message Le message décrivant l'erreur
     * @param cause La cause de l'erreur
     */
    public TechnicalException(String message, Throwable cause)
    {
        super(message, cause);
    }


}
