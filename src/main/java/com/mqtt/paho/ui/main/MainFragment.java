/**
 * Author: nnikolov3 Date: 03/09/2021 Copyright (c) 2021 This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version. This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program. If not, https://www.gnu.org
 */
package com.mqtt.paho.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import mqtt.paho.R;
import mqtt.paho.databinding.MainFragmentBinding;

/** The main fragments updates the ui. */
public final class MainFragment extends Fragment {

  private MainViewModel mySensorViewModel;
  private LayoutInflater inflater;
  @Nullable private ViewGroup container;
  @Nullable private Bundle savedInstanceState;

  private MainFragment() {}

  public static MainFragment newInstance() {
    return createMainFragment();
  }

  public static MainFragment createMainFragment() {
    return new MainFragment();
  }

  // -----------------------------
  @Nullable
  @Override
  public View onCreateView(
      @NonNull final LayoutInflater inflater,
      @Nullable final ViewGroup container,
      @Nullable final Bundle savedInstanceState) {
    this.inflater = inflater;
    this.container = container;
    this.savedInstanceState = savedInstanceState;

    // Creating the data binding
    // -----------------------------
    final MainFragmentBinding binding;
    // Reference to the binding class
    binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);

    /* Ensure that the instance is destroyed
       when the fragment goes away
    */
    binding.setLifecycleOwner(this);
    final View view = binding.getRoot();
    binding.setVariable(uiController, this);
    return view;
  }

  @Override
  public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    final ViewModelProvider viewModelProvider = new ViewModelProvider(this);
    this.mySensorViewModel = viewModelProvider.get(MainViewModel.class);
  }
}
