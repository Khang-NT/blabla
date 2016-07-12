package hasbrain.com.appkit.container;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;

/**
 * Created by blackcat on 09/07/2016.
 */
public class POLinearLayout extends POViewGroup<LinearLayout> {
    private static final String TAG = "POLinearLayout";

    private int orientation;

    private int gravity;

    public POLinearLayout() {
        this.orientation = LinearLayout.VERTICAL;
        this.gravity = Gravity.TOP | Gravity.START; /* Left + top */
    }

    public int getOrientation() {
        return orientation;
    }

    public int getGravity() {
        return gravity;
    }


    @Override
    public LinearLayout generateView(Context context) {
        return assignProperties(new LinearLayout(context));
    }

    @Override
    public LinearLayout assignProperties(LinearLayout ll) {
        ll.setOrientation(getOrientation());
        ll.setGravity(getGravity());
        return super.assignProperties(ll);
    }
}
