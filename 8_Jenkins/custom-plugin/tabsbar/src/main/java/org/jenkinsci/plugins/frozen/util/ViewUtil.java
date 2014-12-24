package org.jenkinsci.plugins.frozen.util;

import hudson.model.TopLevelItem;
import hudson.model.Job;
import hudson.model.View;

public class ViewUtil {

	public static int getRedBallsCount(View v) {

		int failed = 0;

		for (TopLevelItem item : v.getItems()) {
			for (Job j : item.getAllJobs()) {

				switch (j.getIconColor()) {
				case RED:
					failed++;
					break;
				case BLUE:
				case YELLOW:
				case DISABLED:
				default:
					break;
				}
			}
		}

		return failed;
	}
}
