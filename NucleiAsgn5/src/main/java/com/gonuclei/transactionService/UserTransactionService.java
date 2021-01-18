package com.gonuclei.transactionService;

import com.gonuclei.models.bo.UserBo;
import com.gonuclei.models.entities.UserEntity;
import com.gonuclei.repo.master.MasterUserRepository;
import com.gonuclei.repo.slave.SlaveUserRepository;
import com.gonuclei.mapper.UserObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type User transaction service.
 */
//interacts with db (use user entity)
@Service
public class UserTransactionService {

  /**
   * The Slave user repository.
   */
  @Autowired
  private SlaveUserRepository slaveUserRepository;

  /**
   * The Master user repository.
   */
  @Autowired
  private MasterUserRepository masterUserRepository;

  /**
   * The User object mapper.
   */
  @Autowired
  private UserObjectMapper userObjectMapper;

  /**
   * Signup transaction boolean.
   *
   * @param userBo the user bo
   * @return the boolean
   */
  public boolean signupTransaction(UserBo userBo) {

    UserEntity userEntity = userObjectMapper.userBoToUserEntity(userBo);
    if (!slaveUserRepository.existsByEmailId(userEntity.getEmailId())) {
      masterUserRepository.save(userEntity);
      return true;
    } else {
      return false;
    }
  }
}
