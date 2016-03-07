package hotforms.com.br.realmtest.services;

import android.content.Context;

import hotforms.com.br.realmtest.model.Person;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class PersonServices {
    private Context mContext;

    public PersonServices(Context context) {
        mContext = context;
    }

    public RealmResults<Person> getPerson() {
        Realm realm = Realm.getInstance(mContext);
        RealmQuery<Person> personRealmQuery = realm.where(Person.class);

        return personRealmQuery.findAllSorted("Name");
    }

    public void populate(int totalRecords) {
        Realm realm = Realm.getInstance(mContext);

        if (realm.where(Person.class).count() == 0) {
            realm.beginTransaction();

            for (int i = 1; i < totalRecords; i++) {
                Person person = realm.createObject(Person.class);
                person.setId(i);
                person.setAge(i);
                person.setName(String.format("Name %s", i));
            }

            realm.commitTransaction();
        }
    }
}