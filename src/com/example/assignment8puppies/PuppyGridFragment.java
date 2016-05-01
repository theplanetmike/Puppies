package com.example.assignment8puppies;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PuppyGridFragment extends ListFragment implements ConstantsInterface {
	//turn this into a grid later
	//public static final String EXTRA_PUPPY_ID = "puppy_id"; //now a constant?
	private ArrayList<Puppy> puppyArray;
	private Callbacks callbacks;
	
	public interface Callbacks
	{
		public void onPuppySelected(int puppyID);
	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		callbacks = (Callbacks)activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		callbacks=null;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true); //new for two pane
		//getActivity().setTitle(R.string.app_name); //not needed in two pane
		
		puppyArray = PuppySet.makeList().getPuppies();
		
		ArrayAdapter<Puppy> adapter = new ArrayAdapter<Puppy>(getActivity(), android.R.layout.simple_list_item_1, puppyArray);
		setListAdapter(adapter);
	}

	
	@Override
	public void onListItemClick(ListView listView, View v, int position, long id) {

		super.onListItemClick(listView, v, position, id);

		//Log.i("Mike", "position: " + position); //position is 0-5
		
		callbacks.onPuppySelected(position);
		
		/*not needed in two pain
		Intent intent = new Intent(getActivity(), PuppyDetailsActivity.class);
		intent.putExtra(EXTRA_PUPPY_ID, puppy.getId());
		startActivity(intent);
		*/
	}
}
