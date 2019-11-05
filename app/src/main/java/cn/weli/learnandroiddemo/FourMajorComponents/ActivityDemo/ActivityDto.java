package cn.weli.learnandroiddemo.FourMajorComponents.ActivityDemo;

public class ActivityDto {


    public static int getStandard_number() {
        return standard_number;
    }

    public static void setStandard_number(int standard_number) {
        ActivityDto.standard_number = standard_number;
    }

    public static int getSingleTop() {
        return singleTop;
    }

    public static void setSingleTop(int singleTop) {
        ActivityDto.singleTop = singleTop;
    }

    public static int getSingleTask() {
        return singleTask;
    }

    public static void setSingleTask(int singleTask) {
        ActivityDto.singleTask = singleTask;
    }

    public static int getSingleInstance() {
        return singleInstance;
    }

    public static void setSingleInstance(int singleInstance) {
        ActivityDto.singleInstance = singleInstance;
    }
    public static int getSingleInstanceCount() {
        return singleInstanceCount;
    }

    public static void setSingleInstanceCount(int singleInstanceCount) {
        ActivityDto.singleInstanceCount = singleInstanceCount;
    }

    public static int standard_number;
    public static int singleTop;
    public static int singleTask;
    public static int singleInstance;
    public static int singleInstanceCount;
}
