package cn.weli.learnandroiddemo.FourMajorComponents.ContentProviderDemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class ImageActivity extends AppCompatActivity {

    private ImageView mImg;
    private Uri mImgUri;
    private ContentResolver mContentResolver;
    private Cursor mCursor;

    private AlertDialog alertDialog;
    private AlertDialog mDialog;
    private static final int NOT_NOTICE = 2;//如果勾选了不再询问

    //读写权限
    private static String[] PERMISSION_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };

    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;

    public static final String TAG = "ImageActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //申请权限
        requestPer();
        mImg = findViewById(R.id.img);

        mImgUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        mContentResolver = ImageActivity.this.getContentResolver();

        //只查询jpeg和png的图片
        mCursor = mContentResolver.query(mImgUri, null, MediaStore.Images.Media.
                MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?", new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media.DATE_MODIFIED);
        if (mCursor == null) {
            return;
        }
        //只显示第一张图片
        mCursor.moveToNext();
        String path = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));

        Bitmap bitmap = BitmapFactory.decodeFile(path);
        mImg.setImageBitmap(bitmap);
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCursor.moveToNext()) {
                    String path = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));

                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    mImg.setImageBitmap(bitmap);
                }else {
                    mCursor.moveToFirst();
                    String path = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));

                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    mImg.setImageBitmap(bitmap);
                }
            }
        });
    }

    public void requestPer() {
        //判断是否是6.0以上的版本
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            //判断是否申请过此权限
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
                //没有的话则申请
                ActivityCompat.requestPermissions(this, PERMISSION_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i(TAG, "申请的动态权限为: " + permissions[i]);
                if (grantResults[i] == PERMISSION_GRANTED) {  //选择了始终允许
                    Toast.makeText(this, "权限" + permissions[i] + "申请成功", Toast.LENGTH_SHORT).show();
                } else {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])) {  //用户选择了禁止，不在访问
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("permission").setMessage("点击允许才可以使用此功能").setPositiveButton("去允许", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (mDialog != null && mDialog.isShowing()) {
                                    mDialog.dismiss();
                                }
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", getPackageName(), null); //注意：就是package，不用改包名；
                                intent.setData(uri);
                                startActivityForResult(intent, NOT_NOTICE);
                            }
                        });
                        mDialog = builder.create();
                        mDialog.setCanceledOnTouchOutside(false);
                        mDialog.show();
                    } else { //选择禁止
                        AlertDialog.Builder builder = new AlertDialog.Builder(ImageActivity.this);
                        builder.setTitle("permission")
                                .setMessage("点击允许才可以使用此功能")
                                .setPositiveButton("去允许", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (alertDialog != null && alertDialog.isShowing()) {
                                            alertDialog.dismiss();
                                        }
                                        //申请权限
                                        ActivityCompat.requestPermissions(ImageActivity.this, PERMISSION_STORAGE, REQUEST_PERMISSION_CODE);
                                    }
                                });
                        alertDialog = builder.create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.show();

                    }

                }
            }
        }
    }
}
