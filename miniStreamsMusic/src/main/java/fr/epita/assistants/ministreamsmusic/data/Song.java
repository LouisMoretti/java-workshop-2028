package fr.epita.assistants.ministreamsmusic.data;

public class Song {
    private String name;
    private Artist artist;

    public Song(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }
}
