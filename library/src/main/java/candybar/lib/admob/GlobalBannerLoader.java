package candybar.lib.admob;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class GlobalBannerLoader {

    private Activity mainActivity;
    private AdView bannerAdView;
    private LinearLayout linearLayout;
    private String id = null;
    private View parentLayout;

    public GlobalBannerLoader(Activity mainActivity, LinearLayout linearLayout, View parentLayout, String adId) {
        this.parentLayout = parentLayout;
        this.id = adId;
        /*if (Utility.isDonated(mainActivity)) {
            bannerAdView = null;
            return;
        }
        if (Utility.isTestLab(mainActivity)) return;*/

        /*if(BuildConfig.DEBUG)
            return;*/

        if (id == null) return;

        this.mainActivity = mainActivity;
        this.linearLayout = linearLayout;

        bannerAdView = new AdView(mainActivity);
        bannerAdView.setAdSize(getAdSize(mainActivity));
        bannerAdView.setAdUnitId(id);
        linearLayout.addView(bannerAdView);
    }

    private AdSize getAdSize(Activity activity) {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth);
    }

    public void showBanner() {

        if (mainActivity == null || bannerAdView == null)
            return;
        /*if (Utility.isDonated(mainActivity)) {
            bannerAdView = null;
            return;
        }*/


        if (linearLayout == null)
            return;
        bannerAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                if (parentLayout != null)
                    parentLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                if (parentLayout != null)
                    parentLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        bannerAdView.loadAd(adRequest);
    }

    public void destroy() {
        try {
            if (bannerAdView != null) {
                bannerAdView.destroy();
            }
            if (parentLayout != null) {
                parentLayout.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
        }
        mainActivity = null;
    }

    public void resume() {
        if (bannerAdView != null)
            bannerAdView.resume();
    }

    public void pause() {
        if (bannerAdView != null)
            bannerAdView.pause();
    }
}