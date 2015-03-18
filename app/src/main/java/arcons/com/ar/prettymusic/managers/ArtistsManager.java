package arcons.com.ar.prettymusic.managers;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import arcons.com.ar.prettymusic.managers.value.Artist;
import arcons.com.ar.prettymusic.managers.value.Song;

/**
 * Created by Gustavo on 17/03/2015.
 */
public class ArtistsManager {
    public Artist[] getArtists(Context context) {

        //Some audio may be explicitly marked as not being music
        String orderBy = MediaStore.Audio.Artists.ARTIST + " DESC";

        String[] projection = {
                MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.ARTIST,
                MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
                MediaStore.Audio.Artists.NUMBER_OF_TRACKS
        };

        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                projection,
                null,
                null,
                null);

        Artist[] artists = new Artist[cursor.getCount()];
        while(cursor.moveToNext()) {
            artists[ cursor.getPosition() ] = new Artist( cursor.getString(0), cursor.getString(1), Long.parseLong(cursor.getString(2)), Long.parseLong(cursor.getString(3)) );
        }

        return artists;

    }
}
