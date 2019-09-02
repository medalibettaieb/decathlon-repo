package decathlon_si.services.interfaces;

import java.util.Date;

import javax.ejb.Local;

import decathlon_si.domaine.Magasin;
import decathlon_si.domaine.Produit;
import decathlon_si.utilitaire.IGenericDAO;

@Local
public interface MagasinServiceLocal extends IGenericDAO<Magasin> {
	void assignProduitToMagasin(Produit produit, Magasin magasin, Date dateEntree);
}
