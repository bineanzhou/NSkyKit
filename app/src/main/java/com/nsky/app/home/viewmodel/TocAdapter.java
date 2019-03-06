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

package com.nsky.app.home.viewmodel;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.nsky.app.home.model.FeatureBlock;

import java.util.List;

/** Handles individual items in the catalog table of contents. */
public class TocAdapter extends Adapter<TocViewHolder> {

  private final FragmentActivity activity;
  private final List<FeatureBlock> featureBlocks;

  public TocAdapter(FragmentActivity activity, List<FeatureBlock> featureBlocks) {
    this.activity = activity;
    this.featureBlocks = featureBlocks;
  }

  @Override
  public TocViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    return new TocViewHolder(activity, viewGroup);
  }

  @Override
  public void onBindViewHolder(TocViewHolder tocViewHolder, int i) {
    tocViewHolder.bind(activity, featureBlocks.get(i));
  }

  @Override
  public int getItemCount() {
    return featureBlocks.size();
  }
}
