package decathlon_si.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Magasin
 *
 */
@Entity

public class Magasin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String code;
	private String adresse;

	@OneToMany(mappedBy = "magasin", fetch = FetchType.EAGER)
	private List<StockDetail> stockDetails;
	private static final long serialVersionUID = 1L;

	public Magasin() {
		super();
	}

	public Magasin(String name, String code, String adresse) {
		super();
		this.name = name;
		this.code = code;
		this.adresse = adresse;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<StockDetail> getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(List<StockDetail> stockDetails) {
		this.stockDetails = stockDetails;
	}

}
