package vip.mate.core.common.constant;

/**
 * 网络通信常量，包括枚举类
 *
 * @author david
 */
public class WebConstant {

    /**
     * json类型报文，UTF-8字符集
     */
    public static final String JSON_UTF8 = "application/json;charset=UTF-8";

    /**
     * ws请求匹配头
     */
    public static final String DEFAULT_FILTER_PATH = "/ws/";

    /**
     * ws请求端口偏移
     */
    public static final int WS_PORT = 10;

    /**
     * 字符集
     */
    public enum Character {

        UTF8("UTF-8", "UTF-8"),
        GBK("GBK", "GBK");

        private final String code;
        private final String info;

        Character(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    /**
     * 返回类型
     */
    public enum ResultType {
        SUCCESS("success", "操作成功"),
        ERROR("error", "操作失败"),
        WARNING("warning", "操作异常");

        private final String code;
        private final String info;

        ResultType(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    /**
     * 请求类型
     */
    public enum Type {

        LOOKUP_RMI("rmi:", "RMI 远程方法调用"),
        LOOKUP_LDAP("ldap:", "LDAP 远程方法调用"),
        LOOKUP_LDAPS("ldaps:", "LDAPS 远程方法调用"),
        HTTP("http://", "http请求"),
        HTTPS("https://", "https请求"),
        WS("ws://", "ws请求"),
        WSS("wss://", "wss请求");

        private final String code;
        private final String info;

        Type(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }
}
