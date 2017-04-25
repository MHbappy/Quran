package com.quran.islam.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quran.islam.domain.MasterTable;
import com.quran.islam.quran.R;

import java.util.List;
/**
 * Created by NgocTri on 11/7/2015.
 */
public class ListProductAdapter extends BaseAdapter {
    private Context mContext;
    private List<MasterTable> mProductList;

    public ListProductAdapter(Context mContext, List<MasterTable> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mProductList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.item_listview, null);
        TextView tvName = (TextView)v.findViewById(R.id.searchKeyWord);
        tvName.setText(mProductList.get(position).getSearchKeyWord());
        return v;
    }
}
