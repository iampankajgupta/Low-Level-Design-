package Test;

import java.util.List;
import java.util.Objects;

public class Child extends Root{

    private String name;
    private int age;

    public Child(List<String> strings) {
        super(strings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object childObject) {
        if(this == childObject) return true;
        if(childObject == null || getClass() != childObject.getClass()) return false;
        Child child = (Child) childObject;
        return child.age == this.age && child.name.equals(this.name);
    }
}
