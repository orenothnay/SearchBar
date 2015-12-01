package com.oren.searchbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FocusEditText mFocusEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.top_toolbar);
        toolbar.setTitle("some title");
        toolbar.inflateMenu(R.menu.menu_main);
        final View logoLayout = findViewById(R.id.logo_layout);
        mFocusEditText = (FocusEditText) findViewById(R.id.search_bar);
        mFocusEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(final View v, final boolean hasFocus)
            {
                // this is the main interesting point, you can extend this with animations.
                if(hasFocus)
                {
                    logoLayout.setVisibility(View.GONE);
                    toolbar.setVisibility(View.GONE);
                }
                else
                {
                    logoLayout.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mFocusEditText.clearFocus();
    }
}
