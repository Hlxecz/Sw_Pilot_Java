package Bio05;

public abstract class AncientArtifact{
    private final String name;

    public AncientArtifact(String name) {
        this.name = name;
        System.out.println( name + " 유물이 생성되었습니다.");
    }

    abstract void describe();

    public String getName() {
        return name;
    }
}
