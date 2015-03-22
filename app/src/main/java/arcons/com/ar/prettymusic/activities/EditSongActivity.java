package arcons.com.ar.prettymusic.activities;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import arcons.com.ar.prettymusic.R;
import arcons.com.ar.prettymusic.managers.AlbumsManager;
import arcons.com.ar.prettymusic.managers.ArtistsManager;
import arcons.com.ar.prettymusic.managers.SongsManager;
import arcons.com.ar.prettymusic.managers.value.Song;

public class EditSongActivity extends ActionBarActivity {

    private ArtistsManager artistsManager = new ArtistsManager();
    private AlbumsManager albumsManager = new AlbumsManager();
    private SongsManager songsManager = new SongsManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        setAutocompleteValues( R.id.song_artist_input, artistsManager.getArtistsNames( this ), this);
        setAutocompleteValues( R.id.song_album_input, albumsManager.getAlbumsNames( this ), this);

        Song song = (Song) getIntent().getSerializableExtra("song");
        setTextToInput( R.id.song_title_input, song.getTitle() );
        setTextToInput( R.id.song_artist_input, song.getArtist() );
        setTextToInput( R.id.song_album_input, song.getAlbum() );
        setIntToInput( R.id.song_track_input, song.getTrack() );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_song, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveSong(View view){
        Song songToUpdate = (Song) getIntent().getSerializableExtra("song");
        songsManager.updateSong(
                songToUpdate,
                getInputText( R.id.song_title_input ),
                getInputText( R.id.song_artist_input ),
                getInputText( R.id.song_album_input ),
                getInputInt( R.id.song_track_input ),
                this );
    }

    // TODO: pasar a util
    private String getInputText(int inputId) {
        return ( (EditText) findViewById( inputId ) ).getText().toString();
    }

    // TODO: pasar a util
    private int getInputInt(int inputId) {
        return Integer.parseInt( ( (EditText) findViewById( inputId ) ).getText().toString() );
    }

    // TODO: pasar a util
    private void setTextToInput(int inputId, String value) {
        ( (EditText) findViewById( inputId ) ).setText( value );
    }

    // TODO: pasar a util
    private void setIntToInput(int inputId, int value) {
        ( (EditText) findViewById( inputId ) ).setText( String.valueOf(value) );
    }

    // TODO: pasar a util
    private void setAutocompleteValues(int itemId, String[] values, Context context) {
        AutoCompleteTextView item = (AutoCompleteTextView) findViewById( itemId );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, values);
        item.setAdapter(adapter);
    }
}
