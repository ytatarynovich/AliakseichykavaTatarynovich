package com.epam.jmp.bank.model;

import com.epam.jmp.bank.exceptions.RoleNotFoundException;

public enum Role {

	ADMIN(),
	ACCONT();

	public static Role findByName(String name) {
		name = name != null ? name.toUpperCase() : name;
		for(Role role : values()) {
			if(role.name().toUpperCase().equals(name)) {
				return role;
			}
		}
		throw new RoleNotFoundException(name);
	}
}
