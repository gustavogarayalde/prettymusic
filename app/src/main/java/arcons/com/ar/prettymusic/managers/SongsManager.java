package arcons.com.ar.prettymusic.managers;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.RemoteControlClient;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.media.MediaMetadataCompat;
import android.widget.Button;
import android.widget.Toast;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.ID3Tag;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v1.ID3V1Tag;
import org.blinkenlights.jid3.v1.ID3V1_0Tag;
import org.blinkenlights.jid3.v2.ID3V2Tag;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import arcons.com.ar.prettymusic.managers.value.Album;
import arcons.com.ar.prettymusic.managers.value.Artist;
import arcons.com.ar.prettymusic.managers.value.Song;

/**
 * Created by Gustavo on 16/03/2015.
 */
public class SongsManager {

    private ArtistsManager artistsManager = new ArtistsManager();
    private AlbumsManager albumsManager = new AlbumsManager();

    public Song[] getSongs(Context context) {

        //Some audio may be explicitly marked as not being music
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        String orderBy = MediaStore.Audio.Media.TITLE + " DESC"; 

        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ALBUM,
                "album_artist",
                MediaStore.Audio.Media.ALBUM_ID,
                MediaStore.Audio.Media.ARTIST_ID,
                MediaStore.Audio.Media.TRACK,
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
            songs[ cursor.getPosition() ] = new Song( cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), bitmap, cursor.getString(5), cursor.getInt(6) );
        }

        return songs;
    }

    public void updateSong(Song songToUpdate, String title, String artistToPut, String albumToPut, int track, Context context) {
        Artist artist = artistsManager.getArtistByName(artistToPut, context);
        Album album = albumsManager.getAlbumByName( albumToPut, context );

        ContentValues values = new ContentValues();
        values.put(MediaStore.Audio.Media.TITLE, title);
        values.put(MediaStore.Audio.Media.TRACK, track);

        values.put(MediaStore.Audio.Media.ALBUM, album.getName());
        values.put(MediaStore.Audio.Media.ALBUM_ID, album.getId());

        values.put(MediaStore.Audio.Media.ARTIST_ID, artist.getId());
        values.put(MediaStore.Audio.Media.ARTIST, artist.getName());
        values.put("album_artist", artist.getName());

        int rows = context.getContentResolver().update(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                values,
                MediaStore.Audio.Media._ID + "= ?",
                new String[]{songToUpdate.getId()}
        );
        Toast notificacion= Toast.makeText(context,"Cambios guardados",Toast.LENGTH_LONG);
        notificacion.show();
    }
}
