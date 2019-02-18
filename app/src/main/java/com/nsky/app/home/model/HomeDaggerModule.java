/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nsky.app.home.model;

import com.nsky.app.home.HomeFragment;
import com.nsky.app.home.TocResourceProvider;
import dagger.Provides;

/**
 * The Dagger module for {@link HomeFragment} dependencies.
 *
 */
@dagger.Module()
public class HomeDaggerModule {

  @Provides
  static TocResourceProvider provideTocResourceProvider() {
    return new TocResourceProvider();
  }

}
