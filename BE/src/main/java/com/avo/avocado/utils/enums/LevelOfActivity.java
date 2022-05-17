package com.avo.avocado.utils.enums;

public enum LevelOfActivity {
    LIGHT(1.3),
    MODERATE(1.5),
    HIGH(1.7),
    VERY_HIGH(1.9);

    public  double label;

    private LevelOfActivity(double label) {
        this.label = label;
    }

    public  double getLevelOfActivityValue(){
        return this.label;
    }
}
