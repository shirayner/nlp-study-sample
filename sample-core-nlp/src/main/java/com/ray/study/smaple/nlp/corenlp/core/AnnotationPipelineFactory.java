package com.ray.study.smaple.nlp.corenlp.core;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.LanguageInfo;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * description
 *
 * @author r.shi 2021/5/11 20:27
 */
@Slf4j
public class AnnotationPipelineFactory {

    private AnnotationPipelineFactory() {
    }

    /**
     * see {@link LanguageInfo}
     */
    private static final List<String> LANGUAGES = Arrays.asList("en");
    private static final Map<String, StanfordCoreNLP> PIPELINE_MAP = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        LANGUAGES.forEach(language -> {
            StanfordCoreNLP pipeline = new StanfordCoreNLP(language);
            PIPELINE_MAP.put(language, pipeline);
        });
    }

    public static void initPipelines() {
        log.info("=================start load nlp pipeline.================");
        LANGUAGES.forEach(language -> {
            StanfordCoreNLP pipeline = PIPELINE_MAP.get(language);
            Annotation annotation = new Annotation("This is a test.");
            pipeline.annotate(annotation);
        });
        log.info("=================nlp pipeline loaded.================");
    }

    public static Optional<StanfordCoreNLP> getPipeline(String locale) {
        String lang = locale.split("-")[0];
        return Optional.ofNullable(PIPELINE_MAP.get(lang));
    }


}
