
package com.blah.reader.test;


import com.blah.reader.MyActivity;
import com.jayway.android.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;


public class RssReaderTest extends ActivityInstrumentationTestCase2<MyActivity>{
	
	private Solo solo;		
		
	public RssReaderTest() {
		super("com.blah.reader", MyActivity.class);
		
	}
	
	public void setUp() throws Exception {
		 solo = new Solo(getInstrumentation(), getActivity());
	}

	 
	@Smoke
	public void testRssList() throws Exception {
		solo.scrollDown();
		solo.scrollUp();

		
		// Should get the View out of that click.
		solo.clickInList(0);
		
	 }
	

	@Override
	public void tearDown() throws Exception {
		try {
			solo.finalize(); 	//Robotium will finish all the activities that have been open
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	} 
}


