package com.macsoftech.vihaan.model;

import java.util.List;

public class StoresList {
    private String _id;
    private String storeId;
    private String storeName;
    private String longitude;
    private String latitude;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
        return storeOpen;
    }

    public void setStoreOpen(String storeOpen) {
        this.storeOpen = storeOpen;
    }

    public String getStoreClose() {
        return storeClose;
    }

    public void setStoreClose(String storeClose) {
        this.storeClose = storeClose;
    }

    public List<String> getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(List<String> storeImage) {
        this.storeImage = storeImage;
    }

    public List<String> getStoreIcon() {
        return storeIcon;
    }

    public void setStoreIcon(List<String> storeIcon) {
        this.storeIcon = storeIcon;
    }

    private String storeOpen;
    private String storeClose;
    private List<String> storeImage;
    private List<String> storeIcon;
}
