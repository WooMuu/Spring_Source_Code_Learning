package chapter5.bean;

/**
 * Created by zjb on 2019/10/21.
 */
public class TestB {
    private TestC testC;

    public TestB(TestC testC) {
        this.testC = testC;
    }

    public TestB() {
    }

    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }
}
