package name.kangjun.xjc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import name.kangjun.xjc.R;
import name.kangjun.xjc.model.ManhuaHomeCommonItemBean;

/**
 * 漫画——精挑细选
 * Created by Kangjun on 2017/7/26.
 */

public class ManhuaHomeCommonItemAdapter extends RecyclerView.Adapter<ManhuaHomeCommonItemAdapter.ViewHolder> {
    private List<ManhuaHomeCommonItemBean> items;
    private int style = 0;      //0：横图  1：竖图

    /**
     * @param items 网络请求的返回结果集
     * @param style 0：横图  1：竖图
     */
    public ManhuaHomeCommonItemAdapter(List<ManhuaHomeCommonItemBean> items, int style) {
        this.items = items;
        this.style = style;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item_manhua, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (style == 0) {
            holder.manhuaCover.setImageURI(items.get(position).getThumb_1());
            holder.manhuaCover.setAspectRatio(1.78f);
        } else {
            holder.manhuaCover.setImageURI(items.get(position).getThumb());
            holder.manhuaCover.setAspectRatio(0.75f);
        }
        holder.manhuaName.setText(items.get(position).getTitle());
        holder.manhuaAuthor.setText(items.get(position).getAuthor());

        //设置更新频率的标签
        int mGxType = items.get(position).getGx_type();
        switch (mGxType) {
            case 0: //连载中
                holder.gengxinType.setVisibility(View.GONE);
                break;
            case 1: //每周更新
                holder.gengxinType.setVisibility(View.GONE);
                break;
            case 2: //一周两更
                holder.gengxinType.setVisibility(View.GONE);
                break;
            case 3: //一周三更
                holder.gengxinType.setText("一周三更");
                break;
            case 4: //隔日更新
                holder.gengxinType.setText("隔日更新");
                break;
            case 5: //工作日更
                holder.gengxinType.setText("工作日更");
                break;
            case 6: //每日更新
                holder.gengxinType.setText("每日更新");
                break;
            case 7: //一周五更
                holder.gengxinType.setText("一周五更");
                break;
            case 8: //一周六更
                holder.gengxinType.setText("一周六更");
                break;
            case 9: //一周四更
                holder.gengxinType.setText("一周四更");
                break;
            case 10: //一日双更
                holder.gengxinType.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView manhuaCover;
        private TextView manhuaName;
        private TextView manhuaAuthor;
        private TextView gengxinType;

        private void assignViews() {
            manhuaCover = (SimpleDraweeView) itemView.findViewById(R.id.manhua_cover);
            manhuaName = (TextView) itemView.findViewById(R.id.manhua_name);
            manhuaAuthor = (TextView) itemView.findViewById(R.id.manhua_author);
            gengxinType = (TextView) itemView.findViewById(R.id.gengxin_type);
        }


        private ViewHolder(View itemView) {
            super(itemView);
            assignViews();
        }
    }
}
