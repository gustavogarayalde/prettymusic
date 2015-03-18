package arcons.com.ar.prettymusic.managers.value;

import android.graphics.Bitmap;

import arcons.com.ar.prettymusic.layout.list.ListableItem;

/**
 * Created by Gustavo on 17/03/2015.
 */
public class Album implements ListableItem {

    private String id;
    private String name;
    private String artist;
    private Bitmap art;
    private long numberOfTracks;

    public Album(String id, String name, String artist, Bitmap art, long numberOfTracks) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.art = art;
        this.numberOfTracks = numberOfTracks;
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
}
