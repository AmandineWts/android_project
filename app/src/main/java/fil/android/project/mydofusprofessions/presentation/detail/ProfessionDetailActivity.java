package fil.android.project.mydofusprofessions.presentation.detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fil.android.project.mydofusprofessions.R;

public class ProfessionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profession_detail_activity);
        TextView nameTextView = findViewById(R.id.profession_detail_name_textview);
        Intent intent = getIntent();
        nameTextView.setText(intent.getStringExtra("profession_id"));
    }

}
