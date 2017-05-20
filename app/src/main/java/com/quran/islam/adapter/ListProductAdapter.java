package com.quran.islam.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;
import com.quran.islam.domain.MasterTable;
import com.quran.islam.quran.DetailByKey;
import com.quran.islam.quran.R;


import java.util.ArrayList;
import java.util.List;


public class ListProductAdapter extends BaseAdapter implements Filterable {
    private Context mContext;
    private List<MasterTable> mProductList;
    private ArrayList<MasterTable> arraylist;
    private ValueFilter valueFilter;
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

        return arraylist.get(position);
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

//                Toast.makeText(mContext,
//                        "The favorite list would appear on clicking this icon"+mProductList.get(position).getSearchKeyWord()+mProductList+position,
//                        Toast.LENGTH_LONG).show();


                Intent intent = new Intent(mContext, DetailByKey.class);
                intent.putExtra("key",mProductList.get(position).getDetail());

                Toast.makeText(mContext,
                        "The favorite list would appear on clicking this icon"+mProductList.get(position).getSearchKeyWord()+mProductList.get(position).getDetail(),
                        Toast.LENGTH_LONG).show();

                mContext.startActivity(intent);

            }
        });
        return v;
    }


    @Override
    public Filter getFilter() {
        if(valueFilter==null) {

            valueFilter=new ValueFilter();
        }

        return valueFilter;
    }



    private class ValueFilter extends Filter {

        //Invoked in a worker thread to filter the data according to the constraint.
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint!=null && constraint.length()>0){
                ArrayList<MasterTable> filterList=new ArrayList<MasterTable>();
                for(int i=0;i<arraylist.size();i++){
                    if((arraylist.get(i).getSearchKeyWord().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        MasterTable contacts = new MasterTable();
                        contacts.setSearchKeyWord(arraylist.get(i).getSearchKeyWord());
                        contacts.setDetail(arraylist.get(i).getDetail());
                        contacts.setId(arraylist.get(i).getId());
                        filterList.add(contacts);
                    }
                }
                results.count=filterList.size();
                results.values=filterList;
            }else{
                results.count=arraylist.size();
                results.values=arraylist;
            }
            return results;
        }


        //Invoked in the UI thread to publish the filtering results in the user interface.
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            mProductList=(ArrayList<MasterTable>) results.values;
            notifyDataSetChanged();
        }
    }
}



