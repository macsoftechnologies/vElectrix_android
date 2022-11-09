package com.macsoftech.vihaan.app;

import androidx.multidex.MultiDexApplication;

import com.macsoftech.vihaan.helper.Helper;

//import org.acra.ACRA;
//import org.acra.ReportField;
//import org.acra.ReportingInteractionMode;
//import org.acra.annotation.ReportsCrashes;


/**
 * Created by Ramesh on 06/10/17.
 */
//@ReportsCrashes(mailTo = "rameshakuladev@gmail.com",
//        customReportContent = {ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME,
//                ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL,
//                ReportField.CUSTOM_DATA,
//        },
//        mode = ReportingInteractionMode.DIALOG
//)
public class BaseApp extends MultiDexApplication {

    private static BaseApp instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        ACRA.init(this);
//        ACRA.init(this, new CoreConfigurationBuilder()
//                //core configuration:
//                .withBuildConfigClass(BuildConfig.class)
//                .withReportFormat(StringFormat.JSON)
//                .withPluginConfigurations(
//                        new MailSenderConfigurationBuilder()
//                                //required
//                                .withMailTo("rameshakuladev@gmail.com")
//                                //defaults to true
//                                .withReportAsFile(true)
//                                //defaults to ACRA-report.stacktrace
//                                .withReportFileName("Crash.txt")
//                                //defaults to "<applicationId> Crash Report"
//                                .withSubject("Crash report")
//                                //defaults to empty
//                                .withBody("Please check this logs.")
//                                .build()
//                )
//        );

    }

    public static BaseApp getInstance() {
        return instance;
    }

    public static boolean hasNetwork() {
        return Helper.isNetworkAvailable(instance);
    }
}
