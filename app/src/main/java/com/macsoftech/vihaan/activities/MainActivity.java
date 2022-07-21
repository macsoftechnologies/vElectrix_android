package com.macsoftech.vihaan.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.adapter.MainListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

   private RecyclerView recyclerView;

    String[] values = new String[] { "VENROUTE", "VENERY", "VEASE","VEQUIPMENT","VESSENTIAL"};

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
            int position = viewHolder.getAdapterPosition();
            switch (position){
                case 1:
                    Intent intent = new Intent(MainActivity.this, VenRouteActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.listview);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        MainListAdapter listAdapter = new MainListAdapter(MainActivity.this,list);
        RecyclerView.LayoutManager linearLayout =  new LinearLayoutManager(this);
       // linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayout);
        //DividerItemDecoration dividerItemDecoration =  new DividerItemDecoration(recyclerView.getContext(),0);
       //recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(listAdapter);
        listAdapter.onItemClickListener(clickListener);
    }
}