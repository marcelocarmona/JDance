package com.example.jdance.app;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jdance.app.model.Repository;
import com.example.jdance.app.model.Robot;
import com.example.jdance.app.model.SenderRequest;
import com.example.jdance.app.util.DanceFloorAdapter;
import com.example.jdance.app.util.DeleteOnItemLongClickListener;

import java.util.List;


public class DanceFloorActivity extends ListActivity {

    private List<Robot> robots = Repository.getInstance().getDanceFloor();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new DanceFloorAdapter(this, robots));

        //delete robot
        getListView().setOnItemLongClickListener(new DeleteOnItemLongClickListener(robots));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dance_floor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_go:
                go();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //override animation transition
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.animation_to_left_enter, R.anim.animation_to_left_leave);
    }

    //method to dance
    private void go() {
        //send request
        SenderRequest senderRequest = new SenderRequest(this);
        senderRequest.toDance();

        Toast.makeText(getApplicationContext(), getString(R.string.dancing), Toast.LENGTH_SHORT).show();
        finish();
    }
}
