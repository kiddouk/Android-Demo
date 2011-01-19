package com.blah.reader;

public class RSSItem {
	private String title;
	private String description;
	private String date;
	private String url;
	
	
	public RSSItem() {
		
	}
	
	public String toString() {
		String str = new String();
		

		str += "Title: " + this.title + "\n";
		str += "Date: " + this.date.toString() + "\n";
		str += "Description: " + this.description + "\n";
		str += "URL: " + this.url + "\n";
		
		return str;
		
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return this.date;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}	
	
	public String getUrl() {
		return this.url;
	}
	
}