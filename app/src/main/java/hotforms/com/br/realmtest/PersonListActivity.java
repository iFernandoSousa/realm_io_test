package hotforms.com.br.realmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import hotforms.com.br.realmtest.adapter.PersonAdapter;
import hotforms.com.br.realmtest.model.Person;
import io.realm.Realm;
import io.realm.RealmResults;

public class PersonListActivity extends AppCompatActivity {
    RealmResults<Person> personList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        recyclerView = (RecyclerView) findViewById(R.id.person_recyclerView);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        Realm realm = Realm.getInstance(this);
        personList = realm.where(Person.class).findAll();
        recyclerView.setAdapter(new PersonAdapter(PersonListActivity.this, personList));
    }
}
