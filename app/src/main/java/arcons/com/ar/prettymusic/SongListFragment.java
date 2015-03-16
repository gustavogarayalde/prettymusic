package arcons.com.ar.prettymusic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import arcons.com.ar.prettymusic.managers.SongsManager;
import arcons.com.ar.prettymusic.managers.value.Song;

/**
 * Created by Gustavo on 16/03/2015.
 */
public class SongListFragment extends Fragment {

    private SongsManager songsManager = new SongsManager();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.song_list, container, false );

        ListView list = (ListView) rootView.findViewById(R.id.song_list);
        String[] canciones =  {"Item 1", "Item 2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,canciones );
        //ArrayAdapter<Song> adapter = new ArrayAdapter<Song>(getActivity(),android.R.layout.simple_list_item_1, songsManager.getSongs());
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Toast notificacion= Toast.makeText(getActivity(),"Prueba",Toast.LENGTH_LONG);
                notificacion.show();
            }
        });

        return rootView;
    }
}
