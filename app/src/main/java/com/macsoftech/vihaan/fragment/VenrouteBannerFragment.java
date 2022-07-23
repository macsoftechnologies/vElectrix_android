package com.macsoftech.vihaan.fragment;

import android.content.Context;
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
import com.macsoftech.vihaan.activities.VenRouteDetailActivity;
import com.macsoftech.vihaan.adapter.VenrouteListAdapter;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.BrandListResponse;
import com.macsoftech.vihaan.model.BrandsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenrouteBannerFragment extends Fragment {

    RecyclerView recyclerView;
    List<BrandsList> list;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            BrandsList item = list.get(position);
            Intent intent = new Intent(getActivity(), VenRouteDetailActivity.class);
            intent.putExtra("brandLogo", item.getLogo());
            intent.putExtra("brandName", item.getBrandName());
            intent.putExtra("data", item);
            startActivity(intent);

        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewItem = inflater.inflate(R.layout.fragment_venroutebanners, container, false);
        recyclerView = viewItem.findViewById(R.id.venroute_recycleView);
        return viewItem;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        RestApi.getInstance().getService().brandList().enqueue(new Callback<BrandListResponse>() {
            @Override
            public void onResponse(Call<BrandListResponse> call, Response<BrandListResponse> response) {

                list = response.body().getData().getBrandsList();
                displayDetails(list, getActivity());
            }

            @Override
            public void onFailure(Call<BrandListResponse> call, Throwable t) {
            }
        });
    }


    private void displayDetails(List<BrandsList> list, Context mContext) {

        VenrouteListAdapter listAdapter = new VenrouteListAdapter(list, mContext);
        RecyclerView.LayoutManager linearLayout = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(listAdapter);
        listAdapter.onItemClickListener(clickListener);
    }
}
