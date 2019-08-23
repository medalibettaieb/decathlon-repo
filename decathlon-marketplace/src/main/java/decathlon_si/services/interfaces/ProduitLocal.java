package decathlon_si.services.interfaces;

import javax.ejb.Local;

import decathlon_si.domaine.Produit;
import decathlon_si.utilitaire.IGenericDAO;
@Local
public interface ProduitLocal extends IGenericDAO<Produit> {

}
