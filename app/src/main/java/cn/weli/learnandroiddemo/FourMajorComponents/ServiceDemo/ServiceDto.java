package cn.weli.learnandroiddemo.FourMajorComponents.ServiceDemo;

public class ServiceDto {
    public static int startServiceNum;

    public static int getStartServiceNum() {
        return startServiceNum;
    }

    public static void setStartServiceNum(int startServiceNum) {
        ServiceDto.startServiceNum = startServiceNum;
    }

    public static int getBindServiceNum() {
        return bindServiceNum;
    }

    public static void setBindServiceNum(int bindServiceNum) {
        ServiceDto.bindServiceNum = bindServiceNum;
    }

    public static int bindServiceNum;
}
