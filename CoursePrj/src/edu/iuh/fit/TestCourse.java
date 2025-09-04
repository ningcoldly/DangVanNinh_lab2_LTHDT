package edu.iuh.fit;

import java.util.Scanner;

public class TestCourse {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CourseList list = new CourseList(100);
        int choice;

        do {
     System.out.println("\n===== COURSE MANAGEMENT =====");
     System.out.println("1. Add course");
     System.out.println("2. Display all courses");
     System.out.println("3. Remove course by ID");
     System.out.println("4. Search course by ID");
     System.out.println("5. Search courses by Title");
     System.out.println("6. Search courses by Department");
     System.out.println("7. Sort courses by Title");
     System.out.println("8. Find courses with max Credit");
     System.out.println("9. Find department with most courses");
     System.out.println("0. Exit");
     System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    try {
               System.out.print("Enter ID: ");
               String id = sc.nextLine();
               System.out.print("Enter Title: ");
               String title = sc.nextLine();
               System.out.print("Enter Credit: ");
               int credit = sc.nextInt(); sc.nextLine();
               System.out.print("Enter Department: ");
               String dep = sc.nextLine();
               Course c = new Course(id, title, credit, dep);
               list.addCourse(c);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    Course[] arr = list.getCourses();
                    if (arr.length == 0) System.out.println("Empty list!");
                    else {
                        System.out.printf("%-10s %-25s %-5s %-15s\n", "ID", "Title", "Cre", "Department");
                        for (Course c : arr) System.out.println(c);
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to remove: ");
                    String id = sc.nextLine();
                    System.out.println(list.removeCourse(id) ? "Removed successfully!" : "Course not found!");
                }
                case 4 -> {
                    System.out.print("Enter ID to search: ");
                    String id = sc.nextLine();
                    Course c = list.searchCourse(id);
                    System.out.println(c == null ? "Not found!" : c);
                }
                case 5 -> {
                    System.out.print("Enter Title keyword: ");
                    String t = sc.nextLine();
                    Course[] res = list.searchCourseByTitle(t);
                    if (res == null) System.out.println("Not found!");
                    else for (Course c : res) System.out.println(c);
                }
                case 6 -> {
                    System.out.print("Enter Department: ");
                    String d = sc.nextLine();
                    Course[] res = list.searchCourseByDepartment(d);
                    if (res == null) System.out.println("Not found!");
                    else for (Course c : res) System.out.println(c);
                }
                case 7 -> {
                    Course[] sorted = list.sortCoursesByTitle();
                    for (Course c : sorted) System.out.println(c);
                }
                case 8 -> {
                    Course[] res = list.findMaxCreditCourses();
                    if (res == null) System.out.println("Empty list!");
                    else for (Course c : res) System.out.println(c);
                }
                case 9 -> {
                    String dep = list.findDepartmentWithMostCourses();
                    System.out.println(dep == null ? "Empty list!" : "Department with most courses: " + dep);
                }
            }
        } while (choice != 0);
    }
}
