package arcons.com.ar.prettymusic.managers;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

import arcons.com.ar.prettymusic.managers.value.Album;
import arcons.com.ar.prettymusic.managers.value.Artist;

/**
 * Created by Gustavo on 17/03/2015.
 */
public class AlbumsManager {


    public Album[] getAlbums(Context context) {
        //Some audio may be explicitly marked as not being music
        String orderBy = MediaStore.Audio.Albums.ALBUM + " DESC";

        String[] projection = {
                MediaStore.Audio.Albums._ID,
                MediaStore.Audio.Albums.ALBUM,
                MediaStore.Audio.Albums.ARTIST,
                MediaStore.Audio.Albums.ALBUM_ART,
                MediaStore.Audio.Albums.NUMBER_OF_SONGS
        };

        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                projection,
                null,
                null,
                null);

        Album[] albums = new Album[cursor.getCount()];
        while(cursor.moveToNext()) {
            Bitmap art = getArt(context, cursor.getLong(0), cursor.getString(3));

            albums[ cursor.getPosition() ] = new Album( cursor.getString(0), cursor.getString(1), cursor.getString(2), art , cursor.getLong(4) );
        }

        return albums;
    }

    private Bitmap getArt(Context context, Long id, String pathToArt) {
        Bitmap art = null;
        if (pathToArt != null && !pathToArt.isEmpty()){
            try {
                art = BitmapFactory.decodeFile(pathToArt);
            } catch (Exception exception) {
                // log error
            }
        }
        return art;
    }
}
