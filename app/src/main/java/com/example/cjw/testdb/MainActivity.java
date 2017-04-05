package com.example.cjw.testdb;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.cjw.testdb.db.MachineDatabase;

public class MainActivity extends AppCompatActivity {

    private TextView status;

    public static final String TAG = "MainActivity";

    public static MachineDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = (TextView) findViewById(R.id.status);
    }

    @Override
    protected void onStart() {
        openDatabase();

        loadData();

        super.onStart();
    }

    /**
     * 데이터베이스 열기
     */
    public void openDatabase() {
        // open database
        if (database != null) {
            database.close();
            database = null;
        }

        database = MachineDatabase.getInstance(this);

        /* database is null test code */
//        if (database == null)
//            Toast.makeText(this, "database is null...", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(this, "database is not null!", Toast.LENGTH_SHORT).show();

        boolean isOpen = database.open();
        if (isOpen) {
            Log.d(TAG, "Machine database is open.");
        }
        else {
            Log.e(TAG, "Machine database is not open.");
        }
    }

    public void loadData() {
        String sql = "select * from MACHINE_INFO order by _id";

        int recordCount = -1;
        String str = "";
        if (database != null) {
            Cursor outCursor = database.rawQuery(sql);

            recordCount = outCursor.getCount();

            for (int i=0; i<recordCount; i++) {
                outCursor.moveToNext();

                Integer id = outCursor.getInt(0);
                String installation_place = outCursor.getString(1);
                String installation_location = outCursor.getString(2);
                String hours_of_operation = outCursor.getString(3);
                String certificate_type = outCursor.getString(4);
                String road_name_address = outCursor.getString(5);
                String management_agency_name = outCursor.getString(6);
                String contact_number = outCursor.getString(7);
                String land_lot_number_address = outCursor.getString(8);
                String longitude = outCursor.getString(9);
                String latitude = outCursor.getString(10);
                String date_of_last_update = outCursor.getString(11);

                str += id.toString() + ": " + installation_place + ", " + installation_location
                        + ", " + hours_of_operation + "\n";
            }

            status.setText(str);

            outCursor.close();
        }
    }

}
