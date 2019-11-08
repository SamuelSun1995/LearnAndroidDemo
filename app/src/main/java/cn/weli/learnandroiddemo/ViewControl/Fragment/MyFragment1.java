package cn.weli.learnandroiddemo.ViewControl.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.weli.learnandroiddemo.R;

public class MyFragment1 extends Fragment {

    public static final String TAG = "Fragment1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.static_fragment_layout1, null);
        Bundle bundle = getArguments();
        Log.i(TAG, "获取Activity传递过来的数据为：" + bundle.getString("str"));
        Toast.makeText(getActivity(),"获取到来自Activity的数据："+bundle.getString("str"),Toast.LENGTH_SHORT).show();
        return view;
    }

    //Fragment传递数据给Activity
    //Step1：定义一个回调接口
    public interface CallBack{
        //定义一个获取信息的方法
        void getResult(String result);
    }

    //Step2:接口回调
    public void getData(CallBack callBack){
        callBack.getResult("Fragment通过回调方法向Activity传数据！");
    }




}
