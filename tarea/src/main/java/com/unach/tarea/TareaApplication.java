package com.unach.tarea;

import com.unach.tarea.presentacion.TareaApplicationFx;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TareaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TareaApplication.class, args);
		Application.launch(TareaApplicationFx.class,args);
	}

}
