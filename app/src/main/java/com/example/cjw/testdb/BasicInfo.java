package com.example.cjw.testdb;

public class BasicInfo {

    /**
     * Package Name
     */
    public static String PACKAGE_NAME = "com.example.cjw.testdb";

    /**
     * Database Name
     */
    public static String DATABASE_NAME = "machine.db";

    /**
     * Database Folder Location
     */
    public static String DATABASE_FOLDER_LOCATION = "/data/data/" + PACKAGE_NAME + "/databases";

    /**
     * Database File Location
     */
    public static String DATABASE_FILE_Location = "/data/data/" + PACKAGE_NAME + "/databases/" + DATABASE_NAME;

    //========== 액티비티 요청 코드  ==========//
    public static final int REQ_VIEW_ACTIVITY = 1001;
    public static final int REQ_INSERT_ACTIVITY = 1002;
    public static final int REQ_PHOTO_CAPTURE_ACTIVITY = 1501;
    public static final int REQ_PHOTO_SELECTION_ACTIVITY = 1502;
    public static final int REQ_VIDEO_RECORDING_ACTIVITY = 1503;
    public static final int REQ_VIDEO_LOADING_ACTIVITY = 1504;
    public static final int REQ_VOICE_RECORDING_ACTIVITY = 1505;
    public static final int REQ_HANDWRITING_MAKING_ACTIVITY = 1506;

}
