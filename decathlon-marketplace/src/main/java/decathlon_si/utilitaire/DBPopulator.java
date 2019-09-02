package decathlon_si.utilitaire;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import decathlon_si.domaine.Admin;
import decathlon_si.domaine.Categorie;
import decathlon_si.domaine.Client;
import decathlon_si.domaine.Magasin;
import decathlon_si.domaine.Produit;
import decathlon_si.domaine.StockManager;
import decathlon_si.services.interfaces.CategorieLocal;
import decathlon_si.services.interfaces.MagasinServiceLocal;
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
	@EJB
	private MagasinServiceLocal magasinServiceLocal;

	public DBPopulator() {
	}

	@PostConstruct
	public void init() {
		Client client = new Client("a", "a", "a", "a", "a@a", "a", "a");
		Client client2 = new Client("b", "b", "b", "b", "b@b", "b", "b");
		Client client3 = new Client("c", "c", "c", "c", "c@c", "c", "c");
		Client client4 = new Client("d", "d", "d", "d", "d@d", "d", "d");

		Admin admin = new Admin("z", "z", "z", "z", "z@z", "z", "z");

		StockManager stockManager=new StockManager("x", "x", "x", "x", "x@x", "x", "x");
		
		Produit produit = new Produit("p001", "basket",100D);
		Produit produit2 = new Produit("p002", "survet",200D);
		Produit produit3 = new Produit("p003", "casket",300D);
		Produit produit4 = new Produit("p004", "chort",400D);

		Categorie categorie = new Categorie("vetements");
		Categorie categorie2 = new Categorie("equipements");

		Magasin magasin=new Magasin("magasin sidi daoud",String.valueOf(-Math.round(Math.random() * (100 - 500))), "18 rue raoud");
		Magasin magasin2=new Magasin("magasin Ben Arous",String.valueOf(-Math.round(Math.random() * (100 - 500))), "20 rue monsef Bay");
		
		userServiceLocal.save(client);
		userServiceLocal.save(client2);
		userServiceLocal.save(client3);
		userServiceLocal.save(client4);
		userServiceLocal.save(admin);
		userServiceLocal.save(stockManager);

		produitLocal.save(produit);
		produitLocal.save(produit2);
		produitLocal.save(produit3);
		produitLocal.save(produit4);

		categorieLocal.save(categorie);
		categorieLocal.save(categorie2);
		
		magasinServiceLocal.save(magasin);
		magasinServiceLocal.save(magasin2);
	}
}