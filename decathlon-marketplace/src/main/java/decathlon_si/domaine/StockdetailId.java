package decathlon_si.domaine;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StockdetailId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1693794387343577390L;
	private int idProduit;
	private int idMagasin;

	public StockdetailId() {
		// TODO Auto-generated constructor stub
	}

	public StockdetailId(int idProduit, int idMagasin) {
		super();
		this.idProduit = idProduit;
		this.idMagasin = idMagasin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMagasin;
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
		StockdetailId other = (StockdetailId) obj;
		if (idMagasin != other.idMagasin)
			return false;
		if (idProduit != other.idProduit)
			return false;
		return true;
	}

}
