package hasbrain.com.appkit.widget;

import android.content.Context;
import android.view.View;

import hasbrain.com.appkit.PropertiesOfView;

/**
 * Created by blackcat on 09/07/2016.
 */
/* Properties of View */
public class POView extends PropertiesOfView<View> {
    private static final String TAG = "POView";

    @Override
    public View generateView(Context context) {
        return assignProperties(new View(context));
    }
}
