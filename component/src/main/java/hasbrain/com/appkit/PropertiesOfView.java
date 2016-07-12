package hasbrain.com.appkit;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.CallSuper;
import android.view.View;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;

/**
 * Created by blackcat on 09/07/2016.
 */
public abstract class PropertiesOfView<T extends View> implements PropertiesOf<T> {
    public static final String BACKGROUND_COLOR = "0";
    private static final String TAG = "PropertiesOfView";
    private int id;

    /* properties of layout params */
    private PropertiesOfLayoutParams layoutParams;

    private String background;

    private int paddingLeft;

    private int paddingRight;

    private int paddingTop;

    private int paddingBottom;

    public PropertiesOfView() {
        this.id = -1;
        this.paddingTop = this.paddingBottom = this.paddingLeft = this.paddingRight = 0;
    }

    public PropertiesOfLayoutParams getPOLayoutParams() {
        return layoutParams;
    }

    public int getId() {
        return id;
    }

    public String getBackground() {
        return background;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public abstract T generateView(Context context);

    @CallSuper
    @Override
    public T assignProperties(T input) {
        input.setId(id);
        if (getPOLayoutParams() != null)
            input.setLayoutParams(getPOLayoutParams().generateLayoutParams());
        assignBackground(input);
        input.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return input;
    }

    private void assignBackground(View view) {
        if (getBackground() != null) {
            String[] var1 = getBackground().split(",");
            switch (var1[0]) {
                case BACKGROUND_COLOR:
                    view.setBackgroundColor(Color.parseColor(var1[1]));
                    break;
            }
        }
    }

    public static class Deserializer implements JsonDeserializer<PropertiesOfView> {
        private static final String CLASS_NAME = "className";

        @Override
        public PropertiesOfView deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASS_NAME);
            String className = prim.getAsString();
            Class<?> rawClass;
            try {
                rawClass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new JsonParseException(e.getMessage());
            }
            return context.deserialize(json, rawClass);
        }
    }
}
