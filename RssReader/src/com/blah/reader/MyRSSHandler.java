package com.blah.reader;


import org.xml.sax.Attributes;
import android.util.Log;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;


public class MyRSSHandler extends DefaultHandler {
	
	
	private static final String TAG = "MyRSSReader - RSSHandler";
	private RSSFeed myRSSFeed;
	
	private RSSItem temp_item;
	
	private String temp_text;
	private Boolean shouldDump;
	
	public MyRSSHandler() {

		Log.v(TAG, "Handler created");

	}

	public RSSFeed getRSSFeed() {
		return myRSSFeed;
	}
	
	
	public void startDocument() throws SAXException {
		this.temp_text = new String();
		this.shouldDump = false;

		//Log.v(TAG, "Document started");
		this.myRSSFeed = new RSSFeed();
	}
	
	
	public void endDocument() throws SAXException {
		
		Log.v(TAG, "Document ended");
	}
	
	
	
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
		throws SAXException {
		//Log.v(TAG, "Element Started: " + localName);


		if ( qName.equals("item") ) {
			Log.v(TAG, "Creating a new Item");
			this.temp_item = new RSSItem();			
		}
		
		else if (qName.equals("title") || qName.equals("description") || qName.equals("category") ||
				qName.equals("pubDate") || qName.equals("link")) {
			_resetBuffer();
			this.shouldDump = true;
		} else {
			this.shouldDump = false;
		}
	}
	
	public void endElement(String namespaceURI, String localName, String qName)
	
		// End of element => We have parsed that element !
		// Time to save the data that we just collected.
	
		throws SAXException {

		// Log.v(TAG, "Element ended: " + qName);

		if (this.temp_item != null && qName.equals("title")) {
			this.temp_item.setTitle(this.temp_text);
			this.temp_text = new String();

		} else if ( this.temp_item != null && qName.equals("description") ) {
			String text = this.temp_text.replaceAll("<!\\[CDATA\\[","");
			text = text.replaceAll("\\]\\]>", "");
			text = text.replaceAll("\\<.*?>","");
			
			if ( text.length() > 100 )
				text = text.substring(0, 100);
			this.temp_item.setDescription( text );
			this.temp_text = new String();

		} else if ( this.temp_item != null && qName.equals("pubDate") ) {
			this.temp_item.setDate( this.temp_text );

		} else if ( this.temp_item != null && qName.equals("category") ) {
			this.temp_item.addCategory( this.temp_text );

		} else if ( this.temp_item != null && qName.equals("link") ) {
			this.temp_item.setUrl( this.temp_text );

		} else if ( this.temp_item != null && qName.equals("item") ) {
			Log.v( TAG, this.temp_item.toString() );
			this.myRSSFeed.addItem(this.temp_item);
		}
	}

	private void _resetBuffer() {
		if ( this.temp_text.length() != 0 ) {
			this.temp_text = new String();
		}
	}
	
	public void characters(char[] ch, int start, int length)
		throws SAXException  {
		
		if (this.shouldDump == true) {
			for(int i = start; i < start + length; i++){
				this.temp_text += ch[i];
			}
		}		
		//Log.v(TAG, "We got characters !: " + this.temp_text);
	}

	
}
