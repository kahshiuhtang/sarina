package com.krtopi.backend.mission.set;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sticker_set")
public class StickerSetEntity {
    @Id
    private String id;
    private String setName;
    private String imageURL;
    private List<String> associatedStickerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<String> getAssociatedStickerId() {
        return associatedStickerId;
    }

    public void setAssociatedStickerId(List<String> associatedStickerId) {
        this.associatedStickerId = associatedStickerId;
    }
}
