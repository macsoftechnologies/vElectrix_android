package com.macsoftech.vihaan.model;

import java.util.List;

public class BrandListData {
    private List<BrandsList> brandsList;

    public List<BrandsList> getBrandsList() {
        return brandsList;
    }

    public void setBrandsList(List<BrandsList> brandsList) {
        this.brandsList = brandsList;
    }

    @Override
    public String toString() {
        return "ClassPojo [brandsList = " + brandsList + "]";
    }
}
