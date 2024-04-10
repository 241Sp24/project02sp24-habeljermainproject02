
package studentdriver;


public class GraduateStudent extends StudentFees{
    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private double ADDITIONAL_FEES = 654.45;
    
    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, int coursesEnrolled, boolean isGraduateAssistant, String graduateAssistantType){
        super(studentName, studentID, isEnrolled);
        this.coursesEnrolled = coursesEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
    }


    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }
    public boolean getIsGraduateAssistant() {
        return isGraduateAssistant;
    }
    
    @Override
    public double getPayableAmount(){
        double tuition = super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE()* this.coursesEnrolled + this.ADDITIONAL_FEES;
        if(graduateAssistantType.equals("full")){
            tuition = this.ADDITIONAL_FEES;
        }else if(graduateAssistantType.equals("half")){
            tuition = ((super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE() * this.coursesEnrolled) / 2 + this.ADDITIONAL_FEES);
        }
        return tuition;
    }
    
    @Override
    public String toString(){
       return "Student name: " + this.getStudentName() + "\nStudent id: " + this.getStudentID() + "\nEnrolled: " + this.getIsEnrolled() + "\nGraduate Assistant: " + this.isGraduateAssistant + "\nGraduate Assistant Type: " + this.graduateAssistantType + "\nCourses Enrolled: " + this.coursesEnrolled + "\nPayable Amount: " + this.getPayableAmount();
    }
    
    
}
