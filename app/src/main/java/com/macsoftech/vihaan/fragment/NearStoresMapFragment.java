package com.macsoftech.vihaan.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.StoresList;
import com.macsoftech.vihaan.model.StoresListResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class NearStoresMapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    GoogleMap googleMap;

    @BindView(R.id.ll_bottom)
    LinearLayout ll_bottom;

    @BindView(R.id.txt_title)
    TextView txt_title;

    @BindView(R.id.txt_timings)
    TextView txt_timings;

    @BindView(R.id.txt_directions)
    TextView txt_directions;


    public NearStoresMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_near_stores_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.map_container, mapFragment)
                .commit();
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull @NotNull GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        this.googleMap = googleMap;

        // Set a listener for marker click.
        googleMap.setOnMarkerClickListener(this);
        loadData();
    }

    public void loadData() {
        //
        RestApi.getInstance().getService()
                .getListOfChargers()
                .enqueue(new Callback<StoresListResponse>() {
                    @Override
                    public void onResponse(Call<StoresListResponse> call, Response<StoresListResponse> response) {
                        if (response.isSuccessful()) {
                            try {
                                showMarkers(response.body().getData().getStoresList());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<StoresListResponse> call, Throwable t) {

                    }
                });
    }

    private void showMarkers(List<StoresList> storesList) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (StoresList store : storesList) {
            try {
                LatLng latLng = new LatLng(Double.parseDouble(store.getLatitude()),
                        Double.parseDouble(store.getLongitude()));
                Marker marker = googleMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Open: " + store.getStoreOpen() + "-" + store.getStoreClose()));
                marker.setTag(store);
                builder.include(latLng);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        LatLngBounds latLngBounds = builder.build();
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 10));
    }

    @Override
    public boolean onMarkerClick(@NonNull @NotNull Marker marker) {
        // Retrieve the data from the marker.
        StoresList store = (StoresList) marker.getTag();

        // Check if a click count was set, then display the click count.
//        if (store != null) {
//            Toast.makeText(getActivity(),
//                    store.getStoreName() +
//                            " has been clicked ",
//                    Toast.LENGTH_SHORT).show();
//        }
        txt_title.setText(store.getShopName());
//        txt_title.setVisibility(View.GONE);
        txt_timings.setText("Open: " + store.getStoreOpen() + "-" + store.getStoreClose());
        txt_directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("geo:0,0?q=" + store.getLatitude() + "," + store.getLongitude() + " (" + "Charging Station" + ")"));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ll_bottom.setVisibility(View.VISIBLE);

        return true;
    }
}