package com.pat_041.android.uniconn;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Abhijit on 14-10-2017.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    public GridViewAdapter(Context c){
        mContext = c;
    }
    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        //get the item corresponding to your position
        Log.v("Inside Grid View : ","I Have Entered the Grid View");
        LinearLayout gridLinearLayout = (LinearLayout) (convertView == null
                ? LayoutInflater.from(mContext).inflate(R.layout.linearlayout_grid, parent, false)
                : convertView);

        ((ImageView)gridLinearLayout.findViewById(R.id.image_grid)).setImageResource(mThumbIds[position]);
        ((TextView)gridLinearLayout.findViewById(R.id.grid_text)).setText(""+mContext.getString(mTextIds[position]));
        //Log.v("Inside Grid View : ","I am Returning from Grid View : "+mTextIds[position]);
        return gridLinearLayout;
    }

    public Integer[] mThumbIds = {
            R.drawable.pic_university, R.drawable.user_image,
            R.drawable.pic_events,R.drawable.explore_the_world_image
    };
    public Integer[] mTextIds = {
            R.string.grid_univ_text,R.string.grid_inst_text,
            R.string.grid_event_text,R.string.grid_explore_projects_text
    };
}
