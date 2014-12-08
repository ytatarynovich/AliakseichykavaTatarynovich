package com.epam.jmp.bank.springwebjaas;

import java.security.Principal;
import com.epam.jmp.bank.model.Role;

/**
 * @see http://techannotation.wordpress.com/2012/12/05/5-minutes-with-spring-authentication-and-authorization-service-jaa/
 */
public class UserPrincipal implements Principal, java.io.Serializable {

	private Role role;

	public UserPrincipal(Role role) {
		this.role = role;
	}

	@Override
	public String getName() {
		return role.name();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
