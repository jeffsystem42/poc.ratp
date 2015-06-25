package fr.ratp.phoebus.exception;

/**
 * Classe des execeptions m�tiers
 */
public class PhoebusException extends Exception {

    /**
     * Cr�e une nouvelle PhoebusException avec un message d'erreur.
     *
     * @param message Le message d�crivant l'erreur
     */
    public PhoebusException(String message)
    {
        super(message);
    }

    /**
     * Cr�e une nouvelle PhoebusException encapsulant un throwable
     *
     * @param cause La cause de l'erreur
     */
    public PhoebusException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Cr�e une nouvelle PhoebusException avec un message d'erreur et encapsulant un throwable
     *
     * @param message Le message d�crivant l'erreur
     * @param cause La cause de l'erreur
     */
    public PhoebusException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
