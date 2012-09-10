package com.WRHEnterprises.TheSunglassFix;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class TheSunglassFix extends Activity 
	{
    private SeekBar mSeekBar;
    private TextView mWebSite;
    private TextView mPhoneNumber;
    
    private OnSeekBarChangeListener mSeekListener = new OnSeekBarChangeListener() 
    	{
    
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
        	{
            setLevel(seekBar.getProgress());
        	}

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) 
        	{
            // Not used
        	}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) 
        	{
            // Not used
        	}

    	};
	
    
    private OnClickListener mClickListener = new OnClickListener() 
    	{
        @Override
        public void onClick(View v) 
        	{
        	Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sunglassfix.com.au")); 
        	startActivity(myIntent); 
        	}
    	};
	
    private OnClickListener mPhoneListener = new OnClickListener() 
		{
    	@Override
    	public void onClick(View v) 
    		{
    		Intent myIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1800786349")); 
    		startActivity(myIntent); 
    		}
		};
    
    
    private void setLevel(int progress) 
    	{
        
    	ImageView mGlasses = (ImageView) this.findViewById(R.id.Glasses);
        
        if (progress == 0) 
        	{
        	mGlasses.setImageResource(R.drawable.sunglasses1);
        	return;
        	}

        if (progress == 1) 
        	{
        	mGlasses.setImageResource(R.drawable.sunglasses2);
        	return;
        	}

        if (progress == 2) 
        	{
        	mGlasses.setImageResource(R.drawable.sunglasses3);
        	return;
        	}
        
        if (progress == 3) 
        	{
        	mGlasses.setImageResource(R.drawable.sunglasses4);
        	return;
        	}
        
        if (progress == 4) 
        	{
        	mGlasses.setImageResource(R.drawable.sunglasses5);
        	return;
        	}
        
        if (progress == 5) 
        	{
        	mGlasses.setImageResource(R.drawable.sunglasses6);
        	return;
        	}
        
    	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
		{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mWebSite = (TextView) this.findViewById(R.id.WebAddress);
        mWebSite.setOnClickListener(mClickListener);

        mPhoneNumber = (TextView) this.findViewById(R.id.PhoneNumber);
        mPhoneNumber.setOnClickListener(mPhoneListener);

        mSeekBar = (SeekBar) this.findViewById(R.id.SeekBar);
        mSeekBar.setOnSeekBarChangeListener(mSeekListener);

        // Initialize the level
        setLevel(0);
        
		}
}