package fr.ratp.phoebus.exception;

/**
 * Classe des execeptions métiers
 */
public class PhoebusException extends Exception {

    /**
     * Crée une nouvelle PhoebusException avec un message d'erreur.
     *
     * @param message Le message décrivant l'erreur
     */
    public PhoebusException(String message)
    {
        super(message);
    }

    /**
     * Crée une nouvelle PhoebusException encapsulant un throwable
     *
     * @param cause La cause de l'erreur
     */
    public PhoebusException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Crée une nouvelle PhoebusException avec un message d'erreur et encapsulant un throwable
     *
     * @param message Le message décrivant l'erreur
     * @param cause La cause de l'erreur
     */
    public PhoebusException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
