package Bio07;

import Bio07.Enum.AnimalType;

public class AnimalSong extends Song{

    private String targetAnimal;

    public AnimalSong(String title, int duration, String artist, String targetAnimal) {
        super(title, duration, artist);
        this.targetAnimal = AnimalType.cKAnimal(targetAnimal);
    }

    @Override
    public String toString() {
        return "\"" + super.getTitle() + ", " + super.getDuration() + "분 , " + super.getArtist() +", " + targetAnimal + "\"";

    }
}
