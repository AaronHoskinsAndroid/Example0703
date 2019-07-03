package examples.aaronhoskins.com.example0703;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ObjectRecyclerViewAdapter extends RecyclerView.Adapter<ObjectRecyclerViewAdapter.ViewHolder> {
    ArrayList<ExampleObject> exampleObjectArrayList;

    public ObjectRecyclerViewAdapter(ArrayList<ExampleObject> exampleObjectArrayList) {
        this.exampleObjectArrayList = exampleObjectArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.example_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExampleObject currentObject = exampleObjectArrayList.get(position);
        holder.setExampleObject(currentObject);
        holder.tvItemOne.setText(currentObject.getmDataItemOne());
        holder.tvItemTwo.setText(currentObject.getmDataItemTwo());
    }

    @Override
    public int getItemCount() {
        return exampleObjectArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvItemOne;
        TextView tvItemTwo;
        ExampleObject exampleObject;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItemOne = itemView.findViewById(R.id.tvItemOne);
            tvItemTwo = itemView.findViewById(R.id.tvItemTwo);
            itemView.setOnClickListener(this);
        }

        public ExampleObject getExampleObject() {
            return exampleObject;
        }

        public void setExampleObject(ExampleObject exampleObject) {
            this.exampleObject = exampleObject;
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("object", exampleObject);
            Intent intent = new Intent(itemView.getContext(), ObjectDetailActivity.class);
            intent.putExtras(bundle);
            itemView.getContext().startActivity(intent);
        }
    }
}
