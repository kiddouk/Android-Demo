package com.blah.reader;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Iterator;
import java.util.Date;

class RSSItemAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<RSSItem> mItems = new ArrayList<RSSItem>();
	
	
	public RSSItemAdapter( Context context, ArrayList<RSSItem> items)  {
		mContext = context;
		mItems = items;
	}
	
	
	@Override
	public int getCount() {
		return mItems.size();
	}
	
	@Override
	public Object getItem(int position) {
		Log.v("TRUC", "Just returned " + mItems.get(position).getTitle() + " - " + mItems.get(position).getDescription() );
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
		
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// The whole magic of the adaptor happens here !
		// Don't forget to uncomment ta piece of code
		// to activate optimization
		
		
		RSSItemView btv;
		
		//if (convertView == null) {
			
			btv = new RSSItemView(mContext, mItems.get(position), parent );
			Log.v("DEBUG", "position : " + position );
						
		//} else {
		//	Log.v("DEBUG", "REUSE ! ");
		//	btv = ( RSSItemView ) convertView;
		//}
		
		
		btv.mapData( mItems.get(position) );
				
		return btv;
	}

}
