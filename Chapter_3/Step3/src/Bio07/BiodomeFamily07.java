package Bio07;

import java.util.*;

public class BiodomeFamily07 {
    public static void main(String[] args) {

        MusicLibary lib = new MusicLibary();
        Player player = new Player();
        System.out.println("\n============== 노래 추가 ==============");
        // 5곡 추가
        lib.addSong(new AnimalSong("초원을 그리며", 2, "레이나", "사슴"));
        lib.addSong(new AnimalSong("영웅 호테", 1, "돈키", "당나귀"));
        lib.addSong(new AnimalSong("과자를 줄게", 3, "제롬", "코끼리"));
        lib.addSong(new ManagerSong("화양연화", 2, "장양림", "재즈"));
        lib.addSong(new ManagerSong("시간의 수평선", 4, "하윤", "팝"));


        System.out.println("\n============== 노래 예시 ==============");
        // 사람 노래 검색 & 재생
        List<ManagerSong> humanSongs = lib.searchByGenre("재즈");
        if (!humanSongs.isEmpty()) {
            player.play(humanSongs.getFirst());
            player.setVolume(30);
        }

        // 당나귀 노래 검색 & 재생
        List<AnimalSong> donkeySongs = lib.searchByAnimal("당나귀");
        if (!donkeySongs.isEmpty()) {
            player.play(donkeySongs.getFirst());
        }
        System.out.println("\n============== 노래 정지 ==============");
        // 노래 정지
        player.pause();

        // 노래 정지 취소
        player.resume();

        System.out.println("\n============== 노래 삭제 ==============");
        // 노래 삭제
        lib.deleteSong("시간의 수평선");

        
        //랜덤 노래 시작
        System.out.println("\n============== 랜덤 노래 ==============");
        player.play(lib.getRandomSong());
    }
}
