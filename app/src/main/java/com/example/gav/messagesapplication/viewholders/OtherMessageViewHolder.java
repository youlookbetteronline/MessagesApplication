package com.example.gav.messagesapplication.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gav.messagesapplication.R;
import com.example.gav.messagesapplication.model.MyMessage;
import com.example.gav.messagesapplication.model.OtherMessage;

public class OtherMessageViewHolder extends BaseViewHolder<OtherMessage>{

    private ImageView ivIcon;
    private TextView tvMessage;
    private TextView tvDate;

    public OtherMessageViewHolder(View itemView) {
        super(itemView);
        ivIcon = itemView.findViewById(R.id.ivIconOthermessage);
        tvMessage = itemView.findViewById(R.id.tvMessageOthermessage);
        tvDate = itemView.findViewById(R.id.tvDateOthermessage);
    }

    @Override
    public void bind(OtherMessage object) {
        tvMessage.setText(object.getMessage());
        tvDate.setText(object.getDate());
        Glide.with(ivIcon)
                .load(object.getIconURL())
                .apply(RequestOptions.circleCropTransform())
                .into(ivIcon);
    }
}
