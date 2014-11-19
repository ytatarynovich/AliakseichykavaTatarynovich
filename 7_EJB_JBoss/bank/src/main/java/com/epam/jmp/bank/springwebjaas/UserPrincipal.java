package com.epam.jmp.bank.springwebjaas;

import java.security.Principal;
import java.util.Date;

/**
 * @see http://techannotation.wordpress.com/2012/12/05/5-minutes-with-spring-authentication-and-authorization-service-jaa/
 */
public class UserPrincipal implements Principal, java.io.Serializable  {
	
	private String name     = null;
    private Date loginTime  = null;
    private String role     = null;
 
    public UserPrincipal(String name) {
        if (name == null)
            throw new NullPointerException("illegal null input");
        this.name = name;
        this.loginTime = new Date();
    }
 
    @Override
    public String getName() {
        return name;
    }
 
    public Date getLoginTime() {
        return loginTime;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }

}
