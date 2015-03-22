package arcons.com.ar.prettymusic.managers.value;

import android.graphics.Bitmap;

import arcons.com.ar.prettymusic.layout.list.ListableItem;

/**
 * Created by Gustavo on 17/03/2015.
 */
public class Album implements ListableItem {

    private String id;
    private String key;
    private String name;
    private String artist;
    private Bitmap art;
    private long numberOfTracks;

    public Album(String id, String name, String artist, Bitmap art, long numberOfTracks, String key) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.art = art;
        this.numberOfTracks = numberOfTracks;
        this.key = key;
    }

    @Override
    public String getListMainText() {
        return name;
    }

    @Override
    public String getListSecondaryText() {
        return artist + " - " + numberOfTracks + " canciones";
    }

    @Override
    public boolean hasImage() {
        return true;
    }

    @Override
    public Bitmap getImage() {
        return art;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Bitmap getArt() {
        return art;
    }

    public void setArt(Bitmap art) {
        this.art = art;
    }

    public long getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(long numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}