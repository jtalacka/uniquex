package com.uniquex.studentsorting;

import com.uniquex.studentsorting.Controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;

@SpringBootApplication
public class StudentSortingApplication{

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(StudentSortingApplication.class)
                .headless(false).run(args);
        MainController mainFrame = (MainController) context.getBean("MainController");
        mainFrame.setArgs(args);
        mainFrame.init();

    }
}
