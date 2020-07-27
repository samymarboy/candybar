package com.samy.candybar.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.samy.candybar.R;
import com.samy.candybar.licenses.License;

import candybar.lib.activities.CandyBarMainActivity;
import candybar.lib.activities.configurations.ActivityConfiguration;
import candybar.lib.admob.GlobalAdmobInterface;
import candybar.lib.admob.GlobalBannerLoader;
import candybar.lib.admob.InterstitialHandler;

public class MainActivity extends CandyBarMainActivity implements GlobalAdmobInterface {

    GlobalBannerLoader globalAdMobLoader;
    public InterstitialHandler interstitialHandler;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View relativeLayout = findViewById(R.id.banner_view_wrapper);
        LinearLayout mAdView = findViewById(R.id.adView);
        globalAdMobLoader = new GlobalBannerLoader(this, mAdView, relativeLayout, getString(R.string.banner_ad_id));
        globalAdMobLoader.showBanner();


        interstitialHandler = new InterstitialHandler();
        interstitialHandler.initAndLoad(this, getString(R.string.interstitial_ad_id));
    }

    @NonNull
    @Override
    public ActivityConfiguration onInit() {
        return new ActivityConfiguration()
                .setLicenseCheckerEnabled(License.isLicenseCheckerEnabled())
                .setLicenseKey(License.getLicenseKey())
                .setRandomString(License.getRandomString())
                .setDonationProductsId(License.getDonationProductsId())
                .setPremiumRequestProducts(License.getPremiumRequestProductsId(), License.getPremiumRequestProductsCount());
    }

    @Override
    protected void onDestroy() {
        if (globalAdMobLoader != null)
            globalAdMobLoader.destroy();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        if (globalAdMobLoader != null)
            globalAdMobLoader.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        if (globalAdMobLoader != null)
            globalAdMobLoader.resume();
        super.onResume();
    }

    @Override
    public InterstitialHandler getInterstitial() {
        return interstitialHandler;
    }
}
