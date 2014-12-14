package com.epam.jmp.bank.springwebjaas;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.authentication.jaas.AuthorityGranter;

import com.epam.jmp.bank.model.Role;

public class RoleGranter implements AuthorityGranter {

	public Set<String> grant(Principal principal) {

		return Collections.singleton(
				Role.findByName(principal.getName())
				.name()
			);
	}

}
