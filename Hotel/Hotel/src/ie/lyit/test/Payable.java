//L00129017
//Aaron Clarke
//BSc Computing - Year 3
//Assignment 2
//30/11/2017

package ie.lyit.test;

public interface Payable {
	public abstract double calculateWage(double taxPercentage);
	// Don't have to put in public abstract
	double incrementSalary(double incrementAmount);
}
