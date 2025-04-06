package creature.human.work;

import java.util.Arrays;

public class Student
{
    private String name;
    private int[] marks;
    private MarksRule marksRule;

    public Student(String name)
    {
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

    public void setMarks(int[] marks) {
        if (marksRule == null) {
            this.marks = marks;
        } else {
            for (int mark : marks) {
                if (!marksRule.isValid(mark)) {
                    throw new IllegalArgumentException("Marks must follow the rule");
                }
            }
            this.marks = marks;
        }
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
