package design_patterns;

import design_patterns.visitor.impl.Parent;
import design_patterns.visitor.impl.Principal;
import org.junit.jupiter.api.Test;

public class ApiTest {
    @Test
    public void test(){
        DataView dataView = new DataView();
        System.out.println("\r\n 家长视角访问");
        dataView.show(new Parent());
        System.out.println("\r\n 校长视角访问");
        dataView.show(new Principal());
    }




}
