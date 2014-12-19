package org.jenkinsci.plugins.frozen;

import org.apache.log4j.Logger;
import org.kohsuke.stapler.DataBoundConstructor;

import hudson.model.Action;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;
import hudson.model.Result;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;

import java.io.IOException;

/**
 * Copyright: https://github.com/jenkinsci/chucknorris-plugin/ (was taken as example)
 */
public class FrozenRecorder extends Recorder {

	protected static final Logger log = Logger.getLogger(FrozenRecorder.class);

	@DataBoundConstructor
	public FrozenRecorder() {
		log.info("FrozenRecorder is created");
	}


	/**
	* Gets the FrozenAction as the project action. This is applicable for
	* each job and only when there's at least one build in the job.
	* @param project
	*            the project
	* @return the project action
	*/
	@Override
    public final Action getProjectAction(final AbstractProject<?, ?> project) {
        Action action = null;
        if (project.getLastBuild() != null) {
            Result result = project.getLastBuild().getResult();
             action = new FrozenAction(result);
        }
        return action;
    }
	
	/**
     * Adds FrozenAction to the build actions. This is applicable for each
     * build.
     * @param build
     *            the build
     * @param launcher
     *            the launcher
     * @param listener
     *            the listener
     * @return true
     * @throws InterruptedException
     *             when there's an interruption
     * @throws IOException
     *             when there's an IO error
     */
    @Override
    public final boolean perform(final AbstractBuild<?, ?> build,
            final Launcher launcher, final BuildListener listener)
            throws InterruptedException, IOException {
    	Result result = build.getResult();
        build.getActions().add(new FrozenAction(result));
        return true;
    }
	
	//@Override
		public BuildStepMonitor getRequiredMonitorService() {
			return BuildStepMonitor.NONE;
		}

}
