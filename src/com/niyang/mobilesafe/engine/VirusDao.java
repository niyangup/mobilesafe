package com.niyang.mobilesafe.engine;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class VirusDao {
	// 1.指定访问数据库的路径
	public static String path = "data/data/com.niyang.mobilesafe/files/antivirus.db";

	// 2.开启数据库,进行访问
	public static List<String> getVirusList(){
		SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
		Cursor cursor = db.query("datable", new String[] {"md5"}, null, null, null, null, null);
		List<String> list=new ArrayList<>();
		
		while (cursor.moveToNext()) {
			list.add(cursor.getString(0));
		}
		
		cursor.close();
		db.close();
		return list;
	}

}
