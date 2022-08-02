package com.macsoftech.vihaan.model;

import java.util.List;

public class ImageResponse {
    private String _id;
    private String url;
    private String imageId;
    private List<String> image;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImage() {
        if (image == null || image.isEmpty()) {
            return "";
        }
        return image.get(0);
    }

    public void setImage(List<String> image) {
        this.image = image;
    }
}
