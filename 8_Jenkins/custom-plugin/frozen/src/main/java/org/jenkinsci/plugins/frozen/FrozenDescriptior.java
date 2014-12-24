package org.jenkinsci.plugins.frozen;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;

/**
 * Copyright: https://github.com/jenkinsci/chucknorris-plugin/ (was taken as example)
 * This class provides build step description.
 */
@Extension
public class FrozenDescriptior extends BuildStepDescriptor<Publisher> {

	public FrozenDescriptior() {
		super(FrozenRecorder.class);
	}

	/**
     * Gets the descriptor display name, used in the post step checkbox
     * description.
     * @return the descriptor display name
     */
	@Override
	public String getDisplayName() {
		return "Activate Frozen";
	}

	/**
     * Checks whether this descriptor is applicable.
     * @param clazz
     *            the class
     * @return true - of course the beard is applicable
     */
	@Override
	public final boolean isApplicable(final Class<? extends AbstractProject> jobType) {
		return true;
	}
}