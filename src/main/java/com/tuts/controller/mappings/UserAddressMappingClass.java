package com.tuts.controller.mappings;

import com.tuts.models.AddressEntity;
import com.tuts.models.UserEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class UserAddressMappingClass implements java.io.Serializable {

  public UserEntity user;
  public AddressEntity address;
}
