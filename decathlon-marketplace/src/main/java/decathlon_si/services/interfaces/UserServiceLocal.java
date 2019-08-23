package decathlon_si.services.interfaces;

import javax.ejb.Local;

import decathlon_si.domaine.User;
import decathlon_si.utilitaire.IGenericDAO;


@Local
public interface UserServiceLocal extends IGenericDAO<User> {

	User login(String login, String password);

}
