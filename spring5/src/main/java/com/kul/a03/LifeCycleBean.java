package com.kul.a03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleBean {

    private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

    public LifeCycleBean() {
        log.info("构造方法");
    }

    @Autowired
    public void autowired(@Value("${JAVA_HOME}") String home) {
        log.info("依赖注入: {}", home);
    }

    @PostConstruct
    public void init() {
        log.info("初始化");
    }

    @PreDestroy
    public void destroy() {
        log.info("销毁");
    }

}
