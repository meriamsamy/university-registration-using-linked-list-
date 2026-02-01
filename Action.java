/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universityregistrationsystem;

/**
 *
 * @author meria
 */


// Save action info
class Action {
    String type; // "enroll" or "remove"
    int studentID;
    int courseID;

    public Action(String type, int studentID, int courseID) {
        this.type = type;
        this.studentID = studentID;
        this.courseID = courseID;
    }
}

