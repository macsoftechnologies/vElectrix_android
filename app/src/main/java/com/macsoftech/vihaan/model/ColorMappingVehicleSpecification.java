package com.macsoftech.vihaan.model;

import java.util.List;

public class ColorMappingVehicleSpecification {
    private List<ColorMappingResponse> colorMappingResponse;

    private String StatusCode;

    public List<ColorMappingResponse> getColorMappingResponse() {
        return colorMappingResponse;
    }

    public void setColorMappingResponse(List<ColorMappingResponse> colorMappingResponse) {
        this.colorMappingResponse = colorMappingResponse;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String StatusCode) {
        this.StatusCode = StatusCode;
    }

    @Override
    public String toString() {
        return "ClassPojo [colorMappingResponse = " + colorMappingResponse + ", StatusCode = " + StatusCode + "]";
    }
}
			