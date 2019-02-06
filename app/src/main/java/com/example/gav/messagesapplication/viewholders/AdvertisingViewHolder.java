package com.example.gav.messagesapplication.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gav.messagesapplication.R;
import com.example.gav.messagesapplication.model.AdvertisingMessage;

public class AdvertisingViewHolder extends BaseViewHolder<AdvertisingMessage> {

    private ImageView ivIcon;
    private TextView tvMessage;
    private TextView tvDate;

    public AdvertisingViewHolder(View itemView) {
        super(itemView);
        ivIcon = itemView.findViewById(R.id.ivIconAdvertising);
        tvMessage = itemView.findViewById(R.id.tvMessageAdvertising);
        tvDate = itemView.findViewById(R.id.tvDateAdvertising);
    }

    @Override
    public void bind(AdvertisingMessage object) {
        tvMessage.setText(object.getMessage());
        tvDate.setText(object.getDate());
        Glide.with(ivIcon)
                .load(object.getIconURL())
                .apply(RequestOptions.circleCropTransform())
                .into(ivIcon);
    }
}
