package arcons.com.ar.prettymusic.fragments;

import android.content.Intent;
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

import arcons.com.ar.prettymusic.activities.EditSongActivity;
import arcons.com.ar.prettymusic.layout.list.ListAdapter;
import arcons.com.ar.prettymusic.R;
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
        ArrayAdapter<Song> adapter = new ListAdapter<Song>(getActivity(),R.layout.song_list_row, songsManager.getSongs(rootView.getContext()));
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Intent intent=new Intent(view.getContext(),EditSongActivity.class);
                intent.putExtra("song",(Song) parent.getItemAtPosition(position));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
