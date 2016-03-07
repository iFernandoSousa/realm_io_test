package hotforms.com.br.realmtest.model;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmLocalConfiguration {
    public static void init(Context context) {
        RealmConfiguration config = new RealmConfiguration.Builder(context)
                .name("database.realm")
                        //.encryptionKey(getKey())
                .schemaVersion(42)
                        //.setModules(new MySchemaModule())
                        //.migration(new MyMigration())
                .build();

        // Use the config
        Realm.setDefaultConfiguration(config);
        Realm.getDefaultInstance();
    }
}
