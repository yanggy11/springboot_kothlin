# springboot_kothlin

# 环境搭建

1. idea创建maven工程，在pom中引入springboot2.0、kothlin等依赖
```
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.6</java.version>
		<kotlin.version>1.2.21</kotlin.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.module</groupId>
			<artifactId>jackson-module-kotlin</artifactId>
		</dependency>
		<dependency>
			<groupId>org.jetbrains.kotlin</groupId>
			<artifactId>kotlin-stdlib-jdk8</artifactId>
		</dependency>
		<dependency>
			<groupId>org.jetbrains.kotlin</groupId>
			<artifactId>kotlin-reflect</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>
	</dependencies>
```

2. 其次，引入kothlin maven插件
```
<sourceDirectory>${project.basedir}/src/main/kotlin</sourceDirectory>
		<testSourceDirectory>${project.basedir}/src/test/kotlin</testSourceDirectory>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<artifactId>kotlin-maven-plugin</artifactId>
				<groupId>org.jetbrains.kotlin</groupId>
				<configuration>
					<args>
						<arg>-Xjsr305=strict</arg>
					</args>
					<compilerPlugins>
						<plugin>spring</plugin>
					</compilerPlugins>
				</configuration>
				<dependencies>
					<dependency>
						<groupId>org.jetbrains.kotlin</groupId>
						<artifactId>kotlin-maven-allopen</artifactId>
						<version>${kotlin.version}</version>
					</dependency>
				</dependencies>
			</plugin>
		</plugins>
```

3.创建主类SpringBootKothlinApplication.kit
```

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpringbootKothlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringbootKothlinApplication::class.javaObjectType, *args)
}
```

启动kothlin工程，如无报错，则基本环境搭建完毕。 

### ps: 也可以使用脚手架工程创建基本的开发环境（https://start.spring.io/），语言选择kothlin.

# 整合spring-data-jpa

1.在pom中添加mysql驱动、数据源、pa依赖
```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid</artifactId>
			<version>1.0.28</version>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
```
2. 创建application.yml文件
```
server:
  port: 1988

spring:
  application:
    name: springboot
  datasource:
    url: jdbc:mysql://rm-bp17330s3si44dsz7bo.mysql.rds.aliyuncs.com:3306/yanggy
    driver-class-name: com.mysql.jdbc.Driver
    username: root
    password: Ygy250725
    initialSize: 100
    minIdle: 1
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    type: com.alibaba.druid.pool.DruidDataSource
  jpa:
    hibernate:
      ddl-auto: update
```
至此，jpa整合完毕。下面进行简单的业务开发

创建model
