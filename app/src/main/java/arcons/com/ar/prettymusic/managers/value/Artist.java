package arcons.com.ar.prettymusic.managers.value;

import android.graphics.Bitmap;

import arcons.com.ar.prettymusic.layout.list.ListableItem;

/**
 * Created by Gustavo on 17/03/2015.
 */
public class Artist implements ListableItem {

    private String id;
    private String name;
    private Long numberOfAlbums;
    private Long numberOfTracks;

    public Artist(String id, String name, long numberOfAlbums, long numberOfTracks) {
        this.id = id;
        this.name = name;
        this.numberOfAlbums = numberOfAlbums;
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public String getListMainText() {
        return name;
    }

    @Override
    public String getListSecondaryText() {
        return numberOfAlbums + " discos, " + numberOfTracks + " canciones";
    }

    @Override
    public boolean hasImage() {
        return false;
    }

    @Override
    public Bitmap getImage() {
        return null;
    }
}
