package com.macsoftech.vihaan.model;

public class StoresList {
    private String _id;
    private String chargerId;
    private String longitude;
    private String latitude;
    private String venergyOpen;
    private String venergyClose;
    private String chargerImage;
    private String shopName;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getChargerId() {
        return chargerId;
    }

    public void setChargerId(String chargerId) {
        this.chargerId = chargerId;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStoreOpen() {
        return venergyOpen;
    }

    public void setStoreOpen(String venergyOpen) {
        this.venergyOpen = venergyOpen;
    }

    public String getStoreClose() {
        return venergyClose;
    }

    public void setStoreClose(String venergyClose) {
        this.venergyClose = venergyClose;
    }


    public String getChargerImage() {
        return chargerImage;
    }

    public void setChargerImage(String chargerImage) {
        this.chargerImage = chargerImage;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
