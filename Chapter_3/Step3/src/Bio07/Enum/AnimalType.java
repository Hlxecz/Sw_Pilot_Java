package Bio07.Enum;

public enum AnimalType {
    DEER("사슴"), DONKEY("당나귀"), ELEPHANT("코끼리");

    private final String name;

    AnimalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String cKAnimal(String type) {
        for (AnimalType list : values()) {
            if (list.getName().equals(type)) {
                return list.getName();
            }
        }
        throw new IllegalArgumentException("사슴, 당나귀, 코끼리만 들을 수 있습니다: " + type);
    }

}


/*
 stream을 이용한 boolean형 조건 검사
boolean found = java.util.Arrays.stream(values())
        .anyMatch(a -> a.getName().equals(type));

    if (!found) {
        System.out.println("사슴, 당나귀, 코끼리만 들을 수 있습니다.");
        System.exit(0);
    }
*/
