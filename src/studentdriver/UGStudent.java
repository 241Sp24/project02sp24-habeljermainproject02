package studentdriver;


public class UGStudent extends StudentFees {
    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private double ADDITIONAL_FEE = 820.70;
    
public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled){
    super(studentName, studentID, isEnrolled);
    this.hasScholarship = hasScholarship;
    this.scholarshipAmount = scholarshipAmount;
    this.coursesEnrolled = coursesEnrolled;
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }
    public boolean isHasScholarship() {
        return hasScholarship;
    }
    
    @Override
    public double getPayableAmount(){
        double payableAmount = super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE()+ this.ADDITIONAL_FEE;
        return payableAmount;
    }
    
    @Override
   public String toString(){
       return "Student name: " + this.getStudentName() + "\nStudent id: " + this.getStudentID() + "\nEnrolled: " + this.getIsEnrolled() + "\nScholarship: " + this.hasScholarship + "\nSchoalrship Amount: " + this.scholarshipAmount + "\nCourses Enrolled: " + this.coursesEnrolled + "\nPayable Amount: " + this.getPayableAmount();
    }




}
