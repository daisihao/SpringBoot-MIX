package com.daisihao.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 在Spring 2.0.1中引入了AbstractRoutingDataSource,
 * 该类充当了DataSource的路由中介, 能有在运行时, 根据某种key值来动态切换到真正的DataSource上。
 * 具体实现类在com.daisihao.DynamicDataSourceContextHolder中的getDataSourceKey()方法
 * getDataSourceKey():该方法初始化名称为master,如果手动设置,则会随机返回一个salve名词
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }
}
