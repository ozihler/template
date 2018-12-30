package com.zihler.courses.transfer;

import com.zihler.courses.dataaccess.Course;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PreviewData {
    private long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private int rating;

    public PreviewData() {
    }

    private PreviewData(long id, String title, String description, String thumbnailUrl, int rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
    }

    public static PreviewData createPreviewFrom(Course course) {
        return new PreviewData(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getThumbnailUrl(),
                course.getRating()
        );
    }

    public static List<PreviewData> createPreviews(List<Course> courses) {
        return courses.stream()
                .map(PreviewData::createPreviewFrom)
                .collect(toList());

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

    @Override
    public String toString() {
        return "PreviewData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", rating=" + rating +
                '}';
    }
}
