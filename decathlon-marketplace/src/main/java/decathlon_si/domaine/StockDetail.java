package decathlon_si.domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: StockDetail
 *
 */
@Entity

public class StockDetail implements Serializable {
	@EmbeddedId
	private StockdetailId stockdetailId;
	private Date dateEntree;
	private Date dateSortie;

	@ManyToOne
	@JoinColumn(name = "idMagasin", referencedColumnName = "id", updatable = false, insertable = false)
	private Magasin magasin;

	@ManyToOne
	@JoinColumn(name = "idProduit", referencedColumnName = "id", updatable = false, insertable = false)
	private Produit produit;
	private static final long serialVersionUID = 1L;

	public StockDetail() {
		super();
	}

	public StockDetail(Date dateEntree, Magasin magasin, Produit produit) {
		super();
		this.dateEntree = dateEntree;
		this.magasin = magasin;
		this.produit = produit;
		this.stockdetailId = new StockdetailId(produit.getId(), magasin.getId());
	}

	public Date getDateEntree() {
		return this.dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return this.dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public StockdetailId getStockdetailId() {
		return stockdetailId;
	}

	public void setStockdetailId(StockdetailId stockdetailId) {
		this.stockdetailId = stockdetailId;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
