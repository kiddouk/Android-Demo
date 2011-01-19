package com.blah.reader;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;

import java.util.ArrayList;

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
		RSSItemView btv;
		if (convertView == null) {
			btv = new RSSItemView(mContext, mItems.get(position));
			Log.v("ZOB", btv.getDescriptionText());
		} else {
			btv = (RSSItemView) convertView;
			String title = mItems.get(position).getTitle();
			btv.setTitleText(title);
			String description = mItems.get(position).getDescription();
			btv.setDescriptionText(description);
		}
		return btv;
	}

	
}
