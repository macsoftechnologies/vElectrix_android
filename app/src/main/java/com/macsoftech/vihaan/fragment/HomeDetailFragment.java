package com.macsoftech.vihaan.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.macsoftech.vihaan.R;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeDetailFragment extends Fragment {


    @BindView(R.id.txt_title)
    TextView txt_title;

    @BindView(R.id.txt_desc)
    TextView txt_desc;

    @BindView(R.id.iv_next)
    ImageView iv_next;

    public HomeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        String title = getArguments().getString("title");
        String desc = getArguments().getString("desc");
        Spannable wordtoSpan = new SpannableString(title);
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt_title.setText(wordtoSpan);
        txt_desc.setText(desc);
        iv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNext();
            }
        });
    }

    private void moveToNext() {
        int index = getArguments().getInt("index");
        String key = getArguments().getString("title");
        if ("VEnroute".equalsIgnoreCase(key)) {
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
        }else if ("VEase".equalsIgnoreCase(key)) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new VEaseFragment())
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        }

    }
}