package com.zihler.courses.output;

public class Thumb {
    private long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private int rating;

    public Thumb() {
    }

    public Thumb(long id, String title, String description, String thumbnailUrl, int rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public int getRating() {
        return rating;
    }
}
