#include <jni.h>
#include <Windows.h>
#include <iostream>
#include "RDPScreenRecord.h"


class ScreenRecording {
public:
	static BOOL CALLBACK MonitorEnumProc(HMONITOR hMonitor, HDC hdcMonitor, LPRECT lprcMonitor, LPARAM dwData)
	{
		MONITORINFOEX mi;
		mi.cbSize = sizeof(MONITORINFOEX);
		GetMonitorInfo(hMonitor, &mi);

		DISPLAY_DEVICE dd;
		dd.cb = sizeof(DISPLAY_DEVICE);
		EnumDisplayDevices(mi.szDevice, 0, &dd, 0);

		std::cout << "Monitor: " << hMonitor << std::endl;
		std::wcout << "  Name: " << dd.DeviceString << std::endl;
		std::wcout << "  Device: " << mi.szDevice << std::endl;

		return TRUE;
	}

private: 
	//declare all private variables
	int target_frame_rate;

	//define all windows functions
	

	//define all personal functions
	   JNIEXPORT void JNICALL Java_RDPScreenRecord_frameRate
	   (JNIEnv*, jobject, jint init) {
		   target_frame_rate = init;
	   }

	   JNIEXPORT jstring JNICALL Java_RDPScreenRecord_findDisplays
	   (JNIEnv*, jobject) {
		   EnumDisplayMonitors(NULL, NULL, &MonitorEnumProc, 0);

	   }
};