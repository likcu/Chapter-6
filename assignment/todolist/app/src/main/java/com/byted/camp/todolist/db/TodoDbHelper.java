package com.byted.camp.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.byted.camp.todolist.operation.db.FeedReaderContract.SQL_DELETE_ENTRIES;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public class TodoDbHelper extends SQLiteOpenHelper {

    // TODO 定义数据库名、版本；创建数据库
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "todo";

    public TodoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TodoContract.SQL_DELETE_ENTRIES);
        onCreate(db);
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("");
        }
    }

}
