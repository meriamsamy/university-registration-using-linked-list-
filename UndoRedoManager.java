/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universityregistrationsystem;

/**
 *
 * @author meria
 */
import java.util.Stack;

public class UndoRedoManager {
    Stack<Action> undoStack = new Stack<>();
    Stack<Action> redoStack = new Stack<>();
    SparseTable table;

    public UndoRedoManager(SparseTable table) {
        this.table = table;
    }

    // Save enroll action
    public void recordEnroll(int studentID, int courseID) {
        undoStack.push(new Action("enroll", studentID, courseID));
        redoStack.clear();
    }

    // Save remove action
    public void recordRemove(int studentID, int courseID) {
        undoStack.push(new Action("remove", studentID, courseID));
        redoStack.clear();
    }

    // Undo last action
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Action last = undoStack.pop();

        if (last.type.equals("enroll")) {
            table.removeEnrollment(last.studentID, last.courseID);
            redoStack.push(new Action("enroll", last.studentID, last.courseID));
        } else {
            table.Enrollment(last.studentID, last.courseID);
            redoStack.push(new Action("remove", last.studentID, last.courseID));
        }

        System.out.println("Undo done.");
    }

    // Redo last undone action
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        Action last = redoStack.pop();

        if (last.type.equals("enroll")) {
            table.Enrollment(last.studentID, last.courseID);
        } else {
            table.removeEnrollment(last.studentID, last.courseID);
        }

        undoStack.push(last);
        System.out.println("Redo done.");
}

   
}