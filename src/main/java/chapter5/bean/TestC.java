package chapter5.bean;

/**
 * Created by zjb on 2019/10/21.
 */
public class TestC {

    private TestA testA;

    public TestC(TestA testA) {
        this.testA = testA;
    }

    public TestC() {
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
