package com.example.kkshop.View.Mine;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kkshop.Controller.Controller;
import com.example.kkshop.Po.DeliverLocation;
import com.example.kkshop.R;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.myholder> {

    private final List locations;
    private final Context context;

    public LocationAdapter(List locations, Context context) {
        this.locations = locations;
        this.context = context;
    }

    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.location_recycle_item,parent,false);
        return new myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myholder holder, final int position) {
        DeliverLocation deliverLocation;
        deliverLocation= (DeliverLocation) locations.get(position);

        holder.tv_name.setText(deliverLocation.getName());
        holder.tv_phone.setText(deliverLocation.getPhone());

        String address = deliverLocation.getCountry() + " " +
                deliverLocation.getCity() + " " +
                deliverLocation.getDistrict() + " " +
                deliverLocation.getStreet() + " " +
                deliverLocation.getDetailedAddress();

        holder.tv_detailed.setText(address);
        if (deliverLocation.getIsdefault()==1){
            holder.tv_default.setText("默认");
        }

        holder.location_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,EditorLocationActivity.class);
                intent.putExtra("Location",(DeliverLocation)locations.get(position));
                context.startActivity(intent);
            }
        });
        holder.location_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeliverLocation deletelocation=(DeliverLocation)locations.get(position);
                if (deletelocation.getIsdefault()==1)
                    Controller.setDefaultlocation(null);

                deletelocation.delete();
            }
        });
    }


    @Override
    public int getItemCount() {
        return locations.size();
    }



    static class myholder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_phone;
        TextView tv_detailed;
        TextView tv_default;
        Button location_edit;
        Button location_delete;

        public myholder(@NonNull final View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.location_item_name);
            tv_phone=itemView.findViewById(R.id.location_item_phone);
            tv_detailed=itemView.findViewById(R.id.location_item_detailed);
            tv_default=itemView.findViewById(R.id.location_item_default);
            location_edit=itemView.findViewById(R.id.location_item_Editor);
            location_delete=itemView.findViewById(R.id.location_item_Delete);
        }
    }
}
