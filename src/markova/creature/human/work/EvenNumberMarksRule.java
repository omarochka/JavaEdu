package markova.creature.human.work;

public class EvenNumberMarksRule implements MarksRule{
    @Override
    public boolean isValid(int mark) {
        return mark % 2 == 0;
    }

    @Override
    public int excelentMark() {
        return 0;
    }
}
