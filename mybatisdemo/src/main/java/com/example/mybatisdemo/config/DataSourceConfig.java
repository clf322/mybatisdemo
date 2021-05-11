package com.example.mybatisdemo.config;/**
 * @Author: LongfeiChen
 * @Description:
 * @Date: Created in 23:23 2021/5/9
 * @Modified By:
 */
import java.io.PrintWriter;

import java.util.logging.Logger;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 *ClassName DataSourceConfig
 *@Description TODO
 *@Author: longfei
 *@Date: 2021/5/9 23:23
 *@Version 1.0
 **/
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DataSource();

    }



}
