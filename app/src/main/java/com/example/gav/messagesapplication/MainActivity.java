package com.example.gav.messagesapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gav.messagesapplication.model.AdvertisingMessage;
import com.example.gav.messagesapplication.model.BaseModel;
import com.example.gav.messagesapplication.model.MyMessage;
import com.example.gav.messagesapplication.model.OtherMessage;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private RecyclerView rv;
    private MainAdapter mainAdapter;
    private RewardedVideoAd rewardedVideoAd;
    public static final String ADD_APP_ID = "ca-app-pub-3897204009249997~9104125753";
    //public static final String AD_UNIT_ID = "ca-app-pub-3897204009249997/3309707745";
    public static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, ADD_APP_ID);

        initRecyclerView();
        initRewardedVideo();
    }

    private void initRecyclerView() {
        rv = findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        mainAdapter = new MainAdapter(getMockModels(), this, (model -> {
            switch (model.getViewType()) {
                case Constants.MY_MESSAGE:
                case Constants.OTHER_MESSAGE:
                    Toast.makeText(this, model.getMessage(), Toast.LENGTH_SHORT).show();
                    break;
                case Constants.ADVERTISING:
                    if (rewardedVideoAd.isLoaded()) {
                        rewardedVideoAd.show();
                    }else{
                        loadRewardedVideoAd();
                    }

            }
        }));
        rv.setAdapter(mainAdapter);
    }

    private void initRewardedVideo() {
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
    }

    private List<BaseModel> getMockModels() {
        List<BaseModel> models = new ArrayList<>();

        MyMessage myMessage = new MyMessage();
        myMessage.setMessage("Hello, i am Oleg");
        myMessage.setDate("05.02.2019");
        myMessage.setIconURL("https://scontent-otp1-1.xx.fbcdn.net/v/t1.0-9/17203091_975012665967981_6081540665971218517_n.jpg?_nc_cat=102&_nc_ht=scontent-otp1-1.xx&oh=426bf62c065a5562c88e3f4d4420103d&oe=5CF6DBC8");

        models.add(myMessage);


        OtherMessage otherMessage = new OtherMessage();
        otherMessage.setMessage("Hello, my name is Tonia");
        otherMessage.setDate("05.02.2019");
        otherMessage.setIconURL("https://scontent-otp1-1.xx.fbcdn.net/v/t1.0-9/22815215_889726654538536_3363697521583208634_n.jpg?_nc_cat=111&_nc_ht=scontent-otp1-1.xx&oh=ecb8bf586977c0b191f6d87239587a14&oe=5CE7D51B");

        models.add(otherMessage);

        AdvertisingMessage advertisingMessage = new AdvertisingMessage();
        advertisingMessage.setMessage("You can see integrated gms video");
        advertisingMessage.setDate("05.02.2019");
        advertisingMessage.setIconURL("https://scontent-otp1-1.xx.fbcdn.net/v/t1.0-9/17203091_975012665967981_6081540665971218517_n.jpg?_nc_cat=102&_nc_ht=scontent-otp1-1.xx&oh=426bf62c065a5562c88e3f4d4420103d&oe=5CF6DBC8");

        models.add(advertisingMessage);

        return models;
    }

    private void loadRewardedVideoAd() {
        rewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        loadRewardedVideoAd();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        //Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_LONG).show();
        Toast.makeText(this, Integer.toString(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
        Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_LONG).show();
    }

    public interface OnHolderClickListener {
        void onClick(BaseModel model);
    }
}
