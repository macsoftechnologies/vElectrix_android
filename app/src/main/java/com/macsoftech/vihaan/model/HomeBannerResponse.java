package com.macsoftech.vihaan.model;

import java.util.ArrayList;
import java.util.List;

public class HomeBannerResponse {
    private List<ImageResponse> imageRes;


    public List<ImageResponse> getImageRes() {
        if (imageRes == null) {
            return new ArrayList<>();
        }
        return imageRes;
    }

    public void setImageRes(List<ImageResponse> imageRes) {
        this.imageRes = imageRes;
    }
}
