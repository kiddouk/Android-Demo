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
		View btv;
		if (convertView == null) {
//			btv = new RSSItemView(mContext, mItems.get(position), parent);
			
			LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	

			btv = mInflater.inflate(R.layout.rssitemview, parent, false);
						
		} else {

			btv = convertView;
			
		}
			Typeface tf_folio = Typeface.createFromAsset(mContext.getAssets(),"Folio Bold BT.ttf");

			TextView title = ( TextView ) btv.findViewById(R.id.itemTitle);
			title.setText( mItems.get(position).getTitle() );
			title.setTypeface(tf_folio);

			TextView description = ( TextView ) btv.findViewById( R.id.itemDescription );
			description.setText ( mItems.get(position).getDescription() );
			
			String categories = new String();
			
			Iterator it = mItems.get(position).getCategories().iterator();
			while (it.hasNext()) {
				categories += it.next() + " ";
			}
			
			TextView categories_tv = ( TextView ) btv.findViewById( R.id.itemCategories );
			categories_tv.setText( categories );

			
//			String description = mItems.get(position).getDescription();
//			btv.setDescriptionText(description);
		
		return btv;
	}

	
}
