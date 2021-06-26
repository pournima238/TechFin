package com.example.techfin;

import java.util.List;

public class Nutrition {
    private List<Nutrients>nutrients;

    public Nutrition(List<Nutrients> nutrients) {
        this.nutrients = nutrients;
    }

    public List<Nutrients> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrients> nutrients) {
        this.nutrients = nutrients;
    }
}
