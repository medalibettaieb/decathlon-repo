package decathlon_si.webCtr.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import decathlon_si.domaine.Categorie;
import decathlon_si.services.interfaces.CategorieLocal;

@ManagedBean
@ViewScoped
public class CategoryCtr {
	private Categorie categorie=new Categorie();
	private List<Categorie> categories = new ArrayList<>();
	private Categorie categorieSelected = new Categorie();
	private boolean showForm = true;
	@EJB
	private CategorieLocal categorieLocal;

	public void doUpdateForm() {
		categorie=new Categorie();
		showForm = false;
	}

	public void doAddCategory() {
		categorieLocal.save(categorie);
		showForm=true;
	}
	public void doDeleteCategory() {
		categorieLocal.delete(categorieSelected);
	}
	public void doAddCategorygg() {
		categorieLocal.save(categorie);
	}

	public List<Categorie> getCategories() {
		categories = categorieLocal.findAll();
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Categorie getCategorieSelected() {
		return categorieSelected;
	}

	public void setCategorieSelected(Categorie categorieSelected) {
		this.categorieSelected = categorieSelected;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
