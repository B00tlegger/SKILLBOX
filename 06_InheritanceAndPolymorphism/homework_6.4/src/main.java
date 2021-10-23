import company.*;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        Company unemployed = new Company();

        List<Employee> managers = new ArrayList<>();
        List<Employee> operators = new ArrayList<>();
        List<Employee> topManagers = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            if (i <= 10) {
                operators.add(new Operator(unemployed));
                topManagers.add(new TopManager(unemployed));
                managers.add(new Manager(unemployed));
            }
            if (i > 10 && i <= 80) {
                operators.add(new Operator(unemployed));
                managers.add(new Manager(unemployed));
            }
            if (i > 80) {
                operators.add(new Operator(unemployed));
            }
        }

        Company company = new Company();

        Employee manager = new Manager(unemployed);
        company.hire(manager);

        company.hireAll(operators);
        company.hireAll(managers);
        company.hireAll(topManagers);
        System.out.println("Доход компании в месяц составил: " + company.getIncome());

        company.getTopSalaryStaff(15);
        System.out.println();
        company.getLowestSalaryStaff(30);

        System.out.println("Сотрудников до увольнения: " + company.getPersonalCount());

        for (int i = 0; i < company.getPersonalCount(); i++) {
            company.fire(i);
        }


        System.out.println("Сотрудников после увольнения: " + company.getPersonalCount());


        company.getTopSalaryStaff(15);
        System.out.println();
        company.getLowestSalaryStaff(30);
    }
}

