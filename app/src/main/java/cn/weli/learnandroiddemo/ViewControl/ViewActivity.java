package cn.weli.learnandroiddemo.ViewControl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.PopupWindow;
import android.widget.Toast;

import cn.weli.learnandroiddemo.R;
import cn.weli.learnandroiddemo.ViewControl.Fragment.DynamicFragmentActivity;
import cn.weli.learnandroiddemo.ViewControl.Fragment.StaticFragmentActivity;
import cn.weli.learnandroiddemo.ViewControl.ListView.ListViewActivity;
import cn.weli.learnandroiddemo.ViewControl.RecyleView.RecyleViewActivity;
import cn.weli.learnandroiddemo.ViewControl.SurfaceView.SurfaceViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ActionBarActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ActionViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.CalendarViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ClockViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ContextMenuActivity;
import cn.weli.learnandroiddemo.ViewControl.View.CusViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.DialogActivity;
import cn.weli.learnandroiddemo.ViewControl.View.MenuActivity;
import cn.weli.learnandroiddemo.ViewControl.View.NotiActivity;
import cn.weli.learnandroiddemo.ViewControl.View.PopupMenuActivity;
import cn.weli.learnandroiddemo.ViewControl.View.PopupWindowActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ProgressBarActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ScrollViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.SearchViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.TextViewActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ToastActivity;
import cn.weli.learnandroiddemo.ViewControl.View.ViewAnimatorActivity;
import cn.weli.learnandroiddemo.ViewControl.View.XmlMenuActivity;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.ViewPageActivity1;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.ViewPageActivity2;
import cn.weli.learnandroiddemo.ViewControl.ViewPage.ViewPageActivity3;
import cn.weli.learnandroiddemo.ViewControl.WebView.WebViewActivity;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnLl;
    private Button mBtnTL;
    private Button mBtnFl;
    private Button mBtnAl;
    private Button mBtnCl;

    private Button mBtnListView;
    private Button mBtnRecyleView;
    private Button mBtnViewPage;
    private Button mBtnViewPage2;
    private Button mBtnViewPage3;
    private Button mBtnWebView;
    private Button mBtnSurfaceView;
    private Button mBtnFragment;
    private Button mBtnDynFragment;

    private Button mBtnCusView;
    private Button mBtnBaseView;
    private Button mBtnClock;
    private Button mBtnProgresssBar;

    private Button mBtnViewAnimator;

    private Button mBtnToast;
    private Button mBtnCalendar;
    private Button mBtnSearch;

    private Button mBtnScroll;
    private Button mBtnNotify;

    private Button mBtnDialog;
    private Button mBtnPopupWindow;
    private Button mBtnMenu;
    private Button mBtnContextMenu;
    private Button mBtnXmlMenu;

    private Button mBtnPopupMenu;
    private Button mBtnActionBar;
    private Button mBtnActionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        bindView();
        setListener();
    }

    public void bindView() {
        mBtnLl = findViewById(R.id.linear_layout);
        mBtnTL = findViewById(R.id.table_layout);
        mBtnFl = findViewById(R.id.fram_layout);
        mBtnAl = findViewById(R.id.absolute_layout);
        mBtnCl = findViewById(R.id.constraint_layout);

        mBtnListView = findViewById(R.id.btn_list);
        mBtnRecyleView = findViewById(R.id.btn_recyleview);
        mBtnViewPage = findViewById(R.id.btn_viewpage);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnSurfaceView = findViewById(R.id.btn_surfaceview);
        mBtnFragment = findViewById(R.id.static_fragment);
        mBtnDynFragment = findViewById(R.id.dynamic_fragment);
        mBtnViewPage2 = findViewById(R.id.btn_viewpage2);
        mBtnViewPage3 = findViewById(R.id.btn_viewpage3);
        mBtnCusView = findViewById(R.id.cus_view);
        mBtnBaseView = findViewById(R.id.btn_baseview);
        mBtnClock = findViewById(R.id.btn_clockview);
        mBtnProgresssBar = findViewById(R.id.btn_progressbar);
        mBtnViewAnimator = findViewById(R.id.btn_viewanimator);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnCalendar = findViewById(R.id.btn_calendar);
        mBtnSearch = findViewById(R.id.btn_search);
        mBtnScroll = findViewById(R.id.btn_scroll);
        mBtnNotify = findViewById(R.id.notice);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnPopupWindow = findViewById(R.id.btn_popupwindow);
        mBtnMenu = findViewById(R.id.btn_menu);
        mBtnContextMenu = findViewById(R.id.btn_contextmenu);
        mBtnXmlMenu = findViewById(R.id.btn_xmlmenu);
        mBtnPopupMenu = findViewById(R.id.btn_popupmenu);
        mBtnActionBar = findViewById(R.id.btn_actionbar);
        mBtnActionView = findViewById(R.id.btn_actionview);



    }

    public void setListener() {
        mBtnActionView.setOnClickListener(this);
        mBtnActionBar.setOnClickListener(this);
        mBtnPopupMenu.setOnClickListener(this);
        mBtnXmlMenu.setOnClickListener(this);
        mBtnContextMenu.setOnClickListener(this);
        mBtnMenu.setOnClickListener(this);
        mBtnPopupWindow.setOnClickListener(this);
        mBtnDialog.setOnClickListener(this);
        mBtnNotify.setOnClickListener(this);
        mBtnScroll.setOnClickListener(this);
        mBtnSearch.setOnClickListener(this);

        mBtnViewAnimator.setOnClickListener(this);
        mBtnLl.setOnClickListener(this);
        mBtnTL.setOnClickListener(this);
        mBtnFl.setOnClickListener(this);
        mBtnAl.setOnClickListener(this);
        mBtnCl.setOnClickListener(this);
        mBtnBaseView.setOnClickListener(this);
        mBtnListView.setOnClickListener(this);
        mBtnRecyleView.setOnClickListener(this);
        mBtnViewPage.setOnClickListener(this);
        mBtnViewPage2.setOnClickListener(this);
        mBtnViewPage3.setOnClickListener(this);
        mBtnWebView.setOnClickListener(this);
        mBtnSurfaceView.setOnClickListener(this);

        mBtnFragment.setOnClickListener(this);
        mBtnDynFragment.setOnClickListener(this);
        mBtnCusView.setOnClickListener(this);
        mBtnClock.setOnClickListener(this);

        mBtnProgresssBar.setOnClickListener(this);
        mBtnToast.setOnClickListener(this);

        mBtnCalendar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout:
                Intent intent_l = new Intent(ViewActivity.this, LinnearLayoutActivity.class);
                startActivity(intent_l);
                break;
            case R.id.table_layout:
                Intent intent_t = new Intent(ViewActivity.this, TableLayoutActivity.class);
                startActivity(intent_t);
                break;
            case R.id.fram_layout:
                Intent intent_f = new Intent(ViewActivity.this, FramLayoutActivity.class);
                startActivity(intent_f);
                break;
            case R.id.absolute_layout:
                Toast.makeText(ViewActivity.this, "此方法已过时！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.constraint_layout:
                Intent intent_c = new Intent(ViewActivity.this, ConstraintLayoutActivity.class);
                startActivity(intent_c);
                break;

            case R.id.btn_list:
                Intent intent_list = new Intent(ViewActivity.this, ListViewActivity.class);
                startActivity(intent_list);
                break;
            case R.id.btn_recyleview:
                Intent intent_recyle = new Intent(ViewActivity.this, RecyleViewActivity.class);
                startActivity(intent_recyle);
                break;
            case R.id.btn_viewpage:
                Intent intent_viewpage = new Intent(ViewActivity.this, ViewPageActivity1.class);
                startActivity(intent_viewpage);
                break;
            case R.id.btn_viewpage2:
                Intent intent_viewpage2 = new Intent(ViewActivity.this, ViewPageActivity2.class);
                startActivity(intent_viewpage2);
                break;
            case R.id.btn_viewpage3:
                Intent intent_viewpage3 = new Intent(ViewActivity.this, ViewPageActivity3.class);
                startActivity(intent_viewpage3);
                break;

            case R.id.static_fragment:
                Intent intent_fragment = new Intent(ViewActivity.this, StaticFragmentActivity.class);
                startActivity(intent_fragment);
                break;
            case R.id.dynamic_fragment:
                Intent intent_dynamic_fragment = new Intent(ViewActivity.this, DynamicFragmentActivity.class);
                startActivity(intent_dynamic_fragment);
                break;
            case R.id.btn_webview:
                Intent intent_webview = new Intent(ViewActivity.this, WebViewActivity.class);
                startActivity(intent_webview);
                break;
            case R.id.btn_surfaceview:
                Intent intent_surfaceview = new Intent(ViewActivity.this, SurfaceViewActivity.class);
                startActivity(intent_surfaceview);
                break;

            case R.id.cus_view:
                Intent intent_cusView = new Intent(ViewActivity.this, CusViewActivity.class);
                startActivity(intent_cusView);
                break;
            case R.id.btn_baseview:
                Intent intent_baseview = new Intent(ViewActivity.this, TextViewActivity.class);
                startActivity(intent_baseview);
                break;

            case R.id.btn_clockview:
                Intent intent_clock = new Intent(ViewActivity.this, ClockViewActivity.class);
                startActivity(intent_clock);
                break;
            case R.id.btn_progressbar:
                Intent intent_progressbar = new Intent(ViewActivity.this, ProgressBarActivity.class);
                startActivity(intent_progressbar);
                break;

            case R.id.btn_viewanimator:
                Intent intent_viewanimator = new Intent(ViewActivity.this, ViewAnimatorActivity.class);
                startActivity(intent_viewanimator);
                break;

            case R.id.btn_toast:
                Intent intent_toast = new Intent(ViewActivity.this, ToastActivity.class);
                startActivity(intent_toast);
                break;
            case R.id.btn_calendar:
                Intent intent_btn_calendar = new Intent(ViewActivity.this, CalendarViewActivity.class);
                startActivity(intent_btn_calendar);
                break;
            case R.id.btn_search:
                Intent intent_btn_search = new Intent(ViewActivity.this, SearchViewActivity.class);
                startActivity(intent_btn_search);
                break;

            case R.id.btn_scroll:
                Intent intent_scroll = new Intent(ViewActivity.this, ScrollViewActivity.class);
                startActivity(intent_scroll);
                break;

            case R.id.notice:
                Intent intent_notice = new Intent(ViewActivity.this, NotiActivity.class);
                startActivity(intent_notice);
                break;
            case R.id.btn_dialog:
                Intent intent_dialog = new Intent(ViewActivity.this, DialogActivity.class);
                startActivity(intent_dialog);
                break;

            case R.id.btn_popupwindow:
                Intent intent_popupwindow = new Intent(ViewActivity.this, PopupWindowActivity.class);
                startActivity(intent_popupwindow);
                break;

            case R.id.btn_menu:
                Intent intent_menu = new Intent(ViewActivity.this, MenuActivity.class);
                startActivity(intent_menu);
                break;

            case R.id.btn_contextmenu:
                Intent intent_contextmenu = new Intent(ViewActivity.this, ContextMenuActivity.class);
                startActivity(intent_contextmenu);
                break;
            case R.id.btn_xmlmenu:
                Intent intent_xmlmenu = new Intent(ViewActivity.this, XmlMenuActivity.class);
                startActivity(intent_xmlmenu);
                break;
            case R.id.btn_popupmenu:
                Intent intent_popupmenu = new Intent(ViewActivity.this, PopupMenuActivity.class);
                startActivity(intent_popupmenu);
                break;
            case R.id.btn_actionbar:
                Intent intent_actionbar = new Intent(ViewActivity.this, ActionBarActivity.class);
                startActivity(intent_actionbar);
                break;
            case R.id.btn_actionview:
                Intent btn_actionview = new Intent(ViewActivity.this, ActionViewActivity.class);
                startActivity(btn_actionview);
                break;
        }
    }
}
