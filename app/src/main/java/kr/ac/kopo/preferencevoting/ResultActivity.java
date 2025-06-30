package kr.ac.kopo.preferencevoting;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent=getIntent();
        int[] voteCount=intent.getIntArrayExtra("voteCount");
        String[] imgName=intent.getStringArrayExtra("imgName");
        TextView[] tv=new TextView[imgName.length];
        RatingBar[] rb=new RatingBar[imgName.length];

        int[] tvId={R.id.text0, R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6, R.id.text7, R.id.text8};
        int[] rbId = {R.id.rating0, R.id.rating1, R.id.rating2, R.id.rating3, R.id.rating4, R.id.rating5, R.id.rating6, R.id.rating7, R.id.rating8};

        for(int i=0;i<imgName.length;i++){
            tv[i]=findViewById(tvId[i]);
            rb[i]=findViewById(rbId[i]);
        }
        for(int i=0;i<imgName.length;i++){
            tv[i].setText(tvId[i]);
            rb[i].setRating(voteCount[i]);
        }
        Button btnBack=findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}