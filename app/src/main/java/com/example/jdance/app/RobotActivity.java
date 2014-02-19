package com.example.jdance.app;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdance.app.model.Repository;
import com.example.jdance.app.model.Robot;
import com.example.jdance.app.model.SenderRequest;

import java.io.IOException;
import java.util.List;

public class RobotActivity extends ListActivity {

    private List<Robot> robots = Repository.getInstance().getRobots();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<Robot>(this, R.layout.list_item, robots));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        //select choreography
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText() + " " + getString(R.string.is_selected), Toast.LENGTH_SHORT).show();

                //Intent
                Intent intent = new Intent(getApplicationContext(), ChoreographyActivity.class);
                intent.putExtra("ROBOT", robots.get(position));
                startActivity(intent);
            }
        });

        //delete robot
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                robots.remove(position);
                ((BaseAdapter) parent.getAdapter()).notifyDataSetChanged();
                return true;
            }
        });

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
            case R.id.action_create_step:
                Intent intent = new Intent(getApplicationContext(), CreateStep.class);
                startActivity(intent);
                return true;
            case R.id.action_create_choreography:
                startActivity(new Intent(getApplicationContext(), CreateChoreography.class));
                return true;
            case R.id.action_dance_floor:
                startActivity(new Intent(getApplicationContext(), DanceFloorActivity.class));
                return true;
            case R.id.action_settings:
                Intent preferencesIntent = new Intent(getApplicationContext(), Settings.class);
                startActivity(preferencesIntent);
                return true;
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
}
