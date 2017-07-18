package name.kangjun.xjc.model;

import java.util.List;

/**
 * Created by Kangjun on 2017/6/28.
 */

public class ManhuaBannerBean {

    /**
     * code : 0
     * msg : 成功
     * data : [{"advertise_type":"0","type":"0","cover":"http://cdn.517w.com/uploadfile/2016/0217/20160217021205292.jpg","man_id":"1149","view_type":"0"},{"advertise_type":"0","type":"1","cover":"http://cdn.517w.com/uploadfile/2017/0615/20170615052740900.jpg","man_id":"http://cdndjcact.517w.com/activite/activite_url/1641497518815.html"},{"advertise_type":"0","type":"0","cover":"http://cdn.517w.com/uploadfile/2017/0613/20170613012429442.jpg","man_id":"1217","view_type":"0"},{"advertise_type":"0","type":"0","cover":"http://cdn.517w.com/uploadfile/2017/0615/20170615041127662.jpg","man_id":"3134","view_type":"0"},{"advertise_type":"0","type":"1","cover":"http://cdn.517w.com/uploadfile/2017/0614/20170614095103363.jpg","man_id":"http://cdndjcact.517w.com/a_download/?ios=itms-apps%3a%2f%2fitunes.apple.com%2fapp%2fid1068045574&android=http%3a%2f%2fdownload.9liuda.com%2fwuli_DYmarket_v5.0.0.apk"},{"title":"蜜糖APP","type":1,"position_id":2,"cover":"http://cdn.517w.com/uploadfile/2017/0601/20170601053545585.jpg","man_id":"http://www.metang520.com/","advertise_type":0}]
     */

    private int code;
    private String msg;
    private List<ManhuaBannerItemBean> data;

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    public List<ManhuaBannerItemBean> getData() {
        return data;
    }

    public void setData(List<ManhuaBannerItemBean> data) {
        this.data = data;
    }

}
