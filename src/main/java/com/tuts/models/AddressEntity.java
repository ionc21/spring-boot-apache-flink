package com.tuts.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
public class AddressEntity implements java.io.Serializable {

  public UUID userId;
  private Integer houseNumber;
  private String streetName;
  private String cityName;
  private String stateName;
  private String countryName;
}
