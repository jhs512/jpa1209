package com.ll.jpa1209.domain.article.articleTag.Service;

//31강, 1번 회원이 게시물에 추가한 태그 찾기, findByArticle_authorId 도입
import com.ll.jpa1209.domain.article.articleTag.entity.ArticleTag;
import com.ll.jpa1209.domain.article.articleTag.repository.ArticleTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {

    private final ArticleTagRepository articleTagRepository;

    public List<ArticleTag> findByAuthorId(long authorId){
        return articleTagRepository.findArticle_authorId(authorId);

    }


}
