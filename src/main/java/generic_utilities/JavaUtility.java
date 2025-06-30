package generic_utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists generic methods related to specific tasks
 */
public class JavaUtility {
	
	/**
	 * This method will capture the current system date and return to the caller
	 * @return
	 */
public String getSystemDate() //screenshot date, report date 
	{
	Date d= new Date();
	SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
	String date = s.format(d);
	return date;
	
}

}
