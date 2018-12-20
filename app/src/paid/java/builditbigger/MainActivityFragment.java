package builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.jokeme.thejokersplayground.DisplayJokes;
import com.udacity.gradle.builditbigger.ConstantUtils;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;*/


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button btTellJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        btTellJoke = (Button) root.findViewById(R.id.btTellJoke);

        btTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EndpointsAsyncTask().execute(getActivity());
            }
        });
        /*AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);*/
        return root;
    }

    static class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

        private Context context;
        private static MyApi myApi = null;

        @Override
        protected String doInBackground(Context... contexts) {
            if (myApi == null) {
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("http://10.0.2.2:8080/_ah/api")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                                request.setDisableGZipContent(true);
                            }
                        });
                myApi = builder.build();
            }

            context = contexts[0];
            try {
                return myApi.myJoke().execute().getMyJoke();
            } catch (Exception e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            /*super.onPostExecute(s);*/

            if (s != null && !s.isEmpty()) {
                Intent i = new Intent(context, DisplayJokes.class);
                i.putExtra(ConstantUtils.INTENT_JOKE, s);
                context.startActivity(i);
            }

        }
    }

   /* public void tellJoke(View view) {
        TheJoker joker = new TheJoker();
        Toast.makeText(getActivity(), joker.getAJokes(), Toast.LENGTH_SHORT).show();
    }*/
}
