package design_patterns.visitor.impl;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import design_patterns.user.impl.Student;
import design_patterns.user.impl.Teacher;
import design_patterns.visitor.Visitor;

public class Principal implements Visitor {
    private Logger logger = LoggerFactory.getLogger(Principal.class);

    @Override
    public void visit(Teacher teacher) {
        logger.error("老师信息 姓名：{} 班级：{} 升学率：{}",
                teacher.name, teacher.clazz, teacher.entranceRatio());
    }

    @Override
    public void visit(Student student) {
        logger.error("学生信息 姓名：{} 班级：{} 人数：{}",
                student.name, student.clazz);
    }
}
