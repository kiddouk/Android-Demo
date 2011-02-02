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
	public int getViewTypeCount() {
		return 2;
	}
	
	@Override
	public int getItemViewType(int position){
		return 0;
		
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
		RSSItemView btv;
		
		if (convertView == null || ! this.isGoodView( (RSSItemView) convertView, position )) {
			
			btv = new RSSItemView(mContext, mItems.get(position), parent, this.isNewGroup(position) );
			Log.v("DEBUG", "position : " + position );
			Log.v("DEBUG", "title: " + mItems.get(position).getTitle() );
						
		} else {
			Log.v("DEBUG", "REUSE ! ");
			btv = ( RSSItemView ) convertView;
		}
		
		
		btv.mapData( mItems.get(position) );
		
		

			
//			String description = mItems.get(position).getDescription();
//			btv.setDescriptionText(description);
		
		return btv;
	}

	private boolean isGoodView(RSSItemView view, int position) {
		
		return this.isNewGroup(position) == view.isHeader();
		
	}
	
	
	private boolean isNewGroup(int position) {
		
		if (position == 0)
			return true;
		
		Date dateCurrentItem = this.mItems.get(position).getDate();
		Date datePreviousItem = this.mItems.get(position - 1).getDate();

		return ! dateCurrentItem.equals(datePreviousItem);
	}
}
