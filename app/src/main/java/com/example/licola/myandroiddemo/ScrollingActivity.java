package com.example.licola.myandroiddemo;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.licola.llogger.LLogger;
import java.util.List;

public class ScrollingActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrolling);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show();
      }
    });

    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction().replace(R.id.container,new NestedScrollFragment()).commit();

    ActivityManager systemService = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
    List<RunningAppProcessInfo> runningAppProcesses = systemService.getRunningAppProcesses();
    for (RunningAppProcessInfo runningAppProcess : runningAppProcesses) {
      LLogger.d(runningAppProcess.lru);
    }
  }
}
