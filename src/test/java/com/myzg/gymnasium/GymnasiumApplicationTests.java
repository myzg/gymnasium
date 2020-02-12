package com.myzg.gymnasium;



import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.myzg.gymnasium.exception.ErrorEnum;
import com.myzg.gymnasium.exception.ProgramException;

import com.myzg.gymnasium.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@SpringBootTest
class GymnasiumApplicationTests {



    @Autowired
    private JwtUtils jwtUtils;

//    @Test
//    public void test2() {
//        Page<Employee> employees = employeeMapper.selectPage(new Page<>(2,3),null);
//        List<Employee>  list = employees.getRecords();
//        list.forEach(System.out::println);
//        System.out.println("??????????");
//    }


    @Test
    void contextLoads() {
        AutoGenerator autoGenerator = new AutoGenerator();
        //全剧配置
        GlobalConfig globalConfig = new GlobalConfig();
        String dir = System.getProperty("user.dir");
        globalConfig.setOutputDir(dir+"/src/main/java");
        globalConfig.setAuthor("myzg");
        globalConfig.setOpen(false);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("zg138904");
        dataSourceConfig.setUrl("jdbc:mysql://49.234.98.192:3306/ftroom?useUnicode=true&useSSL=false&characterEncoding=utf8");

        //包设置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.myzg.gymnasium");


        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);

        autoGenerator.setGlobalConfig(globalConfig).setDataSource(dataSourceConfig).setPackageInfo(packageConfig).setStrategy(strategyConfig);
        autoGenerator.execute();
    }

    @Test
    public void test1(){

    }
}
