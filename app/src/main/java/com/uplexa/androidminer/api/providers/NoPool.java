// Copyright (c) 2020, uPlexa
//
// Please see the included LICENSE file for more information.

package io.uplexaproject.androidminer.api.providers;

import io.uplexaproject.androidminer.api.ProviderAbstract;
import io.uplexaproject.androidminer.api.PoolItem;

public final class NoPool extends ProviderAbstract {

    public NoPool(PoolItem poolItem){
        super(poolItem);
    }

    @Override
    protected void onBackgroundFetchData() {}
}
