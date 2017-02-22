package com.bwie.newstitleyanlei.activity;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.newstitleyanlei.R;
import com.bwie.newstitleyanlei.fragment.FocusFragment;
import com.bwie.newstitleyanlei.fragment.HomeFragment;
import com.bwie.newstitleyanlei.fragment.LoginFragment;
import com.bwie.newstitleyanlei.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg;
    private RadioButton homeRB;
    private RadioButton videoRB;
    private RadioButton focusRb;
    private RadioButton loginRb;
    private Fragment fragment = new Fragment();
    private HomeFragment homeFragment;
    private VideoFragment videoFragment;
    private FocusFragment focusFragment;
    private LoginFragment loginFragment;
    private int theme = R.style.AppTheme;
    private List<RadioButton> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
        setContentView(R.layout.activity_main);

        //   TabLayou
        findviewID();
        homeFragment = new HomeFragment();
        ;
        videoFragment = new VideoFragment();
        focusFragment = new FocusFragment();
        loginFragment = new LoginFragment();

        rg.setOnCheckedChangeListener(this);


        getSupportFragmentManager().beginTransaction().add(R.id.fl, homeFragment).show(homeFragment)
                .add(R.id.fl, videoFragment).hide(videoFragment)
                .add(R.id.fl, focusFragment).hide(focusFragment)
                .add(R.id.fl, loginFragment,"login").hide(loginFragment).commit();
        homeRB.setChecked(true);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Button but= (Button) loginFragment.getView().findViewById(R.id.day_night);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = (theme == R.style.AppTheme) ? R.style.NightAppTheme : R.style.AppTheme;
                MainActivity.this.recreate();
            }
        });
    }

    @Override
    public void recreate() {

        getSupportFragmentManager().beginTransaction().remove(homeFragment)
                .remove(videoFragment)
                .remove(focusFragment)
                .remove(loginFragment).commit();
        super.recreate();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme", theme);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        theme = savedInstanceState.getInt("theme");
    }


    private void findviewID() {
        rg = (RadioGroup) findViewById(R.id.rg);
        homeRB = (RadioButton) findViewById(R.id.homeRB);
        videoRB = (RadioButton) findViewById(R.id.videoRB);
        focusRb = (RadioButton) findViewById(R.id.focusRb);
        loginRb = (RadioButton) findViewById(R.id.loginRb);






        list = new ArrayList<>();

        list.add(homeRB);
        list.add(videoRB);
        list.add(focusRb);
        list.add(loginRb);

        for (RadioButton rb : list) {

            Drawable[] drs = rb.getCompoundDrawables();
            Rect r = new Rect(0, 0, drs[1].getMinimumWidth() * 1 / 2, drs[1].getMinimumHeight() * 1 / 2);
            drs[1].setBounds(r);

            rb.setCompoundDrawables(null, drs[1], null, null);
        }


    }




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.homeRB:

                getSupportFragmentManager().beginTransaction().show(homeFragment).hide(fragment).commit();
                fragment = homeFragment;
                //             getSupportFragmentManager().beginTransaction().replace(R.id.fl, new HomeFragment()).commit();
                break;
            case R.id.videoRB:
                getSupportFragmentManager().beginTransaction().show(videoFragment).hide(fragment).commit();
                fragment = videoFragment;
                break;
            case R.id.focusRb:
                getSupportFragmentManager().beginTransaction().show(focusFragment).hide(fragment).commit();

                fragment = focusFragment;
                break;
            case R.id.loginRb:
                getSupportFragmentManager().beginTransaction().show(loginFragment).hide(fragment).commit();
                fragment = loginFragment;
                break;

        }
    }
}
