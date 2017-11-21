package com.example.user.qrrecoder.data.greendaoauto;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.user.qrrecoder.data.greendao.DeviceItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DEVICE_ITEM".
*/
public class DeviceItemDao extends AbstractDao<DeviceItem, Void> {

    public static final String TABLENAME = "DEVICE_ITEM";

    /**
     * Properties of entity DeviceItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Deviceid = new Property(0, String.class, "deviceid", false, "DEVICEID");
        public final static Property Userid = new Property(1, String.class, "userid", false, "USERID");
        public final static Property Recordtime = new Property(2, long.class, "recordtime", false, "RECORDTIME");
        public final static Property ServerState = new Property(3, int.class, "serverState", false, "SERVER_STATE");
    }


    public DeviceItemDao(DaoConfig config) {
        super(config);
    }
    
    public DeviceItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DEVICE_ITEM\" (" + //
                "\"DEVICEID\" TEXT," + // 0: deviceid
                "\"USERID\" TEXT," + // 1: userid
                "\"RECORDTIME\" INTEGER NOT NULL ," + // 2: recordtime
                "\"SERVER_STATE\" INTEGER NOT NULL );"); // 3: serverState
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_DEVICE_ITEM_DEVICEID ON \"DEVICE_ITEM\"" +
                " (\"DEVICEID\" ASC);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_DEVICE_ITEM_USERID ON \"DEVICE_ITEM\"" +
                " (\"USERID\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DEVICE_ITEM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DeviceItem entity) {
        stmt.clearBindings();
 
        String deviceid = entity.getDeviceid();
        if (deviceid != null) {
            stmt.bindString(1, deviceid);
        }
 
        String userid = entity.getUserid();
        if (userid != null) {
            stmt.bindString(2, userid);
        }
        stmt.bindLong(3, entity.getRecordtime());
        stmt.bindLong(4, entity.getServerState());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DeviceItem entity) {
        stmt.clearBindings();
 
        String deviceid = entity.getDeviceid();
        if (deviceid != null) {
            stmt.bindString(1, deviceid);
        }
 
        String userid = entity.getUserid();
        if (userid != null) {
            stmt.bindString(2, userid);
        }
        stmt.bindLong(3, entity.getRecordtime());
        stmt.bindLong(4, entity.getServerState());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DeviceItem readEntity(Cursor cursor, int offset) {
        DeviceItem entity = new DeviceItem( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // deviceid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // userid
            cursor.getLong(offset + 2), // recordtime
            cursor.getInt(offset + 3) // serverState
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DeviceItem entity, int offset) {
        entity.setDeviceid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUserid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRecordtime(cursor.getLong(offset + 2));
        entity.setServerState(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DeviceItem entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DeviceItem entity) {
        return null;
    }

    @Override
    public boolean hasKey(DeviceItem entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
