package com.samy.candybar.activities;

import androidx.annotation.NonNull;

import com.samy.candybar.R;

import candybar.lib.activities.CandyBarSplashActivity;
import candybar.lib.activities.configurations.SplashScreenConfiguration;

public class SplashActivity extends CandyBarSplashActivity {

    @NonNull
    @Override
    public SplashScreenConfiguration onInit() {
        return new SplashScreenConfiguration(MainActivity.class)
                .setBottomText(getString(R.string.splash_screen_title));
    }
}
