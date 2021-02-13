package com.bridge.monitor.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2019/2/21 10:07
 **/
//@Configuration
/*public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String>filterChainDefinitionMap=new HashMap<>();
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/logout","anon");
        filterChainDefinitionMap.put("/recharge","anon");
        filterChainDefinitionMap.put("/rechargeScore","anon");
        filterChainDefinitionMap.put("/userLogin","anon");
        filterChainDefinitionMap.put("/js/*","anon");
        filterChainDefinitionMap.put("/img/*","anon");
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/list");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public Realm realm(){
        Realm realm=new Realm();
        return realm;
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager webSecurityManager=new DefaultWebSecurityManager();
        webSecurityManager.setRealm(realm());
        return webSecurityManager;
    }
}*/
