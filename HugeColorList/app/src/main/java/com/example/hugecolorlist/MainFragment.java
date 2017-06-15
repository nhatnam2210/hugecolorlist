package com.example.hugecolorlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment implements RecyclerViewItemClickListener{

    private static final int NUMBER_OF_ITEMS = 100000;
    private View rootView;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     *@see Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        setupRecyclerView();
        return rootView;
    }

    /**
     * @see RecyclerViewItemClickListener#onClick(View, int)
     */
    @Override
    public void onClick(View view, int position) {

    }

    /**
     * Setup the recycler view
     */
    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.main_list);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MainAdapter adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(this);
    }

    /**
     * Adapter for the recycler view
     */
    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

        private RecyclerViewItemClickListener itemClickListener;

        /**
         * @see android.support.v7.widget.RecyclerView.Adapter#onCreateViewHolder(ViewGroup, int)
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        /**
         * @see android.support.v7.widget.RecyclerView.Adapter#onBindViewHolder(RecyclerView.ViewHolder, int)
         */
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(String.valueOf(position));
            holder.itemView.setBackgroundColor(Util.positionToColor(position));
        }

        /**
         * @see android.support.v7.widget.RecyclerView.Adapter#getItemCount()
         */
        @Override
        public int getItemCount() {
            return NUMBER_OF_ITEMS;
        }

        /**
         * Set listener for recycler view's item
         *
         * @param itemClickListener The listener
         */
        public void setItemClickListener(RecyclerViewItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        /**
         * View holder class
         */
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView textView;
            public ViewHolder(View view) {
                super(view);
                textView = (TextView) view.findViewById(R.id.list_item_text);
                itemView.setOnClickListener(this);
            }

            /**
             * @see android.view.View.OnClickListener#onClick(View)
             */
            @Override
            public void onClick(View view) {
                itemClickListener.onClick(view, getLayoutPosition());
            }
        }
    }
}
