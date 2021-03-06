/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.wifi;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;
import android.net.wifi.WifiConfiguration;
import java.util.List;

import com.android.settings.R;


/**
 * Configuration details saved by the user on the WifiSettings screen
 */
public class WifiConfigInfo extends Activity {

    private static final String TAG = "WifiConfigInfo";

    private TextView mConfigList;
    private WifiManager mWifiManager;

    //============================
    // Activity lifecycle
    //============================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mWifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        setContentView(R.layout.wifi_config_info);
        mConfigList = (TextView) findViewById(R.id.config_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final List<WifiConfiguration> wifiConfigs = mWifiManager.getConfiguredNetworks();
        StringBuffer configList  = new StringBuffer();
        for (int i = wifiConfigs.size() - 1; i >= 0; i--) {
            configList.append(wifiConfigs.get(i));
        }
        mConfigList.setText(configList);
    }

}
