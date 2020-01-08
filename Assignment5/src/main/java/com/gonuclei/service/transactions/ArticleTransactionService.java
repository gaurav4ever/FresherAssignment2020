package com.gonuclei.service.transactions;

import com.gonuclei.bos.ArticleBo;
import com.gonuclei.dto.ArticleDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * The type Article transaction service.
 */
@Service
public class ArticleTransactionService {

    private final ModelMapper modelMapper;

    /**
     * Instantiates a new Article transaction service.
     */
    public ArticleTransactionService() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * Gets article dto.
     *
     * @param article the article
     * @return the article dto
     */
    public ArticleDto getArticleDto(ArticleBo article) {
        return modelMapper.map(article, ArticleDto.class);
    }
}
