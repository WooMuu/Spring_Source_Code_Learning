package chapter4;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by zjb on 2019/10/16.
 * 目的是将组件注册到spring容器
 */
public class MynamespaceHander extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
