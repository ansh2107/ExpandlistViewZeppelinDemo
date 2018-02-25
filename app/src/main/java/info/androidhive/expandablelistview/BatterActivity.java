package info.androidhive.expandablelistview;

import android.os.Bundle;
import android.app.Activity;
import android.os.Parcelable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.androidhive.expandablelistview.model.Batter;

public class BatterActivity extends Activity {

    private ArrayList<Parcelable> mArraylist1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batter);

        String arrayAsString = getIntent().getExtras().getString("batters");
        List<Batter> list = Arrays.asList(new Gson().fromJson(arrayAsString, Batter[].class));

        List<String> type = new ArrayList<>();
        for(int i =  0 ; i < list.size();i++)
        {

            type.add(list.get(i).getType());
        }


        final ListView listview = (ListView) findViewById(R.id.listview_batter);



        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, type);
        listview.setAdapter(adapter);
    }

}
