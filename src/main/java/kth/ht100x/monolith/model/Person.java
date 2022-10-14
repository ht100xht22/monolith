package kth.ht100x.monolith.model;

public class Person {
    private final String name;
    private final Integer age;
    private final String skill;

    public Person(String name, Integer age, String skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSkill() {
        return skill;
    }
}
