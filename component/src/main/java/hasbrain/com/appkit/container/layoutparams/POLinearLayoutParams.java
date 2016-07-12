package hasbrain.com.appkit.container.layoutparams;

import android.widget.LinearLayout;

import hasbrain.com.appkit.PropertiesOfLayoutParams;

/**
 * Created by blackcat on 09/07/2016.
 */
public class POLinearLayoutParams extends PropertiesOfLayoutParams<LinearLayout.LayoutParams> {
    private static final String TAG = "POLinearLayoutParams";

    private int layoutGravity;

    private float weight;

    public POLinearLayoutParams() {
        this.layoutGravity = -1; // gravity NONE
        this.weight = 0;
    }

    public float getWeight() {
        return weight;
    }

    public int getLayoutGravity() {
        return layoutGravity;
    }

    @Override
    public LinearLayout.LayoutParams generateLayoutParams() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, 0);
        return assignProperties(lp);
    }

    @Override
    public LinearLayout.LayoutParams assignProperties(LinearLayout.LayoutParams input) {
        input.gravity = getLayoutGravity();
        input.weight = getWeight();
        return super.assignProperties(input);
    }
}
