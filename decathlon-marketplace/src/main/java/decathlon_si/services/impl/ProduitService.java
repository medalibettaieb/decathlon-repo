package decathlon_si.services.impl;

import javax.ejb.Stateless;

import decathlon_si.domaine.Produit;
import decathlon_si.services.interfaces.ProduitLocal;
import decathlon_si.utilitaire.GenericDAO;
@Stateless
public class ProduitService extends GenericDAO<Produit> implements ProduitLocal {
	public ProduitService() {
		super(Produit.class);
	}
}
