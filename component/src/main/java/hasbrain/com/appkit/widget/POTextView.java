package hasbrain.com.appkit.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import hasbrain.com.appkit.PropertiesOfView;

/**
 * Created by blackcat on 09/07/2016.
 */
public class POTextView extends PropertiesOfView<TextView> {
    private static final String TAG = "POTextView";

    protected String text;

    protected float textSize;

    protected int textColor;

    protected int gravity;

    protected boolean textAllCaps;

    public POTextView() {
        this.text = "Text view";
        this.textSize = -1;
        this.textColor = Color.BLACK;
        this.gravity = Gravity.CENTER;
        this.textAllCaps = false;
    }

    @Override
    public TextView generateView(Context context) {
        return assignProperties(new TextView(context));
    }

    @Override
    public TextView assignProperties(TextView input) {
        input.setText(text);
        input.setTextColor(textColor);
        input.setGravity(gravity);
        if (textSize >= 0)
            input.setTextSize(textSize);
        input.setAllCaps(textAllCaps);
        return super.assignProperties(input);
    }
}
