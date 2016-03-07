package hotforms.com.br.realmtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hotforms.com.br.realmtest.R;
import hotforms.com.br.realmtest.model.Person;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

public class PersonAdapter extends RealmBasedRecyclerViewAdapter<Person, PersonAdapter.VersionViewHolder> {
    private RealmResults<Person> mPersonList;
    private LayoutInflater mLayoutInflater;

    public PersonAdapter(Context context, RealmResults<Person> realmResults) {
        super(context, realmResults, true, true);
        mLayoutInflater = LayoutInflater.from(context);
        mPersonList = realmResults;
    }

    @Override
    public VersionViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.cardview_person, viewGroup, false);

        return new VersionViewHolder(view);
    }

    @Override
    public void onBindRealmViewHolder(VersionViewHolder holder, int i) {
        Person person = mPersonList.get(i);

        holder.cardview_person_name.setText(person.getName());
        holder.cardview_person_age.setText(String.valueOf(person.getAge()));
    }

    class VersionViewHolder extends RealmViewHolder {
        TextView cardview_person_name;
        TextView cardview_person_age;

        public VersionViewHolder(View itemView) {
            super(itemView);

            cardview_person_name = (TextView) itemView.findViewById(R.id.cardview_person_name);
            cardview_person_age = (TextView) itemView.findViewById(R.id.cardview_person_age);
        }
    }
}
