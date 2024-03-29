package design_patterns.user.impl;

import design_patterns.user.User;
import design_patterns.visitor.Visitor;

public class Student extends User {
    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() *  100);
    }
}
