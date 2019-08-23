package decathlon_si.services.impl;

import javax.ejb.Stateless;

import decathlon_si.domaine.Categorie;
import decathlon_si.services.interfaces.CategorieLocal;
import decathlon_si.utilitaire.GenericDAO;

@Stateless
public class CategorieService extends GenericDAO<Categorie> implements CategorieLocal {
	public CategorieService() {
		super(Categorie.class);
	}
}
