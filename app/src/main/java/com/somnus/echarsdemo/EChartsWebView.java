package com.somnus.echarsdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class EChartsWebView extends WebView {
    private boolean requestDisallowInterceptTouchEvent = true;
    private static int emptyFontSize = 14;
    private static String emptyMsg = "暂无数据~";

    public EChartsWebView(@NonNull Context context) {
        this(context, null);
    }

    public EChartsWebView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EChartsWebView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressLint({"ClickableViewAccessibility", "SetJavaScriptEnabled"})
    private void init() {
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.getSettings().setSupportZoom(false);
        this.getSettings().setDisplayZoomControls(false);

        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        requestDisallowInterceptTouchEvent(requestDisallowInterceptTouchEvent);
        return super.onTouchEvent(event);
    }

    public void setData(String data) {
        loadData(data,null);
    }


    public void setData(String data,List<Object> datas) {
        loadData(data,datas);
    }

    public void setEmpty() {
        loadData("",null);
    }

    public void setEmpty(String msg, int emptyFontSize) {
        emptyMsg = msg;
        this.emptyFontSize = emptyFontSize;
        loadData("",null);
    }


    private void loadData(String data, List<Object> datas) {
        this.loadUrl("file:///android_asset/echarts.html");
        this.setWebViewClient(new EChartsWebViewClient(data,datas));
    }

    public static class EChartsWebViewClient extends WebViewClient {

        private String data;
        private List<Object> datas;

        public EChartsWebViewClient(String data,List<Object> datalist) {
            this.data = data;
            this.datas =  datalist;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onPageFinished(final WebView view, String url) {
            LogUtil.info("图表", "html加载完成 onPageFinished " + data);
            view.post(() -> {
                if (TextUtils.isEmpty(data)) {
                    String emptyUrl = String.format("javascript:setEmpty(%s, %s)", "'" + emptyMsg + "'", emptyFontSize);
                    LogUtil.info("图表", emptyUrl);
                    view.loadUrl(emptyUrl);
                } else{
//                                    [["21:10", 1], ["22:15", 1], ["23:10", 1], ["1:10", 1], ["3:10", 1]]
                    String [][] arr = {{"21:10","1"},{"22:15","3"},{"23:10","2"},{"1:10","1"},{"3:10","1"}};
                    LogUtil.info("图表", Arrays.deepToString(arr));
                    String [][] arr1 = {{"21:10","2"},{"22:15","3"},{"23:10","2"},{"1:10","1"},{"3:10","1"}};

                    Gson mGson = new Gson();
                    String dataInfo = String.format("javascript:setData(%s,%s,%s)",data, mGson.toJson(arr),mGson.toJson(arr1));
                    LogUtil.info("图表",dataInfo);
                    view.loadUrl(dataInfo);
                }
            });
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            LogUtil.info("图表加载出错", error.toString());
        }
    }

    public boolean isRequestDisallowInterceptTouchEvent() {
        return requestDisallowInterceptTouchEvent;
    }

    public void setRequestDisallowInterceptTouchEvent(boolean requestDisallowInterceptTouchEvent) {
        this.requestDisallowInterceptTouchEvent = requestDisallowInterceptTouchEvent;
    }
}
