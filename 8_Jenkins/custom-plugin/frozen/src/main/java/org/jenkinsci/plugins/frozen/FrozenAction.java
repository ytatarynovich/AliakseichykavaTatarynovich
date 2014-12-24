package org.jenkinsci.plugins.frozen;

import org.apache.log4j.Logger;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Result;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;

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
	* Gets the URL name for this action (used in jelly files)
	* @return the URL name
	*/
	//@Override
	public String getUrlName() {
		return "frozen";
	}

	//--------------------
	private Style style;

	public FrozenAction(Result result) {
		this.style = Style.getByBuildResult(result);
		log.info("FrozenAction is created");
	}

	public String getText() {
		return style.getText();
	}

	public String getImageName() {
		return style.getImageName();
	}

	

}
