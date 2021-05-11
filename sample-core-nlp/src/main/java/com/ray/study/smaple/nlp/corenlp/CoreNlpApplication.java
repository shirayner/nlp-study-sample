package com.ray.study.smaple.nlp.corenlp;

import com.ray.study.smaple.nlp.corenlp.core.AnnotationPipelineFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Application
 *
 * @author r.shi 2021/5/11 17:07
 */
@SpringBootApplication
public class CoreNlpApplication {

    public static void main(String[] args) {
        AnnotationPipelineFactory.initPipelines();
        SpringApplication.run(CoreNlpApplication.class, args);
    }

}
