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

public class Commande implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numCommande;
	private Date dateOfCommande;
	private String lieu;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> ligneCommandes;
	private static final long serialVersionUID = 1L;

	public Commande() {
		super();
	}

	public Commande(String numCommande, Date dateOfCommande, String lieu) {
		super();
		this.numCommande = numCommande;
		this.dateOfCommande = dateOfCommande;
		this.lieu = lieu;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumCommande() {
		return this.numCommande;
	}

	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}

	public Date getDateOfCommande() {
		return this.dateOfCommande;
	}

	public void setDateOfCommande(Date dateOfCommande) {
		this.dateOfCommande = dateOfCommande;
	}

	public String getLieu() {
		return this.lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

}
