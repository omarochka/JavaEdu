package creature.human.work;

import java.util.Arrays;

public class Department
{
    public String name;
    private Employee boss;
    public Employee[] employees;

    public Department(String name){
        this.name = name;
    }

    public void setBoss(Employee boss) {
        if(boss.department != this)
            boss.department = this;
        else
            this.boss = boss;
    }

    public Employee getBoss() {
        return new Employee(boss.name, boss.department);
    }

    public void addEmployee(Employee emp){
        Employee[] tempEmp;
        if (employees != null && employees.length != 0) {
            tempEmp = Arrays.copyOf(employees, employees.length + 1);
        }
        else {
            tempEmp = new Employee[1];
        }
        tempEmp[tempEmp.length - 1] = emp;
        employees = tempEmp;
        emp.department = this;
    }

    @Override
    public String toString() {
        if (employees == null) return name;

        StringBuilder resultStr = new StringBuilder(name);
        resultStr.append(" [");

        for (int i = 0; i < employees.length; i++)
        {
            resultStr.append(employees[i].name).append(",");
            if (i + 1 == employees.length)
                resultStr.deleteCharAt(resultStr.length() - 1);
        }

        resultStr.append("]");
        return resultStr.toString();
    }
}
