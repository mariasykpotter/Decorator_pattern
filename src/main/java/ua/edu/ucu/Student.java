package ua.edu.ucu;


class Student {

    private double gPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double gPA, int year) {
        this.gPA = gPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getgPA() {
        return gPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" +
                surname + ", " + "gPA=" + gPA + ", year=" + year + '}';
    }

    @Override
    public int hashCode() {
        return (int) gPA + year + name.hashCode() + surname.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;
        if (hashCode() != other.hashCode()) {
            return false;
        }
        return getName().equals(((Student) obj).getName()) && getSurname().equals(((Student) obj).
                getSurname()) && getgPA() == other.getgPA() && getYear() == other.getYear();
    }
}
