package com.github.adminfaces.starter.infra.security;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.github.adminfaces.template.config.AdminConfig;
import com.github.adminfaces.template.session.AdminSession;

import decathlon_si.domaine.Admin;
import decathlon_si.domaine.Client;
import decathlon_si.domaine.StockManager;
import decathlon_si.domaine.User;
import decathlon_si.services.interfaces.UserServiceLocal;

/**
 * Created by rmpestano on 12/20/14.
 *
 * This is just a login example.
 *
 * AdminSession uses isLoggedIn to determine if user must be redirect to login
 * page or not. By default AdminSession isLoggedIn always resolves to true so it
 * will not try to redirect user.
 *
 * If you already have your authorization mechanism which controls when user
 * must be redirect to initial page or logon you can skip this class.
 */
@Named
@SessionScoped
@Specializes
public class LogonMB extends AdminSession implements Serializable {
	private User user = new User();
	private Boolean isLogged = false;
	private Boolean isEmployee = false;
	private Boolean isAdmin = false;
	@EJB
	private UserServiceLocal userManagementLocal;
	private boolean loggedInAsClient;
	private boolean loggedInAsAdministrateur;
	private boolean loggedInAsStockManager;

	private String currentUser;
	private String email;
	private String password;
	private boolean remember;
	@Inject
	private AdminConfig adminConfig;

	public void login() throws IOException {
		User userLoggedIn = userManagementLocal.login(user.getUserName(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			isLogged = true;

			currentUser = email;
			addDetailMessage("Logged in successfully as <b>" + email + "</b>");
			Faces.getExternalContext().getFlash().setKeepMessages(true);
			Faces.redirect(adminConfig.getIndexPage());

			if (userLoggedIn instanceof Client) {
				setLoggedInAsClient(true);
			} else if (userLoggedIn instanceof Admin) {
				setLoggedInAsAdministrateur(true);
			} else if (userLoggedIn instanceof StockManager) {
				setLoggedInAsStockManager(true);
			}
		} else {
			addDetailMessage("(Veuillez insérer une matricule et un mot de passe valide");
			Faces.getExternalContext().getFlash().setKeepMessages(true);
			Faces.redirect(adminConfig.getLoginPage());
		}

	}

	@Override
	public boolean isLoggedIn() {
		return isLogged;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public UserServiceLocal getUserManagementLocal() {
		return userManagementLocal;
	}

	public void setUserManagementLocal(UserServiceLocal userManagementLocal) {
		this.userManagementLocal = userManagementLocal;
	}

	public boolean isLoggedInAsClient() {
		return loggedInAsClient;
	}

	public void setLoggedInAsClient(boolean loggedInAsClient) {
		this.loggedInAsClient = loggedInAsClient;
	}

	public boolean isLoggedInAsAdministrateur() {
		return loggedInAsAdministrateur;
	}

	public void setLoggedInAsAdministrateur(boolean loggedInAsAdministrateur) {
		this.loggedInAsAdministrateur = loggedInAsAdministrateur;
	}

	public boolean isLoggedInAsStockManager() {
		return loggedInAsStockManager;
	}

	public void setLoggedInAsStockManager(boolean loggedInAsStockManager) {
		this.loggedInAsStockManager = loggedInAsStockManager;
	}

	public AdminConfig getAdminConfig() {
		return adminConfig;
	}

	public void setAdminConfig(AdminConfig adminConfig) {
		this.adminConfig = adminConfig;
	}

}
