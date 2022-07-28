package com.macsoftech.vihaan.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.activities.VenRouteActivity;
import com.macsoftech.vihaan.adapter.MainListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment {
    @BindView(R.id.listview)
    RecyclerView recyclerView;

    @BindView(R.id.piechart_1)
    PieChart pieChart;

    @BindView(R.id.iv_logo)
    ImageView iv_logo;

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
        setPieChart();
        iv_logo.setRotation(-45);
        iv_logo.animate()
                .rotation(0)
                .setDuration(1000)
                .start();
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
//                    getActivity().getSupportFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.container, new VenrouteBannerFragment())
//                            .commitAllowingStateLoss();

                    break;
            }
        }
    };

    public void setPieChart() {
        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        //
        pieChart.getLegend().setEnabled(false);

//        pieChart.setExtraOffsets(105,10,5,5);
        pieChart.setRotation(-40);
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setTransparentCircleRadius(50f);
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setRotationEnabled(false);
        pieChart.setDrawSliceText(false);
        pieChart.setDrawEntryLabels(false);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        for (String str : values) {
            yValues.add(new PieEntry(100f, str));
        }
//        yValues.add(new PieEntry(100f, "A2"));
//        yValues.add(new PieEntry(100f, "A3"));
//        yValues.add(new PieEntry(100f, "A4"));
//        yValues.add(new PieEntry(100f, "A5"));

        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(16f);
        dataSet.setSelectionShift(5f);
        dataSet.setDrawValues(false);
//        dataSet.setColors(COLORFUL_COLORS);
        dataSet.setColors(COLORFUL_COLORS);
        PieData pieData = new PieData((dataSet));
        pieData.setValueTextSize(0f);
        pieData.setValueTextColor(Color.YELLOW);
        pieChart.setData(pieData);
        //PieChart Ends Here
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                String label = ((PieEntry) e).getLabel();
                if (label.equalsIgnoreCase(values[0])) {
//                    Intent intent = new Intent(getActivity(), VenRouteActivity.class);
//                    startActivity(intent);
//                    iv_logo.setImageResource(R.drawable.pop_up_02);
                    iv_logo.setImageResource(R.drawable.pop_up_01);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.container, new VenrouteBannerFragment())
                                    .addToBackStack(null)
                                    .commitAllowingStateLoss();
                        }
                    },500);

                } else if (label.equalsIgnoreCase(values[1])) {

                }

            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    public static final int[] COLORFUL_COLORS = {
            Color.TRANSPARENT,
            Color.TRANSPARENT,
            Color.TRANSPARENT,
            Color.TRANSPARENT,
            Color.TRANSPARENT,
            Color.TRANSPARENT,
    };
}
