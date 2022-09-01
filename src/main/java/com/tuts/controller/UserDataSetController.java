package com.tuts.controller;

import com.tuts.controller.mappings.UserAddressMappingClass;
import com.tuts.models.AddressEntity;
import com.tuts.models.UserEntity;
import com.tuts.utils.Selectors;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1")
public class UserDataSetController {

  @GetMapping("/users")
  public List<UserEntity> entities() {
    try {
      ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
      DataSet<UserEntity> userEntityDataSet = env.fromCollection(
              List.of(new UserEntity("Kingsley", "Victor", LocalDate.of(1998, 10, 30), "SINGLE"))
      );
      return userEntityDataSet.collect();
    } catch (Exception exc) {
      exc.printStackTrace();
      return null;
    }
  }

  @GetMapping("/users_addresses")
  public List<UserAddressMappingClass> usersAndAddresses() {
    try {
      ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

      UserEntity user1 = new UserEntity("Kingsley", "Victor", LocalDate.of(1998, 10, 30), "SINGLE");
      UserEntity user2 = new UserEntity("Jackson", "Willie", LocalDate.of(1997, 12, 10), "MARRIED");

      AddressEntity address1 = new AddressEntity(user1.id, 1, "Mount Zion close", "Lagos", "Lagos", "Nigeria");
      AddressEntity address2 = new AddressEntity(user2.id, 9, "Curacao", "Buffalo", "New York", "United States");

      DataSet<UserEntity> users = env.fromElements(user1, user2);
      DataSet<AddressEntity> addresses = env.fromElements(address1, address2);

      return addresses
        .join(users)
        .where(new Selectors.IdKeySelectorAddressEntity())
        .equalTo(new Selectors.IdKeySelectorUserEntity())
        .collect()
        .stream()
        .map(tuple -> new UserAddressMappingClass(tuple.f1, tuple.f0))
        .collect(Collectors.toList());
    } catch (Exception exc) {
      exc.printStackTrace();
      return null;
    }
  }
}
