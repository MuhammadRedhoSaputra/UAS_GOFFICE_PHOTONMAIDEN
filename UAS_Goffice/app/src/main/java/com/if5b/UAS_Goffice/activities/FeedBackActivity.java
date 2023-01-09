package com.if5b.UAS_Goffice.activities;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.if5b.UAS_Goffice.R;

public class FeedBackActivity extends AppCompatActivity {

    private ImageView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedback =findViewById(R.id.iv_logoUs);

        Glide.with(FeedBackActivity.this)
                .load(R.drawable.logo_goffice)
                .transform(new CircleCrop())
                .into(feedback);
    }
}

