package seryi.app.com.surfinbcn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);
        WebView webview = (WebView) v.findViewById(R.id.webView);
        webview.loadUrl("http://www.todosurf.com/prevision/barceloneta-spot123.htm");
        return v;
    }
}