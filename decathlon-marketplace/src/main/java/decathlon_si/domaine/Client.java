package decathlon_si.domaine;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String adresse, String numTel, String email, String userName,
			String password) {
		super(nom, prenom, adresse, numTel, email, userName, password);
	}

}
