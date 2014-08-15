package uk.ac.openmf.mobile.syncdown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBController  extends SQLiteOpenHelper {

	public DBController(Context applicationcontext) {
		super(applicationcontext, "openmf.db", null, 1);
	}
	//Creates Table
	@Override
	public void onCreate(SQLiteDatabase database) {
		String query;
		query = "CREATE TABLE users ( userId TEXT, username TEXT, address TEXT, contact TEXT, email TEXT, enabled TEXT, forename TEXT, main_office TEXT, password TEXT, role TEXT, supervisor TEXT, surname TEXT)";
		database.execSQL(query);
		query = "CREATE TABLE tasks ( taskId TEXT, accountnumber	TEXT, amount TEXT, assignedto TEXT, cashier TEXT, collectiontype TEXT, dateassigned TEXT, datecompleted TEXT, description TEXT, newclient TEXT, status TEXT)";
		database.execSQL(query);
		query = "CREATE TABLE clients ( clientId TEXT, accountnumber	TEXT, activationdate TEXT, active TEXT, address TEXT, balance TEXT, blacklisted TEXT, clientclassification TEXT, clienttype TEXT, contact TEXT, dateofbirth TEXT, eligible TEXT, externalId TEXT, forename TEXT, gender TEXT, groupid TEXT, main_office TEXT, midname TEXT, submittedon TEXT, supervisor TEXT, surname TEXT)";
		database.execSQL(query);        
	}
	@Override
	public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
		String query;
		query = "DROP TABLE IF EXISTS users";
		database.execSQL(query);
		query = "DROP TABLE IF EXISTS tasks";
		database.execSQL(query);
		query = "DROP TABLE IF EXISTS clients";
		database.execSQL(query);
		onCreate(database);
	}


	/**
	 * Inserts User into SQLite DB
	 * @param queryValues
	 */
	public void insertUser(HashMap<String, String> queryValues) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("userId", queryValues.get("userId"));
		values.put("username", queryValues.get("username"));
		values.put("address", queryValues.get("address"));
		values.put("contact", queryValues.get("contact"));
		values.put("email", queryValues.get("email"));
		values.put("enabled", queryValues.get("enabled"));
		values.put("forename", queryValues.get("forename"));
		values.put("main_office", queryValues.get("main_office"));
		values.put("password", queryValues.get("password"));
		values.put("role", queryValues.get("role"));
		values.put("supervisor", queryValues.get("supervisor"));
		values.put("surname", queryValues.get("surname"));
		database.insert("users", null, values);
		database.close();
	}

	/**
	 * Get list of Users from SQLite DB as Array List
	 * @return
	 */
	public Map<String, HashMap<String, String>> getAllUsers() {
		Map<String, HashMap<String, String>> usersList;
		usersList = new HashMap<String, HashMap<String, String>>();
		String selectQuery = "SELECT  * FROM users";
		SQLiteDatabase database = this.getWritableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				HashMap<String, String> map = new HashMap<String, String>();
				String uid = cursor.getString(0);
				map.put("userId", uid);
				map.put("username", cursor.getString(1));
				map.put("address", cursor.getString(2));
				map.put("contact", cursor.getString(3));
				map.put("email", cursor.getString(4));
				map.put("enabled", cursor.getString(5));
				map.put("forename", cursor.getString(6));
				map.put("main_office", cursor.getString(7));
				map.put("password", cursor.getString(8));
				map.put("role", cursor.getString(9));
				map.put("supervisor", cursor.getString(10));
				map.put("surname", cursor.getString(11));
				usersList.put(uid, map);
			} while (cursor.moveToNext());
		}
		database.close();
		return usersList;
	}

	public void insertTask(HashMap<String, String> queryValues) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("taskId", queryValues.get("taskId"));
		values.put("accountnumber", queryValues.get("accountnumber"));
		values.put("amount", queryValues.get("amount"));	
		values.put("assignedto", queryValues.get("assignedto"));	
		values.put("cashier", queryValues.get("cashier"));
		values.put("collectiontype", queryValues.get("collectiontype"));
		values.put("dateassigned", queryValues.get("dateassigned"));
		values.put("datecompleted", queryValues.get("datecompleted"));
		values.put("description", queryValues.get("description"));
		values.put("newclient", queryValues.get("newclient"));
		values.put("status", queryValues.get("status"));
		database.insert("tasks", null, values);
		database.close();
	}

	/**
	 * Get list of Users from SQLite DB as Array List
	 * @return
	 */
	public Map<String, HashMap<String, String>> getAllTasks() {
		Map<String, HashMap<String, String>> usersList;
		usersList = new HashMap<String, HashMap<String, String>>();
		String selectQuery = "SELECT  * FROM tasks";
		SQLiteDatabase database = this.getWritableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				HashMap<String, String> map = new HashMap<String, String>();
				String taskid = cursor.getString(0);
				map.put("taskId", taskid);
				map.put("accountnumber", cursor.getString(1));
				map.put("amount", cursor.getString(2));	
				map.put("assignedto", cursor.getString(3));	
				map.put("cashier", cursor.getString(4));
				map.put("collectiontype", cursor.getString(5));
				map.put("dateassigned", cursor.getString(6));
				map.put("datecompleted", cursor.getString(7));
				map.put("description", cursor.getString(8));
				map.put("newclient", cursor.getString(9));
				map.put("status", cursor.getString(10));
				usersList.put(taskid, map);
			} while (cursor.moveToNext());
		}
		database.close();
		return usersList;
	}

	public void insertClient(HashMap<String, String> queryValues) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("clientId", queryValues.get("clientId"));
		values.put("accountnumber", queryValues.get("accountnumber"));
		values.put("activationdate", queryValues.get("activationdate"));	
		values.put("active", queryValues.get("active"));	
		values.put("address", queryValues.get("address"));	
		values.put("balance", queryValues.get("balance"));	
		values.put("blacklisted", queryValues.get("blacklisted"));	
		values.put("clientclassification", queryValues.get("clientclassification"));	
		values.put("clienttype", queryValues.get("clienttype"));	
		values.put("contact", queryValues.get("contact"));	
		values.put("dateofbirth", queryValues.get("dateofbirth"));	
		values.put("eligible", queryValues.get("eligible"));	
		values.put("externalId", queryValues.get("externalId"));	
		values.put("forename", queryValues.get("forename"));	
		values.put("gender", queryValues.get("gender"));	
		values.put("groupid", queryValues.get("groupid"));	
		values.put("main_office", queryValues.get("main_office"));	
		values.put("midname", queryValues.get("midname"));	
		values.put("submittedon", queryValues.get("submittedon"));	
		values.put("supervisor", queryValues.get("supervisor"));	
		values.put("surname", queryValues.get("surname"));	
		database.insert("clients", null, values);
		database.close();
	}

	/**
	 * Get list of Users from SQLite DB as Array List
	 * @return
	 */
	public Map<String, HashMap<String, String>> getAllClients() {
		Map<String, HashMap<String, String>> usersList;
		usersList = new HashMap<String, HashMap<String, String>>();
		String selectQuery = "SELECT  * FROM clients";
		SQLiteDatabase database = this.getWritableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				HashMap<String, String> map = new HashMap<String, String>();
				String clientid = cursor.getString(0);
				map.put("clientId", clientid);
				map.put("accountnumber", cursor.getString(1));
				map.put("activationdate", cursor.getString(2));	
				map.put("active", cursor.getString(3));	
				map.put("address", cursor.getString(4));	
				map.put("balance", cursor.getString(5));	
				map.put("blacklisted", cursor.getString(6));	
				map.put("clientclassification", cursor.getString(7));	
				map.put("clienttype", cursor.getString(8));	
				map.put("contact", cursor.getString(9));	
				map.put("dateofbirth", cursor.getString(10));	
				map.put("eligible", cursor.getString(11));	
				map.put("externalId", cursor.getString(12));	
				map.put("forename", cursor.getString(13));	
				map.put("gender", cursor.getString(14));	
				map.put("groupid", cursor.getString(15));	
				map.put("main_office", cursor.getString(16));	
				map.put("midname", cursor.getString(17));	
				map.put("submittedon", cursor.getString(18));	
				map.put("supervisor", cursor.getString(19));	
				map.put("surname", cursor.getString(20));	
				usersList.put(clientid, map);
			} while (cursor.moveToNext());
		}
		database.close();
		return usersList;
	}
	
	public void updateTask(String taskId) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("status", "true");
		database.update("tasks", values, "taskId="+taskId, null);
		database.close();
	}
	
	public void removeTask(String taskId) {
		SQLiteDatabase database = this.getWritableDatabase();
		database.delete("tasks", "taskId="+taskId, null);
		database.close();
	}
	 
    /**
     * Get Sync status of SQLite
     * @return
     */
    public boolean getSyncStatus(){
        if(this.dbSyncCount() == 0){
            return false;
        }else{
        	return true; //required
        }
    }
 
    /**
     * Get SQLite records that are yet to be Synced
     * @return
     */
    public int dbSyncCount(){
        int count = 0;
        String selectQuery = "SELECT  * FROM tasks where status = '"+"true"+"'";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        count = cursor.getCount();
        database.close();
        return count;
    } 
    
	public List<String> getSyncableTasks() {
		List<String> taskList = new ArrayList<String>();
		String selectQuery = "SELECT  * FROM tasks where status = '"+"true"+"'";
		SQLiteDatabase database = this.getWritableDatabase();
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				String taskid = cursor.getString(0);
				taskList.add(taskid);
			} while (cursor.moveToNext());
		}
		database.close();
		return taskList;
	}
    
}
