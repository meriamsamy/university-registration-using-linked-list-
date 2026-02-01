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
public class SparseTable {
    LinkedList studentHead;
    LinkedList courseHead;
    UndoRedoManager undoRedo; 

public SparseTable() {
    studentHead = null;
    courseHead = null;
    undoRedo = new UndoRedoManager(this);
}
   
public LinkedList findStudent(int studentID) {
        for (LinkedList currentstudent = studentHead; currentstudent != null; currentstudent = currentstudent.next) {
            if (currentstudent.ID == studentID) return currentstudent; 
        }
        return null; 
    }

public LinkedList findCourse(int courseID) {
        for (LinkedList currentcourse = courseHead; currentcourse != null; currentcourse = currentcourse.next) {
            if (currentcourse.ID == courseID) return currentcourse; 
        }
        return null; 
    }
    
public void addStudent(int ID) {
    // Search for the student if it already exists
    LinkedList newStudent = findStudent(ID);
    if (newStudent != null) {
        System.out.println("Student ID already exists " + ID);
        return;
    }
    newStudent = new LinkedList(ID);
    // Add to head to improve time complexity
    newStudent.next = studentHead;
    studentHead = newStudent;
    System.out.println("Student " + ID + " added.");
}

    
public void removeStudent(int studentID) {
    // If the list is empty no students to remove
    if (studentHead == null) {
        System.out.println("List is empty");
        return;
    }

    LinkedList pred = null, tmp = studentHead;

    // Find the student with the given ID
    while (tmp != null && tmp.ID != studentID) {
        pred = tmp;
        tmp = tmp.next;
    }

    // If student was not found in the list
    if (tmp == null) {
        System.out.println("Student not found: " + studentID);
        return;
    }

    // Remove the student from all enrolled courses
    Node current = tmp.head;
    while (current != null) {
        removeEnrollment(studentID, current.courseID);
        current = current.nextCourse;
    }

    // Remove the student node from the student linked list
    if (tmp == studentHead) {
        // If the student is the first node, update the head
        studentHead = studentHead.next;
    } else {
        // If not the first, link the previous node to the next
        pred.next = tmp.next;
    }

    System.out.println("Student deleted: " + studentID);
}

public void addCourse(int courseID) {
    // Search for the course if it already exists
    LinkedList newCourse = findCourse(courseID);
    if (newCourse != null) {
        System.out.println("Course ID already exists " + courseID);
        return;
    }
    newCourse = new LinkedList(courseID);
    // Add to head to improve time complexity
    newCourse.next = courseHead;
    courseHead = newCourse;
    System.out.println("Course " + courseID + " added.");
}

public void removeCourse(int courseID) {
    // If the list is empty no courses to remove
    if (courseHead == null) {
        System.out.println("List is empty");
        return;
    }

    LinkedList pred = null, tmp = courseHead;

    // Find the course with the given ID
    while (tmp != null && tmp.ID != courseID) {
        pred = tmp;
        tmp = tmp.next;
    }

    // If course was not found in the list
    if (tmp == null) {
        System.out.println("Course not found: " + courseID);
        return;
    }

    // Remove the course from all enrolled students
    Node current = tmp.head;
    while (current != null) {
        removeEnrollment(current.studentID, courseID);
        current = current.nextStudent;
    }

    // Remove the course node from the course linked list
    if (tmp == courseHead) {
        // If the course is the first node, update the head
        courseHead = courseHead.next;
    } else {
        // If not the first, link the previous node to the next
        pred.next = tmp.next;
    }
    System.out.println("Course deleted: " + courseID);
}

