package markova.creature.human.work;

public class Employee
{
    String name;
    Department department;

    public Employee(String name, Department department)
    {
        this.name = name;
        department.addEmployee(this);
        this.department = department;
    }

    @Override
    public String toString()
    {
        if (department == null || (department.name == null || department.name.isEmpty()))
            return String.format("Сотрудник %s", name);

        if (department.boss == null)
            return String.format("%s работает в отделе %s", name, department.name);

        if (name.equals(department.boss.name))
            return String.format("%s начальник отдела %s", name, department.name);

        return String.format("%s работает в отделе %s, начальник которого %s",
                name, department.name, department.boss.name);
    }
}
