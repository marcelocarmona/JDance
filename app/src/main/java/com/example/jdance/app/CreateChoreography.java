package com.example.jdance.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jdance.app.model.Choreography;
import com.example.jdance.app.model.Repository;
import com.example.jdance.app.model.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mclo on 11/12/13.
 * <p/>
 * referencia de ejemplos de usos de diaogos
 * http://www.devtroce.com/2012/01/19/mensajes-de-dialogo-popup-alertdialog/
 */
public class CreateChoreography extends Activity {

    private Context context = this;
    private List<Step> steps = Repository.getInstance().getSteps();
    private List<Step> newStepList = new ArrayList<Step>();
    private ListView lvSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_choreography);

        lvSteps = (ListView) findViewById(R.id.lvSteps);
        lvSteps.setAdapter(new ArrayAdapter<Step>(this, R.layout.list_item, newStepList));

        //Create Choreography
        View btnCreateChoreography = findViewById(R.id.btnCreateChoreography);
        btnCreateChoreography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtChoreographyName = (EditText) findViewById(R.id.txtChoreographyName);
                String choreographtName = txtChoreographyName.getText().toString();
                Choreography newChoreography = new Choreography(choreographtName, newStepList);
                Repository.getInstance().getChoreographies().add(newChoreography);
                finish();

            }
        });

        //Add Step
        View btnAddStep = findViewById(R.id.btnAddStep);
        btnAddStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Steps");

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
                        ArrayAdapter<String> adapter = (ArrayAdapter<String>) lvSteps.getAdapter();
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        //delete step
        lvSteps.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                newStepList.remove(position);
                ((BaseAdapter) parent.getAdapter()).notifyDataSetChanged();
                return true;
            }
        });
    }
}
