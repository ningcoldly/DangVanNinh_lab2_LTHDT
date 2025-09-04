package edu.iuh.fit;

public class CourseList {
    private Course[] courses;
    private int count;

    public CourseList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        courses = new Course[n];
        count = 0;
    }
    public boolean addCourse(Course c) {
        if (count >= courses.length) {
            System.out.println("Error: List is full!");
            return false;
        }
        if (searchCourse(c.getId()) != null) {
            System.out.println("Error: Course ID already exists!");
            return false;
        }
        courses[count++] = c;
        return true;
    }
    public Course[] getCourses() {
        Course[] result = new Course[count];
        for (int i = 0; i < count; i++) {
            result[i] = courses[i];
        }
        return result;
    }

    public boolean removeCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null;
                return true;
            }
        }
        return false;
    }
    public Course searchCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                return courses[i];
            }
        }
        return null;
    }

    public Course[] searchCourseByTitle(String title) {
        int k = 0;
        Course[] temp = new Course[count];
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                temp[k++] = courses[i];
            }
        }
        if (k == 0) return null;
        Course[] result = new Course[k];
        for (int i = 0; i < k; i++) result[i] = temp[i];
        return result;
    }

    public Course[] searchCourseByDepartment(String dep) {
        int k = 0;
        Course[] temp = new Course[count];
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(dep)) {
                temp[k++] = courses[i];
            }
        }
        if (k == 0) return null;
        Course[] result = new Course[k];
        for (int i = 0; i < k; i++) result[i] = temp[i];
        return result;
    }
    public Course[] sortCoursesByTitle() {
        Course[] sorted = getCourses();
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i].getTitle().compareToIgnoreCase(sorted[j].getTitle()) > 0) {
                    Course tmp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = tmp;
                }
            }
        }
        return sorted;
    }
    public Course[] findMaxCreditCourses() {
        if (count == 0) return null;
        int max = courses[0].getCredit();
        for (int i = 1; i < count; i++) {
            if (courses[i].getCredit() > max) {
                max = courses[i].getCredit();
            }
        }
        int k = 0;
        Course[] temp = new Course[count];
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == max) {
                temp[k++] = courses[i];
            }
        }
        Course[] result = new Course[k];
        for (int i = 0; i < k; i++) result[i] = temp[i];
        return result;
    }
    public String findDepartmentWithMostCourses() {
        if (count == 0) return null;
        String depMax = courses[0].getDepartment();
        int maxCount = 0;
        for (int i = 0; i < count; i++) {
            int cnt = 0;
            for (int j = 0; j < count; j++) {
                if (courses[j].getDepartment().equalsIgnoreCase(courses[i].getDepartment())) {
                    cnt++;
                }
            }
            if (cnt > maxCount) {
                maxCount = cnt;
                depMax = courses[i].getDepartment();
            }
        }
        return depMax;
    }
}
