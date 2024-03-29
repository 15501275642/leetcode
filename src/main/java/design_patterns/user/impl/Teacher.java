package design_patterns.user.impl;

import design_patterns.user.User;
import design_patterns.visitor.Visitor;

import java.math.BigDecimal;

public class Teacher extends User {
    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    //升学率
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }
}
