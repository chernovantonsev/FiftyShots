package ru.antonc.fiftyshots.data.domain;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "image")
public class Image implements Serializable{

    public final static String SHOT_ID = "shot_id";

    @SerializedName("shot_id")
    @DatabaseField(columnName = SHOT_ID)
    private String shotId;

    @SerializedName("hidpi")
    @DatabaseField
    private String hidpi;

    @SerializedName("normal")
    @DatabaseField(id = true)
    private String normal;

    @SerializedName("teaser")
    @DatabaseField
    private String teaser;

    public String getHidpi() {
        return hidpi;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getTeaser() {
        return teaser;
    }

    public String getShotId() {
        return shotId;
    }

    public void setShotId(String shotId) {
        this.shotId = shotId;
    }
}
