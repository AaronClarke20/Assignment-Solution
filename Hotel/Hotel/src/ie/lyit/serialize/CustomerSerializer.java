//L00129017
//Aaron Clarke
//BSc Computing - Year 3
//Assignment 2
//30/11/2017

package ie.lyit.serialize;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import ie.lyit.test.Customer;

public class CustomerSerializer implements CustomerSerializerDAO {
	// Constant FILENAME for the file to be created
	final String FILENAME = "customers.bin";

	private static CustomerSerializer singleInstance;
	
	// Declare ArrayList called books - for storing a list of books
	private ArrayList<Customer> customers;
	

	// Default Constructor
	private CustomerSerializer(){
		System.out.println("OK - Inside Customer Serializer Class Constructor");
		// Construct books ArrayList
		customers = new ArrayList<Customer>();
	}
	
	public static CustomerSerializer getSingleInstance() {
		if(singleInstance == null) {
			singleInstance = new CustomerSerializer();
			System.out.println("OK - Single Object Created: " + singleInstance);
	}
		return singleInstance;
	}
	public void displaySingleton() {
		System.out.println("OK - Customer Serializer Object: " + singleInstance);
	}

	//////////////////////////////////////////////////////
	// Method Name : add()								//
	// Return Type : void								//
	// Parameters : None								//
	// Purpose : Reads one Book record from the user    //
	//           and adds it to the ArrayList books     //
	//////////////////////////////////////////////////////	
	public void add(){
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();	
		// And add it to the books ArrayList
		customers.add(customer);
	}

	////////////////////////////////////////////////////////
	// Method Name : list()							      //
	// Return Type : void			  				      //
	// Parameters : None						 	      //
	// Purpose : Lists all Book records in the ArrayList  //
	////////////////////////////////////////////////////////	
	public void list(){
		// for every Book object in books
      for(Customer tmpCust:customers)
			// display it
			System.out.println(tmpCust);
	}
	
	////////////////////////////////////////////////////////////
	// Method Name : view()									  //
	// Return Type : void								      //
	// Parameters : None								      //
	// Purpose : Displays the required Book record on screen  //
	//         : And returns it, or null if not found         //   
	////////////////////////////////////////////////////////////	
	public Customer view(){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);		

		// Read the number of the book to be viewed from the user
		System.out.println("ENTER NUMBER OF Customer : ");
		int CustToFind=keyboard.nextInt();
		
		// for every Book object in books
	    for(Customer tmpCust:customers){
		   // if it's number equals the number of the bookToView
		   if(tmpCust.getNumber() == CustToFind){
		      // display it
			  System.out.println(tmpCust);
			  return tmpCust;
		   }
		}
	    // if we reach this code the book was not found so return null
	    return null;		
	}

	///////////////////////////////////////////////////////////
	// Method Name : delete()								 //
	// Return Type : void									 //
	// Parameters : None									 //
	// Purpose : Deletes the required Book record from books //
	///////////////////////////////////////////////////////////	
	public void delete(){	
		// Call view() to find, display, & return the book to delete
		Customer tmpCust = view();
		// If the book != null, i.e. it was found then...
	    if(tmpCust != null)
		   // ...remove it from books
	       customers.remove(tmpCust);
	}
	
	///////////////////////////////////////////////////////////
	// Method Name : edit()			  					     //
	// Return Type : void									 //
	// Parameters : None									 //
	// Purpose : Edits the required Book record in books     //
	///////////////////////////////////////////////////////////	
	public void edit(){	
		// Call view() to find, display, & return the book to edit
		Customer tmpCust = view();
		// If the book != null, i.e. it was found then...
	    if(tmpCust != null){
		   // get it's index
		   int index=customers.indexOf(tmpCust);
		   // read in a new book and...
		   tmpCust.read();
		   // reset the object in books
		   customers.set(index, tmpCust);
	    }
	}
	
	///////////////////////////////////////////////////////
	// Method Name : writeRecordsToFile()    			 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Writes the ArrayList books to the       //
	//		     File Books.bin before closing the File  //
	///////////////////////////////////////////////////////	
	public void writeRecordsToFile(){
		try{
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
	
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
	
			os.writeObject(customers);
	
			os.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	///////////////////////////////////////////////////////
	// Method Name : readRecordsFromFile()    			 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads the ArrayList from the File back  //
	//		     into books before closing the File      //
	///////////////////////////////////////////////////////	
	@SuppressWarnings("unchecked")
	public void readRecordsFromFile(){
		try{
			// Deserialize the ArrayList...
			FileInputStream fis = new FileInputStream(FILENAME);
			
			ObjectInputStream is = new ObjectInputStream(fis);

			// COULD use code below to ensure it is an ArrayList
			// BUT no need-we are confident file contains an ArrayList
			// Object o = is.readObject(); 	// READ an object from the file
			// if(o instanceof ArrayList)  	// IF object is an ArrayList
			//    books=(ArrayList<Book>)o;//    ASSIGN object to books			
			customers = (ArrayList<Customer>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find customer file.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}				
	}	

}