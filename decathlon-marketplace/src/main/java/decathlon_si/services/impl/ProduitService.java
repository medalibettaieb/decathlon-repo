package decathlon_si.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import decathlon_si.domaine.Produit;
import decathlon_si.services.interfaces.ProduitLocal;
import decathlon_si.utilitaire.GenericDAO;
@Stateless
@Path("/produits")
public class ProduitService extends GenericDAO<Produit> implements ProduitLocal {
	@PersistenceContext
	private EntityManager entityManager;
	public ProduitService() {
		super(Produit.class);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Produit> findAll() {
		return super.findAll();
	}
}
