/**
 * Copyright : Iheb <br/>
 *
 * @version 1.0<br/>
 */
package fr.banque;

/**
 * Ceci est la classe Compte a seuil. <br/>
 * Il n'est pas possible de descendre en dessous du seuil.
 */
public class CompteASeuil extends Compte implements ICompteASeuil {
	private static final long serialVersionUID = 1L;

	private double seuil;

	/**
	 * Constructeur. <br/>
	 * Le seuil par defaut est de 0
	 */
	public CompteASeuil() {
		this(-1, 0, 0);
	}

	/**
	 * Constructeur de l'objet. <br>
	 *
	 * @param unNumero
	 *            le numero du compte
	 * @param unSoldeInitial
	 *            le solde initial du compte
	 * @param unSeuil
	 *            un seuil
	 */
	public CompteASeuil(int unNumero, double unSoldeInitial, double unSeuil) {
		super(unNumero, unSoldeInitial);
		this.setSeuil(unSeuil);
	}

	@Override
	public double getSeuil() {
		return this.seuil;
	}

	@Override
	public void setSeuil(double unSeuil) {
		this.seuil = unSeuil;
	}

	@Override
	public String toString() {
		return super.toString() + " Seuil=" + this.getSeuil();
	}

	@Override
	public void retirer(double unMontant) throws BanqueException {
		double simu = this.getSolde() - unMontant;
		if (simu <= this.getSeuil()) {
			throw new BanqueException("Votre seuil de " + this.getSeuil() + " ne vous permet pas de retirer "
					+ unMontant + " de votre compte " + this.getNumero());
		} else {
			super.retirer(unMontant);
		}
	}
}
