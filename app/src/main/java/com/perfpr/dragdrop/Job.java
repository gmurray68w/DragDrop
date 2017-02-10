package com.perfpr.dragdrop;

/**
 * Created by Gmurray68w on 2/8/2017.
 */

public class Job {
    private String mEmployeeName;
    private String mPetName;
    private String mJobDate;
    private String mJobType;
    private String mJobTime;
    private int mPosition;

    public Job(String mEmployeeName, String mPetName, String mJobDate, String mJobType, String mJobTime, int mPosition) {
        this.mEmployeeName = mEmployeeName;
        this.mPetName = mPetName;
        this.mJobDate = mJobDate;
        this.mJobType = mJobType;
        this.mJobTime = mJobTime;
        this.mPosition = mPosition;
    }

    public String getmEmployeeName() {
        return mEmployeeName;
    }

    public String getmPetName() {
        return mPetName;
    }

    public String getmJobDate() {
        return mJobDate;
    }

    public String getmJobType() {
        return mJobType;
    }

    public String getmJobTime() {
        return mJobTime;
    }

    public int getmPosition() {
        return mPosition;
    }
}
