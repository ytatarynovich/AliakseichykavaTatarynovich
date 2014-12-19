package org.jenkinsci.plugins.frozen;

import org.apache.log4j.Logger;

import hudson.model.Action;
import hudson.model.Result;

/**
 * Copyright: https://github.com/jenkinsci/chucknorris-plugin/ (was taken as example)
 */
public class FrozenAction implements Action {

	protected static final Logger log = Logger.getLogger(FrozenAction.class);

	/**
	* Gets the action display name.
	* @return the display name
	*/
	//@Override
	public String getDisplayName() {
		return "Frozen Action";
	}

	/**
	* This action doesn't provide any icon file.
	* @return null
	*/
	//@Override
	public String getIconFileName() {
		return null;
	}

	/**
	* Gets the URL name for this action.
	* @return the URL name
	*/
	//@Override
	public String getUrlName() {
		return "frozen";
	}

	//--------------------
	private Result result;

	public FrozenAction(Result result) {
		this.result = result;
		log.info("FrozenAction is created");
	}
	
	public Result getResult() {
		return result;
	}

}
