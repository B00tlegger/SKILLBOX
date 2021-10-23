package company;

public interface Employee extends Comparable<Employee> {
    double getMonthSalary();

    double getMoneyAmount();

    void setCompany(Company company);

}
