package com.example.testbmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BMIActivity extends AppCompatActivity {

	class pdataAdapter extends RecyclerView.Adapter<pdataAdapter.ViewHolder>{

		public pdataAdapter(ArrayList<pdata> pdatalist) {
			this.pdatalist = pdatalist;
		}

		ArrayList<pdata> pdatalist;
		@NonNull
		@Override
		public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
			View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_text,parent,false);
			return new ViewHolder(v1);
		}

		@Override
		public void onBindViewHolder(@NonNull ViewHolder holder, int position){
			double h = pdatalist.get(position).height;
			double w = pdatalist.get(position).weight;
			double bmi = w / ((h / 100.0) * (h / 100.0));
			holder.view_h.setText(String.valueOf(pdatalist.get(position).height));
			holder.view_w.setText(String.valueOf(pdatalist.get(position).weight));
			if (bmi < 18.5) {
				holder.view_img.setImageResource(R.drawable.a1);
			} else if (bmi > 25){
				holder.view_img.setImageResource(R.drawable.a3);
			} else {
				holder.view_img.setImageResource(R.drawable.a2);
			}
		}

		@Override
		public int getItemCount(){
			return pdatalist.size();
		}

		class  ViewHolder extends   RecyclerView.ViewHolder{

			private final TextView view_h;
			private final TextView view_w;
			private final ImageView view_img;

			public ViewHolder(@NonNull View itemView){
				super(itemView);
				view_h = itemView.findViewById(R.id.tv_h);
				view_w = itemView.findViewById(R.id.tv_w);
				view_img = itemView.findViewById(R.id.tv_img);

			}

		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b_m_i);
		Bundle bundle = getIntent().getExtras();
		double w = bundle.getDouble("weight");
		ArrayList<pdata> p = new ArrayList<pdata>();
		p.add(new pdata(190,90));
		p.add(new pdata(170,50));
		p.add(new pdata(172,100));
		p.add(new pdata(190,90));
		p.add(new pdata(170,50));
		p.add(new pdata(172,100));
		RecyclerView recyclerView = findViewById(R.id.RvTest);
		pdataAdapter a = new pdataAdapter(p);
		recyclerView.setAdapter(a);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));




	}
}