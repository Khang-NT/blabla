package hasbrain.com.appkit.container;

import android.view.ViewGroup;

import hasbrain.com.appkit.PropertiesOfView;

/**
 * Created by blackcat on 09/07/2016.
 */
public abstract class POViewGroup<T extends ViewGroup> extends PropertiesOfView<T> {
    private static final String TAG = "POViewGroup";

    /* properties of children */
    private PropertiesOfView[] children;

    public int getChildCount() {
        return children == null ? 0 : children.length;
    }

    /* get properties of child at given index */
    public PropertiesOfView getPOChildAt(int index) {
        return children[index];
    }

    @Override
    public T assignProperties(T input) {
        if (children != null)
            for (PropertiesOfView poView : children)
                input.addView(poView.generateView(input.getContext()));
        return super.assignProperties(input);
    }
}
