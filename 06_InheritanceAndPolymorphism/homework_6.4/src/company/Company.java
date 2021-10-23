package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private double income;
    private ArrayList<Employee> personal = new ArrayList<>();

    public void hire(Employee employee) {
        employee.setCompany(this);
        personal.add(employee);
    }

    public void hireAll(List<Employee> list) {
        for (Employee employee : list) {
            employee.setCompany(this);
        }
        personal.addAll(list);
    }

    public void fire(int index) {
        personal.remove(index);
    }

    public int getPersonalCount() {
        return personal.size();
    }

    public double getIncome() {
        for (Employee employee : personal) {
            income += employee.getMoneyAmount();
        }
        return Math.round(income * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count <= personal.size()) {
            Collections.sort(personal);
            for (int i = personal.size() - 1; i >= (personal.size() - 1) - count; i--) {
                System.out.println(personal.get(i).getMonthSalary());
            }
        }
        return personal;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count <= personal.size()) {
            Collections.sort(personal);
            for (int i = 0; i <= count; i++) {
                System.out.println(personal.get(i).getMonthSalary());
            }
        }
        return personal;
    }
}
