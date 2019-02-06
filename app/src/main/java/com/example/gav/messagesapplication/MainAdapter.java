package com.example.gav.messagesapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.gav.messagesapplication.model.BaseModel;
import com.example.gav.messagesapplication.viewholders.AdvertisingViewHolder;
import com.example.gav.messagesapplication.viewholders.BaseViewHolder;
import com.example.gav.messagesapplication.viewholders.MyMessageViewHolder;
import com.example.gav.messagesapplication.viewholders.OtherMessageViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<? extends BaseModel> mList;
    private LayoutInflater mInflator;
    private final MainActivity.OnHolderClickListener onHolderClickListener;

    public MainAdapter(List<? extends BaseModel> list, Context context, MainActivity.OnHolderClickListener onHolderClickListener) {
        this.mList = list;
        this.mInflator = LayoutInflater.from(context);
        this.onHolderClickListener = onHolderClickListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder result = null;
        switch (viewType) {
            case Constants.MY_MESSAGE:
                result = new MyMessageViewHolder(mInflator.inflate(R.layout.mymessage_item, parent ,false));
                break;
            case Constants.OTHER_MESSAGE:
                result = new OtherMessageViewHolder(mInflator.inflate(R.layout.othermessage_item,parent,false));
                break;
            case Constants.ADVERTISING:
                result = new AdvertisingViewHolder(mInflator.inflate(R.layout.advertising_item,parent,false));
                break;
        }

        BaseViewHolder finalResult = result;
        result.itemView.setOnClickListener(v -> {
            int position = finalResult.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onHolderClickListener.onClick(mList.get(position));
            }});
        return result;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
