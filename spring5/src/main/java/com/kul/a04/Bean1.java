package com.kul.a04;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Slf4j
public class Bean1 {

    private Bean2 bean2;

    @Autowired
    public void setBean2(Bean2 bean2) {
        log.info("@Autowired生效: {}" , bean2);
        this.bean2 = bean2;
    }

    @Autowired
    private Bean3 bean3;

    @Resource
    public void setBean3(Bean3 bean3) {
        log.info("@Resource生效: {}", bean3);
        this.bean3 = bean3;
    }

    private String home;

    @Autowired
    public void setHome(@Value("${JAVA_HOME}") String home) {
        log.info("@Value生效: {}" , home);
        this.home = home;
    }

    @PostConstruct
    public void init() {
        log.info("@PostConstruct 生效");
    }

    @PreDestroy
    public void destroy() {
        log.info("@PreDestroy 生效");
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "bean2=" + bean2 +
                ", bean3=" + bean3 +
                ", home='" + home + '\'' +
                '}';
    }
}
