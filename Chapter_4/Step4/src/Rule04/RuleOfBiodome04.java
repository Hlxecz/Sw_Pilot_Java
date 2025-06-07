package Rule04;

import Rule04.BioType.AnimalFeature;
import Rule04.BioType.MicrobeFeature;
import Rule04.BioType.PlantFeature;
import Rule04.Enum.BioType;

public class RuleOfBiodome04 {
    public static void main(String[] args) {


        // 동물 2개
        BiologicalEntity<AnimalFeature> cat = new BiologicalEntity<>(
                "고양이", BioType.ANIMAL, new AnimalFeature("귀여움", "포유류", "20년"));
        BiologicalEntity<AnimalFeature> zebra = new BiologicalEntity<>(
                "얼룩말", BioType.ANIMAL, new AnimalFeature("잘 달린다", "포유류", "10년"));

        // 식물 2개
        BiologicalEntity<PlantFeature> rosemary = new BiologicalEntity<>(
                "로즈마리", BioType.PLANT, new PlantFeature("보라색", "열매 없음", "7월"));
        BiologicalEntity<PlantFeature> cherry = new BiologicalEntity<>(
                "벚꽃", BioType.PLANT, new PlantFeature("분홍색", "열매 있음", "3월"));

        // 미생물 2개
        BiologicalEntity<MicrobeFeature> ecoli = new BiologicalEntity<>(
                "이콜라이", BioType.MICROBE, new MicrobeFeature("약 산성", "호흡 및 발효 대사"));
        BiologicalEntity<MicrobeFeature> bacillus = new BiologicalEntity<>(
                "바실러스", BioType.MICROBE, new MicrobeFeature("약 산성", "호흡 대사"));

        // 시스템 생성
        BiologicalSystem<BiologicalEntity<?>> system = new BiologicalSystem<>();

        //생물 등록
        system.add(cat);
        system.add(zebra);
        system.add(rosemary);
        system.add(cherry);
        system.add(ecoli);
        system.add(bacillus);

        //생물 삭제
        system.delete();

        //최신 등록 생물
        system.show();

        //비었는지 확인
        system.isEmpty();

        //전체 삭제
        system.clear();

        //비었는지 확인
        system.isEmpty();
    }
}
