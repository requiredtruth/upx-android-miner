// Copyright (c) 2020, uPlexa
//
// Please see the included LICENSE file for more information.

package io.uplexaproject.androidminer.api;

public interface IProviderListener {
    void onStatsChange(ProviderData data);

    boolean onEnabledRequest();
}
