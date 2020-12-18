package com.dudbo.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.viewHolder> {

///////////////////////////////
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private Context context;
    public ContactsRecyclerViewAdapter(Context context) {
        this.context = context;
    }


    //Necessary methods for AdapterView
    @NonNull
    @Override
    //initialise the viewHolder for every contact in Recycler view
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        return (new viewHolder(view));
    }

    //Attach contacts to the viewHolder
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.txtEmail.setText(contacts.get(position).getEmail());
        Glide.with(context).asBitmap().load(contacts.get(position).getImageURL()).into(holder.image);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Selected " + contacts.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Return the number of contacts
    @Override
    public int getItemCount() {
        return contacts.size();
    }
/////////////////////////////////////////
    //Update contact info into the ArrayList
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    //This class is responsible for holding the contacts in recycler view-- needs AdapterView
    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtEmail;
        private CardView parent;
        private ImageView image;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            image = itemView.findViewById(R.id.image);
        }
    }
}
