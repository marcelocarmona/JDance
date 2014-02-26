package com.example.jdance.app.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jdance.app.R;

import java.util.List;

/**
 * Created by mclo on 23/02/14.
 */
public class ItemAdapter extends BaseAdapter {
    private final Context context;
    private final List<? extends Object> list;
    private final int img;

    public ItemAdapter(Context context, List<? extends Object> list, int img) {
        this.context = context;
        this.list = list;
        this.img = img;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.simple_list_item, parent, false);

        // get tViews
        TextView txtRobotIdView = (TextView) rowView.findViewById(R.id.txtName);
        ImageView imgView = (ImageView) rowView.findViewById(R.id.img);

        //set Views
        Object listItem = list.get(position);
        txtRobotIdView.setText(listItem.toString());
        imgView.setImageResource(img);

        return rowView;
    }
}
