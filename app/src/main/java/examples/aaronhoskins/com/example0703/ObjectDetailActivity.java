package examples.aaronhoskins.com.example0703;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ObjectDetailActivity extends AppCompatActivity {
    TextView tvItemOne;
    TextView tvItemTwo;
    ExampleObject exampleObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_detail);
        tvItemOne = findViewById(R.id.tvItemOne);
        tvItemTwo = findViewById(R.id.tvItemTwo);
        Intent intent = getIntent();
        Bundle passedBundle = intent.getExtras();
        exampleObject = passedBundle.getParcelable("object");
        tvItemOne.setText(exampleObject.getmDataItemOne());
        tvItemTwo.setText(exampleObject.getmDataItemTwo());

    }

    public void onClick(View view) {
        //If doing delete operation from details activity
        //MockDatabase mockDatabase = MockDatabase.getInstance();
        //mockDatabase.removeItemFromMockDatabase(exampleObject);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("operation_flag", 0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("object",exampleObject);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
