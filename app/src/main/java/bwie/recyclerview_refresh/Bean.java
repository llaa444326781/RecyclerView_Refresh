package bwie.recyclerview_refresh;

import java.util.List;

/**
 * 1.Bean
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/11/23.
 */
public class Bean {

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"楼主：夫妻中男性患了糖尿病，女人会得什么病？  回复：蛀牙！","hashId":"53233a2ebd19c7284698a880cf5f3d8d","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"一女子郁闷的对女同事说：\u201c我现在得尽量避免怀孕！\u201d  女同事奇怪的问道：\u201c避免怀孕？？你先生不是才做过接扎手术吗？\u201d  女子痛苦的答道说：\u201c苦啊！这就是我必须非常小心的原因\u201d\u2026\u2026！","hashId":"f07f7ab69bd65a427c4eaa86871a122b","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"爸爸:儿子你们期末考试你班成绩怎么样， 儿子:有人数学好，有人语文好，有人英语好， 爸爸:那你呢， 儿子:我心态好， 爸爸:\u2026\u2026站那别跑","hashId":"dd315c2e6ef6dcd79e0eea04eea2331d","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"\u201c姐夫...轻点...疼...\u201d \u201c怕什么\u201d \u201c等下我姐回来看到怎么办？\u201d \u201c没事，你姐她刚才不是和你媳妇出去了麽\u201d\u2026\u2026","hashId":"0fa48edd1821f6c565be4e790807d937","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"同事妻管严，零花钱少的可怜，今天一起打牌他输了400块没钱了。想想也可怜，就请他吃饭，吃饭时他说兄弟借十块钱吧，买张请柬回去好报帐，我当时就呆了，又TM学会一招。。","hashId":"8e41f3cf2f617953d85da837544ddb20","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"老婆对我使用家庭暴力，我机智的说道\u201c别在孩子面前使用家庭暴力，对孩子不好\u201d说完正当老婆犹豫不决之际，我家孩子非常懂事跟他妈讲道\u201c没事妈，你打吧我不看！\u201d","hashId":"c63dd9fffccffd248e20ea558be041ad","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"有一天去小卖部买东西，买完了，喊一声：\u201c大姐，结帐。\u201d那大姐噗噗笑了，指了指一个二十多的美女说：\u201c我女儿这么大了，你该叫我什么？\u201d我说：\u201c妈！\u201d","hashId":"042787ef3a48d403db86a0665a264c60","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"某天，和三哥他们一起喝酒，喝高了，开始聊聊人生谈谈理想！ 到我了，我说：我的理想是和我爸一样月薪十万！ 当时，他们都惊呆了：卧槽，没看出来你也是富二代啊！ 我端起酒杯，悠悠说到，不是啊，我爸的理想也是月薪十万...","hashId":"ca898478dad1eca6d5b1a0b00267856d","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"什么方式对老婆最残忍？  回复：一不做 二不休\u2026 回复：然后楼上被绿了\u2026","hashId":"2d57bd22bbab65e79690fc1b61abe904","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"},{"content":"一对夫妻吵架，男的吵不赢女的，直接躺在床上，一动不动。女的就问，\u201c你躺床上干嘛\u201d？男的回答，\u201c死了\u201d！女的又问，\u201c死了怎么还睁着眼\u201d？\u201c死不瞑目\u201d！男的回答，女的又问，\u201c那怎么还呼吸\u201d？男的说，\u201c咽不下这口气\u201d！","hashId":"a943fe3ebba2e0fa6498b18440bd92f9","unixtime":1479873230,"updatetime":"2016-11-23 11:53:50"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 楼主：夫妻中男性患了糖尿病，女人会得什么病？  回复：蛀牙！
         * hashId : 53233a2ebd19c7284698a880cf5f3d8d
         * unixtime : 1479873230
         * updatetime : 2016-11-23 11:53:50
         */

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
