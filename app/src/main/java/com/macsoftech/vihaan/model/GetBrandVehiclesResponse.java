package com.macsoftech.vihaan.model;

public class GetBrandVehiclesResponse {
    private String StatusCode;

    private BrandResponse[] brandResponse;

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String StatusCode) {
        this.StatusCode = StatusCode;
    }

    public BrandResponse[] getBrandResponse() {
        return brandResponse;
    }

    public void setBrandResponse(BrandResponse[] brandResponse) {
        this.brandResponse = brandResponse;
    }

    @Override
    public String toString() {
        return "ClassPojo [StatusCode = " + StatusCode + ", brandResponse = " + brandResponse + "]";
    }
}
