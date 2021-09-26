package cn.weli.learnandroiddemo.Resource;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.weli.learnandroiddemo.R;
import cn.weli.learnandroiddemo.utils.OaidHelper;

public class TelephonyActivity extends AppCompatActivity {

    TextView mTvImei;
    TextView mTvImsi;
    TextView mTvOaid;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephony);
        initView();
    }

    private void initView() {
        mTvImei = findViewById(R.id.tv_imei);
        mTvImsi = findViewById(R.id.tv_imsi);
        mTvOaid = findViewById(R.id.tv_oaid);

        @SuppressLint("ServiceCast") TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        mTvImei.setText(tm.getImei());
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mTvImsi.setText(tm.getSubscriberId());
        OaidHelper oaidHelper = new OaidHelper((ids -> {
            runOnUiThread(()->{
                mTvOaid.setText(ids);
            });
        }));
        oaidHelper.getDeviceIds(this);
    }
}