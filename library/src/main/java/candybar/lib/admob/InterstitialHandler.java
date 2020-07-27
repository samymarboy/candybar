package candybar.lib.admob;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialHandler {

    public static boolean showInterstitialAds = false;
    private InterstitialAd mInterstitialAd;
    private String id = null;

    public void initAndLoad(Context activity, String adId) {
        //if (Utility.isDonated(activity)) return;

        if (mInterstitialAd != null && mInterstitialAd.isLoaded())
            return;
        this.id = adId;
        if (id == null)
            return;

        mInterstitialAd = new InterstitialAd(activity);
        mInterstitialAd.setAdUnitId(id);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                reloadAd();
            }
        });
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build());
    }


    public boolean showFullScreenAd() {
        try {
            /*if (Utility.isDonated(AppConfig.getInstance()))
                return false;*/

            if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                return true;
            } else {
                reloadAd();
                return false;
            }
        } catch (Exception e) {
            Log.e("ERROR",e.getMessage(),e);
            return false;
        }

    }

    private void reloadAd() {
        try {
            //if (Utility.isDonated(AppConfig.getInstance()))
            //    return;
            // Request a new ad if one isn't already loaded.
            if (mInterstitialAd != null && !mInterstitialAd.isLoaded()) {
                mInterstitialAd.loadAd(new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build());
            }
        } catch (Exception e) {
            Log.e("ERROR",e.getMessage(),e);
        }
    }
}