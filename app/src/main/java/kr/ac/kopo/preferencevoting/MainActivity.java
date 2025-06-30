package kr.ac.kopo.preferencevoting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final int voteCount[]=new int[9];
        for(int i=0;i<voteCount.length;i++){
            voteCount[i]=0;

        }
        ImageView imgv[]=new ImageView[9];
        int imgvId[] = { R.id.imv0, R.id.imv1, R.id.imv2, R.id.imv3, R.id.imv4, R.id.imv5, R.id.imv6, R.id.imv7, R.id.imv8 };
        final String imgName[] = { "진주 귀걸이를 한 소녀", "해바라기", "모나리자", "별이 빛나는 밤", "이삭 줍는 여인들", "기억의 지속", "야경", "키스", "대사들" };

        for(int i=0;i<imgv.length;i++){
            final int index;
            index =i;

            imgv[index]=findViewById(imgvId[index]);
            imgv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index]+": 총 " + voteCount[index] + "표",Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnDone=findViewById(R.id.btn_done);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("voteCount",voteCount);
                intent.putExtra("imgName",imgName);
                startActivity(intent);
            }
        });
    }
}