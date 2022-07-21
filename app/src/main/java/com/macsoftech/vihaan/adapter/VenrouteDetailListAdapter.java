package com.macsoftech.vihaan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.BrandResponse;

import java.util.List;

public class VenrouteDetailListAdapter extends RecyclerView.Adapter<VenrouteDetailListAdapter.MyviewHolder> {

    List<BrandResponse> brandsLists;
    Context mContext;
    View.OnClickListener onItemClickListener;


    public VenrouteDetailListAdapter(List<BrandResponse> list, Context nContext) {
        brandsLists = list;
        mContext = nContext;
    }

    public void onItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_venroute_detail_item, parent, false);
        return new MyviewHolder(item);
    }


    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
        holder.txtName.setText(brandsLists.get(position).getBrandName() + "( " + brandsLists.get(position).getModel() + " )");

        Glide.with(mContext)
                .load(RestApi.BASE_URL + brandsLists.get(position).getVehicleImage().get(0))
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .fitCenter()
                .placeholder(R.drawable.nav_profile)
                .error(R.drawable.nav_profile)
                .into((holder.images));

    }

    @Override
    public int getItemCount() {
        return brandsLists.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private ImageView images;

        public MyviewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_model_title);
            images = itemView.findViewById(R.id.image);

            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);

        }
    }

}
