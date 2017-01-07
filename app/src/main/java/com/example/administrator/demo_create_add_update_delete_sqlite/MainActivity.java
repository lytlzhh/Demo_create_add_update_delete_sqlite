package com.example.administrator.demo_create_add_update_delete_sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.unit.Constant;
import com.example.administrator.unit.DB;
import com.example.administrator.unit.MySQLITEhelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MySQLITEhelper mySQLITEhelper;
    SQLiteDatabase sqLiteDatabase;
    private Button create_sql;
    private Button add_sql;
    private Button update_sql;
    private Button delete_sql;
    private LinearLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySQLITEhelper = DB.getInstance(this);
        initView();
    }

    private void initView() {
        create_sql = (Button) findViewById(R.id.create_sql);
        add_sql = (Button) findViewById(R.id.add_sql);
        update_sql = (Button) findViewById(R.id.update_sql);
        delete_sql = (Button) findViewById(R.id.delete_sql);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);

        create_sql.setOnClickListener(this);
        add_sql.setOnClickListener(this);
        update_sql.setOnClickListener(this);
        delete_sql.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_sql:
                sqLiteDatabase = mySQLITEhelper.getWritableDatabase();

                // sqLiteDatabase.execSQL();
                break;
            case R.id.add_sql:
                sqLiteDatabase = mySQLITEhelper.getWritableDatabase();
                String sql1 = "insert into " + Constant.TABLE_NAME + " values(1,'张三1',20)";
                DB.setExcele(sqLiteDatabase, sql1);
                String sql2 = "insert into " + Constant.TABLE_NAME + " values(2,'李四2',25)";
                DB.setExcele(sqLiteDatabase, sql2);

                String sql3 = "insert into " + Constant.TABLE_NAME + " values(3,'李四3',25)";
                DB.setExcele(sqLiteDatabase, sql3);

                String sql4 = "insert into " + Constant.TABLE_NAME + " values(4,'李四4',25)";
                DB.setExcele(sqLiteDatabase, sql4);


                String sql5 = "insert into " + Constant.TABLE_NAME + " values(5,'李四5',25)";
                DB.setExcele(sqLiteDatabase, sql5);

                String sql6 = "insert into " + Constant.TABLE_NAME + " values(6,'李四6',25)";
                DB.setExcele(sqLiteDatabase, sql6);


                sqLiteDatabase.close();
                break;
            case R.id.update_sql:
                sqLiteDatabase = mySQLITEhelper.getWritableDatabase();
                /*UPDATE table_name
SET column1 = value1, column2 = value2...., columnN = valueN
WHERE [condition];*/
                // String sql_update = "update table set name where=_id";
                String sql_update = "update " + Constant.TABLE_NAME + " set " + Constant.NAME + "= '贝克汉姆1' where " + Constant._ID + "=1";
                DB.setExcele(sqLiteDatabase, sql_update);

                String sql_update1 = "update " + Constant.TABLE_NAME + " set " + Constant.NAME + "= '贝克汉姆2' where " + Constant._ID + "=2";
                DB.setExcele(sqLiteDatabase, sql_update);

                sqLiteDatabase.close();
                break;
            case R.id.delete_sql:
                String sql_delete = "delete from " + Constant.TABLE_NAME + " where " + Constant._ID + "=1";
                DB.setExcele(sqLiteDatabase, sql_delete);
                sqLiteDatabase.close();
                break;
        }
    }
}
