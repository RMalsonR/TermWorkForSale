package sample.models;

public class User {
    String login;
    String password;
    String name;
    String lastname; // Отчество
    String surname;  // Фамилия
    String bDate;
    String citizen;
    String city;
    String adress;
    String salary;
    String creditTarget;

    public User(String login, String password, String name, String lastname, String surname, String bDate, String citizen, String city, String adress, String salary, String creditTarget) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.bDate = bDate;
        this.citizen = citizen;
        this.city = city;
        this.adress = adress;
        this.salary = salary;
        this.creditTarget = creditTarget;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getCitizen() {
        return citizen;
    }

    public void setCitizen(String citizen) {
        this.citizen = citizen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCreditTarget() {
        return creditTarget;
    }

    public void setCreditTarget(String creditTarget) {
        this.creditTarget = creditTarget;
    }
}
