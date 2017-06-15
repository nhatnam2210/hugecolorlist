package com.example.hugecolorlist;

import android.view.View;

/**
 * Listener interface for recycler view's item
 */
public interface RecyclerViewItemClickListener {
    /**
     * Handle recycler view's item's click event
     *
     * @param view The view
     * @param position The position of recycler view's item
     */
    public void onClick(View view, int position);
}
