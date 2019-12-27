# view相关知识

### 自定义View分为两大块。 
自定义控件  和  自定义容器

自定义View必须重写两个构造方法 
	第一个是一个参数的上下文，用于在java代码中new对象使用。 
	第二个是两个参数的一个上下文，一个AttributSet。 主要用于在xml中定义使用。
	**OnMesure** ：计算出控件的大小。 
	**onLayout**  ：计算出控件的位置。 
	**onDraw** ：画出样式 。
ViewGroup\View的绘制流程：

* 第一步：调用ViewGroup中的onMeasure方法。
             在方法中调用了measureChild方法，执行了所有子控件的onMesure方法测绘出所有的子控件的大小。
  调用setMeasureDimension方法 设置测绘后的大小。

* 第二步：调用ViewGroup中的onLayout方法。
  在方法调用getChildCount方法 获取到子条目数量。
  用for循环遍历出每一个子条目的对象。 通过对象.layout方法 给子控件设置摆放位置。
* 第三步：首先调用ViewGroup的disPatchDraw方法绘制ViewGroup。然后调用View中的onDraw方 进行绘制。

**方法详解:**
   **onMeasure：**用于设置自定义view的大小
    setMeasuredDimension();
  方法内部需要调用MeasureSpec类 可以获取到view的模式 和 大小；
  MeasureSpec.getMode（）获取模式
  MeasureSpec.getSize（）获取大小       
  模式：
  MeasureSpec.EXACTLY 精确值模式： match_parent 或者 固定一个值（。。dp）时使用。
  MeasureSpec.AT_MOST 最大值模式： warp_content 当不确定大小时使用。但是不超过父控件
  MeasureSpec.UNSPECIFIED 不用 就不总结了。
  onDraw方法：
  用于绘制自定义View。
  主要使用到了Canvas 画布对象。 和Paint 画笔对象 进行的绘制。 




### 1. invalidate和postInvalidateDelayed()。

#### 区别与联系

* `postInvalidate()` 方法在非 UI 线程中调用，通知 UI 线程重绘。
* `invalidate()` 方法在 UI 线程中调用，重绘当前 UI。

