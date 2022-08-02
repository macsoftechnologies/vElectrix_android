package com.macsoftech.vihaan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.adapter.ViewPagerAdapter;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.HomeBannerResponse;
import com.macsoftech.vihaan.model.ImageResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.iv_banner)
    ImageView iv_banner;

    @BindView(R.id.pager)
    ViewPager2 pager;
    @BindView(R.id.txt_count)
    TextView txt_count;

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
        RestApi.getInstance().getService()
                .getImageList()
                .enqueue(new Callback<HomeBannerResponse>() {
                    @Override
                    public void onResponse(Call<HomeBannerResponse> call, Response<HomeBannerResponse> response) {
                        if (response.isSuccessful()) {
                            setAdapter(response.body().getImageRes());
                        }
                    }

                    @Override
                    public void onFailure(Call<HomeBannerResponse> call, Throwable t) {

                    }
                });
    }

    void setAdapter(List<ImageResponse> imageRes) {
        final ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        pager.setAdapter(adapter);
        for (ImageResponse res : imageRes) {
            adapter.addFrag(ImageViewFragment.newInstance(RestApi.BASE_URL + res.getImage()), "");
        }
        txt_count.setText("");
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                txt_count.setText(String.format("%d/%d", position + 1, adapter.getItemCount()));
            }
        });
    }

    public static class ImageViewFragment extends Fragment {

        public static ImageViewFragment newInstance(String imageUrl) {
            ImageViewFragment fragment = new ImageViewFragment();
            Bundle args = new Bundle();
            args.putString("url", imageUrl);
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

            Glide.with(getActivity())
                    .load(getArguments().getString("url"))
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .fitCenter()
                    .placeholder(R.drawable.nav_profile)
                    .error(R.drawable.nav_profile)
                    .into(iv_banner);
        }
    }
}

