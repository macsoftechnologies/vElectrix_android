package com.macsoftech.vihaan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.macsoftech.vihaan.R;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MyviewHolder> {

    List<String> stringList;
    Context mContext;
    View.OnClickListener onItemClickListener;

    private static int[] imgs = {R.drawable.nav_home, R.drawable.nav_menu, R.drawable.nav_home,
            R.drawable.nav_menu, R.drawable.nav_profile};

    public MainListAdapter(Context mainActivity, List<String> list) {
        stringList = list;
        mContext = mainActivity;
    }

    public void onItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mainitem, parent, false);
        return new MyviewHolder(item);
    }


    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
        String title = stringList.get(position);
        Spannable wordtoSpan = new SpannableString(title);
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.txtName.setText(wordtoSpan);
//        holder.txtName.setText(Html.fromHtml("<b>" + title.substring(0, 2) + "</b>" + title.substring(2)));
        holder.icons.setImageResource(imgs[position]);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private ImageView icons;

        public MyviewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_title);
            icons = itemView.findViewById(R.id.image);
            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);

        }
    }
}
