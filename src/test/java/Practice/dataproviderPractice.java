package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderPractice {
@Test (dataProvider= "customerInfo")
public void createCutomer(String name, int id) {
	
	System.out.println("Name of the customer is :" + name );
	System.out.println("id of the customer is :" + id );
	
}
//stock the data

@DataProvider (name= "customerInfo")
public Object[][] getDataforCreateCustomer(){
	Object[][] data =new Object[4][2]; //4 sets of data 2 types of info(attributes), rows and columns
	
	data[0][0]= "Vrunda";
	data [0][1]= 15;
	
	data[1][0]= "Ravi";
	data[1][1]= 16;
	
	data[2][0]= "Aditi";
	data [2][1]= 17;
	
	data[3][0]= "Bhargavi";
	data[3][1]= 18;
	return data;
}
}
