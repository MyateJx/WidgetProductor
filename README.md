# WidgetProductor
项目地址：https://github.com/MyateJx/WidgetProductor

## 说明
- **1、提交代码需严格按照`Alibaba`代码规范**
- **2、每个功能块代码上传，需标明作者及更新时间**
- **3、每个功能块代码需在`app Module`中编写示例代码，并做好标注**

## 1.提示类

| 序号   | 功能块     | 提交人  | 更新时间       | 主要功能类  | 示例代码位置       |
| :---: | :------: | :---: | :---------: | :--- | :----------- |
|   1.1  | Tooltip | 许明君 | 2018-07-16 | **KingoitTooltip** | com.kingoit.widgetproductor.tip.TooltipActivity |
|  1.2   | Dialog |  许明君 | 2018-07-19 | **KingoitDialog** |  com.kingoit.tip.dialog.KingoitDialog |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |



## 2.列表类

|  序号 |  功能块  | 提交人| 更新时间    | 主要功能类   | 示例代码位置   |
| :---: | :------: | :---: | :---------: | :--- | :----------- |
|   2.1  |  流式布局 | 左志杰| 2018-07-16 | **KingoitFlowLayout** |com.kingoit.widgetproductor.list.FlowLayoutActivity |
|   2.2  | Spinner |曾雍皓| 2018-07-16 | **KingoitItemView**|com.kingoit.widgetproductor.MainActivity |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |
|      |         |      |            |      |              |


### 2.1、流式布局
流式布局  : 常用于搜索历史记录、标签展示

![流式布局](https://upload-images.jianshu.io/upload_images/5332977-9010dc33399830ac.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 2.2、Spinner
利用PopupWindow+recyclerview 替代Spinner

![Spinner ](https://upload-images.jianshu.io/upload_images/5332977-8e06f9c1563be7a8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 1.1、Tooltip - 引导提示
作用：弹出引导提示，告诉用户可点击某处，起指明的作用。

期望：

1. 可在目标view的上、下、左、右边弹出。
2. 可调整提示的字体大小、字体颜色、背景颜色。
3. 可设置在屏幕中的方位，上、下、左、右。

![Tooltip ](https://upload-images.jianshu.io/upload_images/57036-addbdd5ad22563cb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 1.2、Dialog - 对话框
作用：弹出对话框，可供用户选择或查看进度。

期望：

1. 可一键调用，可控制其外部点击关闭与否。
2. 可调整字体大小、字体颜色、背景颜色。
3. 可调用不同的选项模式、进度模式。

![Dialog ](https://upload-images.jianshu.io/upload_images/57036-f89f1aa96f313a03.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
