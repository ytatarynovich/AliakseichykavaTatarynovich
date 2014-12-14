http://localhost:8080/BankApp/home


http://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html



<bean id="dataSource"
	class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	<property name="driverClassName" value="${jdbc.driverClassName}" />
	<property name="url" value="${jdbc.url}" />
	<property name="username" value="${jdbc.username}" />
	<property name="password" value="${jdbc.password}" />
</bean>

<jdbc:initialize-database data-source="dataSource" ignore-failures="DROPS">
	<jdbc:script location="classpath:/schema.sql" />
	<!-- jdbc:script location="classpath:/data.sql" / -->
</jdbc:initialize-database>



<!-- jdbc:embedded-database id="dataSource" type="H2">
		<jdbc:script location="classpath:/schema.sql"/>
		<jdbc:script location="classpath:/data.sql"/>
	</jdbc:embedded-database -->








	<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="packagesToScan" >
			<list>
				<value>com.epam.jmp.bank</value>
			</list>
		</property>

		<property name="dataSource" ref="dataSource"/>
		<property name="jpaVendorAdapter">
			<bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
		</bean>
		</property>
	</bean> 

	<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
		<property name="entityManagerFactory" ref="entityManagerFactory" />
	</bean>

	<tx:annotation-driven transaction-manager="transactionManager" />
	
	
	
	
	
	
	
	
	
	
	
	
	<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:jdbc="http://www.springframework.org/schema/jdbc"
	xmlns:jpa="http://www.springframework.org/schema/data/jpa"
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd

		http://www.springframework.org/schema/tx 
		http://www.springframework.org/schema/tx/spring-tx.xsd

		http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context.xsd

		http://www.springframework.org/schema/jdbc 
		http://www.springframework.org/schema/jdbc/spring-jdbc.xsd
		http://www.springframework.org/schema/data/jpa
		http://www.springframework.org/schema/data/jpa/spring-jpa.xsd">