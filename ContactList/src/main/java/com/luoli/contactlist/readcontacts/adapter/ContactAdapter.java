package com.luoli.contactlist.readcontacts.adapter;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luoli.contactlist.R;
import com.luoli.contactlist.readcontacts.bean.GoodMan;

import java.util.ArrayList;


/**
 * Created by LUOLI on 2017/5/4.
 */
public class ContactAdapter extends BaseAdapter {
    private static final String TAG = "ContactAdapter";
    private Context mContext;
    private int newPosition = -1;
    private ArrayList<GoodMan> mList;
    private Handler handler;

    public ContactAdapter() {
    }

    public ContactAdapter(Context context, ArrayList<GoodMan> list) {
        this.mContext = context;
        this.mList = list;
        handler = new Handler();
    }

    public void setPosition(int tag) {
        this.newPosition = tag;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_contact, null);
        }
        final ViewHolder holder = new ViewHolder(convertView);
        GoodMan goodMan = mList.get(position);
        if (!TextUtils.isEmpty(goodMan.getName())) {
            holder.tvName.setText(goodMan.getName());
        }
        if (!TextUtils.isEmpty(goodMan.getNumber())) {
            holder.tvNumber.setText(goodMan.getNumber());
        }
        if (newPosition == position) {
            holder.rlContect.setBackgroundColor(mContext.getResources().getColor(R.color.bg_color));
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    holder.rlContect.setBackgroundColor(mContext.getResources().getColor(R.color.tv_color_contact));
                }
            }, 150);

        } else {
            holder.rlContect.setBackgroundColor(mContext.getResources().getColor(R.color.tv_color_contact));
        }
        initListener(holder.rlContect,position);
        String firstLetter = goodMan.getPinyin().charAt(0) + "";
        if (position == 0) {
            holder.tvLetter.setVisibility(View.VISIBLE);
            holder.tvLetter.setText(firstLetter);
        } else {
            //获取上一个条目的拼音首字母
            GoodMan preGoodMan = mList.get(position - 1);
            String preFirstLetter = preGoodMan.getPinyin().charAt(0) + "";
            if (TextUtils.equals(preFirstLetter, firstLetter)) {
                //和上一个条目的首字母相同
                holder.tvLetter.setVisibility(View.GONE);
                holder.itemView.setVisibility(View.GONE);
            } else {
                holder.tvLetter.setVisibility(View.VISIBLE);
                holder.itemView.setVisibility(View.VISIBLE);
                holder.tvLetter.setText(firstLetter);
            }
        }

        return convertView;
    }
    private void initListener(final RelativeLayout rlContect, final int position) {
        rlContect.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add("删除").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //执行删除操作
                        initAnim(rlContect,position);

                        return true;
                    }
                });
            }
        });
    }
    /**加载动画*/
    private void initAnim(RelativeLayout rlContect, final int position) {
        TranslateAnimation animator = new TranslateAnimation(0,-1000,0,0);
//        animator.setInterpolator(mContext,new AccelerateInterpolator());
//        animator.setRepeatCount(1);
        animator.setDuration(500);
        animator.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mList.remove(position);

                notifyDataSetChanged();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
//        rlContect.setAnimation(animator);
        rlContect.startAnimation(animator);
//        animator.start();
    }
//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
//
//    private OnItemClickListener onItemClickListener;
//    public interface OnItemClickListener {
//        void itemClick(View view);
//    }

    public class ViewHolder {
        RelativeLayout rlContect;
        View itemView;
        TextView tvLetter;
        TextView tvName;
        TextView tvNumber;

        public ViewHolder(View v) {
            rlContect = (RelativeLayout) v.findViewById(R.id.rl_contect);
            itemView = v.findViewById(R.id.item_view);
            tvLetter = (TextView) v.findViewById(R.id.item_tvLetter);
            tvName = (TextView) v.findViewById(R.id.item_tv_name);
            tvNumber = (TextView) v.findViewById(R.id.item_tv_number);
        }
    }
}
