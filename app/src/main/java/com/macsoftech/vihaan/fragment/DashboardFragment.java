package com.macsoftech.vihaan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.activities.VenRouteActivity;
import com.macsoftech.vihaan.adapter.MainListAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment {
    @BindView(R.id.listview)
    RecyclerView recyclerView;
    String[] values = new String[]{"VENROUTE", "VENERY", "VEASE", "VEQUIPMENT", "VESSENTIAL"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewItem = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return viewItem;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        List<String> list = Arrays.asList(values);
        MainListAdapter listAdapter = new MainListAdapter(getActivity(), list);
        RecyclerView.LayoutManager linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(listAdapter);
        listAdapter.onItemClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            switch (position) {
                case 1:
                    Intent intent = new Intent(getActivity(), VenRouteActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
