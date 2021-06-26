package com.example.techfin;

public class model {
    private String title;

   private Nutrition nutrition;

    public model(String title, Nutrition nutrition) {
        this.title = title;
        this.nutrition = nutrition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }
}
