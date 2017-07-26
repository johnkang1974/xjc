package name.kangjun.xjc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import name.kangjun.xjc.R;
import name.kangjun.xjc.model.JingtiaoxixuanItemBean;

/**
 * 漫画——精挑细选
 * Created by Kangjun on 2017/7/26.
 */

public class ManhuaJingtiaoxixuanAdapter extends RecyclerView.Adapter<ManhuaJingtiaoxixuanAdapter.ViewHolder> {
    private List<JingtiaoxixuanItemBean> items;

    public ManhuaJingtiaoxixuanAdapter(List<JingtiaoxixuanItemBean> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jingtiaoxixuan_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.manhuaCover.setImageURI(items.get(position).getThumb());
        holder.manhuaName.setText(items.get(position).getTitle());
        holder.manhuaAuthor.setText(items.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView manhuaCover;
        private TextView manhuaName;
        private TextView manhuaAuthor;

        private void assignViews() {
            manhuaCover = (SimpleDraweeView) itemView.findViewById(R.id.manhua_cover);
            manhuaName = (TextView) itemView.findViewById(R.id.manhua_name);
            manhuaAuthor = (TextView) itemView.findViewById(R.id.manhua_author);
        }


        private ViewHolder(View itemView) {
            super(itemView);
            assignViews();
        }
    }
}
