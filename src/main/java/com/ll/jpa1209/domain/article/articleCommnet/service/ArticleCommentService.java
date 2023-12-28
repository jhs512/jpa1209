package com.ll.jpa1209.domain.article.articleCommnet.service;

//30강, 1번 회원이 작성한 댓글 찾기, ArticleComment 에 author 필드가 있으니 쉽다.
import com.ll.jpa1209.domain.article.articleCommnet.entity.ArticleComment;
import com.ll.jpa1209.domain.article.articleCommnet.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
        private final ArticleCommentRepository articleCommentRepository;

        public List<ArticleComment> findByAuthorId(long authorId){
            return articleCommentRepository.findByAuthorId(authorId);
        }


}
