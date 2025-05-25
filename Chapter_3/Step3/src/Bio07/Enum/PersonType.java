package Bio07.Enum;


public enum PersonType{
   JAZZ("재즈"), POP("팝"),CLASSIC("클래식"), HIPHOP("힙합");

    private final String song;

    PersonType(String songType) {
        this.song = songType;
    }

    public String getSong() {
        return song;
    }

    public static String cKPerson(String songType) {
        for (PersonType list : values()) {
            if (list.getSong().equals(songType)) {
                return list.getSong();
            }
        }
        throw new IllegalArgumentException("재즈, 팝, 클래식, 힙합 만 들을 수 있습니다: " + songType);
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
