package info.androidhive.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.google.gson.Gson;

import info.androidhive.expandablelistview.model.Desserts;
import info.androidhive.expandablelistview.network.api;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	private List<Desserts> dessertsList;
	private MainActivity context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = MainActivity.this;
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();



		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Expanded",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Collapsed",
						Toast.LENGTH_SHORT).show();

			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				/*// TODO Auto-generated method stub
				Toast.makeText(
						getApplicationContext(),
						listDataHeader.get(groupPosition)
								+ " : "
								+ listDataChild.get(
										listDataHeader.get(groupPosition)).get(
										childPosition), Toast.LENGTH_SHORT)
						.show();*/

				if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).toString().equals("Batters "))
				{
					Intent i = new Intent (context,BatterActivity.class);
					String arrayAsString = new Gson().toJson(dessertsList.get(groupPosition).getBatters().getBatter());
					i.putExtra("batters", arrayAsString);
					startActivity(i);

				}
				else
				{
					Intent i = new Intent (context,ToppingAcitivty.class);
					String arrayAsString = new Gson().toJson(dessertsList.get(groupPosition).getTopping());
					i.putExtra("toppings", arrayAsString);
					startActivity(i);


				}


				return false;
			}
		});
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();



		final RestAdapter restadapter = new RestAdapter.Builder().setEndpoint("http://www.anshuli.webhostingforstudents.com").build();

		api flowerapi = restadapter.create(api.class);

		flowerapi.getData(new Callback<List<Desserts>>() {
			@Override
			public void success(List<Desserts> myDessertsList, Response response) {
				dessertsList = myDessertsList;

				for(int i = 0; i < dessertsList.size(); i++)
				{
						listDataHeader.add(dessertsList.get(i).getName());

						List<String> childItem = new ArrayList<String>();
						childItem.add("Batters ");
						childItem.add("Toppings ");

						listDataChild.put(listDataHeader.get(i), childItem);

				}

				listAdapter = new ExpandableListAdapter(context, listDataHeader, listDataChild);

				// setting list adapter
				expListView.setAdapter(listAdapter);


			}

			@Override
			public void failure(RetrofitError error) {
				Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
			}
		});
		
		
		

	}
}
