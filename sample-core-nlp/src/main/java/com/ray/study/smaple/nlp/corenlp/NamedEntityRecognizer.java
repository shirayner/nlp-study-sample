package com.ray.study.smaple.nlp.corenlp;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

/**
 * 命名实体识别
 *
 * @author r.shi 2021/5/11 16:01
 */
public class NamedEntityRecognizer {


    public void recognize(String text) {
        StanfordCoreNLP pipeline = getPipeline();
    }

    private StanfordCoreNLP getPipeline() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        return new StanfordCoreNLP(props);
    }


}
