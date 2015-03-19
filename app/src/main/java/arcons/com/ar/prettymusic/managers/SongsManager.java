package arcons.com.ar.prettymusic.managers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

import arcons.com.ar.prettymusic.managers.value.Song;

/**
 * Created by Gustavo on 16/03/2015.
 */
public class SongsManager {

    public Song[] getSongs(Context context) {

        //Some audio may be explicitly marked as not being music
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        String orderBy = MediaStore.Audio.Media.TITLE + " DESC"; 

        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM_ID
        };

        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null);

        Song[] songs = new Song[cursor.getCount()];
        while(cursor.moveToNext()) {
            final Uri ART_CONTENT_URI = Uri.parse("content://media/external/audio/albumart");
            Uri albumArtUri = ContentUris.withAppendedId(ART_CONTENT_URI, Long.parseLong(cursor.getString(4)));

            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), albumArtUri);
            } catch (Exception exception) {
                // log error
            }
            songs[ cursor.getPosition() ] = new Song( cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), bitmap );
        }

        return songs;
    }

    public void updateSong(Song songToUpdate, String title, String artist, String album, Context context) {
        ContentValues values = new ContentValues();

        values.put(MediaStore.Audio.Media.TITLE, title);
        values.put(MediaStore.Audio.Media.ALBUM, album);
        values.put(MediaStore.Audio.Media.ARTIST, artist);
        context.getContentResolver().update(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                values,
                MediaStore.Audio.Media._ID + "= ?",
                new String[] { songToUpdate.getId() }
        );
    }
}
