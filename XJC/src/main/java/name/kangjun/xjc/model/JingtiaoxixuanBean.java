package name.kangjun.xjc.model;

/**
 * Created by Kangjun on 2017/7/26.
 */

public class JingtiaoxixuanBean {

    /**
     * code : 0
     * msg : 成功
     * data : {"start":0,"type":1,"end":0,"data":[{"bookid":"3251","catid":"31","title":"医妃撩君心","typeid":"0","thumb":"http://cdn.517w.com/uploadfile/2017/0422/thumb_20170422104436822.jpg","description":"只看十格就捧腹的爆笑喜剧，读一千遍仍感动的爱情传奇\r\n史上最逆天最暖萌小医妃狂虐当世最霸气最腹黑俏天子\r\n世道衰败，奸佞当道，俏皇帝扮猪吃虎\r\n山河变色，群雄纷争，小医妃倾覆乾坤\r\n万里江山，不及你一抹笑靥","gx_type":"2","update_chapter_name":"第30话 二哥哥","author":"歪歪狐动漫工作室","status_bz":"1","updatetime":"1500709344","view_type":"1","thumb_1":"http://cdn.517w.com/uploadfile/2017/0725/20170725045716405.jpg"}]}
     */

    private int code;
    private String msg;
    private JingtiaoxixuanListBean data;

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

    public JingtiaoxixuanListBean getData() {
        return data;
    }

    public void setData(JingtiaoxixuanListBean data) {
        this.data = data;
    }
}
