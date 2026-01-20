package utils;

import java.util.Date;

public class CommonUtils {
	public static final int IMPLICIT_WAIT_TIME=15;
	public static final int PAGELOAD_WAIT_TIME=15;
	public static final int EXPLICIT_WAIT_BASIC_TIME=30;
	public static String getTimestampEmail() {
		Date date = new Date();
		return "rehankhan" + date.toString().replace("", "").replace(":", "") + "@gmail.com";
	}

}
