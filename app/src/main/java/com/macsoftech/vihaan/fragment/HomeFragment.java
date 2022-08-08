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

    private void loadBanners() {
        showProgress();
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

