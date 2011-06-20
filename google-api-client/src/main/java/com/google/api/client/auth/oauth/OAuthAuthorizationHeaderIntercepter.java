/*
 * Copyright (c) 2010 Google Inc.
 *
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

package com.google.api.client.auth.oauth;

import com.google.api.client.http.HttpExecuteIntercepter;
import com.google.api.client.http.HttpRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author Yaniv Inbar
 */
@Deprecated
final class OAuthAuthorizationHeaderIntercepter implements HttpExecuteIntercepter {

  OAuthParameters oauthParameters;

  public void intercept(HttpRequest request) throws IOException {
    oauthParameters.computeNonce();
    oauthParameters.computeTimestamp();
    try {
      oauthParameters.computeSignature(request.method.name(), request.url);
    } catch (GeneralSecurityException e) {
      IOException io = new IOException();
      io.initCause(e);
      throw io;
    }
    request.headers.authorization = oauthParameters.getAuthorizationHeader();
  }
}