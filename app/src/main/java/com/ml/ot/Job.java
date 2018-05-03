package com.ml.ot;

/**
 * Created by lucic on 5/3/2018.
 */

public class Job {
    String jobID;
    String jobCompany;
    String jobType;

    public Job(){
    }

    public Job(String jobID, String jobCompany, String jobType) {
        this.jobID = jobID;
        this.jobCompany = jobCompany;
        this.jobType = jobType;
    }

    public String getJobID() {
        return jobID;
    }

    public String getJobCompany() {
        return jobCompany;
    }

    public String getJobType() {
        return jobType;
    }
}
