// Copyright (c) 2020, uPlexa
//
// Please see the included LICENSE file for more information.

package io.uplexaproject.androidminer.api;

import java.util.ArrayList;
import io.uplexaproject.androidminer.Config;

public final class ProviderManager {

    static private ArrayList<PoolItem> mPools = new ArrayList<PoolItem>();

    static public void add(PoolItem poolItem) {
        mPools.add(poolItem);
    }

    static public void add(String key, String pool,String port, int poolType, String poolUrl, String poolIP) {
        mPools.add(new PoolItem(key, pool, port, poolType, poolUrl, poolIP));
    }

    static public void add(String key, String pool, String port, int poolType, String poolUrl, String poolIP, String poolApi) {
        mPools.add(new PoolItem(key, pool, port, poolType, poolUrl, poolIP, poolApi, "",""));
    }

    static public PoolItem[] getPools() {
        return mPools.toArray(new PoolItem[mPools.size()]);
    }

    static public PoolItem getPoolById(int idx) {
        return mPools.get(idx);
    }

    static public PoolItem getPoolById(String idx) {
        int index = Integer.parseInt(idx);

        if (idx.equals("") || mPools.size() < index || mPools.size() == 0) {
            return null;
        }

        return mPools.get(index);
    }

    static final public ProviderData data = new ProviderData();

    static public PoolItem getSelectedPool() {
        if(request.mPoolItem != null) {
            return request.mPoolItem;
        }

        String sp = Config.read("selected_pool");
        if (sp.equals("")) {
            return null;
        }

        return getPoolById(sp);
    }
    static public void afterSave() {
        if(request.mPoolItem != null)  {
            return;
        }

        PoolItem pi = getSelectedPool();
        if(pi == null) {
            return;
        }

        //mPools.clear();
        request.mPoolItem = pi;
        data.isNew = true;
        request.start();
    }

    static final public ProviderRequest request = new ProviderRequest();

    static public void generate() {
        request.stop();
        request.mPoolItem = null;
        //mPools.clear();

        if(!mPools.isEmpty())
            return;

        // User Defined
        add("custom", "custom", "3333", 0, "", "");

        // uPlexa Official pool
        add(
                "uPleax IoT Proxy",
                "iot-proxy.uplexa.com",
                "9194",
                4, // uPlexa IoT Proxy
                "https://iot-proxy.uplexa.com",
                "45.79.218.212",
                "https://uplexa.com/o3.php?r="
        );

        // uPlexa Online
        add(
                "uPlexa Online (Official Pool)",
                "us.uplexa.online",
                "1111",
                3, // CryptonoteNodeJS
                "https://uplexa.online",
                "209.126.0.179",
                "https://api.uplexa.online"
        );

        // MiningOcean
        add(
                "MiningOcean",
                "upx.miningocean.org",
                "4372",
                3, // NodeJS
                "https://upx.miningocean.org",
                "54.36.98.147",
                "https://upxstats.miningocean.org"
        );

        // Miner.rocks
        add(
                "Miner.Rocks",
                "upx.miner.rocks",
                "30022",
                2, // NodeJS
                "https://uplexa.miner.rocks",
                "54.36.98.147"
        );


    }
}
