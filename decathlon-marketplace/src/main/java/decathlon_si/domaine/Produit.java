package decathlon_si.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Produit
 *
 */
@Entity

public class Produit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String libele;
	private Double price;

	@OneToMany(mappedBy = "produit")
	private List<LigneDonation> ligneDonations;

	@OneToMany(mappedBy = "produit")
	private List<LigneCommande> ligneCommandes;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Categorie categorie;

	@OneToMany(mappedBy = "produit")
	private List<StockDetail> stockDetails;
	private static final long serialVersionUID = 1L;

	public Produit() {
		super();
	}

	public Produit(String code, String libele,Double price) {
		super();
		this.code = code;
		this.libele = libele;
		this.price=price;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibele() {
		return this.libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public List<LigneDonation> getLigneDonations() {
		return ligneDonations;
	}

	public void setLigneDonations(List<LigneDonation> ligneDonations) {
		this.ligneDonations = ligneDonations;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<StockDetail> getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(List<StockDetail> stockDetails) {
		this.stockDetails = stockDetails;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
