package com.quran.islam.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.quran.islam.domain.MasterTable;
import com.quran.islam.quran.DetailByKey;
import com.quran.islam.quran.R;
import com.quran.islam.quran.SearchByKeywordActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ListProductAdapter extends BaseAdapter {
    private Context mContext;
    private List<MasterTable> mProductList;
    private ArrayList<MasterTable> arraylist;
    private int po;

    public ListProductAdapter(Context mContext, List<MasterTable> mProductList) {
        Log.v("------------","-----------");
        this.mContext = mContext;
        this.mProductList = mProductList;
        this.arraylist = new ArrayList<MasterTable>();
        this.arraylist.addAll(mProductList);
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.item_listview, null);
        TextView tvName = (TextView)v.findViewById(R.id.searchKeyWord);
        tvName.setText(mProductList.get(position).getSearchKeyWord());




        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,
                        "The favorite list would appear on clicking this icon"+mProductList.get(position).getSearchKeyWord(),
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(mContext, DetailByKey.class);

//                ArrayList<String> arrayList = new ArrayList<String>();
//                arrayList.add("Ekta");
//                arrayList.add("Duita");
//                arrayList.add("Tinta");
//
//                Map<String, String> map = new HashMap<String, String>();
//                map.put("1",arrayList.get(1));
//                map.put("2",arrayList.get(2));
//
//
//                Set<String> keys = map.keySet();
//
//
//                for(String key: keys){
//                    System.out.println(key);
//
//                    if(Integer.toString(position) == key){
//                        intent.putExtra(Integer.toString(position), map.get(key));
//                        mContext.startActivity(intent);
//                    }
//
//                }

                //send item view position and get get detail by this position   
                intent.putExtra(Integer.toString(position),mProductList.get(position).getDetail());
                mContext.startActivity(intent);





//                    intent.putExtra(Integer.toString(position), "hello things");
//                    mContext.startActivity(intent);




            }
        });

        return v;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        mProductList.clear();
        if (charText.length() == 0) {
            mProductList.addAll(arraylist);
        }
        else
        {
            for (MasterTable wp : arraylist)
            {
                if (wp.getSearchKeyWord().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    mProductList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}



