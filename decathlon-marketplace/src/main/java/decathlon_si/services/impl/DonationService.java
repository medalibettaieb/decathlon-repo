package decathlon_si.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import decathlon_si.domaine.Donation;
import decathlon_si.domaine.LigneDonation;
import decathlon_si.domaine.Produit;
import decathlon_si.domaine.User;
import decathlon_si.services.interfaces.DonationServiceLocal;

@Stateless
public class DonationService implements DonationServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void donnerParMap(Map<Produit, Integer> mapOfProduits, User client) {

		Donation donation = new Donation(String.valueOf(Math.round(Math.random() * (10000 - 5000))), new Date(), client);
		entityManager.persist(donation);
		entityManager.flush();
		for (Map.Entry<Produit, Integer> entry : mapOfProduits.entrySet()) {
			Produit key = entry.getKey();
			Integer value = entry.getValue();
			LigneDonation ligneDonation = new LigneDonation(value, donation, key);
			entityManager.merge(ligneDonation);
		}

	}

	@Override
	public void donnerParProduit(Produit produit, Integer quantite) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> findDonationsByUser(int id) {
		return entityManager.createQuery("select a from Donation a where a.user.id=:p").setParameter("p", id)
				.getResultList();
	}

}
