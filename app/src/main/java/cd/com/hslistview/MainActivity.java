package cd.com.hslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        //设置一个垂直方向的layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration=  new DividerItemDecoration(this, DividerItemDecoration. HORIZONTAL_LIST);
//        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(new MyAdapter());
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;
            ImageView iv;
            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.item);
                iv = (ImageView) itemView.findViewById(R.id.iv);
            }
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(), R.layout.item_lv, null);
            MyViewHolder holder = new MyViewHolder(view){};
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText("ceshi+" + position);
        }
        @Override
        public int getItemCount() {
            return 20;
        }
    }
}
