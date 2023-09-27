package com.ltp.javagram;

import java.sql.Date;

public class User {
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private Date dateOfBirth;

  public User(String firstName, String lastName, String username, String email, Date dateOfBirth) {
    setFirstName(firstName);
    setLastName(lastName);
    setUsername(username);
    setEmail(email);
    setDateOfBirth(dateOfBirth);
  }

  public User() {
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
