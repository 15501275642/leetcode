package design_patterns.visitor;

import design_patterns.user.impl.Student;
import design_patterns.user.impl.Teacher;

public interface Visitor {
    //访问学生信息
    void visit(Teacher teacher);

    //访问老师信息
    void visit(Student student);
}
