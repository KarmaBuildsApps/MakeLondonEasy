package myapp.tae.ac.uk.makelondoneasy.extra;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import myapp.tae.ac.uk.makelondoneasy.R;

/**
 * Created by Karma on 21/01/16.
 */
public class LineColors {
    private static int buildVersion = Build.VERSION.SDK_INT;

    public static int[] getTextLineColors(Context context, String lineName) {
        int lineColor = -1;
        int textColor = -1;
        if (lineName.equals("bakerloo")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorBakerloo);
            } else {
                lineColor = context.getResources().getColor(R.color.colorBakerloo);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("central")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorCentral);
            } else {
                lineColor = context.getResources().getColor(R.color.colorCentral);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("circle")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorCircle);
            } else {
                lineColor = context.getResources().getColor(R.color.colorCircle);
            }
            textColor = Color.parseColor("#000000");

        } else if (lineName.equals("district")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorDistrict);
            } else {
                lineColor = context.getResources().getColor(R.color.colorDistrict);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("dlr")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorDlr);
            } else {
                lineColor = context.getResources().getColor(R.color.colorDlr);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("hammersmith-city")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorHammersmithCity);
            } else {
                lineColor = context.getResources().getColor(R.color.colorHammersmithCity);
            }
            textColor = Color.parseColor("#000000");
        } else if (lineName.equals("jubilee")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorJubilee);
            } else {
                lineColor = context.getResources().getColor(R.color.colorJubilee);
            }
            textColor = Color.parseColor("#000000");
        } else if (lineName.equals("london-overground")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorLondonOverground);
            } else {
                lineColor = context.getResources().getColor(R.color.colorLondonOverground);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("metropolitan")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorMetropolitan);
            } else {
                lineColor = context.getResources().getColor(R.color.colorMetropolitan);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("northern")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorNorthern);
            } else {
                lineColor = context.getResources().getColor(R.color.colorNorthern);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("piccadilly")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorPiccadilly);
            } else {
                lineColor = context.getResources().getColor(R.color.colorPiccadilly);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("tfl-rail")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorTflRail);
            } else {
                lineColor = context.getResources().getColor(R.color.colorTflRail);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("victoria")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorVictoria);
            } else {
                lineColor = context.getResources().getColor(R.color.colorVictoria);
            }
            textColor = Color.parseColor("#FFFFFF");
        } else if (lineName.equals("waterloo-city")) {
            if (buildVersion >= 23) {
                lineColor = ContextCompat.getColor(context, R.color.colorWaterlooCity);
            } else {
                lineColor = context.getResources().getColor(R.color.colorWaterlooCity);
            }
            textColor = Color.parseColor("#000000");
        }
        int colors[] = {lineColor, textColor};
        return colors;
    }
}

