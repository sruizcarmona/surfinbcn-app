package seryi.app.com.surfinbcn;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hp1 on 21-01-2015.
 */
public class TabSummary extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_summary,container,false);
        String tempUrl = "http://es.surf-forecast.com/breaks/Barceloneta/seatemp";
        new MyWebTempTask((TextView) v.findViewById(R.id.temperatureCelsius)).execute(tempUrl);
        new MyWebInfoTempTask((TextView) v.findViewById(R.id.kk)).execute(tempUrl);

//        String[] data = {
//                    "Mon 6/23 - Sunny - 31/17",
//                    "Tue 6/24 - Foggy - 21/8",
//                    "Wed 6/25 - Cloudy - 22/17",
//                    "Thurs 6/26 - Rainy - 18/11",
//                    "Fri 6/27 - Foggy - 21/10",
//                    "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
//                    "Sun 6/29 - Sunny - 20/7"
//        };
//        List<String> weekForecast= new ArrayList<String>(Arrays.asList(data));
//        ArrayAdapter<String> ForecastAdapter= new ArrayAdapter<String> (
//                getActivity(),
//                R.layout.tab_summary,
//                R.id.listview_forecast,
//                weekForecast);
//        ListView listview = (ListView) v.findViewById(R.id.listview_forecast);
//        listview.setAdapter(ForecastAdapter);
        return v;
    }

    class MyWebTempTask extends AsyncTask {
        TextView mtv;
        public  MyWebTempTask(TextView mtv)
        {
            this.mtv=mtv;
        }

        @Override
        protected Object doInBackground(Object... params) {
        //descarrega metar
            try {
                URL url = new URL((String) params[0]);
                Scanner scanner = new Scanner(url.openStream());
                String line = scanner.nextLine();
                while (line != null) {
                    if (line.contains("tempu")) {
                        line = line.substring(line.indexOf("temp\">") + 6);
                        line = line.substring(0, line.indexOf("</span"));
                        return line;
                    }
                    line = scanner.nextLine();
                }
            } catch (Exception e) {
                Log.e("error webcontenttask", e.toString());
            }
            return null;
        }

        protected void onPostExecute(Object result) {
            TextView tv = (TextView) mtv.findViewById(R.id.temperatureCelsius);
            tv.setText((String) result);
        }
    }

    class MyWebInfoTempTask extends AsyncTask {
        TextView mtv;
        public  MyWebInfoTempTask(TextView mtv)
        {
            this.mtv=mtv;
        }

        @Override
        protected Object doInBackground(Object... params) {
            //descarrega metar
            try {
                URL url = new URL((String) params[0]);
                Scanner scanner = new Scanner(url.openStream());
                String line = scanner.nextLine();
                while (line != null) {
                    if (line.contains("Barceloneta water temperature")) {
                        //line = line.substring(line.indexOf("temp\">") + 6);
                        //line = line.substring(0, line.indexOf("</span"));
                        return line;
                    }
                    line = scanner.nextLine();
                }
            } catch (Exception e) {
                Log.e("error webcontenttask", e.toString());
            }
            return null;
        }

        protected void onPostExecute(Object result) {
            TextView tv = (TextView) mtv.findViewById(R.id.kk);
            tv.setText((String) result);
        }
    }

}
