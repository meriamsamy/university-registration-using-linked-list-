/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universityregistrationsystem;

/**
 *
 * @author meria
 */
public class Node {
    int studentID;
    int courseID;
    Node nextStudent;//next student in the same course
    Node nextCourse;//next course in the same student

   public Node(int studentID, int courseID) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.nextStudent = null;
        this.nextCourse = null;
        
   }
}
