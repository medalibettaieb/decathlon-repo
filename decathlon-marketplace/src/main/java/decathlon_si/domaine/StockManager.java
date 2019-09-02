package decathlon_si.domaine;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: StockManager
 *
 */
@Entity

public class StockManager extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public StockManager() {
		super();
	}

	public StockManager(String nom, String prenom, String adresse, String numTel, String email, String userName,
			String password) {
		super(nom, prenom, adresse, numTel, email, userName, password);
		// TODO Auto-generated constructor stub
	}

}
