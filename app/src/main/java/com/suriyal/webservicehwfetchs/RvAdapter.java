package com.suriyal.webservicehwfetchs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PVHolder> {


    private Context context;
    private List<DataModel> productList;

    //parameterised constructor
    public RvAdapter(Context context, List<DataModel> productList) {
        this.context = context;
        this.productList = productList;
    }


    @Override
    public PVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        return new PVHolder(view);
        // LayoutInflater inflater = LayoutInflater.from(context);
        // View view = inflater.inflate(R.layout.list_data, null);
        //return new PVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PVHolder holder, int position) {


        final DataModel data = productList.get(position);
        holder.tvId.setText(String.valueOf(data.getId()));
        holder.tvName.setText(data.getName());
        holder.tvSalary.setText(String.valueOf(data.getSalary()));
//        holder.tvSalary.setText(data.getSalary());
        holder.tvPhone.setText(data.getPhone());


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class PVHolder extends RecyclerView.ViewHolder {
        private TextView tvId, tvName, tvSalary, tvPhone;

        public PVHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.etId);
            tvName = itemView.findViewById(R.id.etName);
            tvSalary = itemView.findViewById(R.id.etSalary);
            tvPhone = itemView.findViewById(R.id.etPhone);
        }

    }

}
