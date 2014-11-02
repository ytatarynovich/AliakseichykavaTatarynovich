package com.epam.jmp.bank.menu;

import com.epam.jmp.bank.exceptions.ActionNotSupportedException;
import com.epam.jmp.bank.menu.commands.*;
import com.epam.jmp.bank.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
public enum BankAction {

	EXIT (0, "Exit", new ExitCommand()),

	CREATE_ACCOUNT (1, "Create Account", new CreateAccountCommand()),

	SET_ACCOUNT_AMOUNT (2, "Set Account's amount", new SetAcountAmountCommand()),
	
	CHANGE_ACCOUNT_CURRENCY (3, "Change Account's currency", new ChangeAcountCurrencyCommand()),

	FIND_ACCOUNT_BY_ID (4, "Find Account by id", new FindAccountByIdCommand()),

	FIND_ACCOUNT_BY_NAME (5, "Find Accounts by first or last person's name", new FindAccountByNameCommand()),

	PRINT_ALL_ACCOUNTS (6, "Print all accounts", new PrintAllAccountsCommand()),

	CHANGE_EXCHANGE_RATE (7, "Change exchange rate", new ChangeExchangeRateCommand());

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
		throw new ActionNotSupportedException(code);
	}

	public boolean executeCommand(AccountService accountService) {
		return action.execute(accountService);
	}
}
