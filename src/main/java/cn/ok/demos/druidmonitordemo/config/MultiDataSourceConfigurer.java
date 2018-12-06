package cn.ok.demos.druidmonitordemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Druid 多数据源配置
 *
 * @author kyou on 2018-12-06 10:57
 */
@Configuration
public class MultiDataSourceConfigurer {
    @Primary
    @Bean(initMethod = "init")
    @ConfigurationProperties("spring.datasource.druid")
    public DruidDataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(initMethod = "init")
    @ConfigurationProperties("spring.datasource.druid.mydb")
    public DruidDataSource dataSourceMydb() {
        return DruidDataSourceBuilder.create().build();
    }
}
