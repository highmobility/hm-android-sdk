package com.highmobility.hmkit;

import java.util.UUID;

public class Constants {
    static UUID SERVICE_UUID = UUID.fromString("713D0100-503E-4C75-BA94-3148F18D941E");
    static UUID READ_CHAR_UUID = UUID.fromString("713D0102-503E-4C75-BA94-3148F18D941E");
    static UUID WRITE_CHAR_UUID = UUID.fromString("713D0103-503E-4C75-BA94-3148F18D941E");
    static UUID ALIVE_CHAR_UUID = UUID.fromString("713D0104-503E-4C75-BA94-3148F18D941E");
    static UUID INFO_CHAR_UUID = UUID.fromString("713D0105-503E-4C75-BA94-3148F18D941E");
    static UUID SENSING_READ_CHAR_UUID = UUID.fromString("713D0106-503E-4C75-BA94-3148F18D941E");
    static UUID SENSING_WRITE_CHAR_UUID = UUID.fromString("713D0107-503E-4C75-BA94-3148F18D941E");
    static int MAX_COMMAND_LENGTH = 253; // this is without commandId, requiresHMAC and size

    static UUID NOTIFY_DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");

    public static final float registerTimeout = 10.0f;

    /**
     * @deprecated use {@link Link#commandTimeout} instead
     */
    @Deprecated public static final float commandTimeout = 10.0f;

    public static final int certificateStorageCount = 30;

    public interface ResponseCallback {
        void response(int errorCode);
    }
}