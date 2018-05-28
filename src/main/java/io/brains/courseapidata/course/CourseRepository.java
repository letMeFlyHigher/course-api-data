package io.brains.courseapidata.course;


import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface CourseRepository extends CrudRepository<Course, String>{

    public Course findByName(String name);

    public List<Course> findByTopicId(String id);

}
