package com.macsoftech.vihaan.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BrandsList implements Parcelable {
    private String createdAt;

    private String brandName;

    private String brandImage;

    private String brandId;

    private String __v;

    private String logo;

    private String _id;

    private String updatedAt;

    protected BrandsList(Parcel in) {
        createdAt = in.readString();
        brandName = in.readString();
        brandImage = in.readString();
        brandId = in.readString();
        __v = in.readString();
        logo = in.readString();
        _id = in.readString();
        updatedAt = in.readString();
    }

    public static final Creator<BrandsList> CREATOR = new Creator<BrandsList>() {
        @Override
        public BrandsList createFromParcel(Parcel in) {
            return new BrandsList(in);
        }

        @Override
        public BrandsList[] newArray(int size) {
            return new BrandsList[size];
        }
    };

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ClassPojo [createdAt = " + createdAt + ", brandName = " + brandName + ", brandImage = " + brandImage + ", brandId = " + brandId + ", __v = " + __v + ", logo = " + logo + ", _id = " + _id + ", updatedAt = " + updatedAt + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(createdAt);
        parcel.writeString(brandName);
        parcel.writeString(brandImage);
        parcel.writeString(brandId);
        parcel.writeString(__v);
        parcel.writeString(logo);
        parcel.writeString(_id);
        parcel.writeString(updatedAt);
    }
}