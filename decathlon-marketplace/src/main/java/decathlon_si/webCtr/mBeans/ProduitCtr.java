package decathlon_si.webCtr.mBeans;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.github.adminfaces.starter.infra.security.LogonMB;
import com.github.adminfaces.template.config.AdminConfig;

import decathlon_si.domaine.Categorie;
import decathlon_si.domaine.Produit;
import decathlon_si.services.interfaces.CategorieLocal;
import decathlon_si.services.interfaces.CommandeServiceLocal;
import decathlon_si.services.interfaces.ProduitLocal;

@ManagedBean
@ViewScoped
public class ProduitCtr {

	private Produit produit = new Produit();
	private Produit produitSelected = new Produit();
	private List<Produit> produits = new ArrayList<>();
	private List<Produit> produitsFilter = new ArrayList<>();
	private List<Categorie> categories = new ArrayList<>();
	private Categorie categorieSelected = new Categorie();
	private int categorySelectedId;
	private int quantite;
	private Map<Produit, Integer> mapOfproduitCommande = new HashMap<>();
	@EJB
	private ProduitLocal produitLocal;
	@EJB
	private CategorieLocal categorieLocal;
	@EJB
	private CommandeServiceLocal commandeServiceLocal;
	@Inject
	private AdminConfig adminConfig;
	@ManagedProperty(value = "#{logonMB}")
	private LogonMB logonMB;

	@PostConstruct
	private void init() {
		produits = produitLocal.findAll();
		categories = categorieLocal.findAll();
	}

	public Double findTotalCommnande() {
		Double tot = 0D;
		for (Map.Entry<Produit, Integer> entry : mapOfproduitCommande.entrySet()) {
			Produit key = entry.getKey();
			Integer value = entry.getValue();

			tot += key.getPrice() * value;
		}
		return tot;

	}

	public void doPasserCommande() {
		mapOfproduitCommande.put(produitSelected, quantite);
	}

	public void doCancelPasserCommande() {
		mapOfproduitCommande.remove(produitSelected);
	}

	public void doPasserDoantion() {

	}

	public void doValiderCommande() {
		commandeServiceLocal.commanderParMap(mapOfproduitCommande, logonMB.getUser());
		mapOfproduitCommande = new HashMap<>();
	}

	public void doDelete() {
		produitLocal.delete(produitSelected);
		produitSelected = new Produit();
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
		produits = produitLocal.findAll();
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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Map<Produit, Integer> getMapOfproduitCommande() {
		return mapOfproduitCommande;
	}

	public void setMapOfproduitCommande(Map<Produit, Integer> mapOfproduitCommande) {
		this.mapOfproduitCommande = mapOfproduitCommande;
	}

	public CategorieLocal getCategorieLocal() {
		return categorieLocal;
	}

	public void setCategorieLocal(CategorieLocal categorieLocal) {
		this.categorieLocal = categorieLocal;
	}

	public CommandeServiceLocal getCommandeServiceLocal() {
		return commandeServiceLocal;
	}

	public void setCommandeServiceLocal(CommandeServiceLocal commandeServiceLocal) {
		this.commandeServiceLocal = commandeServiceLocal;
	}

	public AdminConfig getAdminConfig() {
		return adminConfig;
	}

	public void setAdminConfig(AdminConfig adminConfig) {
		this.adminConfig = adminConfig;
	}

	public LogonMB getLogonMB() {
		return logonMB;
	}

	public void setLogonMB(LogonMB logonMB) {
		this.logonMB = logonMB;
	}

}
