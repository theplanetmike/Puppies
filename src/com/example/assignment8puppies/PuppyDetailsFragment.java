package com.example.assignment8puppies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class PuppyDetailsFragment extends Fragment implements ConstantsInterface {
	
	private Puppy puppy;
	private View view;
	private AudioPlayer player = new AudioPlayer();
	private boolean audioToggle = false;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//old version
		setRetainInstance(true);
		//UUID id = (UUID)getActivity().getIntent().getSerializableExtra(PuppyGridFragment.EXTRA_PUPPY_ID);
		
		

		//new from two pain version
		int id;
		
		if(getArguments() == null)
		{
			//id = (UUID)getActivity().getIntent().getSerializableExtra(EXTRA_PUPPY_ID);
			id = getActivity().getIntent().getIntExtra(EXTRA_PUPPY_ID, 0);
		}
		else
		{
			//id = (UUID)getArguments().getSerializable(EXTRA_PUPPY_ID);
			id = getArguments().getInt(EXTRA_PUPPY_ID);

		}
		
		//both versions
		puppy = PuppySet.makeList().getPuppy(id);
	}

	//new from two pain version
	public static PuppyDetailsFragment newInstance(int id)
	{
		Bundle args = new Bundle();
		args.putInt(EXTRA_PUPPY_ID, id);
		PuppyDetailsFragment fragment = new PuppyDetailsFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_details, container, false);
		
		initPuppies();
		
		return view;
	}
	


	private void initPuppies()
	{
		initBreed();
		initDetails();
		initImage();
		
	}

	private void initBreed()
	{
		TextView breedView = (TextView)view.findViewById(R.id.breed);
		breedView.setText(puppy.getBreed());
	}
	
	private void initDetails()
	{
		TextView descView = (TextView)view.findViewById(R.id.details);
		descView.setText(puppy.getDescription());
	}
	
	private void initImage()
	{
		ImageView imageView = (ImageView)view.findViewById(R.id.img);
		imageView.setImageResource(puppy.getImageID());
		
		
		imageView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//play a bark or stop bark
				if (audioToggle) {
					player.stop();
				}else{
					player.play(getActivity(), puppy.getSoundID());
				}
				audioToggle = !audioToggle;
			}
		});
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		player.stop();
	}
}
