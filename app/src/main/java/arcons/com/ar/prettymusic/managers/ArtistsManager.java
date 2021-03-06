package arcons.com.ar.prettymusic.managers;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import arcons.com.ar.prettymusic.activities.EditSongActivity;
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
                MediaStore.Audio.Artists.NUMBER_OF_TRACKS,
                MediaStore.Audio.Artists.ARTIST_KEY
        };

        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                projection,
                null,
                null,
                null);

        Artist[] artists = new Artist[cursor.getCount()];
        while(cursor.moveToNext()) {
            artists[ cursor.getPosition() ] = new Artist( cursor.getString(0), cursor.getString(1), cursor.getLong(2), cursor.getLong(3), cursor.getString(4));
        }

        return artists;

    }

    public String[] getArtistsNames(Context context) {
        //Some audio may be explicitly marked as not being music
        String orderBy = MediaStore.Audio.Artists.ARTIST + " DESC";

        String[] projection = {
                MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.ARTIST,
        };

        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                projection,
                null,
                null,
                null);

        String[] artists = new String[cursor.getCount()];
        while(cursor.moveToNext()) {
            artists[ cursor.getPosition() ] = cursor.getString(1);
        }

        return artists;
    }

    public Artist getArtistByName(String name, Context context) {
        //Some audio may be explicitly marked as not being music
        String orderBy = MediaStore.Audio.Artists.ARTIST + " DESC";

        String[] projection = {
                MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.ARTIST,
                MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
                MediaStore.Audio.Artists.NUMBER_OF_TRACKS,
                MediaStore.Audio.Artists.ARTIST_KEY
        };

        String selectByName = MediaStore.Audio.Artists.ARTIST + " = ?";
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                projection,
                selectByName,
                new String[]{name},
                null);

        Artist[] artists = new Artist[cursor.getCount()];
        while(cursor.moveToNext()) {
            return new Artist( cursor.getString(0), cursor.getString(1), cursor.getLong(2), cursor.getLong(3), cursor.getString(4));
        }

        return null;
    }
}
