package name.kangjun.xjc.model;

import java.util.List;

/**
 * Created by Kangjun on 2017/7/11.
 */

public class TiaomanHomeListBean {

    /**
     * start : 0
     * end : 20
     * cdn : http://cdn.517w.com/
     * userid : 0
     * data : [{"id":"1","bookid":"3028","title":"只有你听见\u2014\u2014与SNH48一起生活","updatetime":"1499678719","update_chapter_name":"第50话","car_number":"76661","comment_num":"3","thumb_rank":"uploadfile/2017/0710/cr_20170710172348794.jpg","author_userid":"0","author":"一波人漫画工作室","views":"29141782","class_label":{"class_id":18,"class_name":"励志"}},{"id":"2","bookid":"1894","title":"八分钟男神","updatetime":"1499677129","update_chapter_name":"第123话大哥的女装诱惑术（五）","car_number":"76646","comment_num":"0","thumb_rank":"uploadfile/2017/0710/cr_20170710165834366.jpg","author_userid":"642287","author":"指尖动漫","views":"8529394","class_label":{"class_id":"4","class_name":"搞笑"}}]
     */

    private int start;
    private String end;
    private String cdn;
    private int userid;
    private List<TiaomanHomeItemBean> data;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCdn() {
        return cdn;
    }

    public void setCdn(String cdn) {
        this.cdn = cdn;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<TiaomanHomeItemBean> getData() {
        return data;
    }

    public void setData(List<TiaomanHomeItemBean> data) {
        this.data = data;
    }

}
