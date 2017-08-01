package name.kangjun.xjc.model;

import java.util.List;

/**
 * Created by Kangjun on 2017/7/31.
 */

public class ManhuaSectionTitleBean {

    /**
     * code : 0
     * msg : 成功
     * data : [{"posid":"32","name":"新作推荐列表","thumb":""}]
     */

    private int code;
    private String msg;
    private List<ManhuaSectionTitleItemBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ManhuaSectionTitleItemBean> getData() {
        return data;
    }

    public void setData(List<ManhuaSectionTitleItemBean> data) {
        this.data = data;
    }

}
