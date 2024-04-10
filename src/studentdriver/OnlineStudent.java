
package studentdriver;


public class OnlineStudent extends StudentFees{
    //Instance Vaiables
    private int noOfMonths;
    private double MONTHLY_FEE = 1245.25;
    
    //Constructor
    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths){
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }
    
    //Abstract Method
    @Override
    public double getPayableAmount(){
        return MONTHLY_FEE * this.noOfMonths;
    }
    
    //toString
    @Override
    public String toString(){
       return "Student name: " + this.getStudentName() + "\nStudent id: " + this.getStudentID() + "\nEnrolled: " + this.getIsEnrolled() + "\nNumber of Months: " + this.noOfMonths + "\nPayable Amount: " + this.getPayableAmount();
    }
            
}
