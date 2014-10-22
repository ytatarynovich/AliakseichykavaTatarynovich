package com.epam.jmp.concurrency.menu;

import com.epam.jmp.concurrency.menu.commands.*;
import com.epam.jmp.concurrency.services.AccountService;

public enum BankAction {

	EXIT(0, "Exit", new ExitCommand()),

	CREATE_ACCOUNT(1, "Create Account", new CreateAccountCommand()),

	FIND_ACCOUNT_BY_ID(2, "Find Account by id", new FindAccountByIdCommand()),

	FIND_ACCOUNT_BY_NAME(3, "Find Accounts by first or last person's name", new FindAccountByNameCommand());

	private int code;
	private String description;
	private BankCommand action;

	BankAction(int code, String description, BankCommand action) {
		this.code = code;
		this.description = description;
		this.action = action;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + " - " + description;
	}

	public static BankAction findByCode(int code) {
		for(BankAction action : values()) {
			if(action.getCode() == code) {
				return action;
			}
		}
		return null;
	}

	public boolean executeCommand(AccountService accountService) {
		return action.execute(accountService);
	}
}
