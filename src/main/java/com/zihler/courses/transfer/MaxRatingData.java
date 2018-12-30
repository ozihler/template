package com.zihler.courses.transfer;

public class MaxRatingData {
    private int maxRating;

    public MaxRatingData(int maxRating) {
        this.maxRating = maxRating;
    }

    public int getMaxRating() {
        return maxRating;
    }

    @Override
    public String toString() {
        return "MaxRatingData{" +
                "maxRating=" + maxRating +
                '}';
    }
}
