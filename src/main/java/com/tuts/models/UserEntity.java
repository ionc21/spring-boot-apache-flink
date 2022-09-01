package com.tuts.models;

import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@ToString
public class UserEntity implements java.io.Serializable {

  enum MaritalStatus {
    SINGLE,
    MARRIED,
    DIVORCED,
  }

  private String firstName;
  private String lastName;
  private LocalDate dob;
  private MaritalStatus maritalStatus;
  public UUID id;

  public UserEntity() {}

  public UserEntity(final String firstName, final String lastName, final LocalDate dob, final String maritalStatus)
    throws Exception {
    String[] maritalStatuses = new String[] { "SINGLE", "MARRIED", "DIVORCED" };
    boolean includesStatus = false;

    for (String mStatus : maritalStatuses) if (mStatus.equalsIgnoreCase(maritalStatus)) includesStatus = true;

    if (!includesStatus) throw new Exception("[invalid_marital_status]");

    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.maritalStatus = MaritalStatus.valueOf(maritalStatus.toUpperCase());
    this.id = UUID.randomUUID();
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setDob(final LocalDate dob) {
    this.dob = dob;
  }

  public LocalDate getDob() {
    return this.dob;
  }

  public void setMaritalStatus(final String maritalStatus) throws Exception {
    String[] maritalStatuses = new String[] { "SINGLE", "MARRIED", "DIVORCED" };
    boolean includesStatus = false;

    for (String mStatus : maritalStatuses) if (mStatus.equalsIgnoreCase(maritalStatus)) includesStatus = true;

    if (!includesStatus) throw new Exception("[invalid_marital_status]");

    this.maritalStatus = MaritalStatus.valueOf(maritalStatus.toUpperCase());
  }

  public MaritalStatus getMaritalStatus() {
    return this.maritalStatus;
  }
}
