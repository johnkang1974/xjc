package name.kangjun.xjc.model;

import java.util.List;

/**
 * Created by Kangjun on 2017/7/27.
 */

public class ZhuantiZhuanquBean {

    /**
     * code : 0
     * msg : 成功
     * data : [{"advertise_type":"3","type":"1","cover":"http://cdn.517w.com/uploadfile/2017/0725/20170725092110515.jpg","man_id":"http://cdndjcact.517w.com/activite/activite_url/1781500631737.html","title":"新世界专题","type_str":""},{"title":"蜜糖APP","type":1,"position_id":3,"cover":"http://cdn.517w.com/uploadfile/2017/0302/20170302014409563.jpg","man_id":"http://www.metang520.com/","type_str":"","advertise_type":"8"},{"advertise_type":"4","type":"1","cover":"http://cdn.517w.com/uploadfile/2017/0711/20170711091337177.jpg","man_id":"http://cdndjcact.517w.com/activite/activite_url/1731499417138.html","title":"lily专题","type_str":""},{"advertise_type":"6","type":"1","cover":"http://cdn.517w.com/uploadfile/2017/0620/20170620104911899.jpg","man_id":"http://cdndjcact.517w.com/activite/activite_url/1621497008207.html","title":"大学专题","type_str":""},{"advertise_type":"7","type":"1","cover":"http://cdn.517w.com/uploadfile/2017/0711/20170711091935607.jpg","man_id":"http://cdndjcact.517w.com/activite/activite_url/1561495241649.html","title":"520专题","type_str":""},{"advertise_type":"2","type":"1","cover":"http://cdn.517w.com/uploadfile/2017/0715/20170715095550714.jpg","man_id":"http://cdndjcact.517w.com/activite/activite_url/1751500082354.html","title":"7月下旬新作导视","type_str":""},{"advertise_type":"5","type":"1","cover":"http://cdn.517w.com/uploadfile/2017/0725/20170725092540634.jpg","man_id":"http://cdndjcact.517w.com/activite/activite_url/1671498209617.html","title":"男子力这么高，一定是女孩子！","type_str":""}]
     */

    private int code;
    private String msg;
    private List<ZhuantiZhuanquItemBean> data;

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

    public List<ZhuantiZhuanquItemBean> getData() {
        return data;
    }

    public void setData(List<ZhuantiZhuanquItemBean> data) {
        this.data = data;
    }
}
