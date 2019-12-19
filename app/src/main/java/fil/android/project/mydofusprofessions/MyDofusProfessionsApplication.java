package fil.android.project.mydofusprofessions;


import android.app.Application;

import com.facebook.stetho.Stetho;

import fil.android.project.mydofusprofessions.data.di.FakeDependencyInjection;

public class MyDofusProfessionsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        FakeDependencyInjection.setContext(this);
    }

}
