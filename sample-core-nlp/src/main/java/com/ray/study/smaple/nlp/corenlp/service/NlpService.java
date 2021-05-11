package com.ray.study.smaple.nlp.corenlp.service;

import java.util.List;

/**
 * description
 *
 * @author r.shi 2021/5/11 17:13
 */
public interface NlpService {

    /**
     * split text to clause
     * @param locale locale
     * @param text text
     * @return
     */
    List<String> clause(String locale, String text);

}
