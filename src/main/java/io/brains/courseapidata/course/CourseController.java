package io.brains.courseapidata.course;

import io.brains.courseapidata.topic.Topic;
import io.brains.courseapidata.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllByTopicId(@PathVariable String topicId){
       return courseService.getAllByTopicId(topicId);
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@PathVariable String topicId, @RequestBody Course course){
       courseService.addCourse(topicId,course);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses")
    public void updateCourse(@RequestBody Course course , @PathVariable String topicId){
        courseService.updateCourse(topicId,course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
