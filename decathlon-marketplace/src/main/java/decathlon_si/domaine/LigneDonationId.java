package decathlon_si.domaine;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LigneDonationId implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private int idProduit;
	private int idDonation;

	public LigneDonationId() {
	}

	public LigneDonationId(int idProduit, int idDonation) {
		super();
		this.idProduit = idProduit;
		this.idDonation = idDonation;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdDonation() {
		return idDonation;
	}

	public void setIdDonation(int idDonation) {
		this.idDonation = idDonation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDonation;
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
		LigneDonationId other = (LigneDonationId) obj;
		if (idDonation != other.idDonation)
			return false;
		if (idProduit != other.idProduit)
			return false;
		return true;
	}

}
