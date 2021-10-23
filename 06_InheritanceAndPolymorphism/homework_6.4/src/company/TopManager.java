package company;

public class TopManager implements Employee {

    Company company;
    double companyIncome;
    double monthSalary;
    double salary = 40000;

    public TopManager(Company company) {
        this.company = company;
        companyIncome = company.getIncome();

    }

    @Override
    public double getMonthSalary() {
        if (company.getIncome() > 10000000) {
            monthSalary = Math.round(salary + (salary + salary / 2)) * Math.pow(10, 2) / Math.pow(10, 2);
        } else {
            monthSalary = salary;
        }
        return monthSalary;
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
