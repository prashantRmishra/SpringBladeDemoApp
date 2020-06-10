package com.example.config;

import javax.sql.DataSource;

import com.blade.Blade;
import com.blade.ioc.annotation.Bean;
import com.blade.loader.BladeLoader;

import org.apache.commons.dbcp2.BasicDataSource;
@Bean
public class DatabaseConfig implements BladeLoader {
private BasicDataSource dataSource;
    @Override
    public void load(Blade blade) {
        this.dataSource = new BasicDataSource();
        dataSource.setDriverClassName(blade.environment().getOrNull("spring.datasource.driver-class-name"));
        dataSource.setUrl(blade.environment().getOrNull("spring.datasource.url"));
        dataSource.setUsername(blade.environment().getOrNull("spring.datasource.username"));
        dataSource.setPassword(blade.environment().getOrNull("spring.datasource.password"));
        dataSource.setInitialSize(15);
        dataSource.setMaxTotal(8);
        dataSource.setMinIdle(8);
        dataSource.setMaxWaitMillis(6000);

    }
    public DataSource getDataSource(){
        return this.dataSource;
    }
    
}