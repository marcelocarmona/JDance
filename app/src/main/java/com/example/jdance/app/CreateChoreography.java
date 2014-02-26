package com.example.jdance.app;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.jdance.app.model.BeepStep;
import com.example.jdance.app.model.Choreography;
import com.example.jdance.app.model.Repository;
import com.example.jdance.app.model.Step;
import com.example.jdance.app.util.DeleteOnItemLongClickListener;
import com.example.jdance.app.util.DoubleOnSeekBarChangeListener;
import com.example.jdance.app.util.NegativeOnSeekBarChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mclo on 11/12/13.
 * <p/>
 * referencia de ejemplos de usos de diaogos
 * http://www.devtroce.com/2012/01/19/mensajes-de-dialogo-popup-alertdialog/
 */
public class CreateChoreography extends ListActivity {

    private Context context = this;
    private List<Step> steps = Repository.getInstance().getSteps();
    private List<Step> newStepList = new ArrayList<Step>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<Step>(this, R.layout.list_item, newStepList));

        //delete step
        getListView().setOnItemLongClickListener(new DeleteOnItemLongClickListener(newStepList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_choreography_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_step:
                addDefaultStepDialog();
                return true;
            case R.id.action_add_beep_step:
                createBeepStepDialog();
                return true;
            case R.id.action_create_choreography:
                CreateChoreographyDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void addDefaultStepDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(getString(R.string.steps));

        //convierto de forma manual una lista de steps en CharSequence[]
        //no pude encontrar una forma mejor para hacerlo
        CharSequence[] charSequences = new CharSequence[steps.size()];
        int i = 0;
        for (Step step : steps) {
            charSequences[i] = step.toString();
            i++;
        }

        builder.setItems(charSequences, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
//
                //agregando step en la nueva lista
                newStepList.add(steps.get(item));
                ArrayAdapter<String> adapter = (ArrayAdapter<String>) getListAdapter();
                adapter.notifyDataSetChanged();
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void createBeepStepDialog() {
        // get create_step.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View createBeepStepView = li.inflate(R.layout.create_beep_step, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set create_step.xml to alertdialog builder
        alertDialogBuilder.setView(createBeepStepView);


        //Seek bar Frequency
        final SeekBar sbFrequency = (SeekBar) createBeepStepView.findViewById(R.id.sbFrequency);
        final TextView txtFrequency = (TextView) createBeepStepView.findViewById(R.id.txtFrequency);
        sbFrequency.setOnSeekBarChangeListener(new NegativeOnSeekBarChangeListener(txtFrequency));

        //Seek bar SecondsDuration
        final SeekBar sbSecondsDuration = (SeekBar) createBeepStepView.findViewById(R.id.sbSecondsDuration);
        final TextView txtSecondsDuration = (TextView) createBeepStepView.findViewById(R.id.txtSecondsDuration);
        sbSecondsDuration.setOnSeekBarChangeListener(new DoubleOnSeekBarChangeListener(txtSecondsDuration, 0.10));


        // set dialog message
        alertDialogBuilder

                .setTitle(getString(R.string.create_beep))
                .setPositiveButton(getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // create beepStep
                                int frequency = sbFrequency.getProgress();
                                double secondsDuration = sbSecondsDuration.getProgress() * 0.10;
                                //truncate
                                secondsDuration = Math.floor(secondsDuration * 10) / 10;
                                newStepList.add(new BeepStep(frequency, secondsDuration));
                                ((BaseAdapter) getListAdapter()).notifyDataSetChanged();
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

    private void CreateChoreographyDialog() {

        // get create_step.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View createChoreographyView = li.inflate(R.layout.create_choreography, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set create_step.xml to alertdialog builder
        alertDialogBuilder.setView(createChoreographyView);

        final EditText nameInput = (EditText) createChoreographyView
                .findViewById(R.id.txtChoreographyName);

        // set dialog message
        alertDialogBuilder

                .setTitle(getString(R.string.create_choreography))
                .setPositiveButton(getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // create choreorgaphy y se verifica que no este vacio el input
                                String nameString = nameInput.getText().toString();
                                if (!nameString.equals("")) {
                                    Choreography newChoreography = new Choreography(nameString, newStepList);
                                    Repository.getInstance().getChoreographies().add(newChoreography);
                                    finish();
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
