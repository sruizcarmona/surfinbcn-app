package seryi.app.com.surfinbcn;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;


public class testActivityWeb extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activity_web);
        TextView tv = (TextView) findViewById(R.id.textview1);
        tv.setText("Hello World, Android - mkyong.com");
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://www.todosurf.com/prevision/?id=44#prevision");
    }
}
