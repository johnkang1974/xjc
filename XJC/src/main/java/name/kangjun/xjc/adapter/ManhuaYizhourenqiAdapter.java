package name.kangjun.xjc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import name.kangjun.xjc.R;
import name.kangjun.xjc.model.YizhourenqiItemBean;

/**
 * 漫画——一周人气
 * Created by Kangjun on 2017/7/25.
 */

public class ManhuaYizhourenqiAdapter extends RecyclerView.Adapter<ManhuaYizhourenqiAdapter.ViewHolder> {
    public List<YizhourenqiItemBean> items;

    public ManhuaYizhourenqiAdapter(List<YizhourenqiItemBean> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yizhourenqi_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.manhuaCover.setImageURI(items.get(position).getThumb_3());
        holder.manhuaName.setText(items.get(position).getTitle());
        holder.manhuaAuthor.setText(items.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView manhuaCover;
        public TextView manhuaName;
        public TextView manhuaAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
            manhuaCover = (SimpleDraweeView) itemView.findViewById(R.id.manhua_cover);
            manhuaName = (TextView) itemView.findViewById(R.id.manhua_name);
            manhuaAuthor = (TextView) itemView.findViewById(R.id.manhua_author);
        }
    }
}
