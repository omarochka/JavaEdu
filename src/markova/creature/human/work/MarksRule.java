package markova.creature.human.work;

public interface MarksRule extends Cloneable {
    boolean isValid(int mark);
    int excelentMark();
    MarksRule clone();
}
