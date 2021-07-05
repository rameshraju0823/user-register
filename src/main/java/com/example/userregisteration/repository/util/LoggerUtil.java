package com.example.userregisteration.repository.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.Logger;

public class LoggerUtil {
	
	

	private LoggerUtil() {
		super();
		
	}

	public static void logStackTrace(Exception e,Logger logger){
		 StringWriter sw = new StringWriter();
		 String error = String.format("Exception Occured. Full stack Trace:  %s", sw.toString());
		 PrintWriter pw = new PrintWriter(sw, true);
		 e.printStackTrace(pw);
		 pw.flush();
		 sw.flush();
		 logger.error(error);
	}
}
