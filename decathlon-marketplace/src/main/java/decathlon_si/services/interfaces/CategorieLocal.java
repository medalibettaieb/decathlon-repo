package decathlon_si.services.interfaces;

import javax.ejb.Local;

import decathlon_si.domaine.Categorie;
import decathlon_si.utilitaire.IGenericDAO;

@Local
public interface CategorieLocal extends IGenericDAO<Categorie> {

}
