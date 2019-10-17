package chapter4;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;


/**
 * Created by zjb on 2019/10/16.
 * 用于解析xsd文件中的定义和组件定义
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    //Element 对应的类
    public Class getBeanClass(Element element) {
        return User.class;
    }

    //从element解析并提取对应的元素

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        //将提取的数据放入到BeanDefinitionBuilder中，待到完成所有的bean解析后统一注册到beanFactory
        if (StringUtils.hasText(userName)) {
            builder.addPropertyValue("userName", userName);
            builder.addPropertyValue("email", email);
        }
        super.doParse(element, builder);
    }
}
