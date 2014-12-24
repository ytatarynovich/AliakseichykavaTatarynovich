package org.jenkinsci.plugins.frozen;

public enum Color {

	YELLOW("ffff00"),
	GREEN("00ff00"),
	RED("ff0000"),
	BLUE("00ffff");

	private String htmlColor;

	Color(String htmlColor) {
		this.htmlColor = htmlColor;
	}

	public String getHtmlColor() {
		return htmlColor;
	}

	public static Color findByHtmlColor(String htmlColor) {
		for(Color color : values()) {
			if(color.getHtmlColor().equals(htmlColor)) {
				return color;
			}
		}
		throw new RuntimeException("Color [" + htmlColor + "] is not supported");
	}
}
