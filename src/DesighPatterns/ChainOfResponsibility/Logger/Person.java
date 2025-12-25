package DesighPatterns.ChainOfResponsibility.Logger;

import java.util.Objects;

public class Person {
    private String name;
    private String email;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return person.getAge() == this.age && this.getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age);
    }
}
