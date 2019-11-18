package cn.weli.learnandroiddemo.Resource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.weli.learnandroiddemo.R;

public class XmlActivity extends AppCompatActivity {

    private Button mBtnUseXml;
    private TextView mTvShowXml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        mBtnUseXml = findViewById(R.id.btn_use_xml);
        mTvShowXml = findViewById(R.id.tv_show_xml);
        mBtnUseXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //根据xml资源的id获取该资源的解析器
                //getXml()方法返回XmlPullParser对象
                //XmlResourceParser是XmlPullParser的子类
                XmlResourceParser xml = getResources().getXml(R.xml.books);

                StringBuilder sb = new StringBuilder();
                //还没到XML文档的结尾
                try {
                    while (xml.getEventType() != XmlResourceParser.END_DOCUMENT) {
                        if(xml.getEventType() == XmlResourceParser.START_TAG){
                        //获取该标签的标签名
                        String tagName = xml.getName();
                        //如果遇到book标签
                        if(tagName.equals("book")){
                            //根据属性名来获取属性值
                            String bookName = xml.getAttributeValue(null,"price");
                            sb.append("价格：");
                            sb.append(bookName);
                            //根据属性索引来获取属性值
                            String bookPrice = xml.getAttributeValue(1);
                            sb.append("    出版日期：");
                            sb.append(bookPrice);
                            sb.append("    书名:");
                            //获取文本节点的值
                            sb.append(xml.nextText());
                        }
                        sb.append("\n");
                        }
                        //获取解析器的下一个事件
                        xml.next();
                    }
                    mTvShowXml.setText(sb.toString());

                } catch (Exception e) {
                }
            }
        });
    }
}
