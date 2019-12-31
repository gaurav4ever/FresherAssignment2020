package com.gonuclei.service.transactions;

import com.gonuclei.bos.ArticleBo;
import com.gonuclei.dto.ArticleDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ArticleTransactionService {

    private final ModelMapper modelMapper;

    public ArticleTransactionService() {
        this.modelMapper = new ModelMapper();
    }

    public ArticleDto getArticleDto(ArticleBo article) {
        return modelMapper.map(article, ArticleDto.class);
    }
}
