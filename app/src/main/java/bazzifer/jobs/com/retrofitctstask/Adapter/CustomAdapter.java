package bazzifer.jobs.com.retrofitctstask.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bazzifer.jobs.com.retrofitctstask.MainActivity;
import bazzifer.jobs.com.retrofitctstask.Model.APIResponse;
import bazzifer.jobs.com.retrofitctstask.Model.EmployeeListItem;
import bazzifer.jobs.com.retrofitctstask.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.customvh> {
    Activity activity;
    List<EmployeeListItem> list;

    public CustomAdapter(MainActivity mainActivity, List<EmployeeListItem> body) {
        this.activity = mainActivity;
        this.list = body;
    }

    @NonNull
    @Override
    public CustomAdapter.customvh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.activity_resullt, viewGroup, false);
        return new customvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.customvh customvh, int i) {
        customvh.name.setText(list.get(i).getName());
        customvh.phone.setText(list.get(i).getPhone());
        customvh.email.setText(list.get(i).getEmail());
        Picasso.with(activity).load("https://cdn-images-1.medium.com/max/2560/1*zQ8lmPudBJ1sdtzlkbaA7Q.png").into(customvh.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class customvh extends RecyclerView.ViewHolder {
        @InjectView(R.id.textView)
        TextView name;
        @InjectView(R.id.textView1)
        TextView phone;
        @InjectView(R.id.textView2)
        TextView email;
        @InjectView(R.id.imageView)
        ImageView imageView;

        public customvh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
