package sda.testing.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sda.testing.BuildConfig;
import sda.testing.Config;
import sda.testing.R;

public class AboutActivity extends AppCompatActivity {
    @BindView(R.id.about_copyright)
    TextView copyright;
    @BindView(R.id.about_email)
    TextView email;
    @BindView(R.id.about_rate_us)
    View rateUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        setupEmail();
        setupCopyright();
        setupRateUs();
    }

    private void setupEmail() {
        final String email = getResources().getString(R.string.email);
        final String appName = getResources().getString(R.string.app_name);
        final String href = "<a href=\"mailto:" + email + "?subject=" + appName + "\">" + email + "</a>";
        this.email.setText(Html.fromHtml(href));
        this.email.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setupCopyright() {
        final String versionName = BuildConfig.VERSION_NAME;
        final int year = Calendar.getInstance().get(Calendar.YEAR);
        final String copyrightText = String.format(getResources().getString(R.string.copyright), versionName, year);
        copyright.setText(copyrightText);
    }

    private void setupRateUs() {
        if (Config.newInstance(getApplicationContext()).getIsFirstRun()) {
            rateUs.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.about_invite)
    public void inviteFriend() {
        final Intent intent = new Intent();
        final String text = String.format(getString(R.string.share_text), getString(R.string.app_name), getStoreUrl());
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, getString(R.string.invite_via)));
    }

    @OnClick(R.id.about_rate_us)
    public void rateUsClicked() {
        final Uri uri = Uri.parse("market://details?id=" + getPackageName());
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (ActivityNotFoundException ignored) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getStoreUrl())));
        }
    }

    @OnClick(R.id.about_license)
    public void licenseClicked() {
        final Intent intent = new Intent(getApplicationContext(), LicenseActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.about_gplus)
    public void googlePlusClicked() {
        final String link = "https://plus.google.com/communities/104880861558693868382";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
    }

    private String getStoreUrl() {
        return "https://play.google.com/store/apps/details?id=" + getPackageName();
    }
}
