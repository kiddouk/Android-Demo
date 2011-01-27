package com.blah.reader;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Context;
import android.view.WindowManager;
import android.view.Display;

import android.util.Log;

import android.graphics.Color;
import android.graphics.Typeface;
import java.util.Iterator;



public class RSSItemView extends LinearLayout {

	private TextView mTitle, mDescription, mCategories;
	private ImageView mIcon, mArrow;
	private LinearLayout mLayout1;
	private LinearLayout mLayout2;
	
	public RSSItemView(Context context, RSSItem rssItem) {
		super (context);
		Log.v("TEST1", "youpi");
		this.setOrientation(HORIZONTAL);
//		this.setPadding(5, 10, 30, 10);
		
		mLayout1 = new LinearLayout(context);
		mLayout1.setOrientation(HORIZONTAL);
		mLayout1.setPadding(5, 5, 5, 5);

		mLayout2 = new LinearLayout(context);
		mLayout2.setOrientation(VERTICAL);
		mLayout2.setPadding(0, 0, 0, 5);

		
		String categories = new String();
		
		Iterator it = rssItem.getCategories().iterator();
		Log.v("TEST", "Bblah !");
		while (it.hasNext()) {
			categories += it.next() + " ";
		}
		
		mCategories = new TextView(context);
		mCategories.setPadding(40, 0, 0, 0);		
		mCategories.setText( categories );
		mCategories.setTextSize(11);
		mCategories.setTextColor(Color.argb(255, 153, 153, 153));
	//	mTitle.setBackgroundColor(Color.BLACK);
		
		
		mIcon = new ImageView(context);
		mIcon.setImageResource(R.drawable.favicon);
		mIcon.setPadding(5, 0, 10, 0);
		mIcon.setScaleType(ImageView.ScaleType.FIT_XY);
				
		mTitle = new TextView(context);

		Typeface tf_folio = Typeface.createFromAsset(context.getAssets(),"Folio Bold BT.ttf");
		mTitle.setTypeface(tf_folio);
		
		
		mTitle.setPadding(0, 0, 0, 0);		
		mTitle.setText( rssItem.getTitle() );
		mTitle.setTextSize(14);
		mTitle.setTextColor(Color.argb(255, 77, 77, 77));
	//	mTitle.setBackgroundColor(Color.BLACK);
		
		
		mDescription = new TextView(context);
		mDescription.setPadding(40, 0, 0, 0);
		mDescription.setText( rssItem.getDescription() );
		mDescription.setTextSize(13);
		mDescription.setLineSpacing((float)0.0, (float)1.1);
		mDescription.setTextColor(Color.argb(255, 153, 153, 153));
		mDescription.setLines(1);
		mDescription.setHorizontalFadingEdgeEnabled(true);
	//	mDescription.setBackgroundColor(Color.RED);
		
		
		mLayout1.addView(mIcon, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		mLayout1.addView(mTitle, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	//	mLayout1.setBackgroundColor(Color.CYAN);
	//	mLayout1.setPadding(3, 3, 3, 3);
		
		mLayout2.addView(mCategories, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		mLayout2.addView(mLayout1, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		mLayout2.addView(mDescription, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	//	mLayout2.setBackgroundColor(Color.GREEN);
	//	mLayout2.setPadding(3, 3, 3, 3);
		
		
		mArrow = new ImageView(context);
		mArrow.setImageResource(R.drawable.arrow);

		mArrow.setScaleType(ImageView.ScaleType.FIT_XY);
		mArrow.setPadding(0, 15, 0, 0);
	//	mArrow.setBackgroundColor(Color.BLUE);

		
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		int width = display.getWidth();
		
		this.addView(mLayout2, new LinearLayout.LayoutParams(width - 20, LayoutParams.WRAP_CONTENT));
		this.addView(mArrow, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
			
		
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
