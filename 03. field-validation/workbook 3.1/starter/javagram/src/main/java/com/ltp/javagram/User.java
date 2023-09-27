package com.ltp.javagram;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
  @NotBlank(message = "First name can't be blank")
  @Size(min = 2, message = "First name must be at least 2 characters")
  private String firstName;
  @NotBlank(message = "Last name can't be blank")
  @Size(min = 2, message = "Last name must be at least 2 characters")
  private String lastName;
  @NotBlank(message = "Please choose a username")
  @Size(min = 7, message = "Username must be at least 7 characters")
  private String username;
  @Email(message = "Please enter a valid email address.")
  private String email;
  @Past(message = "Date of birth must be in the past.")
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
