package studentdriver;


public class UGStudent extends StudentFees {
    //Instance Variables
    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private double ADDITIONAL_FEE = 820.70;
    
    //Constructor
    public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled){
        super(studentName, studentID, isEnrolled);
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
    }

    //Getters/Setters
    public double getScholarshipAmount() {
        return scholarshipAmount;
    }
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }
    public boolean isHasScholarship() {
        return hasScholarship;
    }
    
    //Abstract Method
    @Override
    public double getPayableAmount(){
        double payableAmount = super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE() * this.coursesEnrolled+ this.ADDITIONAL_FEE;
        if(hasScholarship == true){
            payableAmount = payableAmount - this.scholarshipAmount;
}
        if(super.getIsEnrolled() == false){
            payableAmount = 0;
        }
        return payableAmount;
        }
   

    //toString
    @Override
    public String toString(){
       return "Student name: " + this.getStudentName() + "\nStudent id: " + this.getStudentID() + "\nEnrolled: " + this.getIsEnrolled() + "\nScholarship: " + this.hasScholarship + "\nScholarship Amount: " + this.scholarshipAmount + "\nCourses Enrolled: " + this.coursesEnrolled + "\nPayable Amount: " + this.getPayableAmount();
    }




}
