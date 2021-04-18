package com.example.testbmi;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {


	class personAdapter extends RecyclerView.Adapter<personAdapter.personViewHolder>{

		public personAdapter(@NonNull List<person> personList) {
			this.personList = personList;
		}

		@NonNull

		List<person> personList;

		@Override

		public personViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType){
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bmilist,parent,false);
			return new personViewHolder(view);
		}
		@Override
		public void onBindViewHolder(@NonNull personViewHolder holder , int position){
			person p = personList.get(position);
			holder.height.setText(String.valueOf(p.getHeight()));
			holder.weight.setText(String.valueOf(p.getWeight()));

		}
		@Override
		public int getItemCount(){
			return  personList.size();
		}

		class personViewHolder extends RecyclerView.ViewHolder{

			private final TextView height;
			private final TextView weight;

			public personViewHolder(@NonNull View itemView){
				super(itemView);
				height = itemView.findViewById(R.id.tvheight);
				weight = itemView.findViewById(R.id.tvweight);
			}
		}
	}
    @RequiresApi(api = Build.VERSION_CODES.R)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		Bundle bundle = getIntent().getExtras();
		String h = bundle.getString("height");
		String w = bundle.getString("weight");
		Log.d("h",h);
		Log.d("w",w);

		List<person> personList = new ArrayList<person>();
		personList.add(new person(Double.parseDouble(h),Double.parseDouble(w)));
		RecyclerView recyclerView = findViewById(R.id.RvBMIList);
		personAdapter personAdapter = new personAdapter(personList);
		recyclerView.setAdapter(personAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

	}
}