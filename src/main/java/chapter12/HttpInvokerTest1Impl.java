package chapter12;

/**
 * Created by zjb on 2019/11/17.
 */
public class HttpInvokerTest1Impl implements HttpInvokerTest1 {
    @Override
    public String getTestPo(String desp) {
        return "getTestPo " + desp;
    }
}
