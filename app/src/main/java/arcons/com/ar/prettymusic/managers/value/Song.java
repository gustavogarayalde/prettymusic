package arcons.com.ar.prettymusic.managers.value;

import android.graphics.Bitmap;

import arcons.com.ar.prettymusic.ListableItem;

/**
 * Created by Gustavo on 16/03/2015.
 */
public class Song implements ListableItem{


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
