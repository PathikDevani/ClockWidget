package com.spidren.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;

	private static final String TABLE_WIDGETCONFIG = "WidgetConfig";
	
	private static final String KEY_ID = "Id";
	private static final String KEY_COLOR1 = "Color1";
	private static final String KEY_COLOR2 = "Color2";
	
	Context context;

	public DatabaseHandler(Context context) {
		super(context, "ColockDb", null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_WIDGETCONFIG_TABLE = "CREATE TABLE " + TABLE_WIDGETCONFIG
				+ "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_COLOR1
				+ " TEXT," + KEY_COLOR2 + " TEXT" + ")";
		db.execSQL(CREATE_WIDGETCONFIG_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WIDGETCONFIG);
		onCreate(db);
	}

	public void addContent(WidgetColorContent Content) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_ID, Content.getId());
		values.put(KEY_COLOR1, Content.getFirstColor());
		values.put(KEY_COLOR2, Content.getSecondColor());
		db.replace(TABLE_WIDGETCONFIG, null, values);
		db.close();
		
	}

	public int updateContent(WidgetColorContent Content) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, Content.getId());
		values.put(KEY_COLOR1, Content.getFirstColor());
		values.put(KEY_COLOR2, Content.getSecondColor());
		int i = db.update(TABLE_WIDGETCONFIG, values, KEY_ID + " = ?",
				new String[] { String.valueOf(Content.getId()) });
		db.close();
		return i;
	}

	public WidgetColorContent getContent(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_WIDGETCONFIG, new String[] { KEY_ID,
				KEY_COLOR1, KEY_COLOR2 }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		WidgetColorContent Content = new WidgetColorContent(
				Integer.parseInt(cursor.getString(0)), cursor.getString(1),
				cursor.getString(2));
		db.close();
		return Content;
	}
	
	public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_WIDGETCONFIG;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = 0;
        if(cursor != null){
            count = cursor.getCount();
            cursor.close();
        }   
        return count;
    }
}
