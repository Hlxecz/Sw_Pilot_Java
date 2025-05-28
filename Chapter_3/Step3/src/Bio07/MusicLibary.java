package Bio07;

import java.util.*;

public class MusicLibary {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        for (Song s : songs) {
            if (s.getTitle().equals(song.getTitle())) {
                System.out.println("이미 같은 제목의 곡이 있습니다: " + song.getTitle());
                return;
            }
        }
        songs.add(song);
        System.out.println("새로운 노래 " + song + " 추가되었습니다.");
    }

    public void deleteSong(String title) {
        Iterator<Song> it = songs.iterator();
        while (it.hasNext()) {
            Song s = it.next();
            if (s.getTitle().equals(title)) {
                it.remove();
                System.out.println("노래 " + s + " 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 제목의 곡을 찾을 수 없습니다: " + title);
    }

    public List<Song> searchByTitle(String title) {
        List<Song> result = new ArrayList<>();
        for (Song s : songs) {
            if (s.getTitle().contains(title)) {
                result.add(s);
            }
        }
        return result;
    }

    public List<AnimalSong> searchByAnimal(String animal) {
        List<AnimalSong> result = new ArrayList<>();
        for (Song s : songs) {
            if (s instanceof AnimalSong) {
                AnimalSong as = (AnimalSong) s;
                if (as.toString().contains(animal)) result.add(as);
            }
        }
        return result;
    }

    public List<ManagerSong> searchByGenre(String genre) {
        List<ManagerSong> result = new ArrayList<>();
        for (Song s : songs) {
            if (s instanceof ManagerSong) {
                ManagerSong ms = (ManagerSong) s;
                if (ms.toString().contains(genre)) result.add(ms);
            }
        }
        return result;
    }

    public List<Song> getAllSongs() {
        return new ArrayList<>(songs);
    }

    public Song getRandomSong() {
        if (songs.isEmpty()) return null;
        Collections.shuffle(songs);
        return songs.getFirst();
    }
}
