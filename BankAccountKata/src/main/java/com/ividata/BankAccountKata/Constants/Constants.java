package com.ividata.BankAccountKata.Constants;

/**
 * Class des constants.
 *
 */
public final class Constants {
	
	/**
	 * Constructor.
	 */
	private Constants() {
		//nothing to do
	}
	
	/** TYPE TRANSACTION DEPOSIT. */
	public static final String TRANSACTION_DEPOSIT_TYPE = "DEPOSIT";
	
	/** TYPE TRANSACTION RETRAIT. */
	public static final String TRANSACTION_RETRAIT_TYPE = "RETRAIT";
	
	/** MAX WITHDRAW PER DAY. */
	public static final double MAX_WITHDRAWAL_PER_DAY = 50000;
	
	/** MIN WITHDRAW PER DAY. */
	public static final double MIN_WITHDRAWAL_PER_DAY = 20;
	
	/** MAX DEPOSIT PER DAY. */
	public static final double MAX_DEPOSIT_PER_DAY = 50000;
	
	/** MAX DEPOSIT PER TRANSACTION. */
	public static final double MAX_DEPOSIT_PER_TRANSACTION = 1000;
	
	/** MSG Exception compte bancaire introuvable. */
	public static final String MSG_ACCOUNT_NOT_FOUND_EXCEPTION = "Compte bancaire introuvable"; 
	
	
	public static String MSG_NAME_FIELD = "Message";
	
	public static String MSG_TITLE_FIELD = "Titre";
	
	/** MSG message. */
	public static String MSG_TITLE_VALUE = "Erreur Interne du Serveur";
	
	/** MSG message value. */
	public static String MSG_NAME_VALUE = "Le serveur a rencontré une condition inattendue qui l'a empêché de répondre à la demande.";
	
	/** MSG message value. */
	public static String NOT_FOUND_MSG = "La ressource demandée est introuvable. Veuillez vérifier votre identifiant de ressource.";
	
	/** MSG  MSG_EXCEPTION_MIN_WITHDRAWAL_PER_DAY. */
	public static String MSG_EXCEPTION_MIN_WITHDRAWAL_PER_DAY = "Operation échouée.Vous devez saisir un montant suppérieure à 20";
	
	/** MSG  MSG_EXCEPTION_FONDS_INSUFFISANTS. */
	public static String MSG_EXCEPTION_FONDS_INSUFFISANTS = "Vous avez des fonds insuffisants";
	
	/** MSG  MSG_EXCEPTION_LIMIT_RETRAIT. */
	public static String MSG_EXCEPTION_LIMIT_RETRAIT = "Le retrait par jour ne devrait pas dépasser ";
	
	/** MSG  MSG_SECCUS_RETRAIT. */
	public static String MSG_SECCUS_RETRAIT = "Retrait effectué avec succès";
	
	/** MSG  MSG_MAX_DEPOSIT_PER_DAY. */
	public static String MSG_MAX_DEPOSIT_PER_DAY = "Le dépôt pour la journée ne devrait pas dépasser 150 000 $";
	
	/** MSG  MSG_MAX_DEPOSIT_PER_TRANSACTION. */
	public static String MSG_MAX_DEPOSIT_PER_TRANSACTION = "Le dépôt par transaction ne devrait pas dépasser 40000 $";
	
	/** MSG  MSG_MAX_DEPOSIT_PER_TRANSACTION. */
	public static String MSG_SECCUS_DEPOT = "Dépôt effectué avec succès";
	

}
