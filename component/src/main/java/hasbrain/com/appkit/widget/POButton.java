package hasbrain.com.appkit.widget;

import android.content.Context;
import android.widget.Button;

/**
 * Created by blackcat on 09/07/2016.
 */
public class POButton extends POTextView {
    private static final String TAG = "POButton";

    public POButton() {
        this.text = "Button";
        this.textAllCaps = true;
    }

    @Override
    public Button generateView(Context context) {
        return (Button) super.assignProperties(new Button(context));
    }
}
