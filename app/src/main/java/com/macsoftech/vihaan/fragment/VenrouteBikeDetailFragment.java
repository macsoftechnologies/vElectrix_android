package com.macsoftech.vihaan.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.activities.BookTestDriveActivity;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.BrandResponse;
import com.macsoftech.vihaan.model.ColorMappingResponse;
import com.macsoftech.vihaan.model.ColorMappingVehicleSpecification;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenrouteBikeDetailFragment extends Fragment {

    private String a,b,c,d,e,f,g;

    //RecyclerView recyclerView;
    private String vehId;
    private BrandResponse data;
    private List<BrandResponse> list;
    TextView price;
    TextView logo_brand_name;
    TextView logo_model_name;
    ViewPager viewPager;
    DotsIndicator dots_indicator;
    ViewAdapter viewAdapter;
    //SpringDotsIndicator dot2;
    TextView tBookTestDrive;
    TextView datasheet;
    TextView txt_more;
    LinearLayout ll_data;
    LinearLayout ll_color;

//    private View.OnClickListener clickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
//            int position = viewHolder.getAdapterPosition();
//            BrandResponse item = list.get(position);
//            Intent intent = new Intent(getActivity(), VenRouteBikeDetailActivity.class);
//            intent.putExtra("vehicleId", item.getVehicleId());
//            intent.putExtra("data", item);
//            startActivity(intent);
//
//        }
//    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vehId = getArguments().getString("vehicleId");
        data = getArguments().getParcelable("data");
        View viewItem = inflater.inflate(R.layout.fragment_venroute_bike_detail, container, false);
        viewPager = viewItem.findViewById(R.id.view_pager);
        tBookTestDrive = viewItem.findViewById(R.id.book_test_drive);
        dots_indicator = viewItem.findViewById(R.id.dots_indicator);
        logo_brand_name = viewItem.findViewById(R.id.logo_brand_name);
        logo_model_name = viewItem.findViewById(R.id.logo_model_name);
        price = viewItem.findViewById(R.id.price);
        datasheet = viewItem.findViewById(R.id.datasheet);
        ll_data = viewItem.findViewById(R.id.ll_data);
        //ll_color = viewItem.findViewById(R.id.ll_color);
        txt_more = viewItem.findViewById(R.id.txt_more);
        // dot2 =  viewItem.findViewById(R.id.dot2);
        return viewItem;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Typeface tf = Typeface.createFromAsset(getResources().getAssets(),"fonts/Lato-Bold.ttf");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logo_brand_name.setText(data.getBrandName());
        logo_model_name.setText(data.getModel());
        price.setText("Rs." + data.getAmount());
        tBookTestDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookTestDriveActivity.class);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
        loadData();

        //datasheet
        datasheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showBottomSheetDialog();
            }
        });

    }
    //
//    private void showBottomSheetDialog() {
//        if (mList != null) {
//            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
//
//            View view = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_sheet_specs, null);
//            LinearLayout ll_container = view.findViewById(R.id.ll_container);
//            bottomSheetDialog.setContentView(view);
//            populateBottomSheetContent(ll_container);
//            bottomSheetDialog.show();
//        }
//
//    }

    void populateBottomSheetContent(List<ColorMappingResponse> list, LinearLayout ll_container) {
        ColorMappingResponse data = list.get(0);
        Map<String, String> map = new LinkedHashMap<>();
        //
        map.put("Top Speed", data.getTopSpeed());
        map.put("Range", data.getRange());
        map.put("Charging Time", data.getChargingTime());
        map.put("Load Capacity", data.getLoadCapacity());
        map.put("Battery Capacity", data.getBatteryCapacity());
        map.put("Battery Type", data.getBatteryType());
        map.put("Motor Capacity", data.getMotorCapacity());
        map.put("Motor Type", data.getMotorType());

        //
        map.put("BMS", data.getBms());
        map.put("Battery Casing", data.getBatteryCasing());
        map.put("Charger Output", data.getChargerOutput());
        map.put("External Charging Port", data.getExternalChargingPort());
        map.put("Regenerative Braking", data.getRegenerativeBraking());
        map.put("Display", data.getDisplay());
        map.put("Security", data.getSecurity());
        map.put("Storage", data.getStorage());
        map.put("Gradeablity", data.getGradeablity());
        map.put("Brakes", data.getBrake());
        map.put("Tyre", data.getTyre());
        //
        map.put("Wheel size", data.getWheelSize());
        map.put("Battery Warranty", data.getBatteryWarranty());
        map.put("Motor Warranty", data.getMotorWarranty());
        map.put("Licence & Registration", data.getLicenseRegistration());

//        map.put("Controller", data.getController());
//        map.put("Head Lamp", data.getHeadLamp());
//        map.put("Blinker", data.getBlinkers());
//        map.put("MudGuards", data.getMudGuards());
//        map.put("Seat", data.getSeat());
//        map.put("Throttle", data.getThrottle());
//        map.put("Foot Rest", data.getLadiesFootrest());
//        map.put("Brand Name", data.getBrandName());
//        map.put("Model", data.getModel());
       map.put("Vehicle Name", data.getVehicleName());
//        map.put("Cells", data.getCells());
//        map.put("Amount", data.getAmount());
//        map.put("Speed", data.getSpeed());

        int index = 0;
        for (Map.Entry<String, String> set : map.entrySet()) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.row_spec, null);
            TextView txt_key = view.findViewById(R.id.txt_key);
            TextView txt_value = view.findViewById(R.id.txt_value);
            txt_key.setText(set.getKey().toUpperCase());
            if(index<=8) {
                //Custom font bold is applied to key and value pairs
                Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "fonts/Lato-Bold.ttf");
                txt_value.setTypeface(tf);
                txt_key.setTypeface(tf);
            }
            txt_value.setText(set.getValue());
            ll_container.addView(view);
            view.setBackgroundColor(Color.WHITE);
            view.setVisibility(View.GONE);
            index++;

        }

        for (int i = 0; i < 8; i++) {
            ll_container.getChildAt(i).setVisibility(View.VISIBLE);
        }

