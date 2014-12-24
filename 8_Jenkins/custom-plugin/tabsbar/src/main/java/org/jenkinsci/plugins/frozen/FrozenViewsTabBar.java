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
		return ViewUtil.getRedBallsCount(v);
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
			tabColour = Color.findByHtmlColor(formData.getString("tabColour"));

			save();
			return false;
		}

		private String labelText = "Olaf or Swen";

		public String getLabelText() {
			return labelText;
		}

		private Color tabColour = Color.YELLOW;

		public ListBoxModel doFillTabColourItems() {

			return new ListBoxModel(
					new Option(Color.GREEN.name(), Color.GREEN.getHtmlColor(), tabColour == Color.GREEN),
					new Option(Color.YELLOW.name(), Color.YELLOW.getHtmlColor(), tabColour == Color.YELLOW),
					new Option(Color.RED.name(), Color.RED.getHtmlColor(), tabColour == Color.RED),
					new Option(Color.BLUE.name(), Color.BLUE.getHtmlColor(), tabColour == Color.BLUE));
		}

		public String getTabColorText() {
			return tabColour.getHtmlColor();
		}

	}
}