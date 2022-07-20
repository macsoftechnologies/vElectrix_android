package com.macsoftech.vihaan.model;

public class BrandListResponse {
    private String Message;

    private BrandListData Data;

    private String StatusCode;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public BrandListData getData() {
        return Data;
    }

    public void setData(BrandListData Data) {
        this.Data = Data;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String StatusCode) {
        this.StatusCode = StatusCode;
    }

    @Override
    public String toString() {
        return "ClassPojo [Message = " + Message + ", Data = " + Data + ", StatusCode = " + StatusCode + "]";
    }
}
			