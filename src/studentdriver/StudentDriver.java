package studentdriver;

import java.util.*;
import java.io.*;

public class StudentDriver {


    public static void main(String[] args) throws FileNotFoundException{
        StudentFees[] students = new StudentFees[12];
        
        File inputFile = new File("input.csv");
        Scanner input = new Scanner(inputFile);
        
        ArrayList<StudentFees> studentList = new ArrayList<>();

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
                String gaType = info[5];
                studentList.add( new GraduateStudent(studentName, studentID, enrolled, coursesEnrolled, ga, gaType));
            }else{
                boolean scholarship = Boolean.parseBoolean(info[4]);
                double scholarshipAmount = Double.parseDouble(info[5]);
                int coursesEnrolled = Integer.parseInt(info[3]);
                studentList.add(new UGStudent(studentName, studentID, enrolled, scholarship, scholarshipAmount, coursesEnrolled));
            }              
            
        }
        
        for(StudentFees s: studentList){
            System.out.println(s);
        }
        
      
    }

}
