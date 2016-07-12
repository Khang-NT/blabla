package hasbrain.com.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

import hasbrain.com.appkit.PropertiesOfLayoutParams;
import hasbrain.com.appkit.PropertiesOfView;
import hasbrain.com.appkit.container.POLinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String json = loadJSONFromAsset();
        Gson gsonExt = null;
        {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(PropertiesOfView.class, new PropertiesOfView.Deserializer() {
            });
            builder.registerTypeAdapter(PropertiesOfLayoutParams.class, new PropertiesOfLayoutParams.Deserializer() {
            });
            gsonExt = builder.create();
        }
        POLinearLayout test = (POLinearLayout) gsonExt.fromJson(json, PropertiesOfView.class);

        ViewGroup rootContainer = test.generateView(this);
        setContentView(rootContainer);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("test.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
