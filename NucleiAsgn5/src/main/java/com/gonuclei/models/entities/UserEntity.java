package com.gonuclei.models.entities;

import com.gonuclei.models.AbstractUserModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type User entity.
 */
@Entity
@Table(name = "users")
public class UserEntity extends AbstractUserModel {

}
