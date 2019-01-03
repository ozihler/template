package com.zihler.courses.transfer;

import com.zihler.courses.dataaccess.Course;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PreviewDto {
    private long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private Long rating;

    public PreviewDto() {
    }

    private PreviewDto(long id, String title, String description, String thumbnailUrl, Long rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.rating = rating;
    }

    private static PreviewDto createPreviewFrom(Course course) {
        return new PreviewDto(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getThumbnailUrl(),
                course.getRating()
        );
    }

    public static List<PreviewDto> createPreviews(List<Course> courses) {
        return courses.stream()
                .map(PreviewDto::createPreviewFrom)
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

    public Long getRating() {
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
