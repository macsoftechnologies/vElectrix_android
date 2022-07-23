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
import com.macsoftech.vihaan.activities.VenRouteBikeDetailActivity;
import com.macsoftech.vihaan.adapter.VenrouteDetailListAdapter;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.BrandResponse;
import com.macsoftech.vihaan.model.GetBrandVehiclesResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenrouteBannerDetailFragment extends Fragment {

    RecyclerView recyclerView;
    private String brandName;
    private List<BrandResponse> list;


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            BrandResponse item = list.get(position);
//            Intent intent = new Intent(getActivity(), VenrouteBikeDetailFragment.class);
            Intent intent = new Intent(getActivity(), VenRouteBikeDetailActivity.class);
            intent.putExtra("vehicleId", item.getVehicleId());
            intent.putExtra("data", item);
            startActivity(intent);

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        brandName = getArguments().getString("brandName");
        View viewItem = inflater.inflate(R.layout.fragment_venroutebanners, container, false);
        recyclerView = viewItem.findViewById(R.id.venroute_recycleView);
        return viewItem;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Map<String, String> map = new HashMap<>();
        map.put("brandName", brandName);
        RestApi.getInstance().getService().getBrandVehicles(map).enqueue(new Callback<GetBrandVehiclesResponse>() {
            @Override
            public void onResponse(Call<GetBrandVehiclesResponse> call, Response<GetBrandVehiclesResponse> response) {
                list = response.body().getBrandResponse();
                displayBannerItems(list, getActivity());
            }

            @Override
            public void onFailure(Call<GetBrandVehiclesResponse> call, Throwable t) {

            }
        });
    }


    private void displayBannerItems(List<BrandResponse> list, Context mContext) {

        VenrouteDetailListAdapter listAdapter = new VenrouteDetailListAdapter(list, mContext);
        RecyclerView.LayoutManager linearLayout = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(listAdapter);
        listAdapter.onItemClickListener(clickListener);


    }
}
