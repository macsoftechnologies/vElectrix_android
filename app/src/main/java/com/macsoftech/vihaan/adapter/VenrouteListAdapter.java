package com.macsoftech.vihaan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.BrandsList;

import java.util.List;

public class VenrouteListAdapter extends RecyclerView.Adapter<VenrouteListAdapter.MyviewHolder> {

    List<BrandsList> brandsLists;
    Context mContext;
    View.OnClickListener onItemClickListener;


    public VenrouteListAdapter(List<BrandsList> list, Context nContext) {
        brandsLists = list;
        mContext = nContext;
    }

    public void onItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_venroutebanneritem, parent, false);
        return new MyviewHolder(item);
    }


    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
        //holder.txtName.setText(brandsLists.get(position));
        if (position % 2 == 0) {
            holder.left.setVisibility(View.GONE);
            holder.right.setVisibility(View.VISIBLE);
            holder.images.setShapeAppearanceModel(holder.images.getShapeAppearanceModel()
                    .toBuilder()
                    .setTopRightCorner(CornerFamily.ROUNDED, 30)
                    .setBottomRightCorner(CornerFamily.ROUNDED, 30)
                    .build());

        } else {
            holder.left.setVisibility(View.VISIBLE);
            holder.right.setVisibility(View.GONE);

            holder.images.setShapeAppearanceModel(holder.images.getShapeAppearanceModel()
                    .toBuilder()
//                .setAllCorners(CornerFamily.ROUNDED,30)
                    .setTopLeftCorner(CornerFamily.ROUNDED, 30)
                    .setBottomLeftCorner(CornerFamily.ROUNDED, 30)
                    .build());

        }
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));

        Glide.with(mContext)
                .load(RestApi.BASE_URL + brandsLists.get(position).getBrandImage())
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .fitCenter()
                .placeholder(R.drawable.nav_profile)
                .error(R.drawable.nav_profile)
//                .apply(requestOptions)
                .into((holder.images));

    }

    @Override
    public int getItemCount() {
        return brandsLists.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {

        //private TextView txtName;
        private ShapeableImageView images;
        private View left;
        private View right;

        public MyviewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.image);
            left = itemView.findViewById(R.id.left);
            right = itemView.findViewById(R.id.right);

            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);

        }
    }

}
