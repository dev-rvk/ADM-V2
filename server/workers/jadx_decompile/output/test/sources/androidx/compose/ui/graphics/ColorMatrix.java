package androidx.compose.ui.graphics;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.util.LocalePreferences;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorMatrix.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0086\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000bJP\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f26\u0010&\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\t0'H\u0082\b¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J(\u0010.\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b9\u00107J\u0015\u0010:\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b;\u00107J\u0015\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000f¢\u0006\u0004\b>\u00107J-\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f¢\u0006\u0004\bD\u0010EJ\u001e\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u00101J\u0010\u0010I\u001a\u00020JHÖ\u0001¢\u0006\u0004\bK\u0010LR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006M"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "convertRgbToYuv", "", "convertRgbToYuv-impl", "([F)V", "convertYuvToRgb", "convertYuvToRgb-impl", "dot", "", "m1", "row", "", "m2", "column", "dot-Me4OoYI", "([F[FI[FI)F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "reset", "reset-impl", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "set", "src", "set-jHG-Opc", "([F[F)V", "v", "set-impl", "([FIIF)V", "setToRotateBlue", "setToRotateBlue-impl", "([FF)V", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateRed", "setToRotateRed-impl", "setToSaturation", LocalePreferences.FirstDayOfWeek.SATURDAY, "setToSaturation-impl", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class ColorMatrix {
    private final float[] values;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m3004boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float[] m3005constructorimpl(float[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return values;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3010equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual(fArr, ((ColorMatrix) obj).m3025unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3011equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3013hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3024toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object obj) {
        return m3010equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m3013hashCodeimpl(this.values);
    }

    public String toString() {
        return m3024toStringimpl(this.values);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m3025unboximpl() {
        return this.values;
    }

    private /* synthetic */ ColorMatrix(float[] values) {
        this.values = values;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m3006constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m3005constructorimpl(fArr);
    }

    public final float[] getValues() {
        return this.values;
    }

    /* renamed from: get-impl, reason: not valid java name */
    public static final float m3012getimpl(float[] arg0, int row, int column) {
        return arg0[(row * 5) + column];
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m3016setimpl(float[] arg0, int row, int column, float v) {
        arg0[(row * 5) + column] = v;
    }

    /* renamed from: reset-impl, reason: not valid java name */
    public static final void m3014resetimpl(float[] arg0) {
        ArraysKt.fill$default(arg0, 0.0f, 0, 0, 6, (Object) null);
        arg0[(0 * 5) + 0] = 1.0f;
        arg0[(2 * 5) + 2] = 1.0f;
        arg0[(1 * 5) + 1] = 1.0f;
        arg0[(3 * 5) + 3] = 1.0f;
    }

    /* renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m3017setjHGOpc(float[] arg0, float[] src) {
        Intrinsics.checkNotNullParameter(src, "src");
        ArraysKt.copyInto$default(src, arg0, 0, 0, 0, 14, (Object) null);
    }

    /* renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m3015rotateInternalimpl(float[] arg0, float degrees, Function2<? super Float, ? super Float, Unit> function2) {
        m3014resetimpl(arg0);
        double radians = (degrees * 3.141592653589793d) / 180.0d;
        float cosine = (float) Math.cos(radians);
        float sine = (float) Math.sin(radians);
        function2.invoke(Float.valueOf(cosine), Float.valueOf(sine));
    }

    /* renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m3023timesAssignjHGOpc(float[] arg0, float[] colorMatrix) {
        Intrinsics.checkNotNullParameter(colorMatrix, "colorMatrix");
        float v00 = m3009dotMe4OoYI(arg0, arg0, 0, colorMatrix, 0);
        float v01 = m3009dotMe4OoYI(arg0, arg0, 0, colorMatrix, 1);
        float v02 = m3009dotMe4OoYI(arg0, arg0, 0, colorMatrix, 2);
        float v03 = m3009dotMe4OoYI(arg0, arg0, 0, colorMatrix, 3);
        float v04 = (arg0[(0 * 5) + 0] * colorMatrix[(0 * 5) + 4]) + (arg0[(0 * 5) + 1] * colorMatrix[(1 * 5) + 4]) + (arg0[(0 * 5) + 2] * colorMatrix[(2 * 5) + 4]) + (arg0[(0 * 5) + 3] * colorMatrix[(3 * 5) + 4]) + arg0[(0 * 5) + 4];
        float v10 = m3009dotMe4OoYI(arg0, arg0, 1, colorMatrix, 0);
        float v11 = m3009dotMe4OoYI(arg0, arg0, 1, colorMatrix, 1);
        float v12 = m3009dotMe4OoYI(arg0, arg0, 1, colorMatrix, 2);
        float v13 = m3009dotMe4OoYI(arg0, arg0, 1, colorMatrix, 3);
        float v14 = (arg0[(1 * 5) + 0] * colorMatrix[(0 * 5) + 4]) + (arg0[(1 * 5) + 1] * colorMatrix[(1 * 5) + 4]) + (arg0[(1 * 5) + 2] * colorMatrix[(2 * 5) + 4]) + (arg0[(1 * 5) + 3] * colorMatrix[(3 * 5) + 4]) + arg0[(1 * 5) + 4];
        float v20 = m3009dotMe4OoYI(arg0, arg0, 2, colorMatrix, 0);
        float v21 = m3009dotMe4OoYI(arg0, arg0, 2, colorMatrix, 1);
        float v22 = m3009dotMe4OoYI(arg0, arg0, 2, colorMatrix, 2);
        float v23 = m3009dotMe4OoYI(arg0, arg0, 2, colorMatrix, 3);
        float v24 = (arg0[(2 * 5) + 0] * colorMatrix[(0 * 5) + 4]) + (arg0[(2 * 5) + 1] * colorMatrix[(1 * 5) + 4]) + (arg0[(2 * 5) + 2] * colorMatrix[(2 * 5) + 4]) + (arg0[(2 * 5) + 3] * colorMatrix[(3 * 5) + 4]) + arg0[(2 * 5) + 4];
        float v30 = m3009dotMe4OoYI(arg0, arg0, 3, colorMatrix, 0);
        float v31 = m3009dotMe4OoYI(arg0, arg0, 3, colorMatrix, 1);
        float v32 = m3009dotMe4OoYI(arg0, arg0, 3, colorMatrix, 2);
        float v33 = m3009dotMe4OoYI(arg0, arg0, 3, colorMatrix, 3);
        float v34 = (arg0[(3 * 5) + 0] * colorMatrix[(0 * 5) + 4]) + (arg0[(3 * 5) + 1] * colorMatrix[(1 * 5) + 4]) + (arg0[(3 * 5) + 2] * colorMatrix[(2 * 5) + 4]) + (arg0[(3 * 5) + 3] * colorMatrix[(3 * 5) + 4]) + arg0[(3 * 5) + 4];
        arg0[(0 * 5) + 0] = v00;
        arg0[(0 * 5) + 1] = v01;
        arg0[(0 * 5) + 2] = v02;
        arg0[(0 * 5) + 3] = v03;
        arg0[(0 * 5) + 4] = v04;
        arg0[(1 * 5) + 0] = v10;
        arg0[(1 * 5) + 1] = v11;
        arg0[(1 * 5) + 2] = v12;
        arg0[(1 * 5) + 3] = v13;
        arg0[(1 * 5) + 4] = v14;
        arg0[(2 * 5) + 0] = v20;
        arg0[(2 * 5) + 1] = v21;
        arg0[(2 * 5) + 2] = v22;
        arg0[(2 * 5) + 3] = v23;
        arg0[(2 * 5) + 4] = v24;
        arg0[(3 * 5) + 0] = v30;
        arg0[(3 * 5) + 1] = v31;
        arg0[(3 * 5) + 2] = v32;
        arg0[(3 * 5) + 3] = v33;
        arg0[(3 * 5) + 4] = v34;
    }

    /* renamed from: dot-Me4OoYI, reason: not valid java name */
    private static final float m3009dotMe4OoYI(float[] arg0, float[] m1, int row, float[] m2, int column) {
        return (m1[(row * 5) + 0] * m2[(0 * 5) + column]) + (m1[(row * 5) + 1] * m2[(1 * 5) + column]) + (m1[(row * 5) + 2] * m2[(2 * 5) + column]) + (m1[(row * 5) + 3] * m2[(3 * 5) + column]);
    }

    /* renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m3021setToSaturationimpl(float[] arg0, float sat) {
        m3014resetimpl(arg0);
        float invSat = 1 - sat;
        float R = 0.213f * invSat;
        float G = 0.715f * invSat;
        float B = 0.072f * invSat;
        float v$iv = R + sat;
        arg0[(0 * 5) + 0] = v$iv;
        arg0[(0 * 5) + 1] = G;
        arg0[(0 * 5) + 2] = B;
        arg0[(1 * 5) + 0] = R;
        float v$iv2 = G + sat;
        arg0[(1 * 5) + 1] = v$iv2;
        arg0[(1 * 5) + 2] = B;
        arg0[(2 * 5) + 0] = R;
        arg0[(2 * 5) + 1] = G;
        float v$iv3 = B + sat;
        arg0[(2 * 5) + 2] = v$iv3;
    }

    /* renamed from: setToScale-impl, reason: not valid java name */
    public static final void m3022setToScaleimpl(float[] arg0, float redScale, float greenScale, float blueScale, float alphaScale) {
        m3014resetimpl(arg0);
        arg0[(0 * 5) + 0] = redScale;
        arg0[(1 * 5) + 1] = greenScale;
        arg0[(2 * 5) + 2] = blueScale;
        arg0[(3 * 5) + 3] = alphaScale;
    }

    /* renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m3020setToRotateRedimpl(float[] arg0, float degrees) {
        m3014resetimpl(arg0);
        double radians$iv = (degrees * 3.141592653589793d) / 180.0d;
        float cosine$iv = (float) Math.cos(radians$iv);
        float sine$iv = (float) Math.sin(radians$iv);
        arg0[(2 * 5) + 2] = cosine$iv;
        arg0[(1 * 5) + 1] = cosine$iv;
        arg0[(1 * 5) + 2] = sine$iv;
        float v$iv = -sine$iv;
        arg0[(2 * 5) + 1] = v$iv;
    }

    /* renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m3019setToRotateGreenimpl(float[] arg0, float degrees) {
        m3014resetimpl(arg0);
        double radians$iv = (degrees * 3.141592653589793d) / 180.0d;
        float cosine$iv = (float) Math.cos(radians$iv);
        float sine$iv = (float) Math.sin(radians$iv);
        arg0[(2 * 5) + 2] = cosine$iv;
        arg0[(0 * 5) + 0] = cosine$iv;
        float v$iv = -sine$iv;
        arg0[(0 * 5) + 2] = v$iv;
        arg0[(2 * 5) + 0] = sine$iv;
    }

    /* renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m3018setToRotateBlueimpl(float[] arg0, float degrees) {
        m3014resetimpl(arg0);
        double radians$iv = (degrees * 3.141592653589793d) / 180.0d;
        float cosine$iv = (float) Math.cos(radians$iv);
        float sine$iv = (float) Math.sin(radians$iv);
        arg0[(1 * 5) + 1] = cosine$iv;
        arg0[(0 * 5) + 0] = cosine$iv;
        arg0[(0 * 5) + 1] = sine$iv;
        float v$iv = -sine$iv;
        arg0[(1 * 5) + 0] = v$iv;
    }

    /* renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m3007convertRgbToYuvimpl(float[] arg0) {
        m3014resetimpl(arg0);
        arg0[(0 * 5) + 0] = 0.299f;
        arg0[(0 * 5) + 1] = 0.587f;
        arg0[(0 * 5) + 2] = 0.114f;
        arg0[(1 * 5) + 0] = -0.16874f;
        arg0[(1 * 5) + 1] = -0.33126f;
        arg0[(1 * 5) + 2] = 0.5f;
        arg0[(2 * 5) + 0] = 0.5f;
        arg0[(2 * 5) + 1] = -0.41869f;
        arg0[(2 * 5) + 2] = -0.08131f;
    }

    /* renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m3008convertYuvToRgbimpl(float[] arg0) {
        m3014resetimpl(arg0);
        arg0[(0 * 5) + 2] = 1.402f;
        arg0[(1 * 5) + 0] = 1.0f;
        arg0[(1 * 5) + 1] = -0.34414f;
        arg0[(1 * 5) + 2] = -0.71414f;
        arg0[(2 * 5) + 0] = 1.0f;
        arg0[(2 * 5) + 1] = 1.772f;
        arg0[(2 * 5) + 2] = 0.0f;
    }
}
