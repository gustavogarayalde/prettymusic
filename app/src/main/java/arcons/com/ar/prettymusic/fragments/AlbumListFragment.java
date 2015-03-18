package arcons.com.ar.prettymusic.fragments;

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

import arcons.com.ar.prettymusic.R;
import arcons.com.ar.prettymusic.layout.list.ListAdapter;
import arcons.com.ar.prettymusic.managers.AlbumsManager;
import arcons.com.ar.prettymusic.managers.value.Album;
import arcons.com.ar.prettymusic.managers.value.Artist;

/**
 * Created by Gustavo on 16/03/2015.
 */
public class AlbumListFragment extends Fragment {

    private AlbumsManager albumsManager = new AlbumsManager();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.album_list, container, false );

        ListView list = (ListView) rootView.findViewById(R.id.album_list);
        ArrayAdapter<Album> adapter = new ListAdapter<Album>(getActivity(),R.layout.album_list_row, albumsManager.getAlbums(rootView.getContext()));
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
