# WidgetProductor
项目地址：https://github.com/MyateJx/WidgetProductor

## 说明
- **1、提交代码需严格按照`Alibaba`代码规范**
- **2、每个功能块代码上传，需标明作者及更新时间**
- **3、每个功能块代码需在`app Module`中编写示例代码，并做好标注**

-------------
## 1.提示类

| 序号   | 功能块     | 提交人  | 更新时间       | 主要功能类  | 示例代码位置       |
| :---: | :------: | :---: | :---------: | :--- | :----------- |
|   1.1  | Tooltip | MyateJx | 2018-07-16 | **KingoitTooltip** | com.kingoit.widgetproductor.tip.TooltipActivity |
|  1.2   | Dialog |  MyateJx | 2018-07-19 | **KingoitDialog** |  com.kingoit.tip.dialog.KingoitDialog |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |

---------------------------
### 1.1、Tooltip - 引导提示
作用：弹出引导提示，告诉用户可点击某处，起指明的作用。

期望：

1. 可在目标view的上、下、左、右边弹出。
2. 可调整提示的字体大小、字体颜色、背景颜色。
3. 可设置在屏幕中的方位，上、下、左、右。

![Tooltip ](https://upload-images.jianshu.io/upload_images/57036-e50fd8e32fcd3139.gif?imageMogr2/auto-orient/strip)

### 1.2、Dialog - 对话框
作用：弹出对话框，可供用户选择或查看进度。

期望：

1. 可一键调用，可控制其外部点击关闭与否。
2. 可调整字体大小、字体颜色、背景颜色。
3. 可调用不同的选项模式、进度模式。
4. 旋转屏幕等父窗口重置的情况，自身还能恢复。（todo）
5. 可动态插入表单控件和回调。（todo）

![Dialog ](https://upload-images.jianshu.io/upload_images/57036-223bd881770a068b.gif?imageMogr2/auto-orient/strip)

-------------------

## 2.列表类

|  序号 |  功能块  | 提交人| 更新时间    | 主要功能类   | 示例代码位置   |
| :---: | :------: | :---: | :---------: | :--- | :----------- |
|   2.1  |  流式布局 | zuo123| 2018-07-16 | **KingoitFlowLayout** |com.kingoit.widgetproductor.list.FlowLayoutActivity |
|   2.2  | Spinner |zuo123| 2018-07-23 | **SpinnerUtils**|com.kingoit.widgetproductor.list.SpinnerActivity |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
----------------

### 2.1、流式布局
流式布局  : 常用于搜索历史记录、标签展示。
- **可设置的属性如下**
```
<!--KingoitFlowLayout ，流式布局属性设置-->
    <declare-styleable name="KingoitFlowLayout">
        <attr name="flowLayoutRadius" format="dimension"/>
        <attr name="flowLayoutTextColor" format="color"/>
        <attr name="flowLayoutTextSize" format="dimension"/>
        <attr name="flowLayoutLineColor" format="color"/>
        <attr name="flowLayoutLineWidth" format="dimension"/>
        <attr name="flowLayoutBackgroundColor" format="color"/>
        <attr name="flowLayoutDeleteBtnColor" format="color"/>
    </declare-styleable>
```

- **效果图**
![image.png](https://upload-images.jianshu.io/upload_images/5332977-2d8bc019ee274025.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/5332977-a4937a296fc80fee.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 2.2、Spinner
利用PopupWindow+recyclerview 替代Spinner；
可以自定义的Adapter（需要继承BaseSpinnerAdapter）；
可以自定义列表的item布局，及数据实体。
可以重新设置箭头的图标。
![image.png](https://upload-images.jianshu.io/upload_images/5332977-cbca4a94a45be475.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

------------------------
## 3.导航类

|  序号 |  功能块  | 提交人| 更新时间    | 主要功能类   | 示例代码位置   |
| :---: | :------: | :---: | :---------: | :--- | :----------- |
|   3.1  |  公用HeadView | zuo123| 2018-07-23 | **KingoitHeadView** |com.kingoit.widgetproductor.navigation.HeadViewActivity|
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
----------------

### 3.1、公用HeadView
- **可设置的属性**
```
    <!--KingoitHeadView ，公用头部控件-->
    <declare-styleable name="KingoitHeadView">
        <!--左侧ImageView-->
        <attr name="headLeftImgSrc" format="reference|integer"/>
        <attr name="headLeftImgVisible" format="boolean" />
        <attr name="headLeftImgColor" format="color"/>
        <!--左侧TextView-->
        <attr name="headLeftText" format="string" />
        <attr name="headLeftTextColor" format="color" />
        <attr name="headLeftTextBackground" format="reference|integer" />
        <!--标题TextView-->
        <attr name="headTitleText" format="string" />
        <attr name="headTitleTextColor" format="color" />
        <attr name="headTitleTextVisible" format="boolean" />
        <!--右侧TextView-->
        <attr name="headRightText" format="string" />
        <attr name="headRightTextColor" format="color" />
        <attr name="headRightTextBackground" format="reference|integer" />
        <!--右侧ImageView-->
        <attr name="headRightImgSrc" format="reference|integer"/>
        <attr name="headRightImgVisible" format="boolean" />
        <attr name="headRightImgColor" format="color"/>
    </declare-styleable>
```
- **设计图**
设计的样式如下，分别为：
`左侧ImageView、左侧TextView、标题TextView、标题容器FrameLayout、右侧TextView、右侧ImageView`

![headView](https://upload-images.jianshu.io/upload_images/5332977-5d84dbcd705e18ac.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- **效果图**
![公用头使用](https://upload-images.jianshu.io/upload_images/5332977-30f1fab20258569a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

------------------------
## 4.展示类

|  序号 |  功能块  | 提交人| 更新时间    | 主要功能类   | 示例代码位置   |
| :---: | :------: | :---: | :---------: | :--- | :----------- |
|   4.1  |  横向滚动TextView | zuo123 | 2018-07-23 | **MarqueeTextView** |com.kingoit.widgetproductor.show.MarqueeTextActivity|
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
----------------

### 4.1、横向滚动TextView
![横向滚动TextView.gif](https://upload-images.jianshu.io/upload_images/5332977-a9e8714d5752d963.gif?imageMogr2/auto-orient/strip)

