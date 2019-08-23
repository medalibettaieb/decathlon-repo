package decathlon_si.domaine;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LigneCommandeId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCommande;
	private int idProduit;

	public LigneCommandeId() {
	}

	public LigneCommandeId(int idCommande, int idProduit) {
		super();
		this.idCommande = idCommande;
		this.idProduit = idProduit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCommande;
		result = prime * result + idProduit;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCommandeId other = (LigneCommandeId) obj;
		if (idCommande != other.idCommande)
			return false;
		if (idProduit != other.idProduit)
			return false;
		return true;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

}