//        for (int i = 7; i < ll_container.getChildCount(); i++) {
//            ll_container.getChildAt(i).setVisibility(View.VISIBLE);
//        }

        txt_more.setOnClickListener(view -> {
            for (int i = 0; i < ll_container.getChildCount(); i++) {
                ll_container.getChildAt(i).setVisibility(View.VISIBLE);
            }
            view.setVisibility(View.GONE);
        });
    }

    private void loadData() {
        Map<String, String> map = new HashMap<>();
        map.put("vehicleId", vehId);
        RestApi.getInstance().getService().getBikeSpec(map).enqueue(new Callback<ColorMappingVehicleSpecification>() {

            @Override
            public void onResponse(Call<ColorMappingVehicleSpecification> call, Response<ColorMappingVehicleSpecification> response) {
                if (response.isSuccessful()) {
                    List<ColorMappingResponse> list = response.body().getColorMappingResponse();
//                    displayBannerItems(list, getActivity());
                    populateBottomSheetContent(list, ll_data);
                    loadColorsData();
                }


            }

            @Override
            public void onFailure(Call<ColorMappingVehicleSpecification> call, Throwable t) {

            }
        });
    }


    private void loadColorsData() {
        Map<String, String> map = new HashMap<>();
        map.put("vehicleId", vehId);
        RestApi.getInstance().getService().getVehicleColor(map).enqueue(new Callback<ColorMappingVehicleSpecification>() {

            @Override
            public void onResponse(Call<ColorMappingVehicleSpecification> call, Response<ColorMappingVehicleSpecification> response) {
                if (response.isSuccessful()) {
                    List<ColorMappingResponse> list = response.body().getColorMappingResponse();
                    displayBannerItems(list, getActivity());
                }

            }

            @Override
            public void onFailure(Call<ColorMappingVehicleSpecification> call, Throwable t) {

            }
        });
    }

    List<ColorMappingResponse> mList;

    private void displayBannerItems(List<ColorMappingResponse> list, Context mContext) {
        mList = list;
        viewAdapter = new ViewAdapter(mContext, list);
        viewPager.setAdapter(viewAdapter);
        dots_indicator.attachTo(viewPager);

        for (int i = 0; i < list.size() && i < 4; i++) {
            AppCompatImageView img = new AppCompatImageView(getActivity());
            img.setImageResource(R.drawable.ic_baseline_circle_24);
            try {
                img.setColorFilter(Color.parseColor(list.get(i).getColor()),
                        android.graphics.PorterDuff.Mode.SRC_IN);
                int finalI = i;
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(finalI);
                    }
                });
                ll_color.addView(img);
            } catch (Exception e) {

            }

        }

    }


    public class ViewAdapter extends PagerAdapter {

        private Context context;
        private LayoutInflater layoutInflater;
        //private Integer[] images={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
        List<String> imageList = new ArrayList<>();

        public ViewAdapter(Context mContext, List<ColorMappingResponse> list) {
            this.context = mContext;
            if (list != null) {
                for (ColorMappingResponse colorMappingResponse : list) {
                    try {
                        imageList.add(colorMappingResponse.getVehicleImage().get(0));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
//                imageList = list.get(0).getVehicleImage();
            }
        }

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE
            );
            View view = layoutInflater.inflate(R.layout.viewpager_item, null);
            ImageView imageView = view.findViewById(R.id.view_pager_image);
            //imageView.setImageResource(imageList.get(position));

            Glide.with(getActivity())
                    .load(RestApi.BASE_URL + imageList.get(position))
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .fitCenter()
//                    .placeholder(R.drawable.nav_profile)
                    .error(R.drawable.nav_profile)
                    .into((imageView));

            ViewPager viewPager = (ViewPager) container;
            viewPager.addView(view, 0);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ViewPager viewPager = (ViewPager) container;
            View view = (View) object;
            viewPager.removeView(view);
        }
    }
}
