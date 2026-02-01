/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package universityregistrationsystem;
import java.util.Scanner;

/**
 *
 * @author meria
 */

public class UniversityRegistrationsystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    /*
*/
      SparseTable s1= new SparseTable();
      Scanner in =new Scanner(System.in);
      int x,studentid,courseid;
     
        System.out.println("Welcome to our university management system");
        do{
            System.out.println("1 - Add Student ");
            System.out.println("2 - Add Course ");
            System.out.println("3 - Remove Student ");
            System.out.println("4 - Remove Course");
            System.out.println("5 - Get Last Student");
            System.out.println("6 - Get Last Course ");
            System.out.println("7 - Enroll Student");
            System.out.println("8 - Remove Enrollment");
            System.out.println("9 - Display Student's Courses");
            System.out.println("10- Display Course's Students ");
            System.out.println("11- Is Normal Student ");
            System.out.println("12- is full Course");
            System.out.println("13- undo");
            System.out.println("14- Redo");
            System.out.println("0 - Exit");
            System.out.println("---------------------------------------");
            System.out.print("Please, Enter the action number: ");
            x= in.nextInt();
            System.out.println("---------------------------------------");
            switch(x){
                case 1:
                    System.out.print("Enter Student ID:");
                    studentid=in.nextInt();
                    s1.addStudent(studentid);
                    System.out.println("_");
                    break;
                case 2:
                    System.out.print("Enter Course ID:");
                    courseid=in.nextInt();
                    s1.addCourse(courseid);
                    System.out.println("_");
                    break;
                case 3:
                    System.out.print("Enter Student ID:");
                    studentid=in.nextInt();
                    s1.removeStudent(studentid);
                    System.out.println("_");
                    break;
                case 4:
                     System.out.print("Enter Course ID:");
                    courseid=in.nextInt();
                    s1.removeCourse(courseid);
                    System.out.println("_");
                    break;
                case 5:
                    s1.getLastStudentAdded();
                    
                    System.out.println("_");
                    break;
                case 6:
                    s1.getLastCourseAdded();
                  
                    System.out.println("_");
                    break;
                case 7:
                    System.out.print("Enter Student ID:");
                    studentid=in.nextInt();
                    System.out.print("Enter Course ID:");
                    courseid=in.nextInt();
                    s1.Enrollment(studentid, courseid);
                    System.out.println("_");
                    break;
                case 8:
                    System.out.print("Enter Student ID:");
                    studentid=in.nextInt();
                    System.out.print("Enter Course ID:");
                    courseid=in.nextInt();
                    s1.removeEnrollment(studentid, courseid);
                 
                    System.out.println("_");
                    break;
                case 9:
                    System.out.print("Enter Student ID: ");
                    studentid=in.nextInt();
                        s1.sortCourses(studentid);
                    s1.listCoursesByStudent(studentid);
                    System.out.println("_");
                    break;
                    
                case 10:
                    System.out.print("Enter Course ID:");
                    courseid=in.nextInt();
                     s1.sortStudent(courseid);
                     s1.listStudentsByCourse(courseid);
                    System.out.println("_");
                    break;
                    
                case 11:
                    System.out.println("Enter Student ID: ");
                    studentid=in.nextInt();
                    s1.isNormalStudent(studentid);
                     System.out.println("_");
                     break;
                     
                case 12:
                    System.out.println("Enter Course ID: ");
                    courseid=in.nextInt();
                    s1.isFullCourse(courseid);
                    System.out.println("_");
                     break;
                case 13:
                    s1.undoRedo.undo();
                    break;
                case 14:
                    s1.undoRedo.redo();
                    break; 
                default:
                    if(x==0){
                        System.out.println("Have a nice day");
                    }else{
                    System.out.println("Please, Enter a valid input.");
                    System.out.println("_");}
            }
        }while(x!=0);
    }
}
