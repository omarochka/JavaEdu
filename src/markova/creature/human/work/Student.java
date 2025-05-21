package markova.creature.human.work;

import markova.exceptions.IncorrectMarksException;
import markova.generalInterfaces.Comparable;

import java.util.Arrays;
import java.util.Objects;

public class Student implements Comparable<Student>, Cloneable
{
    private String name;
    private int[] marks;
    private MarksRule marksRule;

    public Student(String name)
    {
        if(name == null) throw new IllegalArgumentException("Name don't be null");
        this.name = name;
    }

    public Student(String name, MarksRule marksRule, int... marks)
    {
        this(name);
        this.marksRule = marksRule;
        setMarks(marks);
    }

    public int[] getMarks() {
        return Arrays.copyOf(marks, marks.length);
    }

    public void setMarks(int... marks) {
        if (marks == null || marks.length == 0) throw new IllegalArgumentException("Need to write marks");
        if (marksRule != null) {
            for (int mark : marks) {
                if (!marksRule.isValid(mark)) {
                    throw new IncorrectMarksException(name);
                }
            }
        }
        this.marks = marks;
    }

    public void addMark(int mark){
        if (marksRule != null) {
            if (!marksRule.isValid(mark)) {
                throw new IncorrectMarksException(name);
            }
        }
        int[] tempMarks;
        if (marks == null) {
            tempMarks = new int[1];
        }
        else {
            tempMarks = Arrays.copyOf(marks, marks.length + 1);
        }
        tempMarks[tempMarks.length-1] = mark;
        marks = tempMarks;
    }

    public float avg() {
        if (marks.length == 0)
            return 0;
        return (float)Arrays.stream(marks).sum() / marks.length;
    }

    public boolean isExcellent(){
        return Arrays.stream(marks).allMatch(x -> x == marksRule.excelentMark());
    }

    @Override
    public String toString()
    {
        StringBuilder resultStr = new StringBuilder(name);
        if(marks != null && marks.length != 0){
            resultStr.append(": ");
            for (int i = 0; i < marks.length; i++)
            {
                resultStr.append(marks[i]).append(",");
                if (i + 1 == marks.length)
                    resultStr.deleteCharAt(resultStr.length() - 1);
            }
        }
        return resultStr.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.name.equals(student.name) && Arrays.equals(this.marks, student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(marks));
    }

    @Override
    public int compare(Student object) {
        return Float.compare(this.avg(), object.avg());
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        s.marks = Arrays.copyOf(this.marks, this.marks.length);

        if (this.marksRule != null) {
            s.marksRule = this.marksRule.clone();
        }

        return s;
    }
}
