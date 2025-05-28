package Bio07;

public class Player {
    private Song currentSong;
    private int volume = 1;
    private boolean isPaused = false;

    public void play(Song song) {
        if (song instanceof AnimalSong) {
            if (volume > 5) {
                volume = 5;
                System.out.println("동물 노래 볼륨이 5를 넘을 수 없어 5로 자동 조정합니다.");
            }
        }
        this.currentSong = song;
        this.isPaused = false;
        System.out.println(song + " 재생합니다.");
    }

    public void pause() {
        if (currentSong == null) {
            System.out.println("재생 중인 곡이 없습니다.");
            return;
        }
        isPaused = true;
        System.out.println(currentSong.getTitle() + " 일시 정지합니다.");
    }

    public void resume() {
        if (currentSong == null) {
            System.out.println("재생 중인 곡이 없습니다.");
            return;
        }
        if (!isPaused) {
            System.out.println("이미 재생 중입니다.");
            return;
        }
        isPaused = false;
        System.out.println(currentSong.getTitle() + " 다시 재생합니다.");
    }

    public void setVolume(int volume) {
        if (currentSong instanceof AnimalSong) {
            if (volume < 0 || volume > 5) {
                System.out.println("동물 노래 볼륨은 0~5 사이여야 합니다.");
                return;
            }
        } else if (currentSong instanceof ManagerSong) {
            if (volume < 0 || volume > 50) {
                System.out.println("사람 노래 볼륨은 0~50 사이여야 합니다.");
                return;
            }
        }
        this.volume = volume;
        System.out.println("볼륨을 " + this.volume + "으로 설정합니다.");
    }

    public Song getCurrentSong() {
        return currentSong;
    }
}
