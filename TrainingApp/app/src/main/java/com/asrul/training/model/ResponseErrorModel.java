package com.asrul.training.model;

import com.google.gson.annotations.SerializedName;

public class ResponseErrorModel {
    @SerializedName("error_msg")
    private String errorMsg;

    @SerializedName("rule")
    private String rule;

    @SerializedName("id")
    private String id;

    @SerializedName("error")
    private boolean error;

    @SerializedName("username")
    private String username;

    @SerializedName("regID")
    private String regID;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }
}
