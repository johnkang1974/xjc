package name.kangjun.xjc.model;

import java.util.List;

/**
 * Created by Kangjun on 2017/7/26.
 */

public class ManhuaHomeCommonListBean {

    /**
     * start : 0
     * type : 1
     * end : 0
     * data : [{"bookid":"3251","catid":"31","title":"医妃撩君心","typeid":"0","thumb":"http://cdn.517w.com/uploadfile/2017/0422/thumb_20170422104436822.jpg","description":"只看十格就捧腹的爆笑喜剧，读一千遍仍感动的爱情传奇\r\n史上最逆天最暖萌小医妃狂虐当世最霸气最腹黑俏天子\r\n世道衰败，奸佞当道，俏皇帝扮猪吃虎\r\n山河变色，群雄纷争，小医妃倾覆乾坤\r\n万里江山，不及你一抹笑靥","gx_type":"2","update_chapter_name":"第30话 二哥哥","author":"歪歪狐动漫工作室","status_bz":"1","updatetime":"1500709344","view_type":"1","thumb_1":"http://cdn.517w.com/uploadfile/2017/0725/20170725045716405.jpg"}]
     */

    private int start;
    private int type;
    private int end;
    private List<ManhuaHomeCommonItemBean> data;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<ManhuaHomeCommonItemBean> getData() {
        return data;
    }

    public void setData(List<ManhuaHomeCommonItemBean> data) {
        this.data = data;
    }
}
