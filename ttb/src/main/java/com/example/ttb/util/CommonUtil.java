package com.ttb.interview.test.util;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CommonUtil {
    public static ZonedDateTime timestampToZonedDateTime(Timestamp timestamp) {
        return timestamp.toInstant()
                .atZone(ZoneId.of("Asia/Bangkok"));
    }

    public static Timestamp ZonedDateTimeToTimestamp(ZonedDateTime zonedDateTime) {
        return Timestamp.from(zonedDateTime.toInstant());
    }
}
