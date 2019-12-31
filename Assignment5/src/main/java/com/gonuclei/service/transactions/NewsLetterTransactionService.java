package com.gonuclei.service.transactions;

import com.gonuclei.bos.NewsLetterBo;
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

@Service
public class NewsLetterTransactionService {

    private final ModelMapper modelMapper;
    private final SalveNewsLetterRepository salveNewsLetterRepository;
    private final MasterNewsLetterRepository masterNewsLetterRepository;

    @Autowired
    public NewsLetterTransactionService(SalveNewsLetterRepository salveNewsLetterRepository, MasterNewsLetterRepository masterNewsLetterRepository) {
        this.salveNewsLetterRepository = salveNewsLetterRepository;
        this.masterNewsLetterRepository = masterNewsLetterRepository;
        this.modelMapper = new ModelMapper();
    }

    //StreamSupport.stream(databaseRepository.findAll().spliterator(),false)
    //                    .collect(Collectors.toList());

    public List<NewsLetterBo> getAllSubscriptions() {
        return Optional.of(salveNewsLetterRepository.findAll()
                .stream()
                .map(subscriptionEntity -> modelMapper.map(subscriptionEntity, NewsLetterBo.class))
                .collect(Collectors.toList())
        ).orElse(new ArrayList<>());
    }

    public NewsLetterBo getSubscription(Integer id) throws NewsLetterNotFound {

        final NewsLetterEntity obtainedSubscription = salveNewsLetterRepository.findById(id).orElseThrow(NewsLetterNotFound::new);
        return modelMapper.map(obtainedSubscription, NewsLetterBo.class);
    }

    /**
     * Add subscription.
     *
     * @param newsLetterBO the subscription bo
     */
    public void addSubscription(NewsLetterBo newsLetterBO) {
        try {
            masterNewsLetterRepository.save(modelMapper.map(newsLetterBO, NewsLetterEntity.class));
        } catch (RuntimeException e) {
            throw new BadRequestException("Subscription Could not be added", HttpStatus.BAD_REQUEST);
        }
    }
}
