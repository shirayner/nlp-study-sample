package com.ray.study.smaple.nlp.corenlp.service.impl;

import com.ray.study.smaple.nlp.corenlp.core.AnnotationPipelineFactory;
import com.ray.study.smaple.nlp.corenlp.service.NlpService;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author r.shi 2021/5/11 17:14
 */
@Service
public class NlpServiceImpl implements NlpService {

    @Override
    public List<String> clause(String locale, String text) {
        Optional<StanfordCoreNLP> pipelineOptional = AnnotationPipelineFactory.getPipeline(locale);
        if (!pipelineOptional.isPresent()) {
            return Collections.emptyList();
        }

        StanfordCoreNLP pipeline = pipelineOptional.get();
        CoreDocument document = new CoreDocument(text);
        pipeline.annotate(document);
        return document.sentences().stream().map(CoreSentence::text).collect(Collectors.toList());
    }
}
