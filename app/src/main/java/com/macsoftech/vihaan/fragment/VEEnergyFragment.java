package com.macsoftech.vihaan.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.macsoftech.vihaan.R;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VEEnergyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VEEnergyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VEEnergyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VEEnergyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VEEnergyFragment newInstance(String param1, String param2) {
        VEEnergyFragment fragment = new VEEnergyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_v_e_energy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        Spannable wordtoSpan = new SpannableString("VENERGY");
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView txt_title = view.findViewById(R.id.txt_title);
        txt_title.setTextColor(Color.GREEN);
        ImageView iv_logo = view.findViewById(R.id.iv_logo);
        txt_title.setText(wordtoSpan);

        Glide.with(getActivity())
//                .load(R.drawable.chargin_station)
                .load(R.drawable.ve_energy)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .fitCenter()
                .into(iv_logo);
        iv_logo.setOnClickListener(view1 -> new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new NearStoresMapFragment())
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
            }
        }, 100));

    }
}