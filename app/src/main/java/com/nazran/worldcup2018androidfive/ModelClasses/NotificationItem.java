package com.nazran.worldcup2018androidfive.ModelClasses;

public class NotificationItem {

    private String flagUrl;
    private String countryName;
    private boolean isNotified;

    //press ALT+insert

    public NotificationItem(String flagUrl, String countryName, boolean isNotified) {
        this.flagUrl = flagUrl;
        this.countryName = countryName;
        this.isNotified = isNotified;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isNotified() {
        return isNotified;
    }

    public void setNotified(boolean notified) {
        isNotified = notified;
    }
}
