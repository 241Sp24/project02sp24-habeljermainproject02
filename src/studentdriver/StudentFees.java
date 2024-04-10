
package studentdriver;


abstract class StudentFees {
    //Instance Variables
    private String studentName;
    private int studentID;
    private boolean isEnrolled;
    private int CREDITS_PER_COURSE = 3;
    private double PER_CREDIT_FEE = 543.50;
    
    //Constructor
    public StudentFees(String studentName, int studentID, boolean isEnrolled){
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;  
    }
    
    //Getters/Setters
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public boolean getIsEnrolled() {
        return isEnrolled;
    }
    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }
    public int getCREDITS_PER_COURSE() {
        return CREDITS_PER_COURSE;
    }
    public double getPER_CREDIT_FEE() {
        return PER_CREDIT_FEE;
    }
    
    //Abstract Method
    abstract double getPayableAmount();
    
    //toString
    @Override
   public String toString(){
       return "Student name: " + studentName + "\nStudent id: " + studentID + "\nEnrolled: " + isEnrolled;
   }
}
