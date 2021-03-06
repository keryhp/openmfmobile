/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2014-07-22 21:53:01 UTC)
 * on 2014-08-14 at 11:00:14 UTC 
 * Modify at your own risk.
 */

package com.appspot.openmicrofinance.clientsapi.model;

/**
 * Model definition for OpenMFClient.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the clientsapi. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class OpenMFClient extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String accountNumber;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String activationdate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean active;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String address;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String balance;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean blacklisted;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String clientclassification;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String clienttype;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String contact;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String createdById;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String dateofbirth;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean eligible;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String externalId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String forename;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String gender;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String groupid;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String midname;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String office;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String submittedon;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String supervisor;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String surname;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long timestamp;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAccountNumber() {
    return accountNumber;
  }

  /**
   * @param accountNumber accountNumber or {@code null} for none
   */
  public OpenMFClient setAccountNumber(java.lang.String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getActivationdate() {
    return activationdate;
  }

  /**
   * @param activationdate activationdate or {@code null} for none
   */
  public OpenMFClient setActivationdate(java.lang.String activationdate) {
    this.activationdate = activationdate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getActive() {
    return active;
  }

  /**
   * @param active active or {@code null} for none
   */
  public OpenMFClient setActive(java.lang.Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAddress() {
    return address;
  }

  /**
   * @param address address or {@code null} for none
   */
  public OpenMFClient setAddress(java.lang.String address) {
    this.address = address;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBalance() {
    return balance;
  }

  /**
   * @param balance balance or {@code null} for none
   */
  public OpenMFClient setBalance(java.lang.String balance) {
    this.balance = balance;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getBlacklisted() {
    return blacklisted;
  }

  /**
   * @param blacklisted blacklisted or {@code null} for none
   */
  public OpenMFClient setBlacklisted(java.lang.Boolean blacklisted) {
    this.blacklisted = blacklisted;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getClientclassification() {
    return clientclassification;
  }

  /**
   * @param clientclassification clientclassification or {@code null} for none
   */
  public OpenMFClient setClientclassification(java.lang.String clientclassification) {
    this.clientclassification = clientclassification;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getClienttype() {
    return clienttype;
  }

  /**
   * @param clienttype clienttype or {@code null} for none
   */
  public OpenMFClient setClienttype(java.lang.String clienttype) {
    this.clienttype = clienttype;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getContact() {
    return contact;
  }

  /**
   * @param contact contact or {@code null} for none
   */
  public OpenMFClient setContact(java.lang.String contact) {
    this.contact = contact;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCreatedById() {
    return createdById;
  }

  /**
   * @param createdById createdById or {@code null} for none
   */
  public OpenMFClient setCreatedById(java.lang.String createdById) {
    this.createdById = createdById;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDateofbirth() {
    return dateofbirth;
  }

  /**
   * @param dateofbirth dateofbirth or {@code null} for none
   */
  public OpenMFClient setDateofbirth(java.lang.String dateofbirth) {
    this.dateofbirth = dateofbirth;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getEligible() {
    return eligible;
  }

  /**
   * @param eligible eligible or {@code null} for none
   */
  public OpenMFClient setEligible(java.lang.Boolean eligible) {
    this.eligible = eligible;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getExternalId() {
    return externalId;
  }

  /**
   * @param externalId externalId or {@code null} for none
   */
  public OpenMFClient setExternalId(java.lang.String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getForename() {
    return forename;
  }

  /**
   * @param forename forename or {@code null} for none
   */
  public OpenMFClient setForename(java.lang.String forename) {
    this.forename = forename;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getGender() {
    return gender;
  }

  /**
   * @param gender gender or {@code null} for none
   */
  public OpenMFClient setGender(java.lang.String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getGroupid() {
    return groupid;
  }

  /**
   * @param groupid groupid or {@code null} for none
   */
  public OpenMFClient setGroupid(java.lang.String groupid) {
    this.groupid = groupid;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public OpenMFClient setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMidname() {
    return midname;
  }

  /**
   * @param midname midname or {@code null} for none
   */
  public OpenMFClient setMidname(java.lang.String midname) {
    this.midname = midname;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getOffice() {
    return office;
  }

  /**
   * @param office office or {@code null} for none
   */
  public OpenMFClient setOffice(java.lang.String office) {
    this.office = office;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSubmittedon() {
    return submittedon;
  }

  /**
   * @param submittedon submittedon or {@code null} for none
   */
  public OpenMFClient setSubmittedon(java.lang.String submittedon) {
    this.submittedon = submittedon;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSupervisor() {
    return supervisor;
  }

  /**
   * @param supervisor supervisor or {@code null} for none
   */
  public OpenMFClient setSupervisor(java.lang.String supervisor) {
    this.supervisor = supervisor;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSurname() {
    return surname;
  }

  /**
   * @param surname surname or {@code null} for none
   */
  public OpenMFClient setSurname(java.lang.String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * @param timestamp timestamp or {@code null} for none
   */
  public OpenMFClient setTimestamp(java.lang.Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  @Override
  public OpenMFClient set(String fieldName, Object value) {
    return (OpenMFClient) super.set(fieldName, value);
  }

  @Override
  public OpenMFClient clone() {
    return (OpenMFClient) super.clone();
  }

}
