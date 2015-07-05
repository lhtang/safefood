package com.tea.prototype.service;

import javax.servlet.http.HttpServletRequest;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tea.prototype.constant.DeviceName;

@Service
public class DeviceTypeService {
	
	private final Logger logger = LoggerFactory
			.getLogger(DeviceTypeService.class);


	public String getDeviceName(HttpServletRequest request) {
		
		UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
		ReadableUserAgent agent = parser.parse(request.getHeader("User-Agent"));
		
		String deviceName = agent.getDeviceCategory().getName();

		logger.debug("deviceName => " + deviceName);

		return deviceName;
	}
	
	public boolean isMobileDevice(String deviceName) {
		
		boolean isMobile = StringUtils.equalsIgnoreCase(deviceName, DeviceName.MOBILE) ? true:false;
		
		return isMobile;
		
	}
	
	public boolean isPersonalComputer(String deviceName) {
		
		boolean isPC = StringUtils.equalsIgnoreCase(deviceName, DeviceName.PERSONAL_COMPUTER) ? true:false;
		
		return isPC;
	}
	
	public boolean isTablet(String deviceName) {
		
		boolean isTablet = StringUtils.equalsIgnoreCase(deviceName, DeviceName.TABLET) ? true:false;
		
		return isTablet;
	}
}
