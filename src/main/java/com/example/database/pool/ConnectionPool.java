package com.example.database.pool;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Map;

public class ConnectionPool implements InitializingBean, DisposableBean {
    private final String username;
    private final Integer poolSize;
    private final List<Object> args;
    private Map<String, Object> properties;

    public ConnectionPool(String username, Integer poolSize, List<Object> args) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
    }

    public ConnectionPool(String username, Integer poolSize, List<Object> args, Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    private void init() {
        System.out.println("2) Init connection pool");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("1) Properties set");
    }

    private void destroyBean() {
        System.out.println("2) Clean Connection Pool");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("1) Destroy Connection Pool");
    }
}
