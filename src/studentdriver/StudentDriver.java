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
        input.close();
        
        Scanner scan;
        input = new Scanner(System.in);
        
        System.out.print("Enter the # of UG Students: ");
        input.nextLine();
        System.out.print("Enter the # of Graduate Students: ");
        input.nextLine();
        System.out.print("Enter the # of Online Students: ");
        input.nextLine();
        System.out.println("\n**********Undergraduate students list**********\n");
        
        int count2 = 0;
        int count3 = 0;
        for(StudentFees s: studentList){
            if(s instanceof UGStudent){
                System.out.println(s);
                System.out.println("");
                
        }
            else if(s instanceof GraduateStudent){
                if(count2 == 0){
                    System.out.println("**********Graduate students list**********\n");
                }
                System.out.println(s);
                System.out.println("");
                count2++;
            }
            else if(s instanceof OnlineStudent){
                if(count3 == 0){
                    System.out.println("**********Online students list**********\n");
                }
                System.out.println(s);
                System.out.println("");
                count3++;
            }
        }
        
      
    }

}
