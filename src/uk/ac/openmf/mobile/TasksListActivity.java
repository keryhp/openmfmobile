package uk.ac.openmf.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.ac.openmf.mobile.syncdown.DBController;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.appspot.openmicrofinance.taskapi.Taskapi;
import com.appspot.openmicrofinance.taskapi.model.OpenMFTask;
import com.appspot.openmicrofinance.taskapi.model.OpenMFTaskCollection;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

public class TasksListActivity extends ListActivity {
	private TextView tv = null;
	private ArrayList<Map<String,String>> list = null;
	private SimpleAdapter adapter = null;
	private String[] from = { "Assigned To", "Date Assigned" };
	private int[] to = { android.R.id.text1, android.R.id.text2};
	DBController controller = new DBController(this);

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setText("List of Tasks");
		tv.setGravity(Gravity.CENTER);
		getListView().addHeaderView(tv);
		//new OpenMFTasksListAsyncTask(this).execute();
		ArrayList<Map<String,String>> tmplist = new ArrayList<Map<String,String>>();
		Map<String, HashMap<String, String>> taskList = controller.getAllTasks();
		for (Map<String, String> task : taskList.values()) {
			HashMap<String, String> item = new HashMap<String, String>();
			for (Map.Entry<String, String> entry : task.entrySet())
			{
				item.put(entry.getKey(), entry.getValue());
			}
			tmplist.add(item);			
		}
		// If users exists in SQLite DB
		if (tmplist.size() != 0) {
			// Set the User Array list in ListView
			ListAdapter adapter = new SimpleAdapter(TasksListActivity.this, tmplist, R.layout.view_task_entry, new String[] {
					"taskId", "accountnumber", "amount" , "assignedto" , "cashier" , "collectiontype" , "dateassigned" , "datecompleted" , "description" , "newclient" , "status" }, new int[] { R.id.taskId, R.id.accountnumber, R.id.amount, R.id.assignedto, R.id.cashier, R.id.collectiontype, R.id.dateassigned, R.id.datecompleted, R.id.description, R.id.newclient, R.id.status });
			ListView myList = (ListView) findViewById(android.R.id.list);
			myList.setAdapter(adapter);
		}

	}

	private class OpenMFTasksListAsyncTask extends AsyncTask<Void, Void, OpenMFTaskCollection>{
		Context context;
		private ProgressDialog pd;

		public OpenMFTasksListAsyncTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute(){ 
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Retrieving OpenMFTasks...");
			pd.show();    
		}

		protected OpenMFTaskCollection doInBackground(Void... unused) {
			OpenMFTaskCollection tasks = null;
			try {
				Taskapi.Builder builder = new Taskapi.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
				Taskapi service =  builder.build();
				tasks = service.list().execute();
			} catch (Exception e) {
				Log.d("Could not retrieve OpenMFTasks", e.getMessage(), e);
			}
			return tasks;
		}

		protected void onPostExecute(OpenMFTaskCollection tasks) {
			pd.dismiss();
			// Do something with the result.
			ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			List<OpenMFTask> _list = tasks.getItems();
			for (OpenMFTask task : _list) {
				HashMap<String, String> item = new HashMap<String, String>();
				//item.put("TaskId", task.getTaskId());
				item.put("Assigned To", task.getAssignedto());
				/*item.put("Acc#", task.getAccountnumber());
					item.put("Amount", task.getAmount());
					item.put("Collection Type", task.getCollectiontype());*/
				item.put("Date Assigned", task.getDateassigned());
				list.add(item);
			}
			adapter = new SimpleAdapter(TasksListActivity.this, list,android.R.layout.simple_list_item_2, from, to);
			setListAdapter(adapter);
		}
	}

	public void taskCompleteHandler(View v) 
	{
		LinearLayout vwParentRow = (LinearLayout)v.getParent();
		TextView child = (TextView)vwParentRow.findViewById(R.id.taskId);
		Button btnChild = (Button)vwParentRow.getChildAt(11);
		System.out.println("Completing task " + child.getText());
		controller.updateTask(child.getText().toString());
		btnChild.setText("Complete");
		vwParentRow.refreshDrawableState();       
	}
}
