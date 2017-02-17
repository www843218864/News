package com.bwie.newstitleyanlei.activity;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   TabLayou
        findviewID();


        rg.setOnCheckedChangeListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, new HomeFragment()).commit();
        homeRB.setChecked(true);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    private void findviewID() {
        rg = (RadioGroup) findViewById(R.id.rg);
        homeRB = (RadioButton) findViewById(R.id.homeRB);
        videoRB = (RadioButton) findViewById(R.id.videoRB);
        focusRb = (RadioButton) findViewById(R.id.focusRb);
        loginRb = (RadioButton) findViewById(R.id.loginRb);

        List<RadioButton> list=new ArrayList<>();
        list.add(homeRB);
        list.add(videoRB);
        list.add(focusRb);
        list.add(loginRb);

        for(RadioButton rb:list){

            Drawable[] drs = rb.getCompoundDrawables();
            Rect r = new Rect(0, 0, drs[1].getMinimumWidth() * 1 / 2, drs[1].getMinimumHeight() * 1 / 2);
            drs[1].setBounds(r);

            rb.setCompoundDrawables(null,drs[1],null,null);
        }





    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.homeRB:

                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new HomeFragment()).commit();
                break;
            case R.id.videoRB:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new VideoFragment()).commit();
                break;
            case R.id.focusRb:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new FocusFragment()).commit();
                break;
            case R.id.loginRb:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new LoginFragment()).commit();
                break;

        }
    }
}
