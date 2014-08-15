package uk.ac.openmf.mobile;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import uk.ac.openmf.mobile.syncdown.DBController;
import uk.ac.openmf.mobile.syncdown.SampleBC;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends ActionBarActivity {
	// DB Class to perform DB related operations
	DBController controller = new DBController(this);
	// Progress Dialog Object
	ProgressDialog prgDialog;
	HashMap<String, String> queryValues;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initialize Progress Dialog properties
		prgDialog = new ProgressDialog(this);
		prgDialog.setMessage("Transferring Data from Remote MySQL DB and Syncing SQLite. Please wait...");
		prgDialog.setCancelable(false);
		// BroadCase Receiver Intent Object
		Intent alarmIntent = new Intent(getApplicationContext(), SampleBC.class);
		// Pending Intent Object
		PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		// Alarm Manager Object
		AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
		// Alarm Manager calls BroadCast for every Ten seconds (10 * 1000), BroadCase further calls service to check if new records are inserted in 
		// Remote MySQL DB
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + 5000, 10 * 1000, pendingIntent);

		//Event Listener for About App button
		Button btnAboutApp = (Button)findViewById(R.id.btnAboutApp);
		btnAboutApp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);		
				builder.setTitle("About Application");
				builder.setMessage("OpenMF Mobile\r\nVersion 1.0");
				builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				builder.show();
			}
		});


		//Event Listener for List Tasks button
		Button btnListTasks = (Button)findViewById(R.id.btnListTasks);
		btnListTasks.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, TasksListActivity.class);
				startActivity(myIntent);
			}
		});

		//Event Listener for List Tasks button
		Button btnListUsers = (Button)findViewById(R.id.btnListUsers);
		btnListUsers.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, UsersListActivity.class);
				startActivity(myIntent);
			}
		});

		//Event Listener for List Tasks button
		Button btnListClients = (Button)findViewById(R.id.btnListClients);
		btnListClients.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, ClientsListActivity.class);
				startActivity(myIntent);
			}
		});

		/*//Event Listener for Add Task button
		Button btnUpdateTask = (Button)findViewById(R.id.btnUpdateTask);
		btnUpdateTask.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, UpdateTaskActivity.class);
				startActivity(myIntent);
			}
		});*/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// When Options Menu is selected
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. 
		int id = item.getItemId();
		// When Sync action button is clicked
		if (id == R.id.refresh) {
			// Transfer data from remote MySQL DB to SQLite on Android and perform Sync
			syncSQLiteMySQLDB();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// Method to Sync MySQL to SQLite DB
	public void syncSQLiteMySQLDB() {
		// Create AsycHttpClient object
		AsyncHttpClient client = new AsyncHttpClient();
		// Http Request Params Object
		RequestParams params = new RequestParams();
		// Show ProgressBar
		prgDialog.show();
		// Make Http call to getusers
		client.get("https://openmicrofinance.appspot.com/_ah/api/usersapi/v1/openmfusercollection", params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				// Hide ProgressBar
				//prgDialog.hide();
				// Update SQLite DB with response sent by getusers.php
				updateUsersSQLite(response);
			}
			// When error occured
			@Override
			public void onFailure(int statusCode, Throwable error, String content) {
				// TODO Auto-generated method stub
				// Hide ProgressBar
				prgDialog.hide();
				if (statusCode == 404) {
					Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
				} else if (statusCode == 500) {
					Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet]",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		// Make Http call to gettasks
		client.get("https://openmicrofinance.appspot.com/_ah/api/taskapi/v1/openmftaskcollection", params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				// Hide ProgressBar
				//prgDialog.hide();
				// Update SQLite DB with response sent by getusers.php
				updateTasksSQLite(response);
			}
			// When error occured
			@Override
			public void onFailure(int statusCode, Throwable error, String content) {
				// TODO Auto-generated method stub
				// Hide ProgressBar
				prgDialog.hide();
				if (statusCode == 404) {
					Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
				} else if (statusCode == 500) {
					Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet]",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		// Make Http call to getclients
		client.get("https://openmicrofinance.appspot.com/_ah/api/clientsapi/v1/openmfclientcollection", params, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String response) {
				// Hide ProgressBar
				prgDialog.hide();
				// Update SQLite DB with response sent by getusers.php
				updateClientsSQLite(response);
			}
			// When error occured
			@Override
			public void onFailure(int statusCode, Throwable error, String content) {
				// TODO Auto-generated method stub
				// Hide ProgressBar
				prgDialog.hide();
				if (statusCode == 404) {
					Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
				} else if (statusCode == 500) {
					Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet]",
							Toast.LENGTH_LONG).show();
				}
			}
		});
		
		if(controller.getSyncStatus()){
			List<String> taskList = controller.getSyncableTasks();
			for (String taskId : taskList) {
				// Make Http call to gettasks
				client.put("https://openmicrofinance.appspot.com/_ah/api/taskapi/v1/openmftask/" + taskId, params, new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						//System.out.println("Taskid completed" + response);
						//delete from local sqlitedb
						String taskId = getTaskId(response);
						if(taskId != null)
						controller.removeTask(taskId);
					}
					// When error occured
					@Override
					public void onFailure(int statusCode, Throwable error, String content) {
						// TODO Auto-generated method stub
						// Hide ProgressBar
						prgDialog.hide();
						if (statusCode == 404) {
							Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
						} else if (statusCode == 500) {
							Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
						} else {
							Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet]",
									Toast.LENGTH_LONG).show();
						}
					}
				});
			}
		}
	}

	public void updateUsersSQLite(String response){
		Map<String, HashMap<String, String>> usersAvailList = controller.getAllUsers();
		// Create GSON object
		Gson gson = new GsonBuilder().create();
		try {
			JSONObject jobj = new JSONObject(response);
			// Extract JSON array from the response
			JSONArray arr = jobj.getJSONArray("items"); //new JSONArray(response);
			System.out.println(arr.length());
			// If no of array elements is not zero
			if(arr.length() != 0){
				// Loop through each array element, get JSON object which has user data
				for (int i = 0; i < arr.length(); i++) {
					// Get JSON object
					JSONObject obj = (JSONObject) arr.get(i);
					if(!usersAvailList.containsKey(obj.get("id").toString())){
						//					System.out.println(obj.get("id"));
						//					System.out.println(obj.get("username"));
						// DB QueryValues Object to insert into SQLite
						queryValues = new HashMap<String, String>();
						// Add userID extracted from Object
						queryValues.put("userId", obj.get("id").toString());
						// Add userName extracted from Object
						queryValues.put("username", obj.get("username").toString());
						if(obj.has("address"))
							queryValues.put("address", obj.get("address").toString());
						else
							queryValues.put("address", "");
						if(obj.has("contact"))
							queryValues.put("contact", obj.get("contact").toString());
						else
							queryValues.put("contact", "");
						queryValues.put("email", obj.get("email").toString());
						queryValues.put("enabled", obj.get("enabled").toString());
						queryValues.put("forename", obj.get("forename").toString());
						queryValues.put("main_office", obj.get("main_office").toString());
						queryValues.put("password", obj.get("password").toString());
						queryValues.put("role", obj.get("role").toString());
						if(obj.has("supervisor"))
							queryValues.put("supervisor", obj.get("supervisor").toString());
						else
							queryValues.put("supervisor", "");
						queryValues.put("surname", obj.get("surname").toString());
						// Insert User into SQLite DB
						controller.insertUser(queryValues);
					}
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateTasksSQLite(String response){
		Map<String, HashMap<String, String>> usersAvailList = controller.getAllTasks();
		// Create GSON object
		Gson gson = new GsonBuilder().create();
		try {
			JSONObject jobj = new JSONObject(response);
			// Extract JSON array from the response
			JSONArray arr = jobj.getJSONArray("items"); //new JSONArray(response);
			System.out.println(arr.length());
			// If no of array elements is not zero
			if(arr.length() != 0){
				// Loop through each array element, get JSON object which has task data
				for (int i = 0; i < arr.length(); i++) {
					// Get JSON object
					JSONObject obj = (JSONObject) arr.get(i);
					if(!usersAvailList.containsKey(obj.get("id").toString())){
						// DB QueryValues Object to insert into SQLite
						queryValues = new HashMap<String, String>();
						queryValues.put("taskId", obj.get("id").toString());
						if(obj.has("accountnumber"))
							queryValues.put("accountnumber", obj.get("accountnumber").toString());
						else
							queryValues.put("accountnumber", "");
						if(obj.has("amount"))
							queryValues.put("amount", obj.get("amount").toString());
						else
							queryValues.put("amount", "");
						if(obj.has("cashier"))
							queryValues.put("cashier", obj.get("cashier").toString());
						else
							queryValues.put("cashier", "");
						queryValues.put("assignedto", obj.get("assignedto").toString());
						queryValues.put("collectiontype", obj.get("collectiontype").toString());
						queryValues.put("dateassigned", obj.get("dateassigned").toString());
						if(obj.has("datecompleted"))
							queryValues.put("datecompleted", obj.get("datecompleted").toString());
						else
							queryValues.put("datecompleted", "");
						if(obj.has("newclient"))
							queryValues.put("newclient", obj.get("newclient").toString());
						else
							queryValues.put("newclient", "");

						if(obj.has("description"))
							queryValues.put("description", obj.get("description").toString());
						else
							queryValues.put("description", "");

						if(obj.has("status"))
							queryValues.put("status", obj.get("status").toString());
						else
							queryValues.put("status", "");

						// Insert User into SQLite DB
						controller.insertTask(queryValues);
					}
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateClientsSQLite(String response){
		Map<String, HashMap<String, String>> usersAvailList = controller.getAllUsers();
		// Create GSON object
		Gson gson = new GsonBuilder().create();
		try {
			JSONObject jobj = new JSONObject(response);
			// Extract JSON array from the response
			JSONArray arr = jobj.getJSONArray("items"); //new JSONArray(response);
			System.out.println(arr.length());
			// If no of array elements is not zero
			if(arr.length() != 0){
				// Loop through each array element, get JSON object which has user data
				for (int i = 0; i < arr.length(); i++) {
					// Get JSON object
					JSONObject obj = (JSONObject) arr.get(i);
					if(!usersAvailList.containsKey(obj.get("id").toString())){
						// DB QueryValues Object to insert into SQLite
						queryValues = new HashMap<String, String>();
						// Add userID extracted from Object
						queryValues.put("clientId", obj.get("id").toString());
						if(obj.has("accountnumber"))
							queryValues.put("accountnumber", obj.get("accountnumber").toString());
						else
							queryValues.put("accountnumber", "");
						if(obj.has("activationdate"))
							queryValues.put("activationdate", obj.get("activationdate").toString());
						else
							queryValues.put("activationdate", "");
						if(obj.has("active"))
							queryValues.put("active", obj.get("active").toString());
						else
							queryValues.put("active", "");
						if(obj.has("address"))
							queryValues.put("address", obj.get("address").toString());
						else
							queryValues.put("address", "");
						if(obj.has("balance"))
							queryValues.put("balance", obj.get("balance").toString());
						else
							queryValues.put("balance", "");
						if(obj.has("blacklisted"))
							queryValues.put("blacklisted", obj.get("blacklisted").toString());
						else
							queryValues.put("blacklisted", "");
						if(obj.has("clientclassification"))
							queryValues.put("clientclassification", obj.get("clientclassification").toString());
						else
							queryValues.put("clientclassification", "");
						if(obj.has("clienttype"))
							queryValues.put("clienttype", obj.get("clienttype").toString());
						else
							queryValues.put("clienttype", "");
						if(obj.has("contact"))
							queryValues.put("contact", obj.get("contact").toString());
						else
							queryValues.put("contact", "");
						if(obj.has("dateofbirth"))
							queryValues.put("dateofbirth", obj.get("dateofbirth").toString());
						else
							queryValues.put("dateofbirth", "");
						if(obj.has("eligible"))
							queryValues.put("eligible", obj.get("eligible").toString());
						else
							queryValues.put("eligible", "");
						if(obj.has("surname"))
							queryValues.put("surname", obj.get("surname").toString());
						else
							queryValues.put("surname", "");
						if(obj.has("forename"))
							queryValues.put("forename", obj.get("forename").toString());
						else
							queryValues.put("forename", "");
						if(obj.has("supervisor"))
							queryValues.put("supervisor", obj.get("supervisor").toString());
						else
							queryValues.put("supervisor", "");

						if(obj.has("externalId"))
							queryValues.put("externalId", obj.get("externalId").toString());
						else
							queryValues.put("externalId", "");
						if(obj.has("gender"))
							queryValues.put("gender", obj.get("gender").toString());
						else
							queryValues.put("gender", "");
						if(obj.has("groupid"))
							queryValues.put("groupid", obj.get("groupid").toString());
						else
							queryValues.put("groupid", "");
						if(obj.has("main_office"))
							queryValues.put("main_office", obj.get("main_office").toString());
						else
							queryValues.put("main_office", "");
						if(obj.has("midname"))
							queryValues.put("midname", obj.get("midname").toString());
						else
							queryValues.put("midname", "");
						if(obj.has("forename"))
							queryValues.put("submittedon", obj.get("submittedon").toString());
						else
							queryValues.put("submittedon", "");

						// Insert User into SQLite DB
						controller.insertClient(queryValues);
					}
				}
				// Reload the Main Activity
				//reloadActivity();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTaskId(String response){
		String taskId = null;
		try {
			JSONObject jobj = new JSONObject(response);
			// Extract JSON array from the response
			taskId = (String)jobj.get("id");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taskId;
	}
	// Reload MainActivity
	public void reloadActivity() {
		Intent objIntent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(objIntent);
	}

}
