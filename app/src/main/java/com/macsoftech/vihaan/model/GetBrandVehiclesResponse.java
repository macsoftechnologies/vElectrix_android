package com.macsoftech.vihaan.model;

import java.util.List;

public class GetBrandVehiclesResponse {
    private String StatusCode;

    private List<BrandResponse> brandResponse;

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String StatusCode) {
        this.StatusCode = StatusCode;
    }

    public List<BrandResponse> getBrandResponse() {
        return brandResponse;
    }

    public void setBrandResponse(List<BrandResponse> brandResponse) {
        this.brandResponse = brandResponse;
    }

    @Override
    public String toString() {
        return "ClassPojo [StatusCode = " + StatusCode + ", brandResponse = " + brandResponse + "]";
    }
}
