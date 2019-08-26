package decathlon_si.webCtr.mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import decathlon_si.domaine.User;
import decathlon_si.services.interfaces.UserServiceLocal;

@ManagedBean
@ViewScoped
public class UserCtr {
	private User user = new User();
	private User userSelected = new User();
	private List<User> users = new ArrayList<User>();
	@EJB
	private UserServiceLocal userServiceLocal;

	public void doAddUser() {
		userServiceLocal.save(user);
	}

	public void doDeleteUser() {
		userServiceLocal.delete(userSelected);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

	public List<User> getUsers() {
		users = userServiceLocal.findAll();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserServiceLocal getUserServiceLocal() {
		return userServiceLocal;
	}

	public void setUserServiceLocal(UserServiceLocal userServiceLocal) {
		this.userServiceLocal = userServiceLocal;
	}

}
