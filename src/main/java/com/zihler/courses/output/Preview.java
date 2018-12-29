package com.zihler.courses.output;

public class Preview {
    private long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private int rating;

    public Preview() {
    }

    private Preview(long id, String title, String description, String thumbnailUrl, int rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
    }

    public static Preview createPreviewFrom(Course course) {
        return new Preview(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getThumbnailUrl(),
                course.getRating()
        );
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
