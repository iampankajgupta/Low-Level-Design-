package DesighPatterns;

public class Main {
    public static void main(String[] args) {
        BuilderPattern builderPattern = new BuilderPattern.InnerBuilder().setAge(1).setAddress("something").build();

    }
}
