package decathlon_si.services.impl;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import decathlon_si.domaine.Magasin;
import decathlon_si.domaine.Produit;
import decathlon_si.domaine.StockDetail;
import decathlon_si.services.interfaces.MagasinServiceLocal;
import decathlon_si.utilitaire.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class MagasinService extends GenericDAO<Magasin> implements MagasinServiceLocal {
	public MagasinService() {
		super(Magasin.class);
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void assignProduitToMagasin(Produit produit, Magasin magasin, Date dateEntree) {
		StockDetail stockDetail = new StockDetail(dateEntree, entityManager.merge(magasin),
				entityManager.merge(produit));
		entityManager.persist(stockDetail);

	}

}
