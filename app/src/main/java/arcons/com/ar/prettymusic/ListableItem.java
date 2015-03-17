package arcons.com.ar.prettymusic;

import android.graphics.Bitmap;

/**
 * Created by Gustavo on 16/03/2015.
 */
public interface ListableItem {

    String getListMainText();

    String getListSecondaryText();

    boolean hasImage();

    Bitmap getImage();
}
