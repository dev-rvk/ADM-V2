package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPaint.android.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\t*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b*\u00060\u0003j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u0018\u0010\r\u001a\u00020\u000e*\u00060\u0003j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u00020\u0011*\u00060\u0003j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0012\u001a\u00020\u0013*\u00060\u0003j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u0010\u0010\u0014\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0010\u0010\u0015\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0018\u0010\u0016\u001a\u00020\u0017*\u00060\u0003j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0018\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\tH\u0000\u001a%\u0010\u001c\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a%\u0010!\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u000bH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001a\u0010$\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010%H\u0000\u001a%\u0010&\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u000eH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010 \u001a\u001a\u0010(\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010)H\u0000\u001a \u0010*\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u000e\u0010\u001a\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,H\u0000\u001a%\u0010-\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0011H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010 \u001a%\u0010/\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0013H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010 \u001a\u0018\u00101\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a\u0018\u00102\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a%\u00103\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0017H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010 *\n\u00105\"\u00020\u00032\u00020\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Paint", "Landroidx/compose/ui/graphics/Paint;", "makeNativePaint", "Landroid/graphics/Paint;", "asComposePaint", "getNativeAlpha", "", "Landroidx/compose/ui/graphics/NativePaint;", "getNativeAntiAlias", "", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "(Landroid/graphics/Paint;)I", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getNativeStrokeMiterLimit", "getNativeStrokeWidth", "getNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeAlpha", "", "value", "setNativeAntiAlias", "setNativeBlendMode", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "setNativeStrokeMiterLimit", "setNativeStrokeWidth", "setNativeStyle", "setNativeStyle--5YerkU", "NativePaint", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidPaint_androidKt {

    /* compiled from: AndroidPaint.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint asComposePaint(android.graphics.Paint $this$asComposePaint) {
        Intrinsics.checkNotNullParameter($this$asComposePaint, "<this>");
        return new AndroidPaint($this$asComposePaint);
    }

    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    /* renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m2835setNativeBlendModeGB0RdKg(android.graphics.Paint setNativeBlendMode, int mode) {
        Intrinsics.checkNotNullParameter(setNativeBlendMode, "$this$setNativeBlendMode");
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m3345setBlendModeGB0RdKg(setNativeBlendMode, mode);
        } else {
            setNativeBlendMode.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m2803toPorterDuffModes9anfk8(mode)));
        }
    }

    public static final void setNativeColorFilter(android.graphics.Paint $this$setNativeColorFilter, ColorFilter value) {
        Intrinsics.checkNotNullParameter($this$setNativeColorFilter, "<this>");
        $this$setNativeColorFilter.setColorFilter(value != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(value) : null);
    }

    public static final float getNativeAlpha(android.graphics.Paint $this$getNativeAlpha) {
        Intrinsics.checkNotNullParameter($this$getNativeAlpha, "<this>");
        return $this$getNativeAlpha.getAlpha() / 255.0f;
    }

    public static final void setNativeAlpha(android.graphics.Paint $this$setNativeAlpha, float value) {
        Intrinsics.checkNotNullParameter($this$setNativeAlpha, "<this>");
        $this$setNativeAlpha.setAlpha((int) Math.rint(255.0f * value));
    }

    public static final boolean getNativeAntiAlias(android.graphics.Paint $this$getNativeAntiAlias) {
        Intrinsics.checkNotNullParameter($this$getNativeAntiAlias, "<this>");
        return $this$getNativeAntiAlias.isAntiAlias();
    }

    public static final void setNativeAntiAlias(android.graphics.Paint $this$setNativeAntiAlias, boolean value) {
        Intrinsics.checkNotNullParameter($this$setNativeAntiAlias, "<this>");
        $this$setNativeAntiAlias.setAntiAlias(value);
    }

    public static final long getNativeColor(android.graphics.Paint $this$getNativeColor) {
        Intrinsics.checkNotNullParameter($this$getNativeColor, "<this>");
        return ColorKt.Color($this$getNativeColor.getColor());
    }

    /* renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m2836setNativeColor4WTKRHQ(android.graphics.Paint setNativeColor, long value) {
        Intrinsics.checkNotNullParameter(setNativeColor, "$this$setNativeColor");
        setNativeColor.setColor(ColorKt.m3003toArgb8_81llA(value));
    }

    /* renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m2840setNativeStyle5YerkU(android.graphics.Paint setNativeStyle, int value) {
        Intrinsics.checkNotNullParameter(setNativeStyle, "$this$setNativeStyle");
        setNativeStyle.setStyle(PaintingStyle.m3206equalsimpl0(value, PaintingStyle.INSTANCE.m3211getStrokeTiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }

    public static final int getNativeStyle(android.graphics.Paint $this$getNativeStyle) {
        Intrinsics.checkNotNullParameter($this$getNativeStyle, "<this>");
        Paint.Style style = $this$getNativeStyle.getStyle();
        return (style == null ? -1 : WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) == 1 ? PaintingStyle.INSTANCE.m3211getStrokeTiuSbCo() : PaintingStyle.INSTANCE.m3210getFillTiuSbCo();
    }

    public static final float getNativeStrokeWidth(android.graphics.Paint $this$getNativeStrokeWidth) {
        Intrinsics.checkNotNullParameter($this$getNativeStrokeWidth, "<this>");
        return $this$getNativeStrokeWidth.getStrokeWidth();
    }

    public static final void setNativeStrokeWidth(android.graphics.Paint $this$setNativeStrokeWidth, float value) {
        Intrinsics.checkNotNullParameter($this$setNativeStrokeWidth, "<this>");
        $this$setNativeStrokeWidth.setStrokeWidth(value);
    }

    public static final int getNativeStrokeCap(android.graphics.Paint $this$getNativeStrokeCap) {
        Intrinsics.checkNotNullParameter($this$getNativeStrokeCap, "<this>");
        Paint.Cap strokeCap = $this$getNativeStrokeCap.getStrokeCap();
        switch (strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()]) {
            case 1:
                return StrokeCap.INSTANCE.m3295getButtKaPHkGw();
            case 2:
                return StrokeCap.INSTANCE.m3296getRoundKaPHkGw();
            case 3:
                return StrokeCap.INSTANCE.m3297getSquareKaPHkGw();
            default:
                return StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        }
    }

    /* renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m2838setNativeStrokeCapCSYIeUk(android.graphics.Paint setNativeStrokeCap, int value) {
        Paint.Cap cap;
        Intrinsics.checkNotNullParameter(setNativeStrokeCap, "$this$setNativeStrokeCap");
        if (StrokeCap.m3291equalsimpl0(value, StrokeCap.INSTANCE.m3297getSquareKaPHkGw())) {
            cap = Paint.Cap.SQUARE;
        } else if (StrokeCap.m3291equalsimpl0(value, StrokeCap.INSTANCE.m3296getRoundKaPHkGw())) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = StrokeCap.m3291equalsimpl0(value, StrokeCap.INSTANCE.m3295getButtKaPHkGw()) ? Paint.Cap.BUTT : Paint.Cap.BUTT;
        }
        setNativeStrokeCap.setStrokeCap(cap);
    }

    public static final int getNativeStrokeJoin(android.graphics.Paint $this$getNativeStrokeJoin) {
        Intrinsics.checkNotNullParameter($this$getNativeStrokeJoin, "<this>");
        Paint.Join strokeJoin = $this$getNativeStrokeJoin.getStrokeJoin();
        switch (strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()]) {
            case 1:
                return StrokeJoin.INSTANCE.m3306getMiterLxFBmk8();
            case 2:
                return StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
            case 3:
                return StrokeJoin.INSTANCE.m3307getRoundLxFBmk8();
            default:
                return StrokeJoin.INSTANCE.m3306getMiterLxFBmk8();
        }
    }

    /* renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m2839setNativeStrokeJoinkLtJ_vA(android.graphics.Paint setNativeStrokeJoin, int value) {
        Paint.Join join;
        Intrinsics.checkNotNullParameter(setNativeStrokeJoin, "$this$setNativeStrokeJoin");
        if (StrokeJoin.m3301equalsimpl0(value, StrokeJoin.INSTANCE.m3306getMiterLxFBmk8())) {
            join = Paint.Join.MITER;
        } else if (StrokeJoin.m3301equalsimpl0(value, StrokeJoin.INSTANCE.m3305getBevelLxFBmk8())) {
            join = Paint.Join.BEVEL;
        } else {
            join = StrokeJoin.m3301equalsimpl0(value, StrokeJoin.INSTANCE.m3307getRoundLxFBmk8()) ? Paint.Join.ROUND : Paint.Join.MITER;
        }
        setNativeStrokeJoin.setStrokeJoin(join);
    }

    public static final float getNativeStrokeMiterLimit(android.graphics.Paint $this$getNativeStrokeMiterLimit) {
        Intrinsics.checkNotNullParameter($this$getNativeStrokeMiterLimit, "<this>");
        return $this$getNativeStrokeMiterLimit.getStrokeMiter();
    }

    public static final void setNativeStrokeMiterLimit(android.graphics.Paint $this$setNativeStrokeMiterLimit, float value) {
        Intrinsics.checkNotNullParameter($this$setNativeStrokeMiterLimit, "<this>");
        $this$setNativeStrokeMiterLimit.setStrokeMiter(value);
    }

    public static final int getNativeFilterQuality(android.graphics.Paint $this$getNativeFilterQuality) {
        Intrinsics.checkNotNullParameter($this$getNativeFilterQuality, "<this>");
        if (!$this$getNativeFilterQuality.isFilterBitmap()) {
            return FilterQuality.INSTANCE.m3047getNonefv9h1I();
        }
        return FilterQuality.INSTANCE.m3045getLowfv9h1I();
    }

    /* renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m2837setNativeFilterQuality50PEsBU(android.graphics.Paint setNativeFilterQuality, int value) {
        Intrinsics.checkNotNullParameter(setNativeFilterQuality, "$this$setNativeFilterQuality");
        setNativeFilterQuality.setFilterBitmap(!FilterQuality.m3040equalsimpl0(value, FilterQuality.INSTANCE.m3047getNonefv9h1I()));
    }

    public static final void setNativeShader(android.graphics.Paint $this$setNativeShader, Shader value) {
        Intrinsics.checkNotNullParameter($this$setNativeShader, "<this>");
        $this$setNativeShader.setShader(value);
    }

    public static final void setNativePathEffect(android.graphics.Paint $this$setNativePathEffect, PathEffect value) {
        Intrinsics.checkNotNullParameter($this$setNativePathEffect, "<this>");
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) value;
        $this$setNativePathEffect.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }
}
