package name.kangjun.xjc.model;

/**
 * Created by Kangjun on 2017/7/10.
 */

public class TiaomanHomeBean {


    /**
     * code : 0
     * msg : 成功
     * data : {"start":0,"end":"20","cdn":"http://cdn.517w.com/","userid":0,"data":[{"id":"1","bookid":"3028","title":"只有你听见\u2014\u2014与SNH48一起生活","updatetime":"1499678719","update_chapter_name":"第50话","car_number":"76661","comment_num":"3","thumb_rank":"uploadfile/2017/0710/cr_20170710172348794.jpg","author_userid":"0","author":"一波人漫画工作室","views":"29141782","class_label":{"class_id":18,"class_name":"励志"}},{"id":"2","bookid":"1894","title":"八分钟男神","updatetime":"1499677129","update_chapter_name":"第123话大哥的女装诱惑术（五）","car_number":"76646","comment_num":"0","thumb_rank":"uploadfile/2017/0710/cr_20170710165834366.jpg","author_userid":"642287","author":"指尖动漫","views":"8529394","class_label":{"class_id":"4","class_name":"搞笑"}}]}
     */

    private int code;
    private String msg;
    private TiaomanHomeListBean data;

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

    public TiaomanHomeListBean getData() {
        return data;
    }

    public void setData(TiaomanHomeListBean data) {
        this.data = data;
    }
}
