#include <jni.h>
#include <Windows.h>
#include "RDPScreenRecord.h"


class ScreenRecording {
private: 
	//declare all private variables
	int target_frame_rate;

	//define all windows functions
	int EnumDisplayDevices(LPCWSTR lpDevice, DWORD iDevNum, PDISPLAY_DEVICEW lpDisplayDevice, DWORD dwFlags) {


		}


	//define all personal functions
	   JNIEXPORT void JNICALL Java_RDPScreenRecord_frameRate
	   (JNIEnv*, jobject, jint init) {
		   target_frame_rate = init;
	   }

	   JNIEXPORT jstring JNICALL Java_RDPScreenRecord_findDisplays
	   (JNIEnv*, jobject) {
	   }
};