package Bio06.Enum;


public enum AnimalType{
    MONKEY("원숭이"), TIGER("호랑이"), DEER("사슴"), ELEPHANT("코끼리"), RHINOCEROS("코뿔소");

    private final String type;

    public String getType() {
        return type;
    }

    AnimalType(String type) {
        this.type = type;
    }

    public static AnimalType ofKorean(String name) throws Exception {
        for(AnimalType animalType : values()){
            if(animalType.getType().equals(name)){
                return animalType;
            }
        }
        throw new Exception("5가지 동물에 포함되지 않습니다.");
    }

}
