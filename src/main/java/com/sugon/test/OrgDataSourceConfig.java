package com.sugon.test;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
 
@Configuration
@MapperScan(basePackages = "com.sugon.dao.org",sqlSessionFactoryRef = "orgSqlSessionFactory")
public class OrgDataSourceConfig {
    
    @Bean(name = "orgDataSource")
    @ConfigurationProperties("spring.datasource.org")
    @Primary
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }
 
    @Bean(name = "orgSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("orgDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/sugon/mapper/*.xml"));
        return sessionFactoryBean.getObject();
    }
    
    @Bean(name = "orgTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("orgDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "orgSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("orgSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
