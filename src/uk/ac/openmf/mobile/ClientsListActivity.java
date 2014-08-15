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

import com.appspot.openmicrofinance.clientsapi.Clientsapi;
import com.appspot.openmicrofinance.clientsapi.model.OpenMFClient;
import com.appspot.openmicrofinance.clientsapi.model.OpenMFClientCollection;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

public class ClientsListActivity extends ListActivity {
	private TextView tv = null;
	private ArrayList<Map<String,String>> list = null;
	private SimpleAdapter adapter = null;
	private String[] from = { "Name", "Acc#" };
	private int[] to = { android.R.id.text1, android.R.id.text2};
	DBController controller = new DBController(this);
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setText("List of Clients");
		tv.setGravity(Gravity.CENTER);
		getListView().addHeaderView(tv);
		//new OpenMFClientsListAsyncClient(this).execute();
		ArrayList<Map<String,String>> tmplist = new ArrayList<Map<String,String>>();
		Map<String, HashMap<String, String>> clientList = controller.getAllClients();
		for (Map<String, String> client : clientList.values()) {
			HashMap<String, String> item = new HashMap<String, String>();
			for (Map.Entry<String, String> entry : client.entrySet())
			{
				item.put(entry.getKey(), entry.getValue());
			}
			tmplist.add(item);			
		}
		// If users exists in SQLite DB
		if (tmplist.size() != 0) {
			// Set the User Array list in ListView
			ListAdapter adapter = new SimpleAdapter(ClientsListActivity.this, tmplist, R.layout.view_client_entry, new String[] {
							"clientId", "accountnumber", "activationdate", "active", "address", "balance", "blacklisted", "clientclassification", "clienttype", "contact", "dateofbirth", "eligible", "externalId", "forename", "gender", "groupid", "main_office", "midname", "submittedon", "supervisor", "surname" }, 
			new int[] { R.id.clientId, R.id.accountnumber, R.id.activationdate, R.id.active, R.id.address, R.id.balance, R.id.blacklisted, R.id.clientclassification, R.id.clienttype, R.id.contact, R.id.dateofbirth, R.id.eligible, R.id.externalId, R.id.forename, R.id.gender, R.id.groupid, R.id.main_office, R.id.midname, R.id.submittedon, R.id.supervisor, R.id.surname });
			ListView myList = (ListView) findViewById(android.R.id.list);
			myList.setAdapter(adapter);
		}

	}

	private class OpenMFClientsListAsyncClient extends AsyncTask<Void, Void, OpenMFClientCollection>{
		  Context context;
		  private ProgressDialog pd;

		  public OpenMFClientsListAsyncClient(Context context) {
		    this.context = context;
		  }
		  
		  protected void onPreExecute(){ 
		     super.onPreExecute();
		          pd = new ProgressDialog(context);
		          pd.setMessage("Retrieving OpenMFClients...");
		          pd.show();    
		  }

		  protected OpenMFClientCollection doInBackground(Void... unused) {
			  OpenMFClientCollection clients = null;
		    try {
		    	Clientsapi.Builder builder = new Clientsapi.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
				Clientsapi service =  builder.build();
				clients = service.list().execute();
		    } catch (Exception e) {
		      Log.d("Could not retrieve OpenMFClients", e.getMessage(), e);
		    }
		    return clients;
		  }

		  protected void onPostExecute(OpenMFClientCollection clients) {
			  pd.dismiss();
		    // Do something with the result.
 			   ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			   List<OpenMFClient> _list = clients.getItems();
				for (OpenMFClient client : _list) {
					HashMap<String, String> item = new HashMap<String, String>();
					item.put("Name", client.getForename() + " " + client.getSurname());
					item.put("Acc#", client.getAccountNumber());
			 	    list.add(item);
				}
				adapter = new SimpleAdapter(ClientsListActivity.this, list,android.R.layout.simple_list_item_2, from, to);
				setListAdapter(adapter);
		  }
		}
}
