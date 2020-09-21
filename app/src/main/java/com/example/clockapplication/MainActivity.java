package com.example.clockapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private AlarmFragment alarmFragment;
    private ClockFragment clockFragment;
    private StopwatchFragment stopwatchFragment;
    private TimerFragment timerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        alarmFragment = new AlarmFragment();
        clockFragment = new ClockFragment();
        stopwatchFragment = new StopwatchFragment();
        timerFragment = new TimerFragment();


        mMainNav.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_alarm:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(alarmFragment);
                        return true;

                    case R.id.nav_clock:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(clockFragment);
                        return true;

                    case R.id.nav_stopwatch:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(stopwatchFragment);
                        return true;

                    case R.id.nav_timer:
                        mMainNav.setItemBackgroundResource(R.color.colorWhiteTransparent);
                        setFragment(timerFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}