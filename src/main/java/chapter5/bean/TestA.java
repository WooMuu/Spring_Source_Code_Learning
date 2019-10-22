package chapter5.bean;

/**
 * Created by zjb on 2019/10/21.
 */
public class TestA {
private TestB testB;

    public TestA(TestB testB) {
        this.testB = testB;
    }

    public TestA() {
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
