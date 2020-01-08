package fil.android.project.mydofusprofessions.data.di;

import android.content.Context;

import androidx.room.Room;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import fil.android.project.mydofusprofessions.data.database.MyProfessionsDatabase;
import fil.android.project.mydofusprofessions.data.repository.detail.ProfessionDetailDataRepository;
import fil.android.project.mydofusprofessions.data.repository.detail.ProfessionDetailRemoteDataSource;
import fil.android.project.mydofusprofessions.data.repository.list.ProfessionListDataRepository;
import fil.android.project.mydofusprofessions.data.repository.list.locale.ProfessionListLocaleDataSource;
import fil.android.project.mydofusprofessions.data.repository.list.remote.ProfessionListRemoteDataSource;
import fil.android.project.mydofusprofessions.data.repository.list.mapper.ProfessionToProfessionEntityMapper;
import fil.android.project.mydofusprofessions.data.services.ProfessionService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FakeDependencyInjection {

    private static Retrofit retrofit;
    private static Gson gson;
    private static Context applicationContext;

    private static ProfessionService professionService;
    private static ProfessionDetailDataRepository professionDetailDataRepository;
    private static ProfessionListDataRepository professionListDataRepository;

    private static MyProfessionsDatabase myProfessionsDatabase;


    private static final String API_URL = "https://fr.dofus.dofapi.fr/";

    public static ProfessionListDataRepository getProfessionListDataRepository() {
        if(professionListDataRepository == null) {
            ProfessionListRemoteDataSource professionListRemoteDataSource = new ProfessionListRemoteDataSource(getProfessionService());
            ProfessionListLocaleDataSource professionListLocaleDataSource = new ProfessionListLocaleDataSource(getMyProfessionsDatabase());
            ProfessionToProfessionEntityMapper professionToProfessionEntityMapper = new ProfessionToProfessionEntityMapper();
            professionListDataRepository = new ProfessionListDataRepository(professionListRemoteDataSource, professionListLocaleDataSource, professionToProfessionEntityMapper);
        }
        return professionListDataRepository;
    }

    public static ProfessionDetailDataRepository getProfessionDetailDataRepository() {
        if(professionDetailDataRepository == null) {
            ProfessionDetailRemoteDataSource professionDetailRemoteDataSource = new ProfessionDetailRemoteDataSource(getProfessionService());
            professionDetailDataRepository = new ProfessionDetailDataRepository(professionDetailRemoteDataSource);
        }
        return professionDetailDataRepository;
    }

    public static ProfessionService getProfessionService() {
        if(professionService == null) {
            professionService = getRetrofit().create(ProfessionService.class);
        }
        return professionService;
    }

    public static MyProfessionsDatabase getMyProfessionsDatabase() {
        if (myProfessionsDatabase == null) {
            myProfessionsDatabase = Room.databaseBuilder(applicationContext.getApplicationContext(), MyProfessionsDatabase.class, "my-professions-database").build();
        }
        return myProfessionsDatabase;
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
        }
        return retrofit;
    }

    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static void setContext(Context context) {
        applicationContext = context;
    }

}
