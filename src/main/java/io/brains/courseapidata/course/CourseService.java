package io.brains.courseapidata.course;

import io.brains.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public Course getCourse(String id){
       return  courseRepository.findById(id).get();
    }

    public void addCourse(String topicId, Course course) {
        course.setTopic(new Topic(topicId,"topic 1","topic 2"));
        courseRepository.save(course);
    }

    public void updateCourse(String topicId, Course course) {
       courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getAllByTopicId(String topicId) {
        return courseRepository.findByTopicId(topicId);
    }
}
