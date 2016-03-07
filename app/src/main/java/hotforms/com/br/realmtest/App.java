package hotforms.com.br.realmtest;

import android.app.Application;

import hotforms.com.br.realmtest.model.RealmLocalConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmLocalConfiguration.init(this);
    }
}
