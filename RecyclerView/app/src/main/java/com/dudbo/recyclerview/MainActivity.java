package com.dudbo.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecyclerView = findViewById(R.id.contactRecyclerView);

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Stephen Hawkings", "sp@gmail.com", "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTY2MzU1NDM3Mzg4NTcyMzM0/stephen-hawking-on-october-10-1979-in-princeton-new-jersey-photo-by-santi-visalligetty-images.jpg"));
        contacts.add(new Contact("Antoine Lavoisier", "AL@hotmail.com", "https://alphahistory.com/frenchrevolution/wp-content/uploads/2015/04/alavoisier.jpg"));
        contacts.add(new Contact("James Maxwell", "JMX@yahoo.com", "https://www.thoughtco.com/thmb/O9PmEH-EhDdIBF7ItkE2MUc9Sfs=/805x1024/filters:fill(auto,1)/GettyImages-525524956-5c739b2846e0fb0001076317.jpg"));
        contacts.add(new Contact("Michael Faraday", "MF@gmail.com", "https://www.onthisday.com/images/people/michael-faraday-medium.jpg"));
        contacts.add(new Contact("Charles Darwin", "ChD@outlook.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Charles_Darwin_seated_crop.jpg/1200px-Charles_Darwin_seated_crop.jpg"));
        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}