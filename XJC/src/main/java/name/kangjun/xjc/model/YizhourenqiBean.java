package name.kangjun.xjc.model;

import java.util.List;

/**
 * Created by Kangjun on 2017/7/25.
 */

public class YizhourenqiBean {

    /**
     * code : 0
     * msg : 成功
     * data : {"label":0,"get_type":0,"start":0,"end":"10","userid":0,"home":1,"data":[{"bookid":"90","catid":"32","title":"困病之笼","typeid":"0","thumb":"http://cdn.517w.com/uploadfile/2016/0919/thumb_20160919135351401.jpg","description":"为了接近自己暗恋的女生，韦良男扮女装参与了女生们的春游，结果却被恐怖分子绑架，还被注射病毒\u2026\u2026要如何才能在穷凶极恶的恐怖组织手中求活，救出自己暗恋的女生？","gx_type":"9","update_chapter_name":"第453话","author":"大叔酱","status_bz":"1","updatetime":"1500737005","view_type":"0","thumb_3":"http://cdn.517w.com/uploadfile/2016/1118/20161118111830393.jpg","show_label":"[[9,\"悬疑\"]]","rank_id":"1","views":"20093497","label":[],"labeltwo":[]}]}
     */

    private int code;
    private String msg;
    private YizhourenqiListBean data;

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

    public YizhourenqiListBean getData() {
        return data;
    }

    public void setData(YizhourenqiListBean  data) {
        this.data = data;
    }

}
