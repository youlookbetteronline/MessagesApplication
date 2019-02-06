package com.example.gav.messagesapplication.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gav.messagesapplication.R;
import com.example.gav.messagesapplication.model.MyMessage;

public class MyMessageViewHolder extends BaseViewHolder<MyMessage> {

    private ImageView ivIcon;
    private TextView tvMessage;
    private TextView tvDate;

    public MyMessageViewHolder(View itemView) {
        super(itemView);
        ivIcon = itemView.findViewById(R.id.ivIconMymessage);
        tvMessage = itemView.findViewById(R.id.tvMessageMymessage);
        tvDate = itemView.findViewById(R.id.tvDateMymessage);
    }

    @Override
    public void bind(MyMessage object) {
        tvMessage.setText(object.getMessage());
        tvDate.setText(object.getDate());
        Glide.with(ivIcon)
                .load(object.getIconURL())
                .apply(RequestOptions.circleCropTransform())
                .into(ivIcon);
    }
}
