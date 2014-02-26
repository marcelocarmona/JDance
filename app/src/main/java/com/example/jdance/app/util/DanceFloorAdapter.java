package com.example.jdance.app.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jdance.app.R;
import com.example.jdance.app.model.Robot;

import java.util.List;

/**
 * Created by mclo on 21/02/14.
 * <p/>
 * ArrayAdapter para mostrar el nombre del Robot y su coreo
 */
public class DanceFloorAdapter extends ArrayAdapter<Robot> {

    private final Context context;
    private final List<Robot> robots;

    public DanceFloorAdapter(Context context, List<Robot> robots) {
        super(context, R.layout.dance_floor_list_item, robots);
        this.context = context;
        this.robots = robots;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.dance_floor_list_item, parent, false);

        // get textViews
        TextView txtRobotNameView = (TextView) rowView.findViewById(R.id.txtRobotName);
        TextView txtRobotChoreographyView = (TextView) rowView.findViewById(R.id.txtRobotChoreography);
        TextView txtRobotStepsView = (TextView) rowView.findViewById(R.id.txtRobotSteps);
        TextView txtRobotMinutesView = (TextView) rowView.findViewById(R.id.txtRobotSeconds);

        //set textViews
        Robot robot = robots.get(position);
        txtRobotNameView.setText(robot.toString());
        txtRobotChoreographyView.setText(robot.getChorepgraphy().toString());
        txtRobotStepsView.setText(context.getString(R.string.steps) + ": " + Integer.toString(robot.countSteps()));
        txtRobotMinutesView.setText(context.getString(R.string.seconds) + ": " + String.format("%.2f", robot.countSeconds()));

        return rowView;
    }
}
