package hasbrain.com.appkit;

import android.support.annotation.CallSuper;
import android.view.ViewGroup;

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
public abstract class PropertiesOfLayoutParams<T extends ViewGroup.MarginLayoutParams> implements PropertiesOf<T> {
    private static final String TAG = "PropertiesOfLayoutParams";
    private int width;

    private int height;

    private int marginLeft;

    private int marginRight;

    private int marginTop;

    private int marginBottom;

    public PropertiesOfLayoutParams() {
        this.width = this.height = ViewGroup.LayoutParams.MATCH_PARENT;
        this.marginLeft = this.marginRight = this.marginTop = this.marginBottom = 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public abstract T generateLayoutParams();

    @CallSuper
    @Override
    public T assignProperties(T input) {
        input.width = getWidth();
        input.height = getHeight();
        input.setMargins(marginLeft, marginTop, marginRight, marginBottom);
        return input;
    }

    public static class Deserializer implements JsonDeserializer<PropertiesOfLayoutParams> {
        private static final String CLASS_NAME = "className";

        @Override
        public PropertiesOfLayoutParams deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
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
