package Bio07;

import Bio07.Enum.PersonType;

public class ManagerSong extends Song{
    private String songType;

    public ManagerSong(String title, int duration, String artist, String songType) {
        super(title, duration, artist);
        this.songType = PersonType.cKPerson(songType);
    }

    @Override
    public String toString() {
        return "\"" + super.getTitle() + ", " + super.getDuration() + ", " + songType + "\"";

    }
}
