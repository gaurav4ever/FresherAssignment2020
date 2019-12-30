package com.gonuclei.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * The type Date util.
 */
public class DateUtil {

  /**
   * Gets date of expiry.
   *
   * @param validity the validity
   * @return the date of expiry
   */
  public static Date getDateOfExpiry(int validity) {
    Date currDate = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(currDate);

    //add validity to current date
    c.add(Calendar.DATE, validity);

    return c.getTime();
  }
}
