package uk.ac.openmf.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.ac.openmf.mobile.syncdown.DBController;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.appspot.openmicrofinance.usersapi.Usersapi;
import com.appspot.openmicrofinance.usersapi.model.OpenMFUser;
import com.appspot.openmicrofinance.usersapi.model.OpenMFUserCollection;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

public class UsersListActivity extends ListActivity {
	private TextView tv = null;
	private ArrayList<Map<String,String>> list = null;
	private SimpleAdapter adapter = null;
	private String[] from = { "Username", "Role" };
	private int[] to = { android.R.id.text1, android.R.id.text2};
	DBController controller = new DBController(this);
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setText("List of Users");
		tv.setGravity(Gravity.CENTER);
		getListView().addHeaderView(tv);
		//new OpenMFUsersListAsyncUser(this).execute();
		ArrayList<Map<String,String>> tmplist = new ArrayList<Map<String,String>>();
		Map<String, HashMap<String, String>> userList = controller.getAllUsers();
		for (Map<String, String> user : userList.values()) {
			HashMap<String, String> item = new HashMap<String, String>();
			for (Map.Entry<String, String> entry : user.entrySet())
			{
				item.put(entry.getKey(), entry.getValue());
			}
			tmplist.add(item);			
		}
		// If users exists in SQLite DB
		if (tmplist.size() != 0) {
			// Set the User Array list in ListView
			ListAdapter adapter = new SimpleAdapter(UsersListActivity.this, tmplist, R.layout.view_user_entry, new String[] {
							"userId", "username", "address", "contact", "email", "enabled", "forename", "main_office", "role", "supervisor", "surname" }, new int[] { R.id.userId, R.id.username, R.id.address, R.id.contact, R.id.email, R.id.enabled, R.id.forename, R.id.main_office, R.id.role, R.id.supervisor, R.id.surname });
			ListView myList = (ListView) findViewById(android.R.id.list);
			myList.setAdapter(adapter);
		}

	}

	private class OpenMFUsersListAsyncUser extends AsyncTask<Void, Void, OpenMFUserCollection>{
		  Context context;
		  private ProgressDialog pd;

		  public OpenMFUsersListAsyncUser(Context context) {
		    this.context = context;
		  }
		  
		  protected void onPreExecute(){ 
		     super.onPreExecute();
		          pd = new ProgressDialog(context);
		          pd.setMessage("Retrieving OpenMFUsers...");
		          pd.show();    
		  }

		  protected OpenMFUserCollection doInBackground(Void... unused) {
			  OpenMFUserCollection tasks = null;
		    try {
		    	Usersapi.Builder builder = new Usersapi.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
				Usersapi service =  builder.build();
				tasks = service.list().execute();
		    } catch (Exception e) {
		      Log.d("Could not retrieve OpenMFUsers", e.getMessage(), e);
		    }
		    return tasks;
		  }

		  protected void onPostExecute(OpenMFUserCollection users) {
			  pd.dismiss();
		    // Do something with the result.
 			   ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			   List<OpenMFUser> _list = users.getItems();
				for (OpenMFUser user : _list) {
					HashMap<String, String> item = new HashMap<String, String>();
					item.put("Username", user.getUsername());
					item.put("Role", user.getRole());
			 	    list.add(item);
				}
				adapter = new SimpleAdapter(UsersListActivity.this, list,android.R.layout.simple_list_item_2, from, to);
				setListAdapter(adapter);
		  }
		}
}
