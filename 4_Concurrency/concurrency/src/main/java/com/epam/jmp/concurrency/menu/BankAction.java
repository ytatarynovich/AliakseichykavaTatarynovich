package com.epam.jmp.concurrency.menu;

import com.epam.jmp.concurrency.menu.commands.*;
import com.epam.jmp.concurrency.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
public enum BankAction {

	EXIT(0, "Exit", new ExitCommand()),

	CREATE_ACCOUNT(1, "Create Account", new CreateAccountCommand()),

	SET_ACCOUNT_AMOUNT(2, "Set Account's amount", new SetAcountAmountCommand()),
	
	CHANGE_ACCOUNT_CURRENCY(3, "Change Account's currency", new ChangeAcountCurrencyCommand()),

	FIND_ACCOUNT_BY_ID(4, "Find Account by id", new FindAccountByIdCommand()),

	FIND_ACCOUNT_BY_NAME(5, "Find Accounts by first or last person's name", new FindAccountByNameCommand()),

	PRINT_ALL_ACCOUNTs(6, "Print all accounts", new PrintAllAccountsCommand());

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
