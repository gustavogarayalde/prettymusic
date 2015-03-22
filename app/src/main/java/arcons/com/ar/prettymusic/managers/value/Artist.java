package arcons.com.ar.prettymusic.managers.value;

import android.graphics.Bitmap;

import arcons.com.ar.prettymusic.layout.list.ListableItem;

/**
 * Created by Gustavo on 17/03/2015.
 */
public class Artist implements ListableItem {

    private String key;
    private String id;
    private String name;
    private Long numberOfAlbums;
    private Long numberOfTracks;

    public Artist(String id, String name, long numberOfAlbums, long numberOfTracks, String key) {
        this.id = id;
        this.name = name;
        this.numberOfAlbums = numberOfAlbums;
        this.numberOfTracks = numberOfTracks;
        this.key = key;
    }

    @Override
    public String getListMainText() {
        return name;
    }

    @Override
    public String getListSecondaryText() {
        return numberOfAlbums + " discos, " + numberOfTracks + " canciones. Id: " + id;
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

    public Long getNumberOfAlbums() {
        return numberOfAlbums;
    }

    public void setNumberOfAlbums(Long numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }

    public Long getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(Long numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    @Override

    public boolean hasImage() {
        return false;
    }

    @Override
    public Bitmap getImage() {
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

