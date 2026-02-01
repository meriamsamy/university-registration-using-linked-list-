# university-registration-using-linked-list-

## Description
A console-based Java application for managing **students**, **courses**, and **enrollments** in a university.  
It supports **undo/redo functionality** and uses **linked lists** with a **sparse table** structure for efficient data management.

---

## Features
- Add / remove students and courses
- Enroll / remove student enrollments
- List courses for a student
- List students for a course
- Check if a student is "normal" (2-7 courses)
- Check if a course is full (20-30 students)
- Undo / redo enrollment actions
- Get last added student or course
- Sort students in a course or courses of a student

---

## Project Structure
- UniversityRegistrationsystem.java : Main program with menu
- SparseTable.java : Data management and enrollment logic
- LinkedList.java : Student/Course linked list structure
- Node.java : Enrollment node (student-course relationship)
- UndoRedoManager.java : Undo/Redo manager
- Action.java : Action information for undo/redo

