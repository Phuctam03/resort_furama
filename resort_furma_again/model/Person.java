package model;

import java.time.LocalDate;

public abstract class Person {
    protected String id;
    protected String namePerson;
    protected LocalDate birthDay;
    protected String gender;
    protected String identityCard;
    protected String phone;
    protected String email;

    public Person() {
    }

    public Person(String id, String namePerson, LocalDate birthDay, String gender, String identityCard, String phone,
            String email) {
        this.id = id;
        this.namePerson = namePerson;
        this.birthDay = birthDay;
        this.gender = gender;
        this.identityCard = identityCard;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return " id=" + id + ", namePerson=" + namePerson + ", birthDay=" + birthDay + ", gender=" + gender
                + ", identityCard=" + identityCard + ", phone=" + phone + ", email=" + email ;
    }

}
