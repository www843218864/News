package com.bwie.newstitleyanlei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.newstitleyanlei.fragment.FocusFragment;
import com.bwie.newstitleyanlei.fragment.HomeFragment;
import com.bwie.newstitleyanlei.fragment.LoginFragment;
import com.bwie.newstitleyanlei.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg;
    private RadioButton homeRB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findviewID();


        rg.setOnCheckedChangeListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl,new HomeFragment()).commit();
        homeRB.setChecked(true);

    }

    private void findviewID() {
        rg = (RadioGroup) findViewById(R.id.rg);
        homeRB = (RadioButton) findViewById(R.id.homeRB);
        RadioButton videoRB = (RadioButton) findViewById(R.id.videoRB);
        RadioButton focusRb = (RadioButton) findViewById(R.id.focusRb);
        RadioButton loginRb = (RadioButton) findViewById(R.id.loginRb);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.homeRB:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new HomeFragment()).commit();
                break;
            case R.id.videoRB:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new VideoFragment()).commit();
                break;
            case R.id.focusRb:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new FocusFragment()).commit();
                break;
            case R.id.loginRb:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new LoginFragment()).commit();
                break;

        }
    }
}
