package sample.models;

public class User {
    int hashCode;
    String login;
    String password;
    String name;
    String lastName; // Отчество
    String surName;  // Фамилия
    String bDate;
    String citizen;
    String city;
    String adress;
    String salary;
    String creditTarget;
    String phoneNumber;

    @Override
    public String toString() {
        return hashCode + " " + login + " " + password + " " +
                name+ " " + lastName+ " "  + surName+ " " + bDate+ " " + citizen+ " " +
                city+ " " + adress+ " " + salary+ " " + creditTarget+ " " + phoneNumber;
    }

    public User(int hashCode, String login, String password, String name, String lastName, String surName, String bDate, String citizen, String city, String adress, String salary, String creditTarget, String phoneNumber) {
        this.hashCode = hashCode;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.bDate = bDate;
        this.citizen = citizen;
        this.city = city;
        this.adress = adress;
        this.salary = salary;
        this.creditTarget = creditTarget;
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
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
