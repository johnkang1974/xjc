package name.kangjun.xjc.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import name.kangjun.xjc.R;
import name.kangjun.xjc.model.TiaomanHomeItemBean;


/**
 * Created by Kangjun on 2017/7/11.
 */

//public class TiaomanHomeAdapter extends RecyclerView.Adapter<TiaomanHomeAdapter.ItemViewHolder> {
public class TiaomanHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<TiaomanHomeItemBean> mTiaomanHomeItem;
    private static String strCDN;
    private static final int TYPE_ITEM = 0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //顶部FootView


    public static void setStrCDN(String strCDN) {
        TiaomanHomeAdapter.strCDN = strCDN;
    }

    public TiaomanHomeAdapter(Context context) {
        mContext = context;
        mTiaomanHomeItem = new ArrayList<>();

    }

    public void addData(List<TiaomanHomeItemBean> items) {
        mTiaomanHomeItem.clear();
        mTiaomanHomeItem.addAll(items);
        notifyDataSetChanged();
    }

    public void addMoreData(List<TiaomanHomeItemBean> items) {
        mTiaomanHomeItem.addAll(items);
        notifyDataSetChanged();
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //装普通的条漫item
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tiaoman_home_item, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
            return itemViewHolder;
        }
        //装上拉加载的item
        else if (viewType == TYPE_FOOTER) {
            View footView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_footer, parent, false);
            FootViewHolder footViewHolder = new FootViewHolder(footView);
            return footViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        //条漫的item
        if (holder instanceof ItemViewHolder) {
            final TiaomanHomeItemBean item = mTiaomanHomeItem.get(position);
            ((ItemViewHolder)holder).labelOfName.setText(item.getTitle());
            ((ItemViewHolder)holder).labelOfType.setText(item.getClass_label().getClass_name());
            ((ItemViewHolder)holder).labelOfAuthor.setText(item.getAuthor());
            ((ItemViewHolder)holder).imageOfChapter.setImageURI(Uri.parse(strCDN + item.getThumb_rank()));
            ((ItemViewHolder)holder).labelOfChapterName.setText(item.getUpdate_chapter_name());
            ((ItemViewHolder)holder).labelOfCommentNumber.setText(item.getComment_num());
        }
        //上拉加载的item
        else if (holder instanceof FootViewHolder){
            //没有什么可以刷新的
        }
    }

    @Override
    public int getItemCount() {
        return mTiaomanHomeItem.size() + 1;
    }

    /**
     *
     */
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView labelOfType;
        private TextView labelOfName;
        private TextView labelOfAuthor;
        private SimpleDraweeView imageOfChapter;
        private TextView labelOfChapterName;
        private TextView labelOfCommentNumber;

        private ItemViewHolder(View itemView) {

            super(itemView);
            labelOfType = (TextView) itemView.findViewById(R.id.labelOfType);
            labelOfName = (TextView) itemView.findViewById(R.id.labelOfName);
            labelOfAuthor = (TextView) itemView.findViewById(R.id.labelOfAuthor);
            imageOfChapter = (SimpleDraweeView) itemView.findViewById(R.id.imageOfChapter);
            labelOfChapterName = (TextView) itemView.findViewById(R.id.labelOfChapterName);
            labelOfCommentNumber = (TextView) itemView.findViewById(R.id.labelOfCommentNumber);
        }
    }

    public class FootViewHolder extends RecyclerView.ViewHolder {
        //以后根据上拉还是下拉在分别设置textview的文字
        private ProgressBar footerReflash;

        public FootViewHolder(View itemView) {
            super(itemView);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }
}
