package creature.human;

public class Person
{
    public Name name;
    final Person father;

    public Person(String name)
    {
        this(new Name(name) ,null);
    }

    public Person(Name name)
    {
        this(name ,null);
    }

    public Person(String name, Person father)
    {
        this(new Name(name), father);
    }

    // Основной конструктор
    public Person(Name name, Person father)
    {
        this.name = name;
        this.father = father;
    }

    public Person getFather() {
        return new Person(this.father.name, this.father.father);
    }

    public Name getName() {
        return new Name(getPersonalName(), getFamilyName(), getPatronymic());
    }

    private String getPersonalName()
    {
        return this.name.getPersonalName();
    }

    private String getPatronymic()
    {
        return this.name.getPatronymic();
    }

    private String getFamilyName()
    {
        if (this.name.getFamilyName() != null && !this.name.getFamilyName().isEmpty())
            return this.name.getFamilyName();

        Person currentFather = this.father;
        while (currentFather != null){
            if (currentFather.name != null && currentFather.name.getFamilyName() != null
                    && !currentFather.name.getFamilyName().isEmpty())
                return currentFather.name.getFamilyName();
            currentFather = currentFather.father;
        }
        return null;
    }

    @Override
    public String toString()
    {
        String familyName = getFamilyName();
        String patronymic = getPatronymic();

        if (father == null)
            return String.format("%s", name);

        if ((patronymic == null || patronymic.isEmpty())
                && father.name.getPersonalName() != null && !father.name.getPersonalName().isEmpty())
            patronymic = father.name.getPersonalName() + "ович";

        Name result = new Name(getPersonalName(), familyName, patronymic);

        return  result.toString();
    }
}
