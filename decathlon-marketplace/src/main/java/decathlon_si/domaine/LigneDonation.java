package decathlon_si.domaine;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: LigneDonation
 *
 */
@Entity

public class LigneDonation implements Serializable {
	@EmbeddedId
	private LigneDonationId ligneDonationId;
	private int quantite;

	@ManyToOne
	@JoinColumn(name = "idDonation", referencedColumnName = "id", updatable = false, insertable = false)
	private Donation donation;
	@ManyToOne
	@JoinColumn(name = "idProduit", referencedColumnName = "id", updatable = false, insertable = false)
	private Produit produit;
	private static final long serialVersionUID = 1L;

	public LigneDonation() {
		super();
	}

	public LigneDonation(int quantite, Donation donation, Produit produit) {
		super();
		this.quantite = quantite;
		this.donation = donation;
		this.produit = produit;
		this.ligneDonationId = new LigneDonationId(produit.getId(), donation.getId());
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LigneDonationId getLigneDonationId() {
		return ligneDonationId;
	}

	public void setLigneDonationId(LigneDonationId ligneDonationId) {
		this.ligneDonationId = ligneDonationId;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
