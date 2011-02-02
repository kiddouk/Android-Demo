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
import java.text.SimpleDateFormat;


public class RSSItemView extends LinearLayout {

	private LayoutInflater mInflater;
	private View mView;
	private Context mContext;
	
	public RSSItemView(Context context, RSSItem rssItem, ViewGroup parent) {
		super (context);
		this.mContext = context;
		
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	
		
		
		// Infate, simply convert your XML file into an Object ( a View ) so you can
		// use it. Simple and efficient.
		
		mView = mInflater.inflate(R.layout.rssitemview, parent, false);

		// Our RSSItemView is a VIEW by itself. Make sure that the inflated view
		// is part of our object. Otherwise, we will render nothing.
		this.addView(mView, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

	}
	

	public void mapData( RSSItem rssItem ) {
		// We simply get any Widget but its ID. We change
		// the text according to the content of the RSS Item.
				
		String categories = new String();		

		Iterator it = rssItem.getCategories().iterator();
		while (it.hasNext()) {
			categories += it.next() + " ";
		}
		
		// Place your TTF font in the "res" directory
		// Typeface tf_folio = Typeface.createFromAsset(mContext.getAssets(),"Folio Bold BT.ttf");

		TextView title = ( TextView ) mView.findViewById(R.id.itemTitle);
		title.setText( rssItem.getTitle() );
		//title.setTypeface(tf_folio);
		
		TextView description = ( TextView ) mView.findViewById( R.id.itemDescription );
		description.setText ( rssItem.getDescription() );
		
		
		TextView categories_tv = ( TextView ) mView.findViewById( R.id.itemCategories );
		categories_tv.setText( categories );
		
		TextView tvCategories = (TextView) mView.findViewById(R.id.itemCategories);
		tvCategories.setText(categories);
		
		TextView tvTitle = (TextView) mView.findViewById(R.id.itemTitle);

		//tvTitle.setTypeface(tfFolio);

		tvTitle.setText( rssItem.getTitle() );
		
		TextView tvDescription = (TextView) mView.findViewById(R.id.itemDescription);
		tvDescription.setText( rssItem.getDescription() );
		

		this.setOrientation(VERTICAL);
		
	}
	
}
