//Hasan Pekedis 150120068
//This class's object represents the payroll of the employees.
//toString method returns a string text that contain information about the employees.
//calculateSalary method calculate salary for each employee and return a int value.
//There are set and get methods for each data field.
public class Payroll {

    private int workHour;
    private int itemCount;

    public Payroll(int workHour, int itemCount){
        this.workHour = workHour;
        this.itemCount = itemCount;
    }
    
    public String toString(){
        return "The work hour is " + workHour + " and the produced item count is " + itemCount + ".";
    }
    public int calculateSalary(){
        return itemCount*2+workHour*3;
    }
    
    public int getWorkHour() {
        return workHour;
    }
    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }
    public int getItemCount() {
        return itemCount;
    }
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}