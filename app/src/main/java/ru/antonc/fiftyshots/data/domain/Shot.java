package ru.antonc.fiftyshots.data.domain;


import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

@DatabaseTable(tableName = "shot")
public class Shot implements Serializable {

    public final static String ID = "id";

    @SerializedName("id")
    @DatabaseField(id = true, dataType = DataType.STRING, columnName = ID)
    private String id;

    @SerializedName("title")
    @DatabaseField
    private String title;

    @SerializedName("description")
    @DatabaseField
    private String description;

    @SerializedName("updated_at")
    @DatabaseField
    private Date dateUpdate;

    @SerializedName("images")
    private Image mImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        this.mImage = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }
}
