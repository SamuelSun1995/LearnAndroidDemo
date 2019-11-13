package cn.weli.learnandroiddemo.ViewControl.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;

import cn.weli.learnandroiddemo.R;

public class SurfaceViewActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSIONS_CODE = 1;
    private static final String[] REQUIRED_PERMISSIONS = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private SurfaceView mSurfaceView1;
    private MySurfaceView mSurfaceView2;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceHolder.Callback mSurfaceCallback;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);

        bindView();
        openCamera();
    }

    public void bindView(){
        mSurfaceView1 = findViewById(R.id.surfaceview1);
    }


    public void openCamera(){
        mSurfaceHolder = mSurfaceView1.getHolder();
         mSurfaceCallback = new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mCamera = android.hardware.Camera.open(0);

                try {
                    mCamera.setPreviewDisplay(holder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mCamera.startPreview();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            }
        };

        mSurfaceHolder.addCallback(mSurfaceCallback);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 动态权限检查
        if (!isRequiredPermissionsGranted() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(REQUIRED_PERMISSIONS, REQUEST_PERMISSIONS_CODE);
        }
    }

    /**
     * 判断我们需要的权限是否被授予，只要有一个没有授权，我们都会返回 false。
     *
     * @return true 权限都被授权
     */
    private boolean isRequiredPermissionsGranted() {
        for (String permission : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }
}
