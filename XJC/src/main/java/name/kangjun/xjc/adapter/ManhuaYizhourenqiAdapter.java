package name.kangjun.xjc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import name.kangjun.xjc.R;
import name.kangjun.xjc.model.YizhourenqiItemBean;
import name.kangjun.xjc.view.ManhuaDetailActivity;

/**
 * 漫画——一周人气
 * Created by Kangjun on 2017/7/25.
 */

public class ManhuaYizhourenqiAdapter extends RecyclerView.Adapter<ManhuaYizhourenqiAdapter.ViewHolder> {
    private List<YizhourenqiItemBean> items;
    private Context mContext;

    public ManhuaYizhourenqiAdapter(Context context, List<YizhourenqiItemBean> items) {
        this.items = items;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yizhourenqi_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.manhuaCover.setImageURI(items.get(position).getThumb_3());
        holder.manhuaName.setText(items.get(position).getTitle());
        holder.manhuaAuthor.setText(items.get(position).getAuthor());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ManhuaDetailActivity.class);
                mContext.startActivity(intent);
//                ((Activity) mContext).getParent().overridePendingTransition(
//                        android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                ((AppCompatActivity) mContext).getParent().overridePendingTransition(
                        android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView manhuaCover;
        private TextView manhuaName;
        private TextView manhuaAuthor;
        private LinearLayout linearLayout;

        private ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.yizhourenqi_item_area);
            manhuaCover = (SimpleDraweeView) itemView.findViewById(R.id.manhua_cover);
            manhuaName = (TextView) itemView.findViewById(R.id.manhua_name);
            manhuaAuthor = (TextView) itemView.findViewById(R.id.manhua_author);
        }
    }
}
