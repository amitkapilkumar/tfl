package com.tfl.buses.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class AppUtil {
    private AppUtil() { }

    public static final String STOP_G_URL = "https://api.tfl.gov.uk/StopPoint/490000091G/Arrivals?mode=bus";
    public static final String STOP_H_URL = "https://api.tfl.gov.uk/StopPoint/490000091H/Arrivals?mode=bus";

    private static final String format = "yyyy-MM-dd HH:mm:ss";
    private static final String timeFormat = "HH:mm";
    private final static SimpleDateFormat sdf = new SimpleDateFormat(format); //2020-07-05T16:41:08Z
    private final static SimpleDateFormat timeSDF = new SimpleDateFormat(timeFormat); //2020-07-05T16:41:08Z

    public static String convertTimeToBST(String timeUTC) throws ParseException {
        timeUTC = timeUTC.replace("T", " ").replace("Z", "");
        Calendar calBST = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
        calBST.setTime(sdf.parse(timeUTC));
        calBST.add(Calendar.HOUR_OF_DAY, 1);

        return  timeSDF.format(calBST.getTime());
    }
}
