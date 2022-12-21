//Hasan Pekedis 150120068
//This class's object represents a factory with employees.
//getRevenue method calculates total revenue of factory. It returns a double value.
//getPaidSalaries method calculates total salaries of all employees. It returns a double value.
//addEmployee method adds employee objects to factory. Also this method adds employee's items 
//to startShift method. In this way items store in items.
//removeEmployee method removes employees from employees array. Also it checks if there is no employee
//that have input id and method change output base on this checks.
//addPayroll method create payroll objects for Payroll class. It returns payroll object.
//resizeEmployeeArray method changes size of employee arrays because we have to change array when
//add employee.
//checkEmployee method checks id list for new employees.
//resizePayrollArray method changes size of payroll arrays because we have to change array when
//add a payroll.
//employeeIdFinder method checks ids for new employees.
//There are set and get methods for each data field.
//Also I used java.util.Arrays for using Arrays.copyOf().
import java.util.Arrays;

public class Factory {

    private String name;
    private Employee[] employees;
    private Storage storage;
    private Payroll[] payrolls;
    private double itemPrice;
    
    public Factory(String name, int capacity, double itemPrice) {
    	Storage storage = new Storage(capacity);
    	
    	this.storage = storage;
        this.name = name;
        this.itemPrice = itemPrice;
    }
  
    public double getRevenue(){
        Item[] storageList = storage.getItems();
        if (storageList == null) {
        	return 0;
        } 
        else {
        	double revenue = storageList.length * itemPrice;
            return revenue;
        }
    }
    public double getPaidSalaries(){
    	double paidSalaries = 0;
    	for (int i = 0; i < this.payrolls.length; i++) {
    		paidSalaries = paidSalaries + this.payrolls[i].calculateSalary();
    	}
    	return paidSalaries;
    }
    public void addEmployee(Employee employee){
    	if (employees == null) {
    		Employee[] baseList= new Employee[1];
    		baseList[0] = employee;
    		this.employees = baseList;
        	Item[] items = employee.startShift();
        	for (int i = 0; i < items.length; i++) {
        		this.storage.addItem(items[i]);
        	}
    	} 
    	else {
        	this.employees = resizeEmployeeArray(employees);
        	this.employees[employees.length - 1] = employee;
        
        	Item[] newItems = employee.startShift();
        	for (int i = 0; i < newItems.length; i++) {
        		this.storage.addItem(newItems[i]);
        	}
    	}
    	
    }
    public void removeEmployee(int id) {
    	if (employees == null) {
    		System.out.println("There are no employees!");
    	} 
    	else if (checkEmployee(id)) {
    		System.out.println("Employee does not exist!");
    	} 
    	else if (employees.length == 1) {
    		employees = null;
    	} 
    	else {
    		int employeeId = employeeIdFinder(id);
    		Payroll payroll = employees[employeeId].endShift();
    		addPayroll(payroll);
    		for (int j = employeeId; j < this.employees.length - 1; j++) {
    			this.employees[j] = this.employees[j + 1];
    		}
    	}
    }
    public void addPayroll(Payroll payroll) {
    	if (this.payrolls == null) {
    		Payroll[] baseList= new Payroll[1];
    		baseList[0] = payroll;
    		this.payrolls = baseList;
    	} 
    	else {
    		this.payrolls = resizePayrollArray(payrolls);
    		this.payrolls[payrolls.length - 1] = payroll;
    	}
    }
    
    public Employee[] resizeEmployeeArray(Employee[] employees) {
    	return Arrays.copyOf(employees, employees.length + 1);
    }
    public boolean checkEmployee(int id) {
    	for (int i = 0; i < employees.length; i++) {
    		if (employees[i].getId() == id) {
    			return false;
    		}
    	}
		return true;
    }
    
    public Payroll[] resizePayrollArray(Payroll[] payrolls) {
    	return Arrays.copyOf(payrolls, payrolls.length + 1);
    }
    public int employeeIdFinder(int id) {
    	if (employees == null) {
    		return -1;
    	} 
    	else {
    		for (int i = 0; i < employees.length; i++) {
        		if (employees[i].getId() == id) {
        			return i;
        		}
        	}
    	}
    	return -1;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employee[] getEmployees() {
        return employees;
    }
    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
    public Storage getStorage() {
        return storage;
    }
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    public Payroll[] getPayrolls() {
        return payrolls;
    }
    public void setPayrolls(Payroll[] payrolls) {
        this.payrolls = payrolls;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
}