package cn.weli.learnandroiddemo.FourMajorComponents.ContentProviderDemo;

public class PhotoDto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    private String name;    //联系人姓名
    private String telPhone;    //电话号码

    public PhotoDto() {
    }

    public PhotoDto(String name, String telPhone) {
        this.name = name;
        this.telPhone = telPhone;
    }

}
