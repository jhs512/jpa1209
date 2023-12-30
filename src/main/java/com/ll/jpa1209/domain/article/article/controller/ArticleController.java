package com.ll.jpa1209.domain.article.article.controller;

//37강, 게시물 리스트
import com.ll.jpa1209.domain.article.article.entity.Article;
import com.ll.jpa1209.domain.article.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
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
//39강, 파트 3, 1부
import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.stream.Collector;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(
            @RequestParam(value = "kwType", defaultValue = "")List<String> kwTypes,
            @RequestParam(defaultValue = "0") int page,
            Model model
    ){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page,10,Sort.by(sorts));

        Map<String,Boolean> kwTypesMap  = kwTypes
                .stream()
                .collect(Collector.toMap(
                   kwType ->kwType,
                   kwType -> true
                ));
        Page<Article> itempage = articleService.search(pageable);
        model.addAttribute("itemsPage",itemsPage);
        model.addAttribute("kwTypesMap",kwTypesMap);
        return "article/list";

    }

}
