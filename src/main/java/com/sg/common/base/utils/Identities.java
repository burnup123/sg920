package com.sg.common.base.utils;

import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Identities
{
    private static SecureRandom random = new SecureRandom();

    public static String uuid()
    {
        return UUID.randomUUID().toString();
    }

    public static String uuid2()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String uuid3()
    {
        long val = ByteBuffer.wrap(uuid2().toString().getBytes()).getLong();
        return Long.toString(val, 36);
    }

    public static long randomLong()
    {
        return Math.abs(random.nextLong());
    }


}