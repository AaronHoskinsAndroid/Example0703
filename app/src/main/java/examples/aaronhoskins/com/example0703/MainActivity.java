package examples.aaronhoskins.com.example0703;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ObjectRecyclerViewAdapter objectRecyclerViewAdapter;
    MockDatabase mockDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mockDatabase = MockDatabase.getInstance();
        recyclerView = findViewById(R.id.recyclerView);
        objectRecyclerViewAdapter
                = new ObjectRecyclerViewAdapter(mockDatabase.getAllMockObjects());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            if(bundle != null) {
                ExampleObject exampleObject = bundle.getParcelable("object");
                if(exampleObject != null) {
                    int flag = intent.getIntExtra("operation_flag", -1);
                    switch (flag) {
                        case 0:
                            deleteItem(exampleObject);
                            break;
                        default:
                            Log.d("TAG", "onCreate: UNSUPPORTED OPERATION");
                    }
                }
            }
        }


        recyclerView.setAdapter(objectRecyclerViewAdapter);
    }

    public void deleteItem(ExampleObject exampleObject) {
        mockDatabase.removeItemFromMockDatabase(exampleObject);
        objectRecyclerViewAdapter.notifyDataSetChanged();
    }
}
