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
 * on 2014-08-14 at 10:56:12 UTC 
 * Modify at your own risk.
 */

package com.appspot.openmicrofinance.usersapi;

/**
 * Service definition for Usersapi (v1).
 *
 * <p>
 * An API to manage users
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link UsersapiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Usersapi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the usersapi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://openmicrofinance.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "usersapi/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Usersapi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Usersapi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "add".
   *
   * This request holds the parameters needed by the the usersapi server.  After setting any optional
   * parameters, call the {@link Add#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public Add add() throws java.io.IOException {
    Add result = new Add();
    initialize(result);
    return result;
  }

  public class Add extends UsersapiRequest<com.appspot.openmicrofinance.usersapi.model.OpenMFUser> {

    private static final String REST_PATH = "addOpenMFUser";

    /**
     * Create a request for the method "add".
     *
     * This request holds the parameters needed by the the usersapi server.  After setting any
     * optional parameters, call the {@link Add#execute()} method to invoke the remote operation. <p>
     * {@link Add#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected Add() {
      super(Usersapi.this, "POST", REST_PATH, null, com.appspot.openmicrofinance.usersapi.model.OpenMFUser.class);
    }

    @Override
    public Add setAlt(java.lang.String alt) {
      return (Add) super.setAlt(alt);
    }

    @Override
    public Add setFields(java.lang.String fields) {
      return (Add) super.setFields(fields);
    }

    @Override
    public Add setKey(java.lang.String key) {
      return (Add) super.setKey(key);
    }

    @Override
    public Add setOauthToken(java.lang.String oauthToken) {
      return (Add) super.setOauthToken(oauthToken);
    }

    @Override
    public Add setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Add) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Add setQuotaUser(java.lang.String quotaUser) {
      return (Add) super.setQuotaUser(quotaUser);
    }

    @Override
    public Add setUserIp(java.lang.String userIp) {
      return (Add) super.setUserIp(userIp);
    }

    @Override
    public Add set(String parameterName, Object value) {
      return (Add) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getUserById".
   *
   * This request holds the parameters needed by the the usersapi server.  After setting any optional
   * parameters, call the {@link GetUserById#execute()} method to invoke the remote operation.
   *
   * @param omfuId
   * @return the request
   */
  public GetUserById getUserById(java.lang.String omfuId) throws java.io.IOException {
    GetUserById result = new GetUserById(omfuId);
    initialize(result);
    return result;
  }

  public class GetUserById extends UsersapiRequest<com.appspot.openmicrofinance.usersapi.model.OpenMFUser> {

    private static final String REST_PATH = "openmfuser/{omfuId}";

    /**
     * Create a request for the method "getUserById".
     *
     * This request holds the parameters needed by the the usersapi server.  After setting any
     * optional parameters, call the {@link GetUserById#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetUserById#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param omfuId
     * @since 1.13
     */
    protected GetUserById(java.lang.String omfuId) {
      super(Usersapi.this, "GET", REST_PATH, null, com.appspot.openmicrofinance.usersapi.model.OpenMFUser.class);
      this.omfuId = com.google.api.client.util.Preconditions.checkNotNull(omfuId, "Required parameter omfuId must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetUserById setAlt(java.lang.String alt) {
      return (GetUserById) super.setAlt(alt);
    }

    @Override
    public GetUserById setFields(java.lang.String fields) {
      return (GetUserById) super.setFields(fields);
    }

    @Override
    public GetUserById setKey(java.lang.String key) {
      return (GetUserById) super.setKey(key);
    }

    @Override
    public GetUserById setOauthToken(java.lang.String oauthToken) {
      return (GetUserById) super.setOauthToken(oauthToken);
    }

    @Override
    public GetUserById setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetUserById) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetUserById setQuotaUser(java.lang.String quotaUser) {
      return (GetUserById) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetUserById setUserIp(java.lang.String userIp) {
      return (GetUserById) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String omfuId;

    /**

     */
    public java.lang.String getOmfuId() {
      return omfuId;
    }

    public GetUserById setOmfuId(java.lang.String omfuId) {
      this.omfuId = omfuId;
      return this;
    }

    @Override
    public GetUserById set(String parameterName, Object value) {
      return (GetUserById) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "list".
   *
   * This request holds the parameters needed by the the usersapi server.  After setting any optional
   * parameters, call the {@link List#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public List list() throws java.io.IOException {
    List result = new List();
    initialize(result);
    return result;
  }

  public class List extends UsersapiRequest<com.appspot.openmicrofinance.usersapi.model.OpenMFUserCollection> {

    private static final String REST_PATH = "openmfusercollection";

    /**
     * Create a request for the method "list".
     *
     * This request holds the parameters needed by the the usersapi server.  After setting any
     * optional parameters, call the {@link List#execute()} method to invoke the remote operation. <p>
     * {@link List#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected List() {
      super(Usersapi.this, "GET", REST_PATH, null, com.appspot.openmicrofinance.usersapi.model.OpenMFUserCollection.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public List setAlt(java.lang.String alt) {
      return (List) super.setAlt(alt);
    }

    @Override
    public List setFields(java.lang.String fields) {
      return (List) super.setFields(fields);
    }

    @Override
    public List setKey(java.lang.String key) {
      return (List) super.setKey(key);
    }

    @Override
    public List setOauthToken(java.lang.String oauthToken) {
      return (List) super.setOauthToken(oauthToken);
    }

    @Override
    public List setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (List) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public List setQuotaUser(java.lang.String quotaUser) {
      return (List) super.setQuotaUser(quotaUser);
    }

    @Override
    public List setUserIp(java.lang.String userIp) {
      return (List) super.setUserIp(userIp);
    }

    @Override
    public List set(String parameterName, Object value) {
      return (List) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "remove".
   *
   * This request holds the parameters needed by the the usersapi server.  After setting any optional
   * parameters, call the {@link Remove#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public Remove remove(java.lang.Long id) throws java.io.IOException {
    Remove result = new Remove(id);
    initialize(result);
    return result;
  }

  public class Remove extends UsersapiRequest<Void> {

    private static final String REST_PATH = "openmfuser/{id}";

    /**
     * Create a request for the method "remove".
     *
     * This request holds the parameters needed by the the usersapi server.  After setting any
     * optional parameters, call the {@link Remove#execute()} method to invoke the remote operation.
     * <p> {@link
     * Remove#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected Remove(java.lang.Long id) {
      super(Usersapi.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public Remove setAlt(java.lang.String alt) {
      return (Remove) super.setAlt(alt);
    }

    @Override
    public Remove setFields(java.lang.String fields) {
      return (Remove) super.setFields(fields);
    }

    @Override
    public Remove setKey(java.lang.String key) {
      return (Remove) super.setKey(key);
    }

    @Override
    public Remove setOauthToken(java.lang.String oauthToken) {
      return (Remove) super.setOauthToken(oauthToken);
    }

    @Override
    public Remove setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Remove) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Remove setQuotaUser(java.lang.String quotaUser) {
      return (Remove) super.setQuotaUser(quotaUser);
    }

    @Override
    public Remove setUserIp(java.lang.String userIp) {
      return (Remove) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public Remove setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public Remove set(String parameterName, Object value) {
      return (Remove) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Usersapi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Usersapi}. */
    @Override
    public Usersapi build() {
      return new Usersapi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link UsersapiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setUsersapiRequestInitializer(
        UsersapiRequestInitializer usersapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(usersapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}