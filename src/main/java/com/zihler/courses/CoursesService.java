package com.zihler.courses;

import com.zihler.courses.output.MaxRating;
import com.zihler.courses.output.Thumb;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("coursesService")
public class CoursesService {
    List<Thumb> getThumbs() {

        List<Thumb> thumbs = new ArrayList<>();

        for (int courseId = 0; courseId < 50; courseId++) {
            thumbs.add(
                    new Thumb(
                            courseId,
                            String.format("Title %d", courseId),
                            String.format("Description %d", courseId),
                            String.format("courses/course/%d", courseId),
                            new Random().nextInt(5)+1
                    )
            );
        }

        return thumbs;
    }

    MaxRating getCurrentMaxRating() {
        return new MaxRating(5);
    }
}
