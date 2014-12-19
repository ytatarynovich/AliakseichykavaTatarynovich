package org.jenkinsci.plugins.frozen;

import hudson.Extension;
import hudson.model.View;
import hudson.util.ListBoxModel;
import hudson.util.ListBoxModel.Option;
import hudson.views.ViewsTabBar;
import hudson.views.ViewsTabBarDescriptor;
import net.sf.json.JSONObject;

import org.jenkinsci.plugins.frozen.util.ViewUtil;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

public class FrozenViewsTabBar extends ViewsTabBar {

	@DataBoundConstructor
	public FrozenViewsTabBar() {
		super();
	}

	public String getTabLabel() {
		FrozenViewsTabBarDescriptor descriptor = (FrozenViewsTabBarDescriptor) super.getDescriptor();
		return descriptor.getLabelText();
	}

	public String getTabColour() {
		FrozenViewsTabBarDescriptor descriptor = (FrozenViewsTabBarDescriptor) super.getDescriptor();
		return descriptor.getTabColorText();
	}

	public int getFailureCount(View v){
		return ViewUtil.getRedBallCount(v);
	}

	@Extension
	public static final class FrozenViewsTabBarDescriptor extends ViewsTabBarDescriptor {

		public FrozenViewsTabBarDescriptor() {
			load();
		}

		@Override
		public String getDisplayName() {
			return "Frozen - Custom Views TabBar";
		}

		@Override
		public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
			labelText = formData.getString("labelText");
			tabColour = formData.getString("tabColour");

			save();
			return false;
		}

		private String labelText = "Olaf or Swen";

		public String getLabelText() {
			return labelText;
		}

		private String tabColour = "ffff00";

		public ListBoxModel doFillTabColourItems() {

			return new ListBoxModel(new Option("Green", "00ff00",
					tabColour.equals("00ff00")), new Option("Yellow", "ffff00",
					tabColour.equals("ffff00")), new Option("Red", "ff0000",
					tabColour.equals("ff0000")));
		}

		public String getTabColorText() {
			return tabColour;
		}

	}
}