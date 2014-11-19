package com.epam.jmp.bank.springwebjaas;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;
 
import org.springframework.security.authentication.jaas.AuthorityGranter;

/**
 * @see http://techannotation.wordpress.com/2012/12/05/5-minutes-with-spring-authentication-and-authorization-service-jaa/
 */
public class RoleGranter implements AuthorityGranter {
	
	public Set<String> grant(Principal principal) {
		 
        if (principal.getName().equals("admin")) {
        	System.out.println("\n\n!!!ADMIN\n\n");
            return Collections.singleton("ADMIN"); }
        else
            return Collections.singleton("CUSTOMER");
    }

}
