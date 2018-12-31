package com.zihler.courses.transfer;

public class MaxRatingDto {
    private int maxRating;

    public MaxRatingDto(int maxRating) {
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
