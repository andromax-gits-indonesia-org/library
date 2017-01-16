package id.gits.gitsstringhelper;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by teddy on 1/16/17.
 */

public class DateHelper {


    public static final String DATE_INPUT_v1 = "yyyy-MM-dd";
    public static final String DATE_INPUT_v2 = "yyyy-MM-dd HH:mm:ss";
    //sample 01 jan 2017
    public static String DATE_OUTPUT_v1 = "dd MMM yyyy";
    //sample  01 January 2007
    public static final String DATE_OUTPUT_v2 = "dd MMMM yyyy";
    //Monday, 01 Jan 2007
    public static final String DATE_OUTPUT_v3 = "EEEE, dd MMMM yyyy";
    public static final String DATE_OUTPUT_v4= "EEEE, dd MMM yyyy";


    /**
     *
     * @param inputFormat DateHelper.DATE_INPUT_v1
     * @param outputFormat DateHelper.DATE_OUTPUT_v4
     * @param inputDate 2007-01-01
     * @return Monday, 01 Jan 2007
     */
    public static String formateDateFromstring(String inputFormat, String outputFormat, String inputDate) {
        Date parsed = null;
        String outputDate = "";
        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, java.util.Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
        }
        return outputDate;

    }

    /**
     *
     * @param dateInput sample "2007-01-01"
     * @param old_format sample DateHelper.DATE_INPUT_v1
     * @param formatDate sample DateHelper.DATE_OUTPUT_v3
     * @return Senin, 01 Januari 2007
     */
    public static String dateParseToString(String dateInput, String old_format, String formatDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(old_format);
            Date date;
            date = sdf.parse(dateInput);
            Locale id = new Locale("in", "ID");
            SimpleDateFormat format = new SimpleDateFormat(formatDate, id);
            String result = format.format(date);
            return result;
        } catch (ParseException e) {
            return dateInput;
        }
    }

    public static String dateParseToString(Date date, String old_format){
        Locale id = new Locale("in", "ID");
        SimpleDateFormat format = new SimpleDateFormat(old_format, id);
        String result = format.format(date);
        return result;
    }

    public static Date dateParseToDate(String dateInput, String old_format){
        try {
            Locale id = new Locale("in", "ID");
            SimpleDateFormat sdf = new SimpleDateFormat(old_format,id);
            Date date = sdf.parse(dateInput);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

}
