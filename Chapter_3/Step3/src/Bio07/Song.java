package Bio07;

public class Song {
    private String title;        // 제목
    private int duration;        // 재생 시간
    private String artist;       // 음악가

    public Song(String title, int duration, String artist) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