  public void getLastStudentAdded() {
      if(studentHead==null){
          System.out.println("No Student is added");
      }
      else{
                System.out.println("the last sudent id is : "+studentHead.ID);
      } 
    }
   public void getLastCourseAdded() {
        if(courseHead==null){
          System.out.println("No course is added");
      }
      else{
       System.out.println("the last course id is : "+ courseHead.ID);
      } 
    }
   
public void isFullCourse(int courseID) {
    LinkedList course = findCourse(courseID);
    if (course == null) {
        System.out.println("Course with ID " + courseID + " does not exist.");
        return;
    }
    if (course.count >= 20 && course.count  <= 30) {
        System.out.println("Course " + courseID + " is in range (" + course.count  + " students enrolled).");
    } else if (course.count  < 20) {
        System.out.println("Course " + courseID + " is not full \nNumber of students enrolled is (" + course.count  + ").");
    } else {
        System.out.println("Course " + courseID + " is completely full \nNumber of students enrolled is (" + course.count + ").");
    }
}

public void isNormalStudent(int studentID) {
    LinkedList student = findStudent(studentID);
    if (student == null) {
        System.out.println("Student with ID " + studentID + " does not exist.");
        return;
    }
    if (student.count >= 2 && student.count <= 7) {
        System.out.println("Student " + studentID + " is a normal student \nThe number of courses enrolled is (" + student.count + ")");
    } else if (student.count < 2) {
        System.out.println("Student " + studentID + " is not a normal student \nThe number of courses enrolled is (" + student.count + ")");
    } else {
        System.out.println("Student " + studentID + " is not a normal student \nEnrolled in more than 7 courses \nThe number of courses enrolled is (" + student.count + ")");
    }
}


public void listStudentsByCourse(int courseID) {
    LinkedList currentCourse = courseHead;
    while (currentCourse != null) {
        if (currentCourse.ID == courseID) {
            if (currentCourse.head == null)
                System.out.println("No students enrolled in course " + courseID);
            else {
                System.out.println("Course " + courseID + " enrolled students:\n");
                for (Node temp = currentCourse.head; temp != null; temp = temp.nextStudent) {
                    System.out.println("Student " + temp.studentID);
                }
            }
            return;
        }
        currentCourse = currentCourse.next;
    }
    System.out.println("Course not found");
}

public void listCoursesByStudent(int studentID) {
    LinkedList currentStudent = studentHead;
    while (currentStudent != null) {
        if (currentStudent.ID == studentID) {
            if (currentStudent.head == null)
                System.out.println("Student " + studentID + " is not enrolled in any courses");
            else {
                System.out.println("Student " + studentID + " is enrolled in:\n");
                for (Node temp = currentStudent.head; temp != null; temp = temp.nextCourse) {
                    System.out.println("Course " + temp.courseID);
                }
            }
            return;
        }
        currentStudent = currentStudent.next;
    }
    System.out.println("Student not found");
}

