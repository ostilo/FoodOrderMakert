package com.elkanah.foodordermakert.models;

import com.elkanah.foodordermakert.R;

public enum  ModelObject {

    ONE(R.string.one, R.layout.onboarding_one),
    TWO(R.string.two, R.layout.onboarding_two),
    THREE(R.string.three, R.layout.onboarding_three),
    FOUR(R.string.four, R.layout.fragment_login);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
