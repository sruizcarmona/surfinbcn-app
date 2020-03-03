package seryi.app.com.surfinbcn;
 
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
 
public class todosurf extends Fragment {
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
 
            View todosurf_v = inflater.inflate(R.layout.todosurf_frag, container, false);
            ((TextView)todosurf_v.findViewById(R.id.textView)).setText("Todosurf");
            return todosurf_v;
}}
