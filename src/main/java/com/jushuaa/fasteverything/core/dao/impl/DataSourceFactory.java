package com.jushuaa.fasteverything.core.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import javafx.scene.chart.PieChart;

import javax.activation.DataSource;
import java.io.File;
import java.io.InputStream;

public class DataSourceFactory {
    /**
     * 数据源-单例
     */
    private static volatile DruidDataSource dataSource;
    private DataSourceFactory(){
    }
    public  static DataSource dataSource() {
        if (dataSource == null) {
            synchronized (DataSourceFactory.class) {
                if (dataSource == null) {
                    //实例化
                    dataSource = new DruidDataSource();
                    dataSource.setDriverClassName("org.h2.Driver");
                    //URL，username，password
                    //采用的是H2的嵌入式数据库，数据库以及本地文件的方式储存，只需要提供url接口
                    //获取当前工程路径
                    String workDir = System.getProperty("user.dir");
                    dataSource.setUrl("jdbc:h2:" + workDir + File.separator + "fasteverything");
                }
            }

        }
        return (DataSource) dataSource;
    }
    public static void initDatabase(){
        //获取数据源
        //获取SQL语句
        InputStream in =DataSourceFactory.class.getClass().getResourceAsStream("fasteverything.sql");
    }
    public static void main(String[] args) {
        DataSourceFactory.initDatabase();
    }
}
