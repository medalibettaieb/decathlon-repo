package decathlon_si.webCtr.mBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import decathlon_si.domaine.Magasin;
import decathlon_si.domaine.Produit;
import decathlon_si.services.interfaces.MagasinServiceLocal;

@ManagedBean
@ViewScoped
public class MagasinCtr {
	private List<Magasin> magasins = new ArrayList<Magasin>();
	private Produit produit=new Produit();
	private Magasin magasinSelected=new Magasin();
	@EJB
	private MagasinServiceLocal magasinServiceLocal;
	private Date dateEntree;
public void doassignProduitToMagasin() {
	magasinServiceLocal.assignProduitToMagasin(produit, magasinSelected, dateEntree);
}
	public List<Magasin> getMagasins() {
		magasins = magasinServiceLocal.findAll();
		return magasins;
	}

	public void setMagasins(List<Magasin> magasins) {
		this.magasins = magasins;
	}

	public Magasin getMagasinSelected() {
		return magasinSelected;
	}

	public void setMagasinSelected(Magasin magasinSelected) {
		this.magasinSelected = magasinSelected;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public MagasinServiceLocal getMagasinServiceLocal() {
		return magasinServiceLocal;
	}
	public void setMagasinServiceLocal(MagasinServiceLocal magasinServiceLocal) {
		this.magasinServiceLocal = magasinServiceLocal;
	}
	public Date getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	
}
