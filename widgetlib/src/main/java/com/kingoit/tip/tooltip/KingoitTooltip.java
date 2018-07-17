package com.kingoit.tip.tooltip;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.IntDef;
import android.view.View;
import android.view.ViewGroup;

import com.kingoit.widgetlib.R;
import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;

/**
 * @author xmj
 * @date 2018/7/16
 */
public class KingoitTooltip {

    @IntDef({POSITION_ABOVE, POSITION_BELOW, POSITION_LEFT_TO, POSITION_RIGHT_TO})
    public @interface Position {}
    public static final int POSITION_ABOVE = 0;
    public static final int POSITION_BELOW = 1;
    public static final int POSITION_LEFT_TO = 3;
    public static final int POSITION_RIGHT_TO = 4;

    @IntDef({ALIGN_CENTER, ALIGN_LEFT, ALIGN_RIGHT})
    public @interface Align {}
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;

    @IntDef({GRAVITY_CENTER, GRAVITY_LEFT, GRAVITY_RIGHT})
    public @interface Gravity {}
    public static final int GRAVITY_CENTER = 0;
    public static final int GRAVITY_LEFT = 1;
    public static final int GRAVITY_RIGHT = 2;

    private static KingoitTooltip sKingoitTooltip;

    public static KingoitTooltip getInstance() {
        if (sKingoitTooltip == null) {
            sKingoitTooltip = new KingoitTooltip();
        }
        return sKingoitTooltip;
    }

    private ToolTipsManager mToolTipsManager;

    private KingoitTooltip() {
        if (mToolTipsManager == null) {
            mToolTipsManager = new ToolTipsManager();
        }
    }

    public void showTip(Context context, View archorView, ViewGroup rootLayout, String tip, @ToolTip.Position int direction) {
        showTip(context, archorView, rootLayout, tip, direction, context.getResources().getColor(com.tomergoldst.tooltips.R.color.colorBackground));
    }

    public void showTip(Context context, View archorView, ViewGroup rootLayout, String tip, @ToolTip.Position int direction, int backgroundColor) {
        showTip(context, archorView, rootLayout, tip, direction, ToolTip.ALIGN_CENTER, ToolTip.GRAVITY_CENTER,
                null, R.style.TooltipTextAppearance, backgroundColor);
    }

    /**
     * 显示提示
     *
     * @param context
     * @param archorView 锚点view
     * @param rootLayout 根布局
     * @param tip        提示文字
     * @param direction  箭头方向
     * @param align      箭头偏移
     * @param typeface   字体
     */
    public void showTip(Context context, View archorView, ViewGroup rootLayout, String tip,
                        @ToolTip.Position int direction, @ToolTip.Align int align, @ToolTip.Gravity int gravity,
                        Typeface typeface, int textAppearance, int backgroundColor) {
        mToolTipsManager.findAndDismiss(archorView);
        ToolTip.Builder builder;
        builder = new ToolTip.Builder(context, archorView, rootLayout, tip, direction);
        builder.setAlign(align);
        builder.setTypeface(typeface);
        builder.setGravity(gravity);
        builder.setTextAppearance(textAppearance);
        builder.setBackgroundColor(backgroundColor);
        mToolTipsManager.show(builder.build());
    }

    /**
     * 消掉所有
     */
    public void dismissAll() {
        mToolTipsManager.dismissAll();
    }

}
