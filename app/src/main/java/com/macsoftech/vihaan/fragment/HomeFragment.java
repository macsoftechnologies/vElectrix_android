package com.macsoftech.vihaan.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.macsoftech.vihaan.BuildConfig;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.adapter.ViewPagerAdapter;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.HomeBannerResponse;
import com.macsoftech.vihaan.model.ImageResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.iv_banner)
    ImageView iv_banner;

    @BindView(R.id.ll_banners)
    LinearLayout ll_banners;


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.frag_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Glide.with(getActivity())
                .load(R.drawable.ve_home)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .fitCenter()
                .placeholder(R.drawable.nav_profile)
                .error(R.drawable.nav_profile)
                .into(iv_banner);

        loadBanners();
    }

    public void redirectToDetail(int index, String title, String desc) {
        Fragment fragment = new HomeDetailFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("desc", desc);
        args.putInt("index", index);
        fragment.setArguments(args);

        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    @OnClick(R.id.ll_1)
    public void onLogoSelected1() {
        redirectToDetail(1, "VENROUTE", "VEnroute ensures to sell the top-of-the-line electric vehicles to our customers as we invest in improving every aspect of the electric vehicle experience i.e., from technology to design to provide the best products to our customers, we strive for a sense of purpose towards innovation. We at VE believe that innovation is the key to growth and success, which is why no word encompasses what we stand for - The Vigorous Effort we put into providing the best possible service to our customers.");
    }

    @OnClick(R.id.ll_2)
    public void onLogoSelected2() {
        redirectToDetail(2, "VENERGY", "The essential requirements of VE are not only emission-free vehicles with high-performance lithium batteries but also keeping your vehicles charged to get a smooth experience. VE is highly competent in providing charge refill in minimal time in an interval of 20KM with at least one reliable charge station, whether you’re in urban or rural localities.");
    }

    @OnClick(R.id.ll_3)
    public void onLogoSelected3() {
        redirectToDetail(3, "VEASE", "VEase is the initiative taken by VE to change the definition of everyday Indian garage and equipment services, we aim at making this experience the most hygienic, well maintained, and best. We also try to provide 48 hours closing time for any service request throughout Andhra Pradesh.");
    }


    @OnClick(R.id.ll_4)
    public void onLogoSelected4() {
        redirectToDetail(4, "VEQUIPMENT", "The growing e-commerce has brought the world to the fingertips of customers, keeping this very element in mind, VE has come up with an exclusive online platform that helps users and customers to place orders of unique, high end and easy-to-use spare parts and accessories for any EV out there that helps them maintain their vehicle in the best form. We also try to fulfil your order request in a record time of 48 hours.");
    }

    @OnClick(R.id.ll_5)
    public void onLogoSelected5() {
        redirectToDetail(5, "VESSENTIAL", "With the world revolving around web applications or more commonly called apps, VE has come up with VEssential, an exclusive app that helps the user track down the nearest VEnroute stores, VEnergy charging stations, VEase garages, and all the services options related to VElectrix. VEssential ensures a technologically rich, quick, and glitch-free experience for all users.");
    }


    private void loadBanners() {
//        showProgress();
        RestApi.getInstance().getService()
                .getImageList()
                .enqueue(new Callback<HomeBannerResponse>() {
                    @Override
                    public void onResponse(Call<HomeBannerResponse> call, Response<HomeBannerResponse> response) {
                        hideDialog();
                        if (response.isSuccessful()) {
                            setAdapter(response.body().getImageRes());
                        }
                    }

                    @Override
                    public void onFailure(Call<HomeBannerResponse> call, Throwable t) {
                        hideDialog();
                    }
                });
    }


    void setAdapter(List<ImageResponse> imageRes) {
        ll_banners.removeAllViews();
        Map<String, List<ImageResponse>> map = new HashMap<>();
        for (ImageResponse res : imageRes) {
            String key = res.getUrl();
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            List<ImageResponse> list = map.get(key);
            list.add(res);
        }

        for (Map.Entry<String, List<ImageResponse>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.frag_home_banners, null);
                ViewPager2 pager = view.findViewById(R.id.pager);
                TextView txt_count = view.findViewById(R.id.txt_count);

                final ViewPagerAdapter adapter = new ViewPagerAdapter(this);
                pager.setAdapter(adapter);
                for (ImageResponse res : entry.getValue()) {
                    adapter.addFrag(ImageViewFragment.newInstance(RestApi.BASE_URL + res.getImage(), entry.getKey()), entry.getKey());
                }
                txt_count.setText(String.format("%d/%d", 1, adapter.getItemCount()));
                pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
                        txt_count.setText(String.format("%d/%d", position + 1, adapter.getItemCount()));
                    }
                });
                ll_banners.addView(view);
            }

        }


    }

    public static class ImageViewFragment extends Fragment {

        public static ImageViewFragment newInstance(String url, String key) {
            ImageViewFragment fragment = new ImageViewFragment();
            Bundle args = new Bundle();
            args.putString("url", url);
            args.putString("key", key);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.frag_image_banner, container, false);
        }

        @Override
        public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            ImageView iv_banner = view.findViewById(R.id.iv_banner);
            String url = getArguments().getString("url");
            String key = getArguments().getString("key");
            if (BuildConfig.DEBUG) {
                Log.e("Ramesh", "url: " + url);
            }
            Glide.with(getActivity())
                    .load(url)
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .fitCenter()
//                    .apply(new RequestOptions().override(600, 200))
//                    .placeholder(R.drawable.nav_profile)
                    .error(R.drawable.nav_profile)
                    .into(iv_banner);

            iv_banner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ("VEssential".equalsIgnoreCase(key)) {

                    } else if ("VEnroute".equalsIgnoreCase(key)) {
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new VenrouteBannerFragment())
                                .addToBackStack(null)
                                .commitAllowingStateLoss();
                    } else if ("VEnergy".equalsIgnoreCase(key)) {
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new VEEnergyFragment())
                                .addToBackStack(null)
                                .commitAllowingStateLoss();
                    }
                }
            });
        }
    }
}

