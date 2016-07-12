package hasbrain.com.appkit.container.layoutparams;

import android.view.ViewGroup;

import hasbrain.com.appkit.PropertiesOfLayoutParams;

/**
 * Created by blackcat on 11/07/2016.
 */
public class PODefaultLayoutParams extends PropertiesOfLayoutParams<ViewGroup.MarginLayoutParams> {
    private static final String TAG = "PODefaultLayoutParams";

    @Override
    public ViewGroup.MarginLayoutParams generateLayoutParams() {
        return assignProperties(new ViewGroup.MarginLayoutParams(0, 0));
    }
}
