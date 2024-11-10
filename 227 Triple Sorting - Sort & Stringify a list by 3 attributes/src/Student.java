class Student {
    private final int gpa; //grade point average
    private final int age;
    private final String fullName;

    public Student(int age, int gpa, String fullName) {
        this.gpa = gpa;
        this.age = age;
        this.fullName = fullName;
    }

    public int getGpa() {
        return gpa;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", age=" + age +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
