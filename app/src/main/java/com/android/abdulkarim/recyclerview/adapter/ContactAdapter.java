package com.android.abdulkarim.recyclerview.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.abdulkarim.recyclerview.interfaces.OnItemClickListener;
import com.android.abdulkarim.recyclerview.R;
import com.android.abdulkarim.recyclerview.model.Contact;

import com.zhiqing.recyclerview_lib.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private List<Contact> contactList;
    private String[] iColors = {"#3F51B5","#F44336","#009688","#673AB7"};

    private OnItemClickListener onItemClickListener;

    public ContactAdapter(List<Contact> contactList,OnItemClickListener onItemClickListener){
        this.contactList = contactList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ContactAdapter.MyViewHolder holder, final int position) {

        holder.icon.setBackgroundColor(Color.parseColor(iColors[position % 4]));
        holder.icon.setText(String.valueOf(contactList.get(position).getContactName()));
        holder.contactName.setText(contactList.get(position).getContactName());
        holder.contactNumber.setText(contactList.get(position).getContactNumber());
        holder.cTime.setText(contactList.get(position).getcTime());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView icon,contactName,contactNumber,cTime;
        private RelativeLayout iconBackground;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactNameTextView);
            contactNumber = itemView.findViewById(R.id.contactNumberTextView);
            cTime = itemView.findViewById(R.id.cTimeTextView);
            icon = itemView.findViewById(R.id.iconTextView);
            iconBackground = itemView.findViewById(R.id.iconRL);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
