package Bio05;

import java.util.ArrayList;

public class Sorcerer {
    private String name;
    private ArrayList<AncientArtifact> list;

    public Sorcerer(String name) {
        this.name = name;
        this.list = new ArrayList<>();
        System.out.println("마법사 '" + name + "'이 생성되었습니다.\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addArtifact(AncientArtifact... artifacts) {
        for (AncientArtifact anc : artifacts) {
            list.add(anc);
            System.out.println("마법사 '" + name + "'이 " + anc.getName() +
                    "을 소유하게 되었습니다.");
        }
        System.out.println();
    }

    public void useArtifact(AncientArtifact artifact) {
        for (AncientArtifact list : list) {
            if (list == artifact) {
                System.out.println("마법사 '" + name + "'이 " + list.getName() +
                        "의 능력을 확인합니다.\n");
                list.describe();

                if (list instanceof SolarStone) {
                    System.out.println("마법사 '" + name + "'이 " + list.getName() +
                            "의 에너지 생성능력을 사용합니다.");
                    ((SolarStone) list).generateEnergy();
                } else if (list instanceof WindAmulet) {
                    System.out.println("마법사 '" + name + "'이 " + list.getName() +
                            "의 날씨 조절 능력을 사용합니다.");
                    ((WindAmulet) list).controlWeather();
                } else if (list instanceof WaterMirror) {
                    System.out.println("마법사 '" + name + "'이 " + list.getName() +
                            "의 에너지 생성능력을 사용합니다.");
                    ((WaterMirror) list).generateEnergy();
                    ((WaterMirror) list).controlWeather();
                }

            }
        }
    }
}
