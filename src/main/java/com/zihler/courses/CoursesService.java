package com.zihler.courses;

import com.zihler.courses.output.MaxRating;
import com.zihler.courses.output.Preview;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("coursesService")
public class CoursesService {
    List<Preview> getPreviews() {

        List<Preview> previews = new ArrayList<>();

        for (int courseId = 0; courseId < 50; courseId++) {
            previews.add(
                    new Preview(
                            courseId,
                            String.format("Title %d", courseId),
                            String.format("Description %d", courseId),
                            String.format("courses/course/%d", courseId),
                            new Random().nextInt(5)+1
                    )
            );
        }

        return previews;
    }

    MaxRating getCurrentMaxRating() {
        return new MaxRating(5);
    }
}
