package org.jenkinsci.plugins.frozen;

import java.io.IOException;

import javax.servlet.ServletException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import hudson.util.FormFieldValidator;

public class DistributedTestRecorder extends Recorder {
	public static String DISPLAY_NAME = "Frozen plugin";

	private final String report;

	@DataBoundConstructor
	public DistributedTestRecorder(String report) {
		this.report = report;
	}

	public String getReport() {
		return report;
	}

	public boolean perform(AbstractBuild build, Launcher launcher,
			BuildListener listener) {
		
		listener.getLogger().println("Frozen plugin output");
		return true;
	}

	@Extension
	public static final class DescriptorImpl extends
			BuildStepDescriptor<Publisher> {
		@Override
		public String getDisplayName() {
			return DistributedTestRecorder.DISPLAY_NAME;
		}

		public void doCheck(StaplerRequest res, StaplerResponse rsp)
				throws IOException, ServletException {
			//new FormFieldValidator.WorkspaceDirectory(res, rsp).process();
			
		}

		@Override
		public boolean isApplicable(Class arg0) {
			return true;
		}
	}

	public BuildStepMonitor getRequiredMonitorService() {
		// TODO Auto-generated method stub
		return null;
	}
}
