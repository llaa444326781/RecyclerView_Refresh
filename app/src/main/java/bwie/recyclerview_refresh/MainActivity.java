package bwie.recyclerview_refresh;

import android.graphics.pdf.PdfDocument;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import baseactivity.BaseActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import uttils.OkHttpUtils;

public class MainActivity extends BaseActivity {
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;
    private int page = 0;
    private static List<Bean.ResultBean.DataBean> list = new ArrayList<>();
    private static List<Bean.ResultBean.DataBean> myList = new ArrayList<>();

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String json = (String) msg.obj;
            Gson gson = new Gson();
            Bean bean = gson.fromJson(json, Bean.class);
            list = bean.getResult().getData();
            int tag = msg.arg1;
            switch (tag) {
                //添加数据
                case 1:
                    myList.addAll(list);
                    mRecyclerViewAdapter = new RecyclerViewAdapter();
                    mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
                    break;
                //刷新
                case 2:
                    myList.clear();
                    myList.addAll(list);
                    mRecyclerViewAdapter.notifyDataSetChanged();
                    break;
                //刷新
                case 3:
                    myList.addAll(list);
                    mRecyclerViewAdapter.notifyDataSetChanged();
                    break;
            }
            mRecyclerViewAdapter.setOnRecyclerItemClickListener(new RecyclerViewAdapter.OnRecyclerItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Toast.makeText(MainActivity.this,myList.get(position).getContent(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.pullLoadMoreRecyclerView);

        mPullLoadMoreRecyclerView.setLinearLayout();

        mPullLoadMoreRecyclerView.setFooterViewText("loading");


    }

    @Override
    public void getData() {
        getData1("http://japi.juhe.cn/joke/content/list.from?key=%20874ed931559ba07aade103eee279bb37%20&" +
                "page=" + page + "&pagesize=10&sort=asc&time=1418745237", 1);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();

        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                page = 0;
                getData1("http://japi.juhe.cn/joke/content/list.from?key=%20874ed931559ba07aade103eee279bb37%20&" +
                        "page=" + page + "&pagesize=10&sort=asc&time=1418745237", 2);
                mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {
                page++;
                getData1("http://japi.juhe.cn/joke/content/list.from?key=%20874ed931559ba07aade103eee279bb37%20&" +
                        "page=" + page + "&pagesize=10&sort=asc&time=1418745237", 3);
                mPullLoadMoreRecyclerView.setFooterViewText("loading");
                mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
            }
        });

    }

    public void getData1(final String path, final int tag) {
        OkHttpUtils.get(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                handler.obtainMessage(1, tag, 1, json).sendToTarget();
            }
        });

    }


    @Override
    public void loadData() {

    }
    public static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        OnRecyclerItemClickListener onRecyclerItemClickListener;

        public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener) {
            this.onRecyclerItemClickListener = onRecyclerItemClickListener;
        }

        interface OnRecyclerItemClickListener {
            /**
             * @param view     被点击的ittem
             * @param position 点击索引
             */
            void onItemClick(View view, int position);
        }

        public RecyclerViewAdapter() {

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.textView.setText(myList.get(position).getContent());
            if (onRecyclerItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onRecyclerItemClickListener.onItemClick(view, position);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return myList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }

    }
}
