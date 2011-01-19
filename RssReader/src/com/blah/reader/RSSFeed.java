package com.blah.reader;


import java.util.ArrayList;
import android.util.Log;

public class RSSFeed {
	private String title;
	private ArrayList<RSSItem> items;

	private static final String TAG = "RSSFEED";
	
	public ArrayList<RSSItem> getItems()
	{
		return this.items;
	}
	
	public void addItem(RSSItem item)
    {
        if (this.items == null)
            this.items = new ArrayList<RSSItem>();
        Log.v(TAG, "Adding Item");
        this.items.add(item);
        Log.v(TAG, "Items added");
    }
}
