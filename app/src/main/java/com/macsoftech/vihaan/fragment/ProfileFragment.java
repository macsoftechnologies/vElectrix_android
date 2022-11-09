package com.macsoftech.vihaan.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.macsoftech.vihaan.BuildConfig;
import com.macsoftech.vihaan.R;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;

public class
ProfileFragment extends BaseFragment {
    @BindView(R.id.txt_version)
    TextView txt_version;
    TextView terms1;
    TextView privacy1;
    TextView feed1;


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.frag_profile, container, false);

        terms1 = v.findViewById(R.id.terms1);
        privacy1 = v.findViewById(R.id.privacy1);
        feed1 = v.findViewById(R.id.feed1);

        privacy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("http://www.vihaanelectrix.in/privacy_policy.php");
            }
        });


        feed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("http://www.vihaanelectrix.in/contact.php#");
            }
        });

        terms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("http://www.vihaanelectrix.in/terms_conditions.php");
            }
        });
        return v;
    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        txt_version.setText("App Version: " + BuildConfig.VERSION_NAME);
    }
}
