package decathlon_si.domaine;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Commande
 *
 */
@Entity

public class Donation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numDonation;
	private Date dateOfDonation;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "donation")
	private List<LigneDonation> ligneDonations;
	private static final long serialVersionUID = 1L;

	public Donation() {
		super();
	}

	public Donation(String numDonation, Date dateOfDonation) {
		super();
		this.numDonation = numDonation;
		this.dateOfDonation = dateOfDonation;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumDonation() {
		return numDonation;
	}

	public void setNumDonation(String numDonation) {
		this.numDonation = numDonation;
	}

	public Date getDateOfDonation() {
		return dateOfDonation;
	}

	public void setDateOfDonation(Date dateOfDonation) {
		this.dateOfDonation = dateOfDonation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LigneDonation> getLigneDonations() {
		return ligneDonations;
	}

	public void setLigneDonations(List<LigneDonation> ligneDonations) {
		this.ligneDonations = ligneDonations;
	}

}
