package com.daisihao.configuration;

import com.daisihao.common.DataSourceKey;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1、因为使用了@Configuration注解 SpringBoot启动时会扫描这个类
 * 2、初始化一个DynamicDataSource对象,该类继承AbstractRoutingDataSource(这个类可以根据某个key值动态切换Database)
 * 3、初始化一个HashMap,将名称和数据库连接对象放入Map
 * 4、使用@ConfigurationProperties(prefix="")注解和DataSourceBuilder.create().build(),创建配置的数据库连接
 * 5、DynamicDataSource设置默认数据库为master
 * 6、将所有节点放入DynamicDataSource
 * 7、设置ContextHolder中的dataSourceKeys,这个是所有的数据库名称
 * 8、设置ContextHolder中的slaveDataSourceKeys,这个是所有的从数据库名称
 */
@Configuration
public class DataSourceConfigurer {

    @Bean("master")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }


    @Bean("slaveAlpha")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave-alpha")
    public DataSource slaveAlpha() {
        return DataSourceBuilder.create().build();
    }

    @Bean("slaveBeta")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave-beta")
    public DataSource slaveBeta() {
        return DataSourceBuilder.create().build();
    }

    @Bean("slaveGamma")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave-gamma")
    public DataSource slaveGamma() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put(DataSourceKey.master.name(), master());
        dataSourceMap.put(DataSourceKey.slaveAlpha.name(), slaveAlpha());
        dataSourceMap.put(DataSourceKey.slaveBeta.name(), slaveBeta());
        dataSourceMap.put(DataSourceKey.slaveGamma.name(), slaveGamma());
        //设置默认为master节点
        dynamicDataSource.setDefaultTargetDataSource(master());
        //将所有节点放入动态链接池
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        //将所有节点名称放入 dataSourceKeys
        DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());
        //将所有从节点名称放入 slaveDataSourceKeys
        DynamicDataSourceContextHolder.slaveDataSourceKeys.addAll(dataSourceMap.keySet());
        DynamicDataSourceContextHolder.slaveDataSourceKeys.remove(DataSourceKey.master.name());
        return dynamicDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置实体类的位置
        sqlSessionFactoryBean.setTypeAliasesPackage("com.daisihao.pojo");
        //设置XML位置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mappers/*.xml"));
        //将所有节点放入sqlSessionFactoryBean
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}

