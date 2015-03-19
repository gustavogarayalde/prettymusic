package arcons.com.ar.prettymusic.layout.list;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import arcons.com.ar.prettymusic.R;

/**
 * Created by Gustavo on 16/03/2015.
 */
public class SimpleListAdapter<T extends ListableItem> extends ArrayAdapter<T> {

    private ListableItem[] items;
    private int layout;

    public SimpleListAdapter(FragmentActivity activity, int layout, T[] items) {
        super(activity,layout,items);
        this.layout = layout;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout, parent, false);

        ListableItem item = (ListableItem) items[position];

        TextView mainText = (TextView) rowView.findViewById(R.id.simple_list_item);
        mainText.setText( item.getListMainText() );

        return rowView;
    }
}
