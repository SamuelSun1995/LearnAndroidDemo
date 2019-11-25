package cn.weli.learnandroiddemo.Net;


import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class UrlConnManager {

    public static final String TAG = "UrlConnManager";

    /**
     * 配置默认参数
     *
     * @return HttpUrlConnection
     */
    public static HttpURLConnection getHttpUrlConnection(String url) {
        HttpURLConnection mHttpURLConnection = null;
        try {
            URL mUrl = new URL(url);
            //得到Connection对象
            mHttpURLConnection = (HttpURLConnection) mUrl.openConnection();
            //设置链接超时时间
            mHttpURLConnection.setConnectTimeout(15000);
            //设置读取超时时间
            mHttpURLConnection.setReadTimeout(15000);
            //设置请求参数
            mHttpURLConnection.setRequestMethod("POST");
            //添加Header
            mHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            //接收输入流
            mHttpURLConnection.setDoInput(true);
            //传递参数时开启
            mHttpURLConnection.setDoInput(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mHttpURLConnection;
    }

    public static void postParams(OutputStream output, List<NameValuePair> paramsList) throws Exception {
        StringBuilder mStringBuilder = new StringBuilder();
        for (NameValuePair pair : paramsList) {
            if (TextUtils.isEmpty(mStringBuilder)) {

                mStringBuilder.append("&");

            }
            mStringBuilder.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            mStringBuilder.append("=");
            mStringBuilder.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
        writer.write(mStringBuilder.toString());
        writer.flush();
        writer.close();

    }

    /**
     * 调用postParams()方法将请求的参数组织好传给HttpURLConnection的输出流，请求链接并处理返回结果
     *
     * @param url
     */
    public void useHttpUrlConnectionPost(String url) {
        InputStream mInputStream = null;
        HttpURLConnection mHttpURLConnection = UrlConnManager.getHttpUrlConnection(url);
        List<NameValuePair> postParams = new ArrayList<>();
        //要传递的参数
        postParams.add(new BasicNameValuePair("username", "moon"));
        postParams.add(new BasicNameValuePair("password","123"));

        try {
            //HttpURLConnection.getOutputStream输出流请求
            UrlConnManager.postParams(mHttpURLConnection.getOutputStream(),postParams);
            //HttpURLConnection.connect链接
            mHttpURLConnection.connect();
            //HttpURLConnection.getInputStream输入流 响应
            mInputStream = mHttpURLConnection.getInputStream();
            int code = mHttpURLConnection.getResponseCode();
            String respose = converStreamToString(mInputStream);
            Log.i(TAG, "请求状态码: "+ code+"\n请求结果：\n"+respose);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public String converStreamToString(InputStream is){
        String result = "";


        byte[] bytes ;
    try {
        bytes = new byte[is.available()];
        is.read(bytes);
        result = new String(bytes);
    } catch (IOException e) {
        e.printStackTrace();
    }

    return result;
}
}
