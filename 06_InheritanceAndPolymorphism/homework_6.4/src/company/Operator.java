package company;

public class Operator implements Employee {

    Company company;
    double salary = 20000;


    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public double getMoneyAmount() {
        return 0;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int compareTo(Employee o) {
        if (getMonthSalary() > o.getMonthSalary()) {
            return 1;
        }
        if (getMonthSalary() < o.getMonthSalary()) {
            return -1;
        }
        return 0;
    }
}
