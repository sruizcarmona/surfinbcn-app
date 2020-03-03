package seryi.app.com.surfinbcn;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.net.URL;
import java.util.Scanner;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_4,container,false);
        WebView webview1 = (WebView) v.findViewById(R.id.webView1);
        webview1.getSettings().setBuiltInZoomControls(true);
        webview1.getSettings().setSupportZoom(true);
        webview1.getSettings().setLoadWithOverviewMode(true);
        webview1.getSettings().setUseWideViewPort(true);
        //webview1.loadUrl("http://www.skylinewebcams.com/cust/widget.php?id=496");
        webview1.loadUrl("http://static.skylinewebcams.com/live496.jpg");

        WebView webview2 = (WebView) v.findViewById(R.id.webView2);
        webview2.getSettings().setBuiltInZoomControls(true);
        webview1.getSettings().setSupportZoom(true);
        webview2.getSettings().setLoadWithOverviewMode(true);
        webview2.getSettings().setUseWideViewPort(true);
        //webview2.loadUrl("http://www.skylinewebcams.com/cust/widget.php?id=492");
        webview2.loadUrl("http://static.skylinewebcams.com/live492.jpg");

        String tempUrl = "http://es.surf-forecast.com/breaks/Barceloneta/seatemp";
        new MyWebTempTask((TextView) v.findViewById(R.id.temperatureCelsius)).execute(tempUrl);

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
}