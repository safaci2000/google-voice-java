package test.datatypes.records;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.techventus.server.voice.datatypes.Contact;
import com.techventus.server.voice.datatypes.records.ShortMessage;

/**
 * 
 * @author bFutral
 *
 */
public class ShortMessageTest {

	//Constructors for 
	final static String ID = "testID";
	final static String TITLE = "testTitle";
	final Date DATE = new Date(1321038671000l);
	final Contact CONTACT = new Contact("testName", "testID", "testNumber", "testURL");
	
	ShortMessage testShortMessage = new ShortMessage(ID, TITLE, DATE, CONTACT, true);
	
	@Test
	public void testShortMessageToStringOverrideFull() {
		
		Assert.assertEquals("id=testID;title=testTitle;date=Fri Nov 11 11:11:11 PST 2011;contact={id=testID;name=testName;number=testNumber;imageUrl=testURL;};read=true;", testShortMessage.toString());	
		
	}
	
	@Test
	public void testShortMessageToStringOverrideNoID() {
		
		testShortMessage.setId(null);
		
		Assert.assertEquals("title=testTitle;date=Fri Nov 11 11:11:11 PST 2011;contact={id=testID;name=testName;number=testNumber;imageUrl=testURL;};read=true;", testShortMessage.toString());

	}
	
	@Test
	public void testShortMessageToStringOverrideNoTitle() {
		
		testShortMessage.setTitle(null);
		
		Assert.assertEquals("id=testID;date=Fri Nov 11 11:11:11 PST 2011;contact={id=testID;name=testName;number=testNumber;imageUrl=testURL;};read=true;", testShortMessage.toString());
	}
	
	@Test
	public void testShortMessageToStringOverrideNoDate() {
		
		testShortMessage.setDate(null);
		
		Assert.assertEquals("id=testID;title=testTitle;contact={id=testID;name=testName;number=testNumber;imageUrl=testURL;};read=true;", testShortMessage.toString());
	}
	
	@Test
	public void testShortMessageToStringOverrideNoContact() {
		
		testShortMessage.setContact(null);
		
		Assert.assertEquals("id=testID;title=testTitle;date=Fri Nov 11 11:11:11 PST 2011;read=true;", testShortMessage.toString());
	}

}