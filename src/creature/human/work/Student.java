package creature.human.work;

import java.util.Arrays;

public class Student
{
    public String name;
    private int[] marks;

    public Student(String name)
    {
        this.name = name;
    }

    public Student(String name, int... marks)
    {
        this(name);
        setMarks(marks);
    }

    public int[] getMarks() {
        return Arrays.copyOf(marks, marks.length);
    }

    public void setMarks(int[] marks) {
        boolean found = true;
        for (int mark : marks) {
            if (mark < 2 || mark > 5) {
                throw new IllegalArgumentException("Marks must be in range [2, 5]");
            }
        }
        this.marks = marks;
    }

    public float avg() {
        if (marks.length == 0)
            return 0;
        return (float)Arrays.stream(marks).sum() / marks.length;
    }

    public boolean isExcellent(){
        return avg() == 5; //cool
    }

    @Override
    public String toString()
    {
        StringBuilder resultStr = new StringBuilder(name);
        resultStr.append(": ");
        for (int i = 0; i < marks.length; i++)
        {
            resultStr.append(marks[i]).append(",");
            if (i + 1 == marks.length)
                resultStr.deleteCharAt(resultStr.length() - 1);
        }
        return resultStr.toString();
    }
}
