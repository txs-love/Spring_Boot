package com.example.springboot.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

/**
 * @author txssherry@gmail.com
 * @date 2023/1/24 8:28
 */
@Component
/**
 * 第一种,这个的values的注入方式
 * 第二种,指定配置文件 ——>  @ConfigurationProperties(prefix = "类名")
 *                      类名在application.yml当中配置
 * 第三种,配置指定路径的文件夹 ——> Spring.properties; @Value("${ 值 LastName}")
 * 只需要获取一小部分值的情况下面只要 Values
 * 如果需要大量使用文件的情况下面，那么我们需要使用  @ConfigurationProperties(prefix="application.yml当中的类名")
 */
// @ConfigurationProperties(prefix = "dog")``
//@PropertySource(value="classpath:Spring.properties")

@Validated // 数据校验验证数据格式;
public class Dog {
    @Email(message = " 邮箱错误 ")
    private String PersonId;
    private String FirstName;
    private String LastName;
    public Dog(){}
    public Dog(String personId, String firstName, String lastName) {
        PersonId = personId;
        FirstName = firstName;
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "model{" +
                "PersonId='" + PersonId + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
    public String getPersonId() {
        return PersonId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPersonId(String personId) {
        PersonId = personId;
    }
}
