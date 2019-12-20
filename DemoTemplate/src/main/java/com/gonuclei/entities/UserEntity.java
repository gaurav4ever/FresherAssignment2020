package com.gonuclei.entities;

import com.gonuclei.models.AbstractUser;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type User entity.
 */
@Entity
@Table(name = "users")
public class UserEntity extends AbstractUser {

}
