package com.samy.candybar.applications;

import androidx.annotation.NonNull;

import candybar.lib.applications.CandyBarApplication;

//import com.onesignal.OneSignal

public class CandyBar extends CandyBarApplication {

    // Remove '/*' and '*/' to Enable OneSignal
    /*
    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
    */

    @NonNull
    @Override
    public Configuration onInit() {
        Configuration configuration = new Configuration();

        configuration.setGenerateAppFilter(true);
        configuration.setGenerateAppMap(true);
        configuration.setGenerateThemeResources(true);
        configuration.setNavigationIcon(NavigationIcon.STYLE_4);


        /*OtherApp[] otherApps = new OtherApp[] {
                new OtherApp(
                        //You can use png file (without extension) inside drawable-nodpi folder or url
                        "clock_bg",
                        "Title",
                        "Description",
                        "http://www.url.com"),
                new OtherApp(
                        //You can use png file (without extension) inside drawable-nodpi folder or url
                        "https://avatars1.githubusercontent.com/u/23138905?v=3&amp;s=300",
                        "Title",
                        "Description, long description. This is an example of long description.",
                        "https://play.google.com/store/apps/details?id=com.material.dashboard.candybar.demo")
        };
        configuration.setOtherApps(otherApps);*/

        return configuration;
    }
}
