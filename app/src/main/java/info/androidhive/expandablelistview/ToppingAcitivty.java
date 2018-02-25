package info.androidhive.expandablelistview;

import android.os.Bundle;
import android.app.Activity;
import android.os.Parcelable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.androidhive.expandablelistview.model.Batter;
import info.androidhive.expandablelistview.model.Topping;

public class ToppingAcitivty extends Activity {

    private ArrayList<Parcelable> mArraylist1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topping_acitivty);

        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();

        String arrayAsString = getIntent().getExtras().getString("toppings");
        List<Topping> list = Arrays.asList(gson.fromJson(arrayAsString, Topping[].class));

        List<String> type = new ArrayList<>();
        for(int i =  0 ; i < list.size();i++)
        {

            type.add(list.get(i).getType());
        }


        final ListView listview = (ListView) findViewById(R.id.listview_topping);



        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, type);
        listview.setAdapter(adapter);
    }

}
