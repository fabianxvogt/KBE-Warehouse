package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		initFirebase();
		// Get database
		Firestore db = FirestoreClient.getFirestore();


		// Run Spring App
		SpringApplication.run(Application.class, args);
	}

	private static void initFirebase() {
		// Use the application default credentials
		try{
			FileInputStream serviceAccount =
				new FileInputStream("../kbe-warehouse-credentials.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://kbe-warehouse-default-rtdb.firebaseio.com")
				.build();
	
			FirebaseApp.initializeApp(options);
			java.lang.System.out.println("Firebase initialized!");
		} catch (IOException e) {
			java.lang.System.out.println("Credentials not found!");
		}		
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
