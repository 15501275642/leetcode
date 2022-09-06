package design_patterns.visitor.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import design_patterns.user.impl.Student;
import design_patterns.user.impl.Teacher;
import design_patterns.visitor.Visitor;

public class Parent implements Visitor {
    private Logger logger = LoggerFactory.getLogger(Parent.class);

    @Override
    public void visit(Teacher teacher) {
        logger.error("老师信息 姓名：{} 班级：{} 级别：{}",
                teacher.name, teacher.clazz, teacher.identity);
    }

    @Override
    public void visit(Student student) {
        logger.error("学生信息 姓名：{} 班级：{} 排名：{}",
                student.name, student.clazz, student.ranking());
    }
}