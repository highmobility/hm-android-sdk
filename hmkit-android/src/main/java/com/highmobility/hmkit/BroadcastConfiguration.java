/*
 * The MIT License
 *
 * Copyright (c) 2014- High-Mobility GmbH (https://high-mobility.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.highmobility.hmkit;

import android.bluetooth.le.AdvertiseSettings;

import com.highmobility.crypto.value.DeviceSerial;

public class BroadcastConfiguration {
    private int advertiseMode = AdvertiseSettings.ADVERTISE_MODE_BALANCED;
    private int txPowerLevel = AdvertiseSettings.ADVERTISE_TX_POWER_HIGH;
    private DeviceSerial broadcastTarget = null;
    private boolean overrideAdvertisementName = true;

    public BroadcastConfiguration() {

    }

    /**
     * @return The advertise mode
     */
    public int getAdvertiseMode() {
        return advertiseMode;
    }

    /**
     * @return The advertise TX Power level
     */
    public int getTxPowerLevel() {
        return txPowerLevel;
    }

    /**
     * @return The broadcasters targets serial number
     */
    public DeviceSerial getBroadcastTarget() {
        return broadcastTarget;
    }

    /**
     * @return Whether bluetooth name is set to HM one (eg: HM 1CADD). Default is yes.
     * @discussion Bluetooth name is changed on every broadcast start by default. This is a security
     * feature.
     */
    public boolean isOverridingAdvertisementName() {
        return overrideAdvertisementName;
    }

    private BroadcastConfiguration(Builder builder) {
        this.advertiseMode = builder.advertiseMode;
        this.txPowerLevel = builder.txPowerLevel;
        this.broadcastTarget = builder.broadcastTarget;
        this.overrideAdvertisementName = builder.overridesAdvertisementName;
    }

    public static final class Builder {
        private int advertiseMode = AdvertiseSettings.ADVERTISE_MODE_BALANCED;
        private int txPowerLevel = AdvertiseSettings.ADVERTISE_TX_POWER_HIGH;
        private DeviceSerial broadcastTarget = null;
        private boolean overridesAdvertisementName = true;

        /**
         * Sets the advertise mode for the Bluetooth's AdvertiseSettings. Default is
         * ADVERTISE_MODE_BALANCED.
         *
         * @param advertiseMode the advertise mode
         * @return The
         * @see AdvertiseSettings
         */
        public Builder setAdvertiseMode(int advertiseMode) {
            if (advertiseMode > AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY
                    || advertiseMode < AdvertiseSettings.ADVERTISE_MODE_LOW_POWER) return this;
            this.advertiseMode = advertiseMode;
            return this;
        }

        /**
         * Sets the TX power level for the Bluetooth's AdvertiseSettings. Default is
         * ADVERTISE_TX_POWER_HIGH.
         *
         * @param txPowerLevel the TX power level
         * @see AdvertiseSettings
         */
        public Builder setTxPowerLevel(int txPowerLevel) {
            if (txPowerLevel > AdvertiseSettings.ADVERTISE_TX_POWER_HIGH
                    || txPowerLevel < AdvertiseSettings.ADVERTISE_TX_POWER_ULTRA_LOW) return this;
            this.txPowerLevel = txPowerLevel;
            return this;
        }

        /**
         * Sets the given serial number in the broadcast info, so other devices know before
         * connecting if this device is interesting to them or not. This is not required to be set.
         *
         * @param serial the serial set in the broadcast info
         */
        public Builder setBroadcastingTarget(DeviceSerial serial) {
            this.broadcastTarget = serial;
            return this;
        }

        /**
         * Indicates whether HMKit will overwrite the phone's bluetooth name. By default this
         * behaviour is on. If this is false the Chrome emulator will not recognize the device.
         *
         * @param overridesAdvertisementName Indication on whether to overwrite the phone's
         *                                   bluetooth name
         */
        public Builder setOverridesAdvertisementName(boolean overridesAdvertisementName) {
            this.overridesAdvertisementName = overridesAdvertisementName;
            return this;
        }

        public BroadcastConfiguration build() {
            return new BroadcastConfiguration(this);
        }
    }
}
