package name.kangjun.xjc.model;

/**
 * Created by Kangjun on 2017/7/10.
 */

public class TiaomanHomeItemBean {

    /**
     * id : 1
     * bookid : 3028
     * title : 只有你听见——与SNH48一起生活
     * updatetime : 1499678719
     * update_chapter_name : 第50话
     * car_number : 76661
     * comment_num : 3
     * thumb_rank : uploadfile/2017/0710/cr_20170710172348794.jpg
     * author_userid : 0
     * author : 一波人漫画工作室
     * views : 29141782
     * class_label : {"class_id":18,"class_name":"励志"}
     */

    private String id;
    private String bookid;
    private String title;
    private String updatetime;
    private String update_chapter_name;
    private String car_number;
    private String comment_num;
    private String thumb_rank;
    private String author_userid;
    private String author;
    private String views;
    private ClassLabelBean class_label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdate_chapter_name() {
        return update_chapter_name;
    }

    public void setUpdate_chapter_name(String update_chapter_name) {
        this.update_chapter_name = update_chapter_name;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getComment_num() {
        return comment_num;
    }

    public void setComment_num(String comment_num) {
        this.comment_num = comment_num;
    }

    public String getThumb_rank() {
        return thumb_rank;
    }

    public void setThumb_rank(String thumb_rank) {
        this.thumb_rank = thumb_rank;
    }

    public String getAuthor_userid() {
        return author_userid;
    }

    public void setAuthor_userid(String author_userid) {
        this.author_userid = author_userid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public ClassLabelBean getClass_label() {
        return class_label;
    }

    public void setClass_label(ClassLabelBean class_label) {
        this.class_label = class_label;
    }

    public static class ClassLabelBean {
        /**
         * class_id : 18
         * class_name : 励志
         */

        private int class_id;
        private String class_name;

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }
    }
}
