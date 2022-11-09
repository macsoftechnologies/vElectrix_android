package com.macsoftech.vihaan.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class BrandResponse implements Parcelable {
    public Object font;
    private String motor;

    private String throttle;

    private String vehicleName;

    private String batteryCasing;

    private List<String> vehicleImage;

    private String colorId;

    private String mudGuards;

    private String bms;

    private String blinkers;

    private String storage;

    private String battery;

    private String ladiesFootrest;

    private String tyre;

    private String chargerOutput;

    private String createdAt;

    private String security;

    private String rim;

    private String __v;

    private String externalChargingPort;

    private String model;

    private String vehicleId;

    private String regenerativeBraking;

    private String updatedAt;

    private String controller;

    private String headLamp;

    private String brakeLights;

    private String amount;

    private String brandName;

    private String display;

    private String seat;

    private String brake;

    private String cells;

    private String reflector;

    private String gradeablity;

    private String _id;

    protected BrandResponse(Parcel in) {
        motor = in.readString();
        throttle = in.readString();
        vehicleName = in.readString();
        batteryCasing = in.readString();
        vehicleImage = in.createStringArrayList();
        colorId = in.readString();
        mudGuards = in.readString();
        bms = in.readString();
        blinkers = in.readString();
        storage = in.readString();
        battery = in.readString();
        ladiesFootrest = in.readString();
        tyre = in.readString();
        chargerOutput = in.readString();
        createdAt = in.readString();
        security = in.readString();
        rim = in.readString();
        __v = in.readString();
        externalChargingPort = in.readString();
        model = in.readString();
        vehicleId = in.readString();
        regenerativeBraking = in.readString();
        updatedAt = in.readString();
        controller = in.readString();
        headLamp = in.readString();
        brakeLights = in.readString();
        amount = in.readString();
        brandName = in.readString();
        display = in.readString();
        seat = in.readString();
        brake = in.readString();
        cells = in.readString();
        reflector = in.readString();
        gradeablity = in.readString();
        _id = in.readString();
    }

    public static final Creator<BrandResponse> CREATOR = new Creator<BrandResponse>() {
        @Override
        public BrandResponse createFromParcel(Parcel in) {
            return new BrandResponse(in);
        }

        @Override
        public BrandResponse[] newArray(int size) {
            return new BrandResponse[size];
        }
    };

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getThrottle() {
        return throttle;
    }

    public void setThrottle(String throttle) {
        this.throttle = throttle;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getBatteryCasing() {
        return batteryCasing;
    }

    public void setBatteryCasing(String batteryCasing) {
        this.batteryCasing = batteryCasing;
    }

    public List<String> getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(List<String> vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getMudGuards() {
        return mudGuards;
    }

    public void setMudGuards(String mudGuards) {
        this.mudGuards = mudGuards;
    }

    public String getBms() {
        return bms;
    }

    public void setBms(String bms) {
        this.bms = bms;
    }

    public String getBlinkers() {
        return blinkers;
    }

    public void setBlinkers(String blinkers) {
        this.blinkers = blinkers;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getLadiesFootrest() {
        return ladiesFootrest;
    }

    public void setLadiesFootrest(String ladiesFootrest) {
        this.ladiesFootrest = ladiesFootrest;
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public String getChargerOutput() {
        return chargerOutput;
    }

    public void setChargerOutput(String chargerOutput) {
        this.chargerOutput = chargerOutput;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getRim() {
        return rim;
    }

    public void setRim(String rim) {
        this.rim = rim;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }

    public String getExternalChargingPort() {
        return externalChargingPort;
    }

    public void setExternalChargingPort(String externalChargingPort) {
        this.externalChargingPort = externalChargingPort;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegenerativeBraking() {
        return regenerativeBraking;
    }

    public void setRegenerativeBraking(String regenerativeBraking) {
        this.regenerativeBraking = regenerativeBraking;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getHeadLamp() {
        return headLamp;
    }

    public void setHeadLamp(String headLamp) {
        this.headLamp = headLamp;
    }

    public String getBrakeLights() {
        return brakeLights;
    }

    public void setBrakeLights(String brakeLights) {
        this.brakeLights = brakeLights;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getBrake() {
        return brake;
    }

    public void setBrake(String brake) {
        this.brake = brake;
    }

    public String getCells() {
        return cells;
    }

    public void setCells(String cells) {
        this.cells = cells;
    }

    public String getReflector() {
        return reflector;
    }

    public void setReflector(String reflector) {
        this.reflector = reflector;
    }

    public String getGradeablity() {
        return gradeablity;
    }

    public void setGradeablity(String gradeablity) {
        this.gradeablity = gradeablity;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "ClassPojo [motor = " + motor + ", throttle = " + throttle + ", vehicleName = " + vehicleName + ", batteryCasing = " + batteryCasing + ", vehicleImage = " + vehicleImage + ", colorId = " + colorId + ", mudGuards = " + mudGuards + ", bms = " + bms + ", blinkers = " + blinkers + ", storage = " + storage + ", battery = " + battery + ", ladiesFootrest = " + ladiesFootrest + ", tyre = " + tyre + ", chargerOutput = " + chargerOutput + ", createdAt = " + createdAt + ", security = " + security + ", rim = " + rim + ", __v = " + __v + ", externalChargingPort = " + externalChargingPort + ", model = " + model + ", vehicleId = " + vehicleId + ", regenerativeBraking = " + regenerativeBraking + ", updatedAt = " + updatedAt + ", controller = " + controller + ", headLamp = " + headLamp + ", brakeLights = " + brakeLights + ", amount = " + amount + ", brandName = " + brandName + ", display = " + display + ", seat = " + seat + ", brake = " + brake + ", cells = " + cells + ", reflector = " + reflector + ", gradeablity = " + gradeablity + ", _id = " + _id + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(motor);
        parcel.writeString(throttle);
        parcel.writeString(vehicleName);
        parcel.writeString(batteryCasing);
        parcel.writeStringList(vehicleImage);
        parcel.writeString(colorId);
        parcel.writeString(mudGuards);
        parcel.writeString(bms);
        parcel.writeString(blinkers);
        parcel.writeString(storage);
        parcel.writeString(battery);
        parcel.writeString(ladiesFootrest);
        parcel.writeString(tyre);
        parcel.writeString(chargerOutput);
        parcel.writeString(createdAt);
        parcel.writeString(security);
        parcel.writeString(rim);
        parcel.writeString(__v);
        parcel.writeString(externalChargingPort);
        parcel.writeString(model);
        parcel.writeString(vehicleId);
        parcel.writeString(regenerativeBraking);
        parcel.writeString(updatedAt);
        parcel.writeString(controller);
        parcel.writeString(headLamp);
        parcel.writeString(brakeLights);
        parcel.writeString(amount);
        parcel.writeString(brandName);
        parcel.writeString(display);
        parcel.writeString(seat);
        parcel.writeString(brake);
        parcel.writeString(cells);
        parcel.writeString(reflector);
        parcel.writeString(gradeablity);
        parcel.writeString(_id);
    }
}