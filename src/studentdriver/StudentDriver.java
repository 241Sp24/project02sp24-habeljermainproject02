package studentdriver;

//Packages
import java.util.*;
import java.io.*;

public class StudentDriver {


    public static void main(String[] args) throws FileNotFoundException{
        StudentFees[] students = new StudentFees[12];
        
        //Open and Read File
        File inputFile = new File("input.csv");
        Scanner input = new Scanner(inputFile);
        
        //Create ArrayList
        ArrayList<StudentFees> studentList = new ArrayList<>();

        //While Loop to Store File in ArrayList
        while(input.hasNext()){
            String line = input.nextLine();
            String[] info = line.split(",");
            String studentName = info[1];
            int studentID = Integer.parseInt(info[0]);
            boolean enrolled = Boolean.parseBoolean(info[2]);
            
            if(Integer.parseInt(info[0]) > 300){
                int months = Integer.parseInt(info[3]);
                studentList.add(new OnlineStudent(studentName, studentID, enrolled, months));
            }else if(Integer.parseInt(info[0]) > 200){
                int coursesEnrolled = Integer.parseInt(info[3]);
                boolean ga = Boolean.parseBoolean(info[4]);
                String gaType;
                if(ga == true){
                    gaType = info[5];
                }else{
                    gaType = "";
                }
                studentList.add( new GraduateStudent(studentName, studentID, enrolled, coursesEnrolled, ga, gaType));
            }else{
                boolean scholarship = Boolean.parseBoolean(info[4]);
                double scholarshipAmount = Double.parseDouble(info[5]);
                int coursesEnrolled = Integer.parseInt(info[3]);
                studentList.add(new UGStudent(studentName, studentID, enrolled, scholarship, scholarshipAmount, coursesEnrolled));
            }                 
        }
        
        //Close Scanner
        input.close();
        
        //Reopen Scanner
        Scanner scan;
        input = new Scanner(System.in);
        
        //User Input
        System.out.print("Enter the # of UG Students: ");
        int ugcount = input.nextInt();
        System.out.print("Enter the # of Graduate Students: ");
        int gradcount = input.nextInt();
        System.out.print("Enter the # of Online Students: ");
        int ocount = input.nextInt();
        System.out.println("\n**********Undergraduate students list**********\n");
        
        //Variables
        int count2 = 0;
        int count3 = 0;
        double studentFee1 = 0.0;
        double studentFee2 = 0.0;
        double studentFee3 = 0.0;
        int courses1 = 0;
        int scholarships = 0;
        int courses2 = 0;
        int gacount= 0;
        
        //Print Students
        for(StudentFees s: studentList){
            if(s instanceof UGStudent){
                System.out.println(s);
                System.out.println("");
                studentFee1 += s.getPayableAmount();
                courses1 += ((UGStudent) s).getCoursesEnrolled();
                if(((UGStudent) s).isHasScholarship() == true){
                    scholarships++;
                }      
            }
            else if(s instanceof GraduateStudent){
                if(count2 == 0){
                    System.out.println("**********Graduate students list**********\n");
                }
                System.out.println(s);
                System.out.println("");
                count2++;
                studentFee2 += s.getPayableAmount();
                courses2 += ((GraduateStudent) s).getCoursesEnrolled();
                if(((GraduateStudent) s).getIsGraduateAssistant() == true){
                    gacount++;
                }
            }
            else if(s instanceof OnlineStudent){
                if(count3 == 0){
                    System.out.println("**********Online students list**********\n");
                }
                System.out.println(s);
                System.out.println("");
                count3++;
                studentFee3 += s.getPayableAmount();
            }
        }
        
        //Print Output at Bottom 
        System.out.println("**********Undergraduate Students details**********");
        System.out.println("Average Student fee: " + studentFee1 / ugcount);
        System.out.println("Scholarship count: " + scholarships);
        System.out.println("Total number of courses: " + courses1);
        System.out.println("\n**********Graduate Students details**********");
        System.out.println("Average Students fee: " + studentFee2 / gradcount);
        System.out.println("Graduate Assistantship count: " + gacount);
        System.out.println("Total number of courses: " + courses2);
        System.out.println("\n**********Online Students details**********");
        System.out.println("Average Students fee: " + studentFee3 / ocount); 
    }

}
