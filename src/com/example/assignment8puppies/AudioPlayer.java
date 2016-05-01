package com.example.assignment8puppies;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	private MediaPlayer player;
	
	public void play(Context context, int audioID)
	{
		stop();
		player = MediaPlayer.create(context, audioID); //does R.raw. need to be in here somewhere?
		player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				
				stop();
			}
		});
		player.start();
	}
	
	public void stop()
	{
		if(player == null)return;
		
		player.release();
	}

}
