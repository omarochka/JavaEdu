package markova.creature.human.work;

public class ZeroOrOneMarksRule implements MarksRule{
    @Override
    public boolean isValid(int mark) {
        return mark == 0 || mark == 1;
    }

    @Override
    public int excelentMark() {
        return 1;
    }

    @Override
    public ZeroOrOneMarksRule clone() {
        try {
            return (ZeroOrOneMarksRule) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
