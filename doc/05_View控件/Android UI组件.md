# [UI组件](https://www.jianshu.com/p/705a6cb6bfee)

## 一、 开发自定义View

![](https://upload-images.jianshu.io/upload_images/10294405-49437ed26f19f7d5.png?imageMogr2/auto-orient/strip|imageView2/2/w/557/format/webp)

### 1.自定义View基础

 自定义View的实现方式有以下几种 

| 类型              | **定义**                                                     |
| ----------------- | ------------------------------------------------------------ |
| 自定义组合控件    | 多个控件组合成为一个新的控件，方便多处复用                   |
| 继承系统View控件  | 继承自TextView等系统控件，在系统控件的基础功能上进行扩展     |
| 继承View          | 不复用系统控件逻辑，继承View进行功能定义                     |
| 继承系统ViewGroup | 继承自LinearLayout等系统控件，在系统控件的基础功能上进行扩展 |
| 继承ViewViewGroup | 不复用系统控件逻辑，继承ViewGroup进行功能定义                |

### 1.2 View绘制流程

 View的绘制基本由measure()、layout()、draw()这个三个函数完成 

| 函数      | 作用           | 相关方法                                     |
| --------- | -------------- | -------------------------------------------- |
| measure() | 测量View的宽高 | measure(),setMeasuredDimension(),onMeasure() |
| layout() | 计算当前View以及子View的位置 | layout(),onLayout(),setFrame() |
| draw() | 视图的绘制工作 | draw(),onDraw() |

### 1.3 坐标系

 在Android坐标系中，以屏幕左上角作为原点，这个原点向右是X轴的正轴，向下是Y轴正轴。如下所示： 

![](https://upload-images.jianshu.io/upload_images/10294405-a57f0f703dca0eb4.png?imageMogr2/auto-orient/strip|imageView2/2/w/491/format/webp)

除了Android坐标系，还存在View坐标系，View坐标系内部关系如图所示。

![](https://upload-images.jianshu.io/upload_images/10294405-4ca426e6a92db696.png?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp)

#### View获取自身高度

由上图可算出View的高度：

- width = getRight() -  getLeft();
- height  =  getBottom()  -  getTop();

View的源码当中提供了getWidth()和getHeight()方法用来获取View的宽度和高度，其内部方法和上文所示是相同的，我们可以直接调用来获取View得宽高。

#### View自身的坐标

通过如下方法可以获取View到其父控件的距离。

- getTop()；获取View到其父布局顶边的距离。
- getLeft()；获取View到其父布局左边的距离。
- getBottom()；获取View到其父布局底边的距离。
- getRight()；获取View到其父布局右边的距离。

#### 1.4 构造函数

 无论是我们继承系统View还是直接继承View，都需要对构造函数进行重写，构造函数有多个，至少要重写其中一个才行。如我们新建`TestView`， 

#### 1.5 自定义属性

Android系统的控件以android开头的都是系统自带的属性。为了方便配置自定义View的属性，我们也可以自定义属性值。
 Android自定义属性可分为以下几步:

1. 自定义一个View
2. 编写values/attrs.xml，在其中编写styleable和item等标签元素
3. 在布局文件中View使用自定义的属性（注意namespace）
4. 在View的构造方法中通过TypedArray获取

#### 实例说明

- 自定义属性的声明文件 

```
    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <declare-styleable name="test">
            <attr name="text" format="string" />
            <attr name="testAttr" format="integer" />
        </declare-styleable>
    </resources>
```

-  自定义View类 

```
public class MyTextView extends View {
    private static final String TAG = MyTextView.class.getSimpleName();

    //在View的构造方法中通过TypedArray获取
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.test);
        String text = ta.getString(R.styleable.test_testAttr);
        int textAttr = ta.getInteger(R.styleable.test_text, -1);
        Log.e(TAG, "text = " + text + " , textAttr = " + textAttr);
        ta.recycle();
    }
}
```

-  布局文件中使用 

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res/com.example.test"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <com.example.test.MyTextView
        android:layout_width="100dp"
        android:layout_height="200dp"
        app:testAttr="520"
        app:text="helloworld" />

</RelativeLayout>
```

#### 属性值的类型format

 (1). reference：参考某一资源ID 

-  属性定义： 

```
<declare-styleable name = "名称">
     <attr name = "background" format = "reference" />
</declare-styleable>
```

-  属性使用： 

```
<ImageView android:background = "@drawable/图片ID"/>
```

 (2). color：颜色值 

-  属性定义： 

```
<attr name = "textColor" format = "color" />
```

-  属性使用： 

```
<TextView android:textColor = "#00FF00" />
```

 (3). boolean：布尔值 

-  属性定义： 

```
<attr name = "focusable" format = "boolean" />
```

-  属性使用： 

```
<Button android:focusable = "true"/>
```

 (4). dimension：尺寸值 

-  属性定义： 

```
<attr name = "layout_width" format = "dimension" />
```

-  属性使用： 

```
<Button android:layout_width = "42dip"/>
```

(5). float：浮点值

- 属性定义：

```xml
<attr name = "fromAlpha" format = "float" />
```

- 属性使用：

```xml
<alpha android:fromAlpha = "1.0"/>
```

(6). integer：整型值

- 属性定义：

```xml
<attr name = "framesCount" format="integer" />
```

- 属性使用：

```xml
<animated-rotate android:framesCount = "12"/>
```

(7). string：字符串

- 属性定义：

```xml
<attr name = "text" format = "string" />
```

- 属性使用：

```xml
<TextView android:text = "我是文本"/>
```

(8). fraction：百分数

- 属性定义：

```xml
<attr name = "pivotX" format = "fraction" />
```

- 属性使用：

```xml
<rotate android:pivotX = "200%"/>
```

(9). enum：枚举值

- 属性定义：

```xml
<declare-styleable name="名称">
    <attr name="orientation">
        <enum name="horizontal" value="0" />
        <enum name="vertical" value="1" />
    </attr>
</declare-styleable>
```

- 属性使用：

```xml
<LinearLayout  
    android:orientation = "vertical">
</LinearLayout>
```

注意：枚举类型的属性在使用的过程中只能同时使用其中一个，不能 android:orientation = “horizontal｜vertical"

(10). flag：位或运算

- 属性定义：

```xml
<declare-styleable name="名称">
    <attr name="gravity">
            <flag name="top" value="0x01" />
            <flag name="bottom" value="0x02" />
            <flag name="left" value="0x04" />
            <flag name="right" value="0x08" />
            <flag name="center_vertical" value="0x16" />
            ...
    </attr>
</declare-styleable>
```

- 属性使用：

```xml
<TextView android:gravity="bottom|left"/>
```

注意：位运算类型的属性在使用的过程中可以使用多个值

(11). 混合类型：属性定义时可以指定多种类型值

- 属性定义：

```xml
<declare-styleable name = "名称">
     <attr name = "background" format = "reference|color" />
</declare-styleable>
```

- 属性使用：

```xml
<ImageView
android:background = "@drawable/图片ID" />
或者：
<ImageView
```

#### 2. View绘制流程

 View的绘制基本由measure()、layout()、draw()这个三个函数完成 

| **函数**  | **作用**                     | 相关方法                                     |
| --------- | ---------------------------- | -------------------------------------------- |
| measure() | 测量View的宽高               | measure(),setMeasuredDimension(),onMeasure() |
| layout()  | 计算当前View以及子View的位置 | layout(),onLayout(),setFrame()               |
| draw()    | 视图的绘制工作               | draw(),onDraw()                              |

#### 2.1 Measure()

##### MeasureSpec 

`MeasureSpec`是View的内部类，它封装了一个View的尺寸，在`onMeasure()`当中会根据这个`MeasureSpec`的值来确定View的宽高。

`MeasureSpec`的值保存在一个int值当中。一个int值有32位，前两位表示`模式mode`后30位表示`大小size`。即`MeasureSpec` = `mode` + `size`。

在`MeasureSpec`当中一共存在三种`mode`：`UNSPECIFIED`、`EXACTLY` 和
 `AT_MOST`。

对于View来说，`MeasureSpec`的mode和Size有如下意义

| 模式        | 意义                                                         | 对应             |
| ----------- | ------------------------------------------------------------ | ---------------- |
| EXACTLY     | 精准模式，View需要一个精确值，这个值即为MeasureSpec当中的Size | match_parent     |
| AT_MOST     | 最大模式，View的尺寸有一个最大值，View不可以超过MeasureSpec当中的Size值 | wrap_content     |
| UNSPECIFIED | 无限制，View对尺寸没有任何限制，View设置为多大就应当为多大   | 一般系统内部使用 |

使用方式：

```java
 // 获取测量模式（Mode）
    int specMode = MeasureSpec.getMode(measureSpec)

    // 获取测量大小（Size）
    int specSize = MeasureSpec.getSize(measureSpec)

    // 通过Mode 和 Size 生成新的SpecMode
    int measureSpec=MeasureSpec.makeMeasureSpec(size, mode);
```

 在View当中，`MeasureSpace`的测量代码如下： 

```
public static int getChildMeasureSpec(int spec, int padding, int childDimension) {
        int specMode = MeasureSpec.getMode(spec);
        int specSize = MeasureSpec.getSize(spec);

        int size = Math.max(0, specSize - padding);

        int resultSize = 0;
        int resultMode = 0;

        switch (specMode) {
        //当父View要求一个精确值时，为子View赋值
        case MeasureSpec.EXACTLY:
            //如果子view有自己的尺寸，则使用自己的尺寸
            if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
                //当子View是match_parent,将父View的大小赋值给子View
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                resultSize = size;
                resultMode = MeasureSpec.EXACTLY;
                //如果子View是wrap_content，设置子View的最大尺寸为父View
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            }
            break;

        // 父布局给子View了一个最大界限
        case MeasureSpec.AT_MOST:
            if (childDimension >= 0) {
                //如果子view有自己的尺寸，则使用自己的尺寸
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                // 父View的尺寸为子View的最大尺寸
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                //父View的尺寸为子View的最大尺寸
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            }
            break;

        // 父布局对子View没有做任何限制
        case MeasureSpec.UNSPECIFIED:
            if (childDimension >= 0) {
            //如果子view有自己的尺寸，则使用自己的尺寸
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                //因父布局没有对子View做出限制，当子View为MATCH_PARENT时则大小为0
                resultSize = View.sUseZeroUnspecifiedMeasureSpec ? 0 : size;
                resultMode = MeasureSpec.UNSPECIFIED;
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                //因父布局没有对子View做出限制，当子View为WRAP_CONTENT时则大小为0
                resultSize = View.sUseZeroUnspecifiedMeasureSpec ? 0 : size;
                resultMode = MeasureSpec.UNSPECIFIED;
            }
            break;
        }
    
        return MeasureSpec.makeMeasureSpec(resultSize, resultMode);
    }
```









