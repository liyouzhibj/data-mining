package com.xhdsj.model.sup;

public class Code {

    public int code;

    public String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Code success(){
        Code code = new Code();
        code.setCode(200);
        code.setDesc("成功");
        return code;
    }

    public static Code fail(){
        Code code = new Code();
        code.setCode(500);
        code.setDesc("失败");
        return code;
    }


    public static Code fail(String s){
        Code code = new Code();
        code.setCode(500);
        code.setDesc(s);
        return code;
    }
}
