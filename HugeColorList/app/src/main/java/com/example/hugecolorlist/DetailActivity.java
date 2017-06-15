package com.example.hugecolorlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * The detail activity
 */
public class DetailActivity extends AppCompatActivity {
    private int middleIndex;

    /**
     * @see AppCompatActivity#onCreate(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getMiddleIndex();
        setupViews();
    }

    /**
     * Get middle index sent from main fragment
     */
    private void getMiddleIndex() {
        middleIndex = getIntent().getIntExtra(MainFragment.KEY_CLICKED_POSITION, 0);
    }

    /**
     * Setup views based on middle index
     */
    private void setupViews() {
        int topIndex = middleIndex == 0 ? MainFragment.NUMBER_OF_ITEMS - 1 : middleIndex - 1;
        int bottomIndex = middleIndex == MainFragment.NUMBER_OF_ITEMS - 1 ? 0 : middleIndex + 1;
        setViewColor(R.id.detail_top, topIndex);
        setViewColor(R.id.detail_middle, middleIndex);
        setViewColor(R.id.detail_bottom, bottomIndex);
    }

    /**
     * Set color of a view based on its id and index
     *
     * @param viewId  The id of view
     * @param index The index of view
     */
    private void setViewColor(int viewId, int index) {
        View view = findViewById(viewId);
        view.setBackgroundColor(Util.positionToColor(index));
    }
}
