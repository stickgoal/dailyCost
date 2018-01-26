package me.maiz.dal.model;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * Created by Lucas on 2018-01-15.
 */
@Entity
@Table(name="dc_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId;

    private long userId;

    private String name;

    private String type;

    private boolean isDefault;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("categoryId", categoryId)
                .add("userId", userId)
                .add("name", name)
                .add("type", type)
                .add("isDefault", isDefault)
                .toString();
    }
}
