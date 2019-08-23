package decathlon_si.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import decathlon_si.domaine.User;
import decathlon_si.services.interfaces.UserServiceLocal;
import decathlon_si.utilitaire.GenericDAO;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@Path("/user")
public class UserService extends GenericDAO<User> implements UserServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserService() {
		super(User.class);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = entityManager.createQuery("SELECT u FROM User u WHERE u.userName=:l AND u.password=:p", User.class)
					.setParameter("l", login).setParameter("p", password).getSingleResult();
		} catch (Exception e) {
		}
		return user;
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void save(User entity) {
		// TODO Auto-generated method stub
		super.save(entity);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@POST
	@Path("/emm")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response hatha() {
		String message = "This is a text response";

		return Response.status(Response.Status.OK).entity(message).build();
	}
}
