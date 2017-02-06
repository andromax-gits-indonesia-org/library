package id.gits.gitsstringhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String LOG = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        sampleMd5();
//        sampleEncodeBase64();
//        sampleDecodeBase64();
//        sampleValidationEmail();
          sampleDateFormat();
//        sampleRupiahFormat();
//        sampleValidateAlphabet();
//        sampleAppsVersioningInfo();
//        SampleShareUrl();
    }

    public void sampleMd5() {
        String resultMd5 = StringHelper.md5("password");
        Log.d(LOG, "MD5 " + resultMd5);
    }

    public void sampleEncodeBase64() {
        String resultBase64 = StringHelper.encodeBase64("username");
        Log.d(LOG, "ENCODE BASE 64 " + resultBase64);
    }

    public void sampleDecodeBase64() {
        String resultBase64 = StringHelper.decodeBase64("dXNlcm5hbWU=");
        Log.d(LOG, "ENCODE BASE 64 " + resultBase64);
    }

    public void sampleValidationEmail() {
        if (!RegexHelper.emailValidator("sample@gmail.com")) {
            Log.d(LOG, "Format Email Salah");

        } else {
           Log.d(LOG, "Email Valid");
        }
    }

    public void sampleDateFormat() {
        String resultDate = DateHelper.dateParseToString("2007-01-01",
                DateHelper.DATE_INPUT_v1, DateHelper.DATE_OUTPUT_v3);
        Log.d(LOG, "Date format " + resultDate); //Date format Senin, 01 Januari 2007

        String resultDate_2 = DateHelper.formateDateFromstring(DateHelper.DATE_INPUT_v1, DateHelper.DATE_OUTPUT_v4, "2007-01-01");
        Log.d(LOG, "Date format 2 " + resultDate_2); //Date format Senin, 01 Januari 2007

    }

    public void sampleRupiahFormat() {
        String result = StringHelper.formatRupiahWithoutSymbol(2000000);
        Log.d(LOG, "FORMAT MATA UANG " + result);

        String resultCurrency = StringHelper.currency("2000000");
        Log.d(LOG, "FORMAT CURRENCY " + resultCurrency);

    }

    public void sampleValidateAlphabet() {
        if (RegexHelper.alphabet("dfdafafd5fd")) {
            Log.d(LOG, "alphabet valid");
        } else {
            Log.d(LOG, "alphabet not valid");
        }
    }


    public void sampleAppsVersioningInfo() {
        Log.d(LOG,  "OS " + VersioningAppsHelpers.getInstance(this).versionOS());
        Log.d(LOG,  "DEVICE " + VersioningAppsHelpers.getInstance(this).versionManufacture());
        Log.d(LOG,  "SCREEN " + VersioningAppsHelpers.getInstance(this).getScreeSizeInch(this));
        Log.d(LOG,  "DEVICE ID " + VersioningAppsHelpers.getInstance(this).deviceID());
        Log.d(LOG,  "VERSION CODE " + VersioningAppsHelpers.getInstance(this).versionCodeApps());
        Log.d(LOG,  "VERSION NAME " + VersioningAppsHelpers.getInstance(this).versionNameApps());
        Log.d(LOG,  "Build MODEL " + VersioningAppsHelpers.getInstance(this).versionModel());
    }


    public void SampleShareUrl() {
        StringHelper.shareTextUrl(this, "http://www.gits.co.id/", "Gits Indonesia");
    }



}



