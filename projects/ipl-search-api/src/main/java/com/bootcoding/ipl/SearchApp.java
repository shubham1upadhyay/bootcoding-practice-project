package com.bootcoding.ipl;

import com.bootcoding.ipl.model.DataRequest;
import com.bootcoding.ipl.model.DataResponse;
import com.bootcoding.ipl.store.InMemoryDataStore;
import com.bootcoding.ipl.utils.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.io.File;


/**
 * <b>SearchApp</b> is a bootcoding's project practice application
 * where demonstrating how to build Rest API using Spring Boot in Java
 */
@SpringBootApplication
public class SearchApp implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(SearchApp.class, args);
    }

    @Autowired
    private InMemoryDataStore memoryDataStore;

    private DataResponse response;

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("Application is started...");
    }

    @Bean
    @Scope("singleton")
    public DataResponse dataResponse(){
        if(null == response){
            response = memoryDataStore.load(DataRequest.builder().filePath(FileUtility.inputFile()).build());
        }
        return response;
    }
}
