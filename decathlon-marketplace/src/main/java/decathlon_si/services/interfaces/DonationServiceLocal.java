package decathlon_si.services.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import decathlon_si.domaine.Donation;
import decathlon_si.domaine.Produit;
import decathlon_si.domaine.User;

@Local
public interface DonationServiceLocal {
	void donnerParMap(Map<Produit, Integer> mapOfProduits, User client);

	void donnerParProduit(Produit produit, Integer quantite);

	List<Donation> findDonationsByUser(int id);
}
