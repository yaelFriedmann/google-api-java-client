/*
 * Copyright (c) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.data.latitude.v1.atom;

import com.google.api.client.xml.XmlNamespaceDictionary;

import java.util.Map;

/**
 * Utilities for the Atom XML format of the Google Latitude API.
 *
 * @deprecated (scheduled to be removed in version 1.1) Copy into your own
 * application
 */
@Deprecated
public final class GoogleLatitudeAtom {

  /**
   * XML namespace dictionary.
   *
   * @deprecated (scheduled to be removed in version 1.1) Copy into your own
   * application
   */
  @Deprecated
  public static final XmlNamespaceDictionary NAMESPACE_DICTIONARY = new
      XmlNamespaceDictionary();
  static {
    Map<String, String> map = NAMESPACE_DICTIONARY.namespaceAliasToUriMap;
    map.put("", "http://www.w3.org/2005/Atom");
    map.put("gd", "http://schemas.google.com/g/2005");
    map.put("latitude", "http://schemas.google.com/latitude/2010");
  }

  private GoogleLatitudeAtom() {
  }
}