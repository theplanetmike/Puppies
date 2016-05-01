package com.example.assignment8puppies;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

public class PuppyGridActivity extends SingleFragmentActivity 
implements PuppyGridFragment.Callbacks, ConstantsInterface {

	@Override
	protected Fragment createFragment() {
		return new PuppyGridFragment();
	}
	
	//new for two pain layout
	@Override
	protected int getLayoutResId()
	{ //overloaded this method from SingleFragmentActivity
		return R.layout.activity_master_layout;
	}

	@Override
	public void onPuppySelected(int puppyID) {

		if (findViewById(R.id.detail_fragment_container) == null)
		{ //portrait
			Intent intent = new Intent(this, PuppyDetailsActivity.class);
			intent.putExtra(EXTRA_PUPPY_ID, puppyID);
			startActivity(intent);
			//Log.i("Mike", "activity started, puppyID = " + puppyID); //gets this far
		}else
		{ //landscape
			FragmentManager manager = getSupportFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			
			Fragment oldFragment = manager.findFragmentById(R.id.detail_fragment_container);
			Fragment newFragment = PuppyDetailsFragment.newInstance(puppyID);
			
			if (oldFragment != null) //if there was a puppy in the details
			{
				transaction.remove(oldFragment);
			}
			transaction.add(R.id.detail_fragment_container, newFragment);
			transaction.commit();
		}
	}

}
