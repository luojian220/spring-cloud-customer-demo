package com.luno.softone.springcloudcustomerdemo.dto;

/**
 * @author luojian
 * @version 1.0
 * @ClassName: HelloMessageDTO
 * @Reason: TODO ADD REASON(可选)
 * @date: 2018年12月19日 16:27
 * @company:
 * @since JDK 1.8
 */
public class HelloMessageDTO {


    private String name ;

    private String message;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloMessageDTO{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
