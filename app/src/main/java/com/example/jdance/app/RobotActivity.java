package com.example.jdance.app;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jdance.app.model.Repository;
import com.example.jdance.app.model.Robot;
import com.example.jdance.app.model.SenderRequest;
import com.example.jdance.app.util.DeleteOnItemLongClickListener;
import com.example.jdance.app.util.ItemAdapter;

import java.io.IOException;
import java.util.List;

public class RobotActivity extends ListActivity {

    private Context context = this;
    private List<Robot> robots = Repository.getInstance().getRobots();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CharSequence title = getString(R.string.select_a_robot);
        setTitle(title);

        setListAdapter(new ItemAdapter(this, robots, R.drawable.ic_android_dance));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        //select ic_choreography
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Toast.makeText(getApplicationContext(),
                        robots.get(position).toString() + " " + getString(R.string.is_selected), Toast.LENGTH_SHORT).show();

                //Intent
                Intent intent = new Intent(getApplicationContext(), ChoreographyActivity.class);
                intent.putExtra("ROBOT", robots.get(position));
                startActivity(intent);
                overridePendingTransition(R.anim.animation_to_right_enter, R.anim.animation_to_right_leave);
            }
        });

        //delete robot
        listView.setOnItemLongClickListener(new DeleteOnItemLongClickListener(robots));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_load_robots:
                SenderRequest senderRequest = new SenderRequest(this);
                try {
                    senderRequest.loadRobots();
                } catch (IOException e) {
                    alertDialog();
                    e.printStackTrace();
                }
                ((BaseAdapter) getListAdapter()).notifyDataSetChanged();
                return true;
            case R.id.action_create_robot:
                createRobotDialog();
                return true;
            case R.id.action_create_step:
                Intent intent = new Intent(getApplicationContext(), CreateStep.class);
                startActivity(intent);
                return true;
            case R.id.action_create_choreography:
                startActivity(new Intent(getApplicationContext(), CreateChoreography.class));
                return true;
            case R.id.action_dance_floor:
                startActivity(new Intent(getApplicationContext(), DanceFloorActivity.class));
                overridePendingTransition(R.anim.animation_to_right_enter, R.anim.animation_to_right_leave);
                return true;
            case R.id.action_settings:
                Intent preferencesIntent = new Intent(getApplicationContext(), Settings.class);
                startActivity(preferencesIntent);
                return true;
            case R.id.action_about:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mclo.github.io/JDance/"));
                startActivity(browserIntent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.error));
        builder.setMessage(getString(R.string.check_ip_or_port));
        builder.setPositiveButton(getString(R.string.ok), null);
        builder.create();
        builder.show();
    }

    private void createRobotDialog() {
        // get create_step.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View createStepView = li.inflate(R.layout.create_robot, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set create_step.xml to alertdialog builder
        alertDialogBuilder.setView(createStepView);

        final EditText robotIdInput = (EditText) createStepView
                .findViewById(R.id.txtCreateRobot);

        // set dialog message
        alertDialogBuilder

                .setTitle(getString(R.string.robot_id))
                .setPositiveButton(getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // create robot y se verifica que no este vacio el input
                                String robotIdString = robotIdInput.getText().toString();
                                if (!robotIdString.equals("")) {
                                    int robotId = Integer.parseInt(robotIdString);
                                    robots.add(new Robot(robotId));
                                    ((BaseAdapter) getListAdapter()).notifyDataSetChanged();
                                } else
                                    dialog.cancel();
                            }
                        })
                .setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}