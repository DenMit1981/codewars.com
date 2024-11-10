//Tail University is a bit of a mess and can't keep an orderly list of its students.
//The Dean of Tail wants to print out a list of his students by GPA, last name, and age and post it on the walls,
//so everyone can impress his amazing students.
//Given the list of students, sort them by (most important to least important):
//GPA (descending)
//First letter of last name (ascending)
//Age (ascending)
//And the class Student:
//
//class Student {
//    ...
//  int getGpa()
//  int getAge();
//  String getFullName();
//}
//Return the sorted result as full names string, comma separated.
//
//For Example, given the list (name, age, gpa):
//
//David Goodman, 23, 88
//Mark Rose, 25, 82
//Jane Doe, 22, 90
//Jane Dane, 25, 90
//sort(students) should return "Jane Doe,Jane Dane,David Goodman,Mark Rose"

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TripleSorter {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, 88, "David Goodman"));
        students.add(new Student(25, 82, "Mark Rose"));
        students.add(new Student(25, 90, "Jane Doe"));
        students.add(new Student(25, 90, "Jane Dane"));

        System.out.println(sort(students)); //"Jane Doe,Jane Dane,David Goodman,Mark Rose"
    }

    public static String sort(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getGpa).reversed()
                        .thenComparing(student -> getFirstLetterOfLastNameFromFullName(student.getFullName()))
                        .thenComparingInt(Student::getAge))
                .map(Student::getFullName)
                .collect(Collectors.joining(","));
    }

    private static String getFirstLetterOfLastNameFromFullName(String fullName) {
        return fullName.substring(getIndexOfFirstLetterOfLastName(fullName), getIndexOfFirstLetterOfLastName(fullName) + 1);
    }

    private static int getIndexOfFirstLetterOfLastName(String fullName) {
        return fullName.indexOf(" ") + 1;
    }
}


