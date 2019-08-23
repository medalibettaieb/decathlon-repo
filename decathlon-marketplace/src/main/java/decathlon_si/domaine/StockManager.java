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

}
