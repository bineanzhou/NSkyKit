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


import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** Represents a single feature to demo. */
public abstract class FeatureBlock {

  /** Status flag that denotes the demo and component are ready for use. */
  public static final int STATUS_READY = 0;

  /** Status flag that denotes the demo and/or component is work in progress. */
  public static final int STATUS_WIP = 1;

  /** Status flag enum for this {@link FeatureBlock}. */
  @IntDef({STATUS_READY, STATUS_WIP})
  @Retention(RetentionPolicy.SOURCE)
  public @interface Status {}

  @StringRes
  private final int titleResId;
  @DrawableRes
  private final int drawableResId;
  @Status private final int status;

  public FeatureBlock(@StringRes int titleResId, @DrawableRes int drawableResId) {
    this(titleResId, drawableResId, STATUS_READY);
  }

  public FeatureBlock(
      @StringRes int titleResId, @DrawableRes int drawableResId, @Status int status) {
    this.titleResId = titleResId;
    this.drawableResId = drawableResId;
    this.status = status;
  }

  @StringRes
  public int getTitleResId() {
    return titleResId;
  }

  @DrawableRes
  public int getDrawableResId() {
    return drawableResId;
  }

  public int getStatus() {
    return status;
  }

  public abstract Fragment createFragment();

  public abstract Class<? extends Fragment> getFragmentClass();
}
