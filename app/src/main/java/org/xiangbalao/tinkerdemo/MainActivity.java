package org.xiangbalao.tinkerdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.server.callback.ConfigRequestCallback;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private RelativeLayout contentMain;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //TODO 修复BUG
        // contentMain.setBackgroundResource(R.mipmap.rooster);

    }


    /**
     * 初始化
     */
    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        contentMain = (RelativeLayout) findViewById(R.id.content_main);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showInfo(MainActivity.this);


            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_loadPatch) {
            //加载补丁
            TinkerPatch.with().fetchPatchUpdate(true);

        } else if (id == R.id.nav_loadLibrary) {
            //根据在线参数加载补丁
            TinkerPatch.with().fetchDynamicConfig(new ConfigRequestCallback() {
                @Override
                public void onSuccess(HashMap<String, String> configs) {
                    // 根据在线参数决定是否加载补丁
                    if (configs != null && "longtaoge".equals(configs.get("id"))) {
                        // 配置不为空且 id 为"longtaoge" 时才加载补丁
                        //加载补丁
                        TinkerPatch.with().fetchPatchUpdate(true);

                    }

                    TinkerLog.w(TAG, "request config success, config:" + configs);

                }

                @Override
                public void onFail(Exception e) {
                    TinkerLog.w(TAG, "request config failed, exception:" + e);
                }
            }, true);

        } else if (id == R.id.nav_cleanPatch) {
            //清除补丁
            TinkerPatch.with().cleanPatch();

        } else if (id == R.id.nav_killSelf) {
            //重启应用
            ShareTinkerInternals.killAllOtherProcess(getApplicationContext());
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);

        } else if (id == R.id.nav_info) {

            //打开浏览器
            openBrowser(getString(R.string.tinker));


        } else if (id == R.id.nav_share) {
            //分享
            shareMsg(getString(R.string.hotfix), getString(R.string.tinkerdome), getString(R.string.share));

        } else if (id == R.id.nav_about) {
            openBrowser(getString(R.string.about));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void shareMsg(String activityTitle, String msgTitle, String msgText) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle);
        intent.putExtra(Intent.EXTRA_TEXT, msgText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, activityTitle));
    }


    private void openBrowser(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    /**
     * 显示信息
     *
     * @param context
     * @return
     */
    public boolean showInfo(Context context) {
        // add more Build Info
        final StringBuilder sb = new StringBuilder();
        sb.append("\n");
        Tinker tinker = Tinker.with(getApplicationContext());
        if (tinker.isTinkerLoaded()) {
            sb.append("补丁已加载");
        } else {
            sb.append("补丁未加载");
        }

        final TextView v = new TextView(context);
        v.setText(sb);
        v.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        v.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
        v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        v.setTextColor(0xFF000000);
        v.setTypeface(Typeface.MONOSPACE);
        final int padding = 16;
        v.setPadding(padding, padding, padding, padding);

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setView(v);
        final AlertDialog alert = builder.create();
        alert.show();
        return true;
    }


    @Override
    protected void onResume() {


        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
