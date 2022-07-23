package com.macsoftech.vihaan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenrouteBikeDetailFragment extends Fragment {

    //RecyclerView recyclerView;
    private String vehId;
    private BrandResponse data;
    private List<BrandResponse> list;
    TextView price;
    TextView logo_model_name;
    ViewPager viewPager;
    DotsIndicator dots_indicator;
    ViewAdapter viewAdapter;
    //SpringDotsIndicator dot2;
    TextView tBookTestDrive;

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
        logo_model_name = viewItem.findViewById(R.id.logo_model_name);
        price = viewItem.findViewById(R.id.price);
        // dot2 =  viewItem.findViewById(R.id.dot2);
        return viewItem;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logo_model_name.setText(data.getModel());
        price.setText("Rs." + data.getAmount());
        tBookTestDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookTestDriveActivity.class);
                startActivity(intent);
            }
        });
        Map<String, String> map = new HashMap<>();
        map.put("vehicleId", vehId);
        RestApi.getInstance().getService().getBikeSpec(map).enqueue(new Callback<ColorMappingVehicleSpecification>() {

            @Override
            public void onResponse(Call<ColorMappingVehicleSpecification> call, Response<ColorMappingVehicleSpecification> response) {
                List<ColorMappingResponse> list = response.body().getColorMappingResponse();
                displayBannerItems(list, getActivity());

            }

            @Override
            public void onFailure(Call<ColorMappingVehicleSpecification> call, Throwable t) {

            }
        });

    }

    private void displayBannerItems(List<ColorMappingResponse> list, Context mContext) {

        viewAdapter = new ViewAdapter(mContext, list);
        viewPager.setAdapter(viewAdapter);
        dots_indicator.attachTo(viewPager);
        // dot2.setViewPager(viewPager);

//        VenrouteDetailListAdapter listAdapter = new VenrouteDetailListAdapter(list, mContext);
//        RecyclerView.LayoutManager linearLayout = new LinearLayoutManager(mContext);
//        recyclerView.setLayoutManager(linearLayout);
//        recyclerView.setAdapter(listAdapter);
//        listAdapter.onItemClickListener(clickListener);

    }


    public class ViewAdapter extends PagerAdapter {

        private Context context;
        private LayoutInflater layoutInflater;
        //private Integer[] images={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
        List<String> imageList;

        public ViewAdapter(Context mContext, List<ColorMappingResponse> list) {
            this.context = mContext;
            if (list != null) {
                imageList = list.get(0).getVehicleImage();
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
                    .placeholder(R.drawable.nav_profile)
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
