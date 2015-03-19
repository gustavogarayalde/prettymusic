package arcons.com.ar.prettymusic.managers.value;

import android.graphics.Bitmap;

import java.io.Serializable;

import arcons.com.ar.prettymusic.layout.list.ListableItem;

/**
 * Created by Gustavo on 16/03/2015.
 */
public class Song implements ListableItem, Serializable{

    private Bitmap art;
    private String id;
    private String title;
    private String artist;
    private String album;

    public Song(String id, String title, String album, String artist, Bitmap art) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.art = art;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getId(){
        return this.id;
    }

    public Bitmap getArt() {
        return art;
    }

    public void setArt(Bitmap art) {
        this.art = art;
    }

    @Override
    public String getListMainText() {
        return title;
    }

    @Override
    public String getListSecondaryText() {
        return artist + " - " + album;
    }

    @Override
    public boolean hasImage() {
        return true;
    }

    @Override
    public Bitmap getImage() {
        return art;
    }
}
