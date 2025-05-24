package Bio06;

import Bio06.Enum.AnimalType;

public class Animal {
    private String name;
    private String type; // 나중에 enum으로 바꾸는 게 좋음
    private int age;

    public Animal(String name, AnimalType type, int age) {
        this.name = name;
        this.type = type.getType();
        this.age = age;
    }

    // getter/setter
    public String getName() { return name; }
    public String getType() { return type; }
    public int getAge() { return age; }

    public String toString() {
        return name + "(" + type + ", " + age + "살)";
    }
}
