package com.example.zxl.lbsservice;

import java.util.UUID;

/**
 * Created by ZXL on 2016/4/5.
 */
public class Mission {
    private String id;
    private String content;
    private boolean solved;

    public Mission() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
