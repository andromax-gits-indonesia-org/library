package id.gits.gitsstringhelper;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.TypedValue;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by teddy on 1/13/17.
 */

public class StringHelper {

    /**
     * cast String to MD5
     */
    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * encode String to base64
     */
    public static String encodeBase64(String value) {
        String encodePref = Base64.encodeToString(value.getBytes(), Base64.DEFAULT);
        return encodePref;
    }

    /**
     * decode base64
     */
    public static String decodeBase64(String value) {
        String decodeStr = null;
        if (value != null) {
            byte[] decodePref = Base64.decode(value, Base64.DEFAULT);
            decodeStr = new String(decodePref);
            return decodeStr;
        } else {
            //return null
            return "";
        }
    }

    // ================ FORMAT CURRENCY ======================

    /**
     * format mata uang RP
     * @param value sample 200000
     * @return 200.000
     */
    public static String formatRupiahWithoutSymbol(double value){
        Locale id = new Locale("in", "ID");
        return NumberFormat.getInstance(id).format(value);
    }


    public static String currency(String s) {
        String cc;
        try {
            Locale locale = new Locale("en", "UK");
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
            symbols.setDecimalSeparator(',');
            symbols.setGroupingSeparator('.');

            String pattern = "###,###.###";
            DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);

            cc = decimalFormat.format(Double.parseDouble(s)) + "";

        } catch (Exception e) {
            cc = "0";
        }

        return cc;
    }

    public static int DpToPx(Context context, float dp){
        Resources r = context.getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.getDisplayMetrics()
        );
        return px;
    }

    /**
     * share link/URL
     */
    public static void shareTextUrl(Context context, String url, String title) {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, title);
        share.putExtra(Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(share, "Share link!"));
    }

    /**
     * cek connection device
     * @param ctx context
     * @return return true if online
     */
    public static boolean isOnline(Context ctx) {
        if (ctx == null)
            return false;
        ConnectivityManager cm =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

}
