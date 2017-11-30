//L00129017
//Aaron Clarke
//BSc Computing - Year 3
//Assignment 2
//30/11/2017

package ie.lyit.serialize;

import ie.lyit.test.Customer;

public interface CustomerSerializerDAO {

	public void add();
	
	public void list();
	
	public Customer view();
	
	public void delete();
	
	public void edit();
	
	public void writeRecordsToFile();
	
	public void readRecordsFromFile();

}
