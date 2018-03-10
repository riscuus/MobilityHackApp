package com.risco.android.mobilityhackapp.activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.risco.android.mobilityhackapp.R;

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class RewardsFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "RewardsFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        return view;

    }
}
