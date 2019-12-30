package com.gonuclei.Assignment5.transactionService;

import com.gonuclei.Assignment5.bos.SubscriptionBo;
import com.gonuclei.Assignment5.entities.SubscriptionEntity;
import com.gonuclei.Assignment5.exception.BadRequestException;
import com.gonuclei.Assignment5.repository.MasterSubscriptionRepository;
import com.gonuclei.Assignment5.repository.SalveSubscriptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SubscriptionTransactionService {

    private final ModelMapper modelMapper;
    private final SalveSubscriptionRepository salveSubscriptionRepository;
    private final MasterSubscriptionRepository masterSubscriptionRepository;

    @Autowired
    public SubscriptionTransactionService(SalveSubscriptionRepository salveSubscriptionRepository, MasterSubscriptionRepository masterSubscriptionRepository) {
        this.salveSubscriptionRepository = salveSubscriptionRepository;
        this.masterSubscriptionRepository = masterSubscriptionRepository;
        this.modelMapper = new ModelMapper();
    }

    //StreamSupport.stream(databaseRepository.findAll().spliterator(),false)
    //                    .collect(Collectors.toList());

    public List<SubscriptionBo> getAllSubscriptions() {
        return Optional.of(salveSubscriptionRepository.findAll()
                .stream()
                .map(subscriptionEntity -> modelMapper.map(subscriptionEntity, SubscriptionBo.class))
                .collect(Collectors.toList())
        ).orElse(new ArrayList<>());
    }

    /**
     * Add subscription.
     *
     * @param subscriptionBO the subscription bo
     */
    public void addSubscription(SubscriptionBo subscriptionBO) {
        try {
            masterSubscriptionRepository.save(modelMapper.map(subscriptionBO, SubscriptionEntity.class));
        } catch (RuntimeException e) {
            throw new BadRequestException("Subscription Could not be added", HttpStatus.BAD_REQUEST);
        }
    }
}
