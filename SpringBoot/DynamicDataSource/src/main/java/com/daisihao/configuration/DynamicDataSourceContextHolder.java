package com.daisihao.configuration;


import com.daisihao.common.DataSourceKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * 切换数据库的实现类
 */
public class DynamicDataSourceContextHolder {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceKey.class);

    private static int counter = 0;
    //初始化线程名称为master
    private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceKey.master::name);
    //定义所有的数据库节点名
    public static List<Object> dataSourceKeys = new ArrayList<>();
    //定义所有的从数据库节点名
    public static List<Object> slaveDataSourceKeys = new ArrayList<>();
    //设置线程名称为master
    public static void useMasterDataSource() {
        CONTEXT_HOLDER.set(DataSourceKey.master.name());
    }
    //轮询算法,将线程名称设置为slave中的一个
    public static void useSlaveDataSource() {
        try {
            int datasourceKeyIndex = counter % slaveDataSourceKeys.size();
            CONTEXT_HOLDER.set(String.valueOf(slaveDataSourceKeys.get(datasourceKeyIndex)));
            counter++;
            logger.info("===打印从线程名称==="+CONTEXT_HOLDER.get());
        } catch (Exception e) {
            useMasterDataSource();
            e.printStackTrace();
        }
    }
    //判断节点是否在数据库连接池中
    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }


    public static void setDataSourceKey(String key) {
        CONTEXT_HOLDER.set(key);
    }
    //数据库路由中介调用的方法,返回线程的名称
    public static String getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }
    //释放本地线程变量
    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }
}
