package com.blah.reader;

import java.util.ArrayList;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class RSSItem {
	private String title;
	private String description;
	private Date date;
	private String url;
	private ArrayList<String> categories;
	
	
	public RSSItem() {
		this.categories = new ArrayList<String>();
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
				
		String pattern = "E, dd MMM yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			this.date = format.parse(date);
		} catch (ParseException e) {
			Log.v("DateFormat", "ParseException occured");
		}
		
	}

	public Date getDate() {
		return this.date;
	}
	
	public void addCategory(String category) {
		Log.v("CAT", "Adding category");
		this.categories.add(category);
	}
	
	public ArrayList<String> getCategories() {
		return this.categories;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}	
	
	public String getUrl() {
		return this.url;
	}
	
}
