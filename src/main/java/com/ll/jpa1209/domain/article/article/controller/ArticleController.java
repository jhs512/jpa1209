package com.ll.jpa1209.domain.article.article.controller;


import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.domain.article.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(
            @RequestParam(value = "kwType", defaultValue = "") List<String> kwTypes,
            @RequestParam(defaultValue = "0") int page,
            Model model
    ) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        Map<String, Boolean> kwTypesMap = kwTypes
                .stream()
                .collect(Collectors.toMap(
                        kwType -> kwType,
                        kwType -> true
                ));
        Page<Article> itempage = articleService.search(pageable);
        model.addAttribute("itemsPage", itempage);
        model.addAttribute("kwTypesMap", kwTypesMap);
        return "article/list";

    }

}
