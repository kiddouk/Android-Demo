package com.blah.reader;

import java.net.URL;
import java.io.InputStream;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

import android.util.Log;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import java.lang.Thread;


public class MyActivity extends Activity implements Runnable {
    /** Called when the activity is first created. */
    
    public static final String TAG = "MyRSSReader - MyActivity";
    private ListView lv;
    ProgressDialog dialog;
    final MyRSSHandler rssHandler = new MyRSSHandler();
    
    private Handler handler = new Handler() {
    	@Override
    	public void handleMessage(Message msg) {
    		dialog.dismiss();
    
    		            
            try {
           	 lv = (ListView) findViewById(R.id.ListView01);
            
           	 RSSItemAdapter adapter = new RSSItemAdapter(MyActivity.this, rssHandler.getRSSFeed().getItems() );
           	 lv.setAdapter( adapter );
           	 
           	 lv.setOnItemClickListener(new OnItemClickListener() { 
           				 @Override 
           				 public void onItemClick(AdapterView<?> parent, View v, 
           				 int position, long id) {
           					 Intent i = new Intent(Intent.ACTION_VIEW);
           					 String url = rssHandler.getRSSFeed().getItems().get(position).getUrl();
           					 i.setData( Uri.parse( url ));     				 
           					 startActivity(i);
           				 }
           			 }
           			 );
           			 
              	 
            } catch (Exception e) {
   			e.printStackTrace();
   		}
            

    		

    	}
    };

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Insert here a nice popup window
        
        this.refreshData(null);
        
    }
    
    
    public void refreshData(View v) {

    	// View v contains the Button pressed
    	// but we seriously don't care.
    	
    	setContentView(R.layout.main);

        dialog = ProgressDialog.show(this, "", "Loading. Please wait...", true);
        
        Thread thread = new Thread(this);
        thread.start();
    	
    }
    
    public void run() {
    	// Let's retrieve the information
    	Log.v("START", "");
    	XMLReader xmlReader = null;


    	try {

    		SAXParserFactory spfactory = SAXParserFactory.newInstance();
    		SAXParser saxParser = spfactory.newSAXParser();
    		xmlReader = saxParser.getXMLReader();

    		URL sourceUrl = new URL("http://www.kolios.dk/feed");
    		// Set our handler in the engine.

    		xmlReader.setContentHandler(rssHandler);
    		InputStream s = sourceUrl.openStream();

    		InputSource source = new InputSource(s);


    		xmlReader.parse(source);
    		// Let's retrieve out RSS Feed



    	} catch (Exception e) {
    		Log.v(TAG, "Exception : " + e.getMessage());
    	}

    	handler.sendEmptyMessage(0);

    }

}
