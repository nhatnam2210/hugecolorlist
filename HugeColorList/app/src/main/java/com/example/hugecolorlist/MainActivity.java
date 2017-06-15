package com.example.hugecolorlist;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * The main activity
 */
public class MainActivity extends AppCompatActivity {
    private static final String KEY_FRAGMENT_STATE = "fragment_state";
    private Fragment mainFragment;

    /**
     * @see AppCompatActivity#onCreate(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //restore fragment's state
        if(savedInstanceState != null) {
            mainFragment = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FRAGMENT_STATE);
        } else {
            mainFragment = new MainFragment();
        }
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, mainFragment).commit();
    }

    /**
     * @see AppCompatActivity#onSaveInstanceState(Bundle)
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //save fragment's state
        if(mainFragment != null) {
            getSupportFragmentManager().putFragment(outState, KEY_FRAGMENT_STATE, mainFragment);
        }
    }
}
