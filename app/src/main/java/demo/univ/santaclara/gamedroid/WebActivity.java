package demo.univ.santaclara.gamedroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView browser = (WebView) findViewById(R.id.webview);
        browser.loadUrl("http://www.learninggamesforkids.com/memory_games/memory_games_match_game.html");
    }
}
