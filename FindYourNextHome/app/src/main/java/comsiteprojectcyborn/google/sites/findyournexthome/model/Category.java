package comsiteprojectcyborn.google.sites.findyournexthome.model;

/**
 * Created by msrabon on 12/20/16.
 */

public class Category {
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
