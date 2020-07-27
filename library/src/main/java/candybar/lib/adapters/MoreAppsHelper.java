package candybar.lib.adapters;

import android.content.Context;

import candybar.lib.R;

/**
 * Created by  gulsh on 7/27/2020.
 */
public class MoreAppsHelper {
    public static int MORE_APPS_COUNT = 3;

    public static boolean isWallPaperCount(int position, int totalItemCount) {
        if (position == (totalItemCount - MORE_APPS_COUNT) - 1)
            return true;
        return false;
    }

    public static boolean isMoreAppCount(int position, int totalItemCount) {
        if (position >= (totalItemCount - MORE_APPS_COUNT) && position < totalItemCount) {
            return true;
        }
        return false;
    }

    public static AppModel getAppLink(Context ctx, int adapterPosition, int totalCount) {
        if ((totalCount - MORE_APPS_COUNT) == adapterPosition) {
            return new AppModel(ctx.getString(R.string.more_app_one_name), ctx.getString(R.string.more_app_one_desc), ctx.getString(R.string.more_app_one_link), R.drawable.other_app_one_icon);
        } else if ((totalCount - MORE_APPS_COUNT) + 1 == adapterPosition) {
            return new AppModel(ctx.getString(R.string.more_app_two_name), ctx.getString(R.string.more_app_two_desc), ctx.getString(R.string.more_app_two_link), R.drawable.other_app_two_icon);
        } else {
            return new AppModel(ctx.getString(R.string.more_app_three_name), ctx.getString(R.string.more_app_three_desc), ctx.getString(R.string.more_app_three_link), R.drawable.other_app_three_icon);
        }
    }


    static class AppModel {
        String name;
        String des;
        String link;
        int icon;

        public AppModel(String name, String des, String link, int icon) {
            this.name = name;
            this.des = des;
            this.link = link;
            this.icon = icon;
        }
    }
}
