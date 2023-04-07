package com.alipay.cloudrun.superapp;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaosiwei
 * @date 2023/04/07
 */
@SpringBootApplication
@NacosPropertySource(dataId = "${NACOS_DATAID}", autoRefreshed = true, type = ConfigType.YAML)
public class SuperappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperappApplication.class, args);
	}

}
