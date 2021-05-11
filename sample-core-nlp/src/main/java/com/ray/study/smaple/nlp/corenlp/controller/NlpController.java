package com.ray.study.smaple.nlp.corenlp.controller;

import com.ray.study.smaple.nlp.corenlp.controller.dto.ContentDto;
import com.ray.study.smaple.nlp.corenlp.service.NlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description
 *
 * @author r.shi 2021/5/11 17:10
 */
@RestController
@RequestMapping("/nlp")
public class NlpController {
    @Autowired
    NlpService nlpService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/clause")
    public List<String> clause(@RequestBody ContentDto dto) {
        return nlpService.clause(dto.getLocale(), dto.getText());
    }


}
