package com.bwie.newstitleyanlei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.newstitleyanlei.R;

/**
 * 1.类的用途：
 * 2.作者：闫雷
 * 3.2017/2/10 9:50
 */
public class HomeFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.home_fragment,null);

        return view;
    }
}
