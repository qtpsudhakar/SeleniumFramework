package com.config;

import com.report.ScreenshotPolicy;

public class OhrmConfig {

	public static final String APP_URL = "https://opensource-demo.orangehrmlive.com/";
	public static final boolean CREATE_BASE64 = true;
	public static final OpenBrowserFor OPENBROWSER = OpenBrowserFor.EVERYCLASS;
	public static final ScreenshotPolicy SCREEN_SHOT_POLICY = ScreenshotPolicy.TAKE_SCREENSHOTS_FOR_ONLY_FAIL;
	
	public static final Boolean IS_DEBUG_RUN = debugCheck();

	public static Boolean debugCheck() {
		return java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString()
				.indexOf("jdwp") >= 0;
	}
}
