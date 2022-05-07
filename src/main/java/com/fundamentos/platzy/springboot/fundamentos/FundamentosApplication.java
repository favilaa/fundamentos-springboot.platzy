package com.fundamentos.platzy.springboot.fundamentos;

import com.fundamentos.platzy.springboot.fundamentos.bean.MiPractica;
import com.fundamentos.platzy.springboot.fundamentos.bean.MyBean;
import com.fundamentos.platzy.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.platzy.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzy.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.platzy.springboot.fundamentos.entity.User;
import com.fundamentos.platzy.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.platzy.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean mybean;

	private MyBeanWithDependency myBeanWithDependency;

	private MiPractica miPractica;

	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;



	public FundamentosApplication (@Qualifier("componentTwoImplements")ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MiPractica miPractica
	, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.mybean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.miPractica = miPractica;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejmploAnterior();
		saveUserInDatabase();
		getInformacionJpqFromUser();



	}
	private void getInformacionJpqFromUser(){
		LOGGER.info(userRepository.findByUserEmail("fer@gmail.com")
				.orElseThrow(() -> new RuntimeException("No se encontro al usuario")));

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort " + user));
	}

	private void saveUserInDatabase(){
		User user1= new User("Fer","fer@gmail.com", LocalDate.of(2021,03,20));
		User user2= new User("Shaid","shaid@gmail.com", LocalDate.of(2021,03,20));
		User user3= new User("Avila","avila@gmail.com", LocalDate.of(2020,	05,8));

		List<User> list = Arrays.asList(user1,user2,user3);
		list.stream().forEach(userRepository::save);


	}
	private void ejmploAnterior(){
		componentDependency.saludar();
		mybean.print();
		myBeanWithDependency.printWithDependency();
		miPractica.sum(0);
		System.out.println(myBeanWithProperties.fuction());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword() + "-" + userPojo.getAge());
		try{
			//error
			//int value = 10/0;
			//LOGGER.info("Mi valor: " + value);
		}catch (Exception e){
		LOGGER.error("Esto es un error al /0 " + e.getMessage());
		}
	}
}
