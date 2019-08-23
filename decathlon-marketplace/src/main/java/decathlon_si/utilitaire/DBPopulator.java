package decathlon_si.utilitaire;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import decathlon_si.domaine.Admin;
import decathlon_si.domaine.Categorie;
import decathlon_si.domaine.Client;
import decathlon_si.domaine.Produit;
import decathlon_si.services.interfaces.CategorieLocal;
import decathlon_si.services.interfaces.ProduitLocal;
import decathlon_si.services.interfaces.UserServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	@EJB
	private UserServiceLocal userServiceLocal;
	@EJB
	private ProduitLocal produitLocal;
	@EJB
	private CategorieLocal categorieLocal;

	public DBPopulator() {
	}

	@PostConstruct
	public void init() {
		Client client = new Client("a", "a", "a", "a", "a@a", "a", "a");
		Client client2 = new Client("b", "b", "b", "b", "b@b", "b", "b");
		Client client3 = new Client("c", "c", "c", "c", "c@c", "c", "c");
		Client client4 = new Client("d", "d", "d", "d", "d@d", "d", "d");

		Admin admin = new Admin("z", "z", "z", "z", "z@z", "z", "z");

		Produit produit = new Produit("p001", "basket");
		Produit produit2 = new Produit("p002", "survet");
		Produit produit3 = new Produit("p003", "casket");
		Produit produit4 = new Produit("p004", "chort");

		Categorie categorie = new Categorie("vetements");
		Categorie categorie2 = new Categorie("equipements");

		userServiceLocal.save(client);
		userServiceLocal.save(client2);
		userServiceLocal.save(client3);
		userServiceLocal.save(client4);
		userServiceLocal.save(admin);

		produitLocal.save(produit);
		produitLocal.save(produit2);
		produitLocal.save(produit3);
		produitLocal.save(produit4);

		categorieLocal.save(categorie);
		categorieLocal.save(categorie2);
	}
}