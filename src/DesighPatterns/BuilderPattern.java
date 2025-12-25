package DesighPatterns;

public class BuilderPattern {
    private String name;
    private int age;// optional
    private String address; // optional
    private String maritialStatus; // optional

    /*

    ✅ Why Do We Need the Builder Design Pattern?
        🔴 Problem: Telescoping Constructors

    When a class has many parameters, especially optional ones, we often end up with multiple overloaded constructors:

    public class User {
        public User(String name) { ... }
        public User(String name, int age) { ... }
        public User(String name, int age, String address) { ... }
        public User(String name, int age, String address, String phone) { ... }
        // And so on...
    }
    This is called the Telescoping Constructor Anti-Pattern. It becomes:
    Hard to read

    Hard to maintain

    Hard to know what each parameter means

    Error-prone (you might pass values in the wrong order)
            Use the Builder Pattern when:
        You have a class with many optional parameters

        You want to avoid constructor overloading

        You want to build immutable objects

        You want a readable and fluent object creation API

        You’re dealing with complex object creation logic
     */



    public BuilderPattern(InnerBuilder innerBuilder) {
        this.name = innerBuilder.name;
        this.age = innerBuilder.age;
        this.address = innerBuilder.address;
        this.maritialStatus = innerBuilder.maritialStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class InnerBuilder {
        private String name;
        private int age;// optional
        private String address; // optional
        private String maritialStatus; // optional

        public InnerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public InnerBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public InnerBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public InnerBuilder setMaritialStatus(String maritialStatus) {
            this.maritialStatus = maritialStatus;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }
}
