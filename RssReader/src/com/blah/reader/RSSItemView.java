package com.blah.reader;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;

import android.util.Log;

import android.graphics.Color;

public class RSSItemView extends LinearLayout {

	private TextView mTitle, mDescription;
	
	
	public RSSItemView(Context context, RSSItem rssItem) {
		super (context);
		Log.v("TEST1", "youpi");
		this.setOrientation(VERTICAL);
		mTitle = new TextView(context);
		mDescription = new TextView(context);
		
		mTitle.setText( rssItem.getTitle() );
		mTitle.setTextSize(14);
		mTitle.setTextColor(Color.BLACK);

		
		mDescription.setText( rssItem.getDescription() );
		mDescription.setTextSize(11);
		mDescription.setTextColor(Color.GRAY);
		
		
		addView(mTitle, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		addView(mDescription, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
	}
	
	public String getTitleText() {
		return mTitle.toString();
	}
	
	public void setTitleText(String text) {
		mTitle.setText(text);
	}
	
	public String getDescriptionText() {
		return mDescription.toString();
		
	}
	
	public void setDescriptionText(String text) {
		mDescription.setText( text );
	}
	
}
