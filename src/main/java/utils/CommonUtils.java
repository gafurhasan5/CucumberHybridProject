package utils;

import java.util.Date;

public class CommonUtils {
	public static String getTimestampEmail() {
		Date date = new Date();
		return "rehankhan" + date.toString().replace("", "").replace(":", "") + "@gmail.com";
	}

}
