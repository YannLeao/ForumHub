package br.com.yann.forumHub.domain.course;

public record DataResponseCourse(Long id, String name, CategoryCourse category) {

    public DataResponseCourse(Course course) {
        this(course.getId(), course.getName(), course.getCategory());
    }
}
