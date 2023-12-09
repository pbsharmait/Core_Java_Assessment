package con_curd;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String courseId;
    String courseName;
    double courseFees;
    int courseDuration;
    String courseDetail;

    public Course(String courseId, String courseName, double courseFees, int courseDuration, String courseDetail) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFees = courseFees;
        this.courseDuration = courseDuration;
        this.courseDetail = courseDetail;
    }
}

public class CourseManagementSystem {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewCourses();
                    break;
                case 3:
                    searchCourse();
                    break;
                case 4:
                    editCourse();
                    break;
                case 5:
                    deleteCourse();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nCourse Management System Menu:");
        System.out.println("1. Add Course");
        System.out.println("2. View Courses");
        System.out.println("3. Search Course");
        System.out.println("4. Edit Course");
        System.out.println("5. Delete Course");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addCourse() {
        System.out.println("\nAdd Course:");
        System.out.print("Course Id: ");
        String courseId = scanner.nextLine();

        System.out.print("Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Course Fees: ");
        double courseFees = scanner.nextDouble();

        System.out.print("Course Duration (in months): ");
        int courseDuration = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Course Detail: ");
        String courseDetail = scanner.nextLine();

        Course newCourse = new Course(courseId, courseName, courseFees, courseDuration, courseDetail);
        courses.add(newCourse);
        System.out.println("Course added successfully!");
    }

    private static void viewCourses() {
        System.out.println("\nView Courses:");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (Course course : courses) {
                displayCourseInfo(course);
            }
        }
    }

    private static void searchCourse() {
        System.out.println("\nSearch Course:");
        System.out.print("Enter Course Id to search: ");
        String searchId = scanner.nextLine();

        for (Course course : courses) {
            if (course.courseId.equals(searchId)) {
                displayCourseInfo(course);
                return;
            }
        }

        System.out.println("Course not found with Id: " + searchId);
    }

    private static void editCourse() {
        System.out.println("\nEdit Course:");
        System.out.print("Enter Course Id to edit: ");
        String editId = scanner.nextLine();

        for (Course course : courses) {
            if (course.courseId.equals(editId)) {
                System.out.print("Enter new Course Name: ");
                course.courseName = scanner.nextLine();

                System.out.print("Enter new Course Fees: ");
                course.courseFees = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                System.out.print("Enter new Course Duration (in months): ");
                course.courseDuration = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                System.out.print("Enter new Course Detail: ");
                course.courseDetail = scanner.nextLine();

                System.out.println("Course updated successfully!");
                return;
            }
        }

        System.out.println("Course not found with Id: " + editId);
    }

    private static void deleteCourse() {
        System.out.println("\nDelete Course:");
        System.out.print("Enter Course Id to delete: ");
        String deleteId = scanner.nextLine();

        for (Course course : courses) {
            if (course.courseId.equals(deleteId)) {
                courses.remove(course);
                System.out.println("Course deleted successfully!");
                return;
            }
        }

        System.out.println("Course not found with Id: " + deleteId);
    }

    private static void displayCourseInfo(Course course) {
        System.out.println("Course Id: " + course.courseId);
        System.out.println("Course Name: " + course.courseName);
        System.out.println("Course Fees: " + course.courseFees);
        System.out.println("Course Duration: " + course.courseDuration + " months");
        System.out.println("Course Detail: " + course.courseDetail);
        System.out.println("--------------------");
    }
}
