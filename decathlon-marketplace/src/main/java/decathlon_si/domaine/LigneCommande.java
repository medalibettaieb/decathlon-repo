package decathlon_si.domaine;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: LigneCommande
 *
 */
@Entity

public class LigneCommande implements Serializable {
	@EmbeddedId
	private LigneCommandeId ligneCommandeId;
	private int quantite;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCommande", referencedColumnName = "id", updatable = false, insertable = false)
	private Commande commande;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProduit", referencedColumnName = "id", updatable = false, insertable = false)
	private Produit produit;
	private static final long serialVersionUID = 1L;

	public LigneCommande() {
		super();
	}

	public LigneCommande(int quantite, Commande commande, Produit produit) {
		super();
		this.quantite = quantite;
		this.commande = commande;
		this.produit = produit;
		this.ligneCommandeId = new LigneCommandeId(commande.getId(), produit.getId());
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LigneCommandeId getLigneCommandeId() {
		return ligneCommandeId;
	}

	public void setLigneCommandeId(LigneCommandeId ligneCommandeId) {
		this.ligneCommandeId = ligneCommandeId;
	}

}
