package com.gonuclei.service.transactions;

import com.gonuclei.dto.NewsLetterDto;
import com.gonuclei.entities.NewsLetterEntity;
import com.gonuclei.exception.BadRequestException;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.repository.MasterNewsLetterRepository;
import com.gonuclei.repository.SalveNewsLetterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type News letter transaction service.
 */
@Service
public class NewsLetterTransactionService {

    private final ModelMapper modelMapper;
    private final SalveNewsLetterRepository salveNewsLetterRepository;
    private final MasterNewsLetterRepository masterNewsLetterRepository;

    /**
     * Instantiates a new News letter transaction service.
     *
     * @param salveNewsLetterRepository  the salve news letter repository
     * @param masterNewsLetterRepository the master news letter repository
     */
    @Autowired
    public NewsLetterTransactionService(SalveNewsLetterRepository salveNewsLetterRepository, MasterNewsLetterRepository masterNewsLetterRepository) {
        this.salveNewsLetterRepository = salveNewsLetterRepository;
        this.masterNewsLetterRepository = masterNewsLetterRepository;
        this.modelMapper = new ModelMapper();
    }

    //StreamSupport.stream(databaseRepository.findAll().spliterator(),false)
    //                    .collect(Collectors.toList());

    /**
     * Gets all subscriptions.
     *
     * @return the all subscriptions
     */
    public List<NewsLetterDto> getAllNewsLetters() {
        return Optional.of(salveNewsLetterRepository.findAll()
                .stream()
                .map(subscriptionEntity -> modelMapper.map(subscriptionEntity, NewsLetterDto.class))
                .collect(Collectors.toList())
        ).orElse(new ArrayList<>());
    }

    /**
     * Gets subscription.
     *
     * @param id the id
     * @return the subscription
     * @throws NewsLetterNotFound the news letter not found
     */
    public NewsLetterDto getNewsLetter(Long id) throws NewsLetterNotFound {

        final NewsLetterEntity obtainedSubscription = salveNewsLetterRepository.findById(id).orElseThrow(NewsLetterNotFound::new);
        return modelMapper.map(obtainedSubscription, NewsLetterDto.class);
    }

    /**
     * Add subscription.
     *
     * @param newsLetterDto the news letter dto
     */
    public void addNewsLetter(NewsLetterDto newsLetterDto) {
        try {
            masterNewsLetterRepository.save(modelMapper.map(newsLetterDto, NewsLetterEntity.class));
        } catch (RuntimeException e) {
            throw new BadRequestException("Subscription Could not be added", HttpStatus.BAD_REQUEST);
        }
    }
}
