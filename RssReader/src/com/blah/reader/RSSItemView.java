package com.blah.reader;

import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.ImageView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.Display;
import android.view.ViewGroup;
import android.view.View;

import android.util.Log;

import android.graphics.Color;
import android.graphics.Typeface;
import java.util.Iterator;



public class RSSItemView extends LinearLayout {

	private TextView mTitle, mDescription, mCategories;
	private ImageView mIcon, mArrow;
	private LinearLayout mLayout1;
	private LinearLayout mLayout2;
	private LayoutInflater mInflater;
	
	public RSSItemView(Context context, RSSItem rssItem, ViewGroup parent) {
		super (context);
		
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	

		View v = mInflater.inflate(R.layout.rssitemview, parent);

		
		String categories = new String();
		
		Iterator it = rssItem.getCategories().iterator();
		while (it.hasNext()) {
			categories += it.next() + " ";
		}
		
		
		mCategories = (TextView) v.findViewById(R.id.itemCategories);
		mCategories.setText(categories);
		
		mTitle = (TextView) v.findViewById(R.id.itemTitle);

		Typeface tf_folio = Typeface.createFromAsset(context.getAssets(),"Folio Bold BT.ttf");
		mTitle.setTypeface(tf_folio);

		mTitle.setText( rssItem.getTitle() );
		
		mDescription = (TextView) v.findViewById(R.id.itemDescription);
		mDescription.setText( rssItem.getDescription() );
		

//		mLayout1.setPadding(5, 5, 5, 5);

//		mLayout2.setPadding(0, 0, 0, 5);

		
		
		
//		mIcon.setPadding(5, 0, 10, 0);
//		mIcon.setScaleType(ImageView.ScaleType.FIT_XY);
		
		
//		mTitle.setPadding(0, 0, 0, 0);		
//		mTitle.setTextColor(Color.argb(255, 77, 77, 77));
	//	mTitle.setBackgroundColor(Color.BLACK);
		
		
//		mDescription.setPadding(40, 0, 0, 0);
//		mDescription.setText( rssItem.getDescription() );
//		mDescription.setTextSize(13);
//		mDescription.setLineSpacing((float)0.0, (float)1.1);
//		mDescription.setTextColor(Color.argb(255, 153, 153, 153));
//		mDescription.setLines(1);
//		mDescription.setHorizontalFadingEdgeEnabled(true);
	//	mDescription.setBackgroundColor(Color.RED);
				
		
//		mArrow.setScaleType(ImageView.ScaleType.FIT_XY);
//		mArrow.setPadding(0, 15, 0, 0);
	//	mArrow.setBackgroundColor(Color.BLUE);

		
//		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//		Display display = wm.getDefaultDisplay();
//		int width = display.getWidth();
		
//		this.addView(mLayout2, new LinearLayout.LayoutParams(width - 20, LayoutParams.WRAP_CONTENT));
				
			
		
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
