package uk.ac.openmf.mobile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.appspot.openmicrofinance.taskapi.Taskapi;
import com.appspot.openmicrofinance.taskapi.model.OpenMFTask;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

public class UpdateTaskActivity extends Activity {

	CheckBox updateTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_updatetask);
		
		//Event Listener for About App button
		/*Button btnUpdateTask = (Button)findViewById(R.id.btnUpdateTask);
		btnUpdateTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Check if values are provided
				String updateTaskVal = updateTask.getText().toString().trim();
								
				//Go ahead and perform the transaction
				String[] params = {updateTaskVal};
				new AddOpenMFTaskAsyncTask(UpdateTaskActivity.this).execute(params);
				
			}
		});*/
		
	}
	
	private class AddOpenMFTaskAsyncTask extends AsyncTask<String, Void, OpenMFTask>{
		  Context context;
		  private ProgressDialog pd;

		  public AddOpenMFTaskAsyncTask(Context context) {
		    this.context = context;
		  }
		  
		  protected void onPreExecute(){ 
		     super.onPreExecute();
		          pd = new ProgressDialog(context);
		          pd.setMessage("Completing the OpenMFTask...");
		          pd.show();    
		  }

		  protected OpenMFTask doInBackground(String... params) {
			  OpenMFTask response = null;
		    try {
		    	Taskapi.Builder builder = new Taskapi.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
				Taskapi service =  builder.build();
				OpenMFTask task = new OpenMFTask();
				task.setStatus(new Boolean(params[0]));
				response = service.update("").execute(); //TODO add task id
		    } catch (Exception e) {
		      Log.d("Could not Add OpenMFTask", e.getMessage(), e);
		    }
		    return response;
		  }

		  protected void onPostExecute(OpenMFTask task) {
			  //Clear the progress dialog and the fields
			  pd.dismiss();
			  updateTask.setText("");
			  
			  //Display success message to user
			  Toast.makeText(getBaseContext(), "OpenMFTask updated succesfully", Toast.LENGTH_SHORT).show();
		  }
		}


}
