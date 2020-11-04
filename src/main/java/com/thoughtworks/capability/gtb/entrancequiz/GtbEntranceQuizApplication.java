package com.thoughtworks.capability.gtb.entrancequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}

}

// TODO GTB-综合: * 使用了数据库，需求文档要求将数据存储在内存中
// TODO GTB-完成度: * 完成了大部分功能，没有做异常处理
// TODO GTB-测试: * 包含了对Controller的测试，cover了happy pass
// TODO GTB-知识点: * Spring MVC相关的知识点掌握的不错