  public void Enrollment(int studentID, int courseID) {
    // Find student and course
    LinkedList student = findStudent(studentID);
    if (student == null) {
        System.out.println("Student not found.");
        return;
    }
    LinkedList course = findCourse(courseID);
    if (course == null) {
        System.out.println("Course not found.");
        return;
    }
    
    // Check if the registration already exists
    Node current = student.head;
    while (current != null) {
        if (current.courseID == courseID) {
            System.out.println("The student is already registered for the course.");
            return;
        }
        current = current.nextCourse;
    }
    
    // Check registration restrictions
    if (student.count >= 7) {
        System.out.println("The student has reached the maximum number of courses.");
        return;
    }
    if (course.count >= 30) {
        System.out.println("Registration is not possible for this course as it is full.");
        return;
    }
    
    // Add the registration after check
     Node newnode = new Node(studentID, courseID);
     // course
    if (course.head == null || course.head.studentID != studentID) {
        newnode.nextStudent = course.head;
        course.head = newnode;
    } else {
        current = course.head;
        while (current.nextStudent != null && current.nextStudent.studentID != studentID)
            current = current.nextStudent;
            newnode.nextStudent = current.nextStudent;
            current.nextStudent = newnode;
    }
    // student
    if (student.head == null || student.head.courseID != courseID) {
        newnode.nextCourse = student.head;
        student.head = newnode;
    } else {
        current = student.head;
        while (current.nextCourse != null && current.nextCourse.courseID != courseID)
            current = current.nextCourse;
            newnode.nextCourse = current.nextCourse;
            current.nextCourse = newnode;
    }
    
    student.count++;
    course.count++;
    undoRedo.recordEnroll(studentID, courseID);
   // Confirm successful enrollment
    System.out.println("Student " +studentID+" successfully enrolled in course "+courseID );
}

public void removeEnrollment(int studentID,int courseID){
LinkedList spare1 = studentHead;   // To not lose the head of the students
if(spare1 == null){   // There is no students
System.out.println("This student not found.");
return;}
// Iterate to find the student
while(spare1.ID != studentID){
spare1 = spare1.next;
if(spare1 == null){
System.out.println("This student not found.");
return;}
}
Node spare2 = spare1.head;        // To not lose the head of enrolled courses
if(spare2 == null){
System.out.println("There is no enrolled courses.");
return;}
if(spare2.courseID == courseID){   // The course is the first enrolled course
spare1.head = spare1.head.nextCourse;}
else{   // Iterate to find the course that previous the target course
while(spare2.nextCourse != null  && spare2.nextCourse.courseID != courseID){
spare2 = spare2.nextCourse;}
// We did not find the course
if(spare2.nextCourse == null){
System.out.println("This course is not enrolled.");
return;}
 // We find the course and delete it
spare2.nextCourse = spare2.nextCourse.nextCourse;}
--spare1.count;                                   // Decrease the number of enrolled courses

LinkedList spare3 = courseHead;   // To not lose the head of the courses
// Iterate to find the course
while(spare3.ID != courseID){
spare3 = spare3.next;}
Node spare4 = spare3.head;    // To not lose the head of enrolled courses
if(spare4.studentID == studentID){    // The student is the first enrolled student
spare3.head=spare3.head.nextStudent;}
else{  // Iterate to find the student that previous the target student
while(spare4.nextStudent.studentID != studentID){
spare4 = spare4.nextStudent;} // Delete the student
spare4.nextStudent = spare4.nextStudent.nextStudent;}
--spare3.count;                                 // Decrease the number of enrolled students
System.out.println("You have removed the enrollment successfully");}






// sort students
public void sortStudent(int courseID){
    LinkedList currentCourse = courseHead;
    while(currentCourse != null){
        if(currentCourse.ID == courseID){
            currentCourse.head = mergeSort(currentCourse.head);
        }
        currentCourse = currentCourse.next;
    }
    return;
}

public Node mergeSort(Node head){
    if(head == null || head.nextStudent == null){
        return head;
    }
    Node fast = head.nextStudent;
    Node slow = head;
    while(fast != null && fast.nextStudent != null){
        fast = fast.nextStudent.nextStudent;
        slow = slow.nextStudent;
    }
    Node mid = slow.nextStudent;
    slow.nextStudent = null;
    Node l = mergeSort(head);
    Node r = mergeSort(mid);
    return merge(l, r);
}

public Node merge(Node x , Node y){
    if(x == null) return y;
    if(y == null) return x;
    Node k;
    if(x.studentID <= y.studentID){
        k = x;
        k.nextStudent = merge(x.nextStudent, y);
    } else {
        k = y;
        k.nextStudent = merge(x, y.nextStudent);
    }
    return k;
}

// sort courses
public void sortCourses(int studentID){
    LinkedList currentStudent = studentHead;
    while(currentStudent != null){
        if(currentStudent.ID == studentID){
            currentStudent.head = mergeSortCourse(currentStudent.head);
        }
        currentStudent = currentStudent.next;
    }
    return;
}

public Node mergeSortCourse(Node head){
    if(head == null || head.nextCourse == null){
        return head;
    }
    Node fast = head.nextCourse;
    Node slow = head;
    while(fast != null && fast.nextCourse != null){
        fast = fast.nextCourse.nextCourse;
        slow = slow.nextCourse;
    }
    Node mid = slow.nextCourse;
    slow.nextCourse = null;
    Node l = mergeSortCourse(head);
    Node r = mergeSortCourse(mid);
    return mergeCourse(l, r);
}

public Node mergeCourse(Node x , Node y){
    if(x == null) return y;
    if(y == null) return x;
    Node k;
    if(x.courseID <= y.courseID){
        k = x;
        k.nextCourse = mergeCourse(x.nextCourse, y);
    } else {
        k = y;
        k.nextCourse = mergeCourse(x, y.nextCourse);
    }
    return k;
}
}