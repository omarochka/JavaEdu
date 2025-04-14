package markova.creature.human.work;

public class ZeroOrOneMarksRule implements MarksRule{
    @Override
    public boolean isValid(int mark) {
        return mark == 0 || mark == 1;
    }
}
