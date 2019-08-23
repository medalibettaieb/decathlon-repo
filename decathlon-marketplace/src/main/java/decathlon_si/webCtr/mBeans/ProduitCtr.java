package decathlon_si.webCtr.mBeans;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.github.adminfaces.template.config.AdminConfig;

import decathlon_si.domaine.Categorie;
import decathlon_si.domaine.Produit;
import decathlon_si.services.interfaces.CategorieLocal;
import decathlon_si.services.interfaces.ProduitLocal;

@ManagedBean
@SessionScoped
public class ProduitCtr {

	private Produit produit = new Produit();
	private Produit produitSelected = new Produit();
	private List<Produit> produits = new ArrayList<>();
	private List<Produit> produitsFilter = new ArrayList<>();
	private List<Categorie> categories = new ArrayList<>();
	private Categorie categorieSelected = new Categorie();
	private int categorySelectedId;
	@EJB
	private ProduitLocal produitLocal;
	@EJB
	private CategorieLocal categorieLocal;
	@Inject
	private AdminConfig adminConfig;

	@PostConstruct
	private void init() {
		produits = produitLocal.findAll();
		categories = categorieLocal.findAll();
	}

	public void doDelete() {
		produitLocal.delete(produitSelected);
	}

	public void doAdd() {
		System.out.println(categorySelectedId);
		String msg;
		if (produitSelected.getId() == 0) {
			categorieSelected = categorieLocal.find(categorySelectedId);
			produitSelected.setCategorie(categorieSelected);
			produitLocal.update(produitSelected);
			msg = "Produit " + produitSelected.getLibele() + " created successfully";
		} else {
			categorieSelected = categorieLocal.find(categorySelectedId);
			produitSelected.setCategorie(categorieSelected);
			produitLocal.update(produit);
			msg = "Produit " + produitSelected.getLibele() + " updated successfully";
		}
		addDetailMessage(msg);

	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public List<Produit> getProduitsFilter() {
		return produitsFilter;
	}

	public void setProduitsFilter(List<Produit> produitsFilter) {
		this.produitsFilter = produitsFilter;
	}

	public Produit getProduitSelected() {
		return produitSelected;
	}

	public void setProduitSelected(Produit produitSelected) {
		this.produitSelected = produitSelected;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public ProduitLocal getProduitLocal() {
		return produitLocal;
	}

	public void setProduitLocal(ProduitLocal produitLocal) {
		this.produitLocal = produitLocal;
	}

	public Categorie getCategorieSelected() {
		return categorieSelected;
	}

	public void setCategorieSelected(Categorie categorieSelected) {
		this.categorieSelected = categorieSelected;
	}

	public int getCategorySelectedId() {
		return categorySelectedId;
	}

	public void setCategorySelectedId(int categorySelectedId) {
		this.categorySelectedId = categorySelectedId;
	}

}
