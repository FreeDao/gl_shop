package com.glshop.net.utils;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;

import com.glshop.platform.api.setting.data.model.AppInfoModel;
import com.glshop.platform.utils.Logger;
import com.glshop.platform.utils.StringUtils;

/**
 * @Description : ActivityUtil工具类
 * @Copyright   : GL. All Rights Reserved
 * @Company     : 深圳市国立数码动画有限公司
 * @author      : 叶跃丰
 * @version     : 1.0
 * Create Date  : 2014-7-18 上午10:40:28
 */
public final class ActivityUtil {

	// 日志标识
	private static final String TAG = "ActivityUtil";

	private ActivityUtil() {

	}

	/**
	 * 获取当前程序版本号
	 * 
	 * @param context
	 * @return
	 */
	public static int getVersionCode(Context context) {
		PackageManager pm = context.getPackageManager();
		int versionCode = 0;
		try {
			PackageInfo info = pm.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
			versionCode = info.versionCode;
		} catch (NameNotFoundException e) {
			Logger.e(TAG, "getVersionCode error" + e.getMessage(), e);
		}
		return versionCode;
	}

	/**
	 * 获取当前程序版本名称
	 * 
	 * @param context
	 * @return
	 */
	public static String getVersionName(Context context) {
		PackageManager pm = context.getPackageManager();
		String versionName = "1.0.0";
		try {
			PackageInfo info = pm.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
			versionName = info.versionName;

		} catch (NameNotFoundException e) {
			Logger.e(TAG, "getVersionName error", e);
		}
		return versionName;
	}

	/**
	 * 隐藏键盘
	 * 
	 * @param activity
	 */
	public static void hideKeyboard(Activity activity) {
		// 隐藏键盘
		InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
	}

	/**
	 * 获取手机名
	 * 
	 * @param context
	 * @return
	 */
	public static String getPhoneName() {
		return android.os.Build.PRODUCT;
	}

	/**
	 * 获取设备ID
	 * @param context
	 * @return
	 */
	public static String getDeviceId(Context context) {
		String deviceId = "";
		String imei = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
		if (StringUtils.isNotEmpty(imei)) {
			deviceId = imei;
		} else {
			deviceId = ""; // TODO 创建随机数
		}
		return deviceId;
	}

	/***
	 * 判断是否开启其他应用程序
	 * 
	 * @param context
	 *            context
	 * @param intent
	 *            intent
	 * @return boolean
	 */
	public static boolean isOpenOtherIntent(Context context, Intent intent) {
		boolean isOtherApp = false;
		try {
			PackageManager packageManager = context.getPackageManager();
			List<ResolveInfo> acitvitys = packageManager.queryIntentActivities(intent, 0);
			if (acitvitys != null && acitvitys.size() > 0) {
				String packageName = acitvitys.get(0).activityInfo.packageName;
				isOtherApp = !context.getPackageName().equals(packageName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isOtherApp;
	}

	/** 判断应用是否是前台运行 */
	public static boolean isReception(Context context) {
		try {
			ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			ComponentName topName = manager.getRunningTasks(1).get(0).topActivity;
			String currentPackageName = topName.getPackageName();
			if (!StringUtils.isEmpty(currentPackageName) && currentPackageName.equals(context.getPackageName())) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 获取状态栏高度
	 * @param activity
	 * @return
	 */
	public static int getStatusHeight(Activity activity) {
		int statusHeight = 0;
		Rect localRect = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
		statusHeight = localRect.top;
		if (0 == statusHeight) {
			Class<?> localClass;
			try {
				localClass = Class.forName("com.android.internal.R$dimen");
				Object localObject = localClass.newInstance();
				int i5 = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
				statusHeight = activity.getResources().getDimensionPixelSize(i5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return statusHeight;
	}

	/**
	 * 获取应用信息
	 * @param context
	 * @return
	 */
	public static AppInfoModel getAppInfo(Context context) {
		AppInfoModel info = new AppInfoModel();
		info.deviceType = "2";
		info.deviceId = getDeviceId(context);
		info.deviceName = getPhoneName();
		info.versionName = getVersionName(context);
		info.versionCode = String.valueOf(getVersionCode(context));
		return info;
	}

}
