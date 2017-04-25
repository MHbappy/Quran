package com.quran.islam.domain;

/**
 * Created by bappy on 4/25/17.
 */

public class MasterTable {


    private int id;
    private String searchKeyWord;
    private String detail;

    public MasterTable(int id, String searchKeyWord, String detail) {
        this.id = id;
        this.searchKeyWord = searchKeyWord;
        this.detail = detail;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSearchKeyWord() {
        return searchKeyWord;
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
