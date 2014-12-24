package org.jenkinsci.plugins.frozen;

import hudson.model.Result;

public enum Style {

	SUCCESS("Olaf congratulates you with successful build!", "Olaf.gif"),
	FAILED("Swen is dissapointed with results...", "Swen.gif");

	private String text;
	private String imageName;

	Style(String text, String imageName) {
		this.text = text;
		this.imageName = imageName;
	}

	public static Style getByBuildResult(Result result) {

		if(result == Result.SUCCESS) {
			return SUCCESS;
		} else {
			return FAILED;
		}
	}

	public String getText() {
		return text;
	}

	public String getImageName() {
		return imageName;
	}

}
