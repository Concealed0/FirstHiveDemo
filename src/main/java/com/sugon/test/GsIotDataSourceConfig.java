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
@MapperScan(basePackages = "com.sugon.dao.gsiot",sqlSessionFactoryRef = "gsiotSqlSessionFactory")
public class GsIotDataSourceConfig {
    
    @Bean(name = "gsiotDataSource")
    @ConfigurationProperties("spring.datasource.gsiot")
    @Primary
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "gsiotSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("gsiotDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/sugon/mapper/*.xml"));
        return sessionFactoryBean.getObject();
    }
    //未知变量
    @Bean(name = "gsiotTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("gsiotDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "gsiotSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("gsiotSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
