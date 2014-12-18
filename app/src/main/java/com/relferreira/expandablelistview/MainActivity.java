package com.relferreira.expandablelistview;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {

    private Toolbar toolbar;
    private Resources resource;
    private ExpandableListView list;
    private ArrayList<String> listHeader;
    private HashMap<String, List<String>> listItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resource = getResources();
        //Setup Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUpToolbar();
        //Expandable ListView
        list = (ExpandableListView) findViewById(R.id.list);
        //Make list of itens
        makeList();
        list.setAdapter(new ExpandableListAdapter(this, listHeader, listItens));
    }


    private void setUpToolbar(){
        toolbar.setTitle(resource.getString(R.string.app_name));
    }

    private void makeList(){
        listHeader = new ArrayList<String>();
        listItens = new HashMap<String, List<String>>();
        listHeader.add("Group 1");
        listHeader.add("Group 2");
        listHeader.add("Group 3");
        listHeader.add("Group 4");
        listHeader.add("Group 5");
        List<String> scales = new ArrayList<String>();
        scales.add("item 1");
        scales.add("item 2");
        scales.add("item 3");
        listItens.put(listHeader.get(0), scales);
        listItens.put(listHeader.get(1), scales);
        listItens.put(listHeader.get(2), scales);
        listItens.put(listHeader.get(3), scales);
        listItens.put(listHeader.get(4), scales);
    }
}
