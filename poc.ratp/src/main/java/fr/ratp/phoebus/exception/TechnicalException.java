package fr.ratp.phoebus.exception;

/**
 * Classe des exceptions techniques
 */
public class TechnicalException extends Exception {

    /**
     * Cr�e une nouvelle PhoebusException avec un message d'erreur.
     *
     * @param message Le message d�crivant l'erreur
     */
    public TechnicalException(String message)
    {
        super(message);
    }

    /**
     * Cr�e une nouvelle PhoebusException encapsulant un throwable
     *
     * @param cause La cause de l'erreur
     */
    public TechnicalException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Cr�e une nouvelle PhoebusException avec un message d'erreur et encapsulant un throwable
     *
     * @param message Le message d�crivant l'erreur
     * @param cause La cause de l'erreur
     */
    public TechnicalException(String message, Throwable cause)
    {
        super(message, cause);
    }


}
