package com.example.jdance.app.util;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by mclo on 21/02/14.
 * <p/>
 * Listener para eliminar elementos de una lista
 */
public class DeleteOnItemLongClickListener implements AdapterView.OnItemLongClickListener {

    private List list;

    public DeleteOnItemLongClickListener(List list) {
        this.list = list;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        list.remove(position);
        ((BaseAdapter) parent.getAdapter()).notifyDataSetChanged();
        return true;
    }
}
