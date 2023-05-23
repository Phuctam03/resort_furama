package model;


public class Employee extends Person {
    private String degree;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String id, String namePerson, String birthDay, String gender, String identityCard, String phone,
            String email, String degree, String position, double salary) {
        super(id, namePerson, birthDay, gender, identityCard, phone, email);
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee :" + super.toString() + "Degree :" + (this.degree) + "The Position :" + (this.position)
                + "Salary :" + this.salary;
    }

}
