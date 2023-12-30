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

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(
            @RequestParam(value = "page", defaultValue = "0") int page,
            Model model
    ){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page,10,Sort.by(sorts));

        Page<Article> itempage = articleService.search(pageable);
        model.addAttribute("itemPage",itemPage);

        return "article/list";

    }

}
