package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Matrix.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 G2\u00020\u0001:\u0001GB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u001b\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020$¢\u0006\u0004\b\u001e\u0010%J\r\u0010&\u001a\u00020\u0018¢\u0006\u0004\b'\u0010\u001aJ\u0015\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b-\u0010+J\u0015\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b/\u0010+J+\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b8\u00109J\u001b\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001e\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ+\u0010E\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\bF\u00105R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006H"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "", "row", "", "column", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "invert", "", "invert-impl", "([F)V", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "map-impl", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "reset", "reset-impl", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", "scale", "x", "y", "z", "scale-impl", "([FFFF)V", "set", "v", "set-impl", "([FIIF)V", "setFrom", "matrix", "setFrom-58bKbWc", "([F[F)V", "timesAssign", "m", "timesAssign-58bKbWc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "translate", "translate-impl", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class Matrix {
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    /* renamed from: box-impl */
    public static final /* synthetic */ Matrix m3172boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* renamed from: constructor-impl */
    public static float[] m3173constructorimpl(float[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return values;
    }

    /* renamed from: equals-impl */
    public static boolean m3175equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual(fArr, ((Matrix) obj).m3195unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m3176equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* renamed from: hashCode-impl */
    public static int m3178hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public boolean equals(Object obj) {
        return m3175equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m3178hashCodeimpl(this.values);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ float[] m3195unboximpl() {
        return this.values;
    }

    private /* synthetic */ Matrix(float[] values) {
        this.values = values;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ float[] m3174constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m3173constructorimpl(fArr);
    }

    public final float[] getValues() {
        return this.values;
    }

    /* renamed from: get-impl */
    public static final float m3177getimpl(float[] arg0, int row, int column) {
        return arg0[(row * 4) + column];
    }

    /* renamed from: set-impl */
    public static final void m3189setimpl(float[] arg0, int row, int column, float v) {
        arg0[(row * 4) + column] = v;
    }

    /* renamed from: map-MK-Hz9U */
    public static final long m3180mapMKHz9U(float[] arg0, long point) {
        float x = Offset.m2710getXimpl(point);
        float y = Offset.m2711getYimpl(point);
        float z = (arg0[(0 * 4) + 3] * x) + (arg0[(1 * 4) + 3] * y) + arg0[(3 * 4) + 3];
        float inverseZ = 1 / z;
        float pZ = (Float.isInfinite(inverseZ) || Float.isNaN(inverseZ)) ? false : true ? inverseZ : 0.0f;
        return OffsetKt.Offset(((arg0[(0 * 4) + 0] * x) + (arg0[(1 * 4) + 0] * y) + arg0[(3 * 4) + 0]) * pZ, ((arg0[(0 * 4) + 1] * x) + (arg0[(1 * 4) + 1] * y) + arg0[(3 * 4) + 1]) * pZ);
    }

    /* renamed from: map-impl */
    public static final Rect m3181mapimpl(float[] arg0, Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        long p0 = m3180mapMKHz9U(arg0, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long p1 = m3180mapMKHz9U(arg0, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long p3 = m3180mapMKHz9U(arg0, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long p4 = m3180mapMKHz9U(arg0, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        float left = Math.min(Math.min(Offset.m2710getXimpl(p0), Offset.m2710getXimpl(p1)), Math.min(Offset.m2710getXimpl(p3), Offset.m2710getXimpl(p4)));
        float top = Math.min(Math.min(Offset.m2711getYimpl(p0), Offset.m2711getYimpl(p1)), Math.min(Offset.m2711getYimpl(p3), Offset.m2711getYimpl(p4)));
        float right = Math.max(Math.max(Offset.m2710getXimpl(p0), Offset.m2710getXimpl(p1)), Math.max(Offset.m2710getXimpl(p3), Offset.m2710getXimpl(p4)));
        float bottom = Math.max(Math.max(Offset.m2711getYimpl(p0), Offset.m2711getYimpl(p1)), Math.max(Offset.m2711getYimpl(p3), Offset.m2711getYimpl(p4)));
        return new Rect(left, top, right, bottom);
    }

    /* renamed from: map-impl */
    public static final void m3182mapimpl(float[] arg0, MutableRect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        long p0 = m3180mapMKHz9U(arg0, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long p1 = m3180mapMKHz9U(arg0, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long p3 = m3180mapMKHz9U(arg0, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long p4 = m3180mapMKHz9U(arg0, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        rect.setLeft(Math.min(Math.min(Offset.m2710getXimpl(p0), Offset.m2710getXimpl(p1)), Math.min(Offset.m2710getXimpl(p3), Offset.m2710getXimpl(p4))));
        rect.setTop(Math.min(Math.min(Offset.m2711getYimpl(p0), Offset.m2711getYimpl(p1)), Math.min(Offset.m2711getYimpl(p3), Offset.m2711getYimpl(p4))));
        rect.setRight(Math.max(Math.max(Offset.m2710getXimpl(p0), Offset.m2710getXimpl(p1)), Math.max(Offset.m2710getXimpl(p3), Offset.m2710getXimpl(p4))));
        rect.setBottom(Math.max(Math.max(Offset.m2711getYimpl(p0), Offset.m2711getYimpl(p1)), Math.max(Offset.m2711getYimpl(p3), Offset.m2711getYimpl(p4))));
    }

    /* renamed from: timesAssign-58bKbWc */
    public static final void m3191timesAssign58bKbWc(float[] arg0, float[] m) {
        float v00;
        float v01;
        float v02;
        float v03;
        float v10;
        float v11;
        float v12;
        float v13;
        float v20;
        float v21;
        float v22;
        float v23;
        float v30;
        float v31;
        float v32;
        float v33;
        Intrinsics.checkNotNullParameter(m, "m");
        v00 = MatrixKt.m3197dotp89u6pk(arg0, 0, m, 0);
        v01 = MatrixKt.m3197dotp89u6pk(arg0, 0, m, 1);
        v02 = MatrixKt.m3197dotp89u6pk(arg0, 0, m, 2);
        v03 = MatrixKt.m3197dotp89u6pk(arg0, 0, m, 3);
        v10 = MatrixKt.m3197dotp89u6pk(arg0, 1, m, 0);
        v11 = MatrixKt.m3197dotp89u6pk(arg0, 1, m, 1);
        v12 = MatrixKt.m3197dotp89u6pk(arg0, 1, m, 2);
        v13 = MatrixKt.m3197dotp89u6pk(arg0, 1, m, 3);
        v20 = MatrixKt.m3197dotp89u6pk(arg0, 2, m, 0);
        v21 = MatrixKt.m3197dotp89u6pk(arg0, 2, m, 1);
        v22 = MatrixKt.m3197dotp89u6pk(arg0, 2, m, 2);
        v23 = MatrixKt.m3197dotp89u6pk(arg0, 2, m, 3);
        v30 = MatrixKt.m3197dotp89u6pk(arg0, 3, m, 0);
        v31 = MatrixKt.m3197dotp89u6pk(arg0, 3, m, 1);
        v32 = MatrixKt.m3197dotp89u6pk(arg0, 3, m, 2);
        v33 = MatrixKt.m3197dotp89u6pk(arg0, 3, m, 3);
        arg0[(0 * 4) + 0] = v00;
        arg0[(0 * 4) + 1] = v01;
        arg0[(0 * 4) + 2] = v02;
        arg0[(0 * 4) + 3] = v03;
        arg0[(1 * 4) + 0] = v10;
        arg0[(1 * 4) + 1] = v11;
        arg0[(1 * 4) + 2] = v12;
        arg0[(1 * 4) + 3] = v13;
        arg0[(2 * 4) + 0] = v20;
        arg0[(2 * 4) + 1] = v21;
        arg0[(2 * 4) + 2] = v22;
        arg0[(2 * 4) + 3] = v23;
        arg0[(3 * 4) + 0] = v30;
        arg0[(3 * 4) + 1] = v31;
        arg0[(3 * 4) + 2] = v32;
        arg0[(3 * 4) + 3] = v33;
    }

    public String toString() {
        return m3192toStringimpl(this.values);
    }

    /* renamed from: toString-impl */
    public static String m3192toStringimpl(float[] arg0) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |").append(arg0[(0 * 4) + 0]).append(' ').append(arg0[(0 * 4) + 1]).append(' ').append(arg0[(0 * 4) + 2]).append(' ').append(arg0[(0 * 4) + 3]).append("|\n            |").append(arg0[(1 * 4) + 0]).append(' ').append(arg0[(1 * 4) + 1]).append(' ').append(arg0[(1 * 4) + 2]).append(' ').append(arg0[(1 * 4) + 3]).append("|\n            |").append(arg0[(2 * 4) + 0]).append(' ').append(arg0[(2 * 4) + 1]).append(' ').append(arg0[(2 * 4) + 2]).append(' ');
        sb.append(arg0[(2 * 4) + 3]).append("|\n            |").append(arg0[(3 * 4) + 0]).append(' ').append(arg0[(3 * 4) + 1]).append(' ').append(arg0[(3 * 4) + 2]).append(' ').append(arg0[(3 * 4) + 3]).append("|\n        ");
        return StringsKt.trimIndent(sb.toString());
    }

    /* renamed from: invert-impl */
    public static final void m3179invertimpl(float[] arg0) {
        float a00 = arg0[(0 * 4) + 0];
        float a01 = arg0[(0 * 4) + 1];
        float a02 = arg0[(0 * 4) + 2];
        float a03 = arg0[(0 * 4) + 3];
        float a10 = arg0[(1 * 4) + 0];
        float a11 = arg0[(1 * 4) + 1];
        float a12 = arg0[(1 * 4) + 2];
        float a13 = arg0[(1 * 4) + 3];
        float a20 = arg0[(2 * 4) + 0];
        float a21 = arg0[(2 * 4) + 1];
        float a22 = arg0[(2 * 4) + 2];
        float a23 = arg0[(2 * 4) + 3];
        float a30 = arg0[(3 * 4) + 0];
        float a31 = arg0[(3 * 4) + 1];
        float a32 = arg0[(3 * 4) + 2];
        float a33 = arg0[(3 * 4) + 3];
        float b00 = (a00 * a11) - (a01 * a10);
        float b01 = (a00 * a12) - (a02 * a10);
        float b02 = (a00 * a13) - (a03 * a10);
        float b03 = (a01 * a12) - (a02 * a11);
        float b04 = (a01 * a13) - (a03 * a11);
        float b05 = (a02 * a13) - (a03 * a12);
        float b06 = (a20 * a31) - (a21 * a30);
        float b07 = (a20 * a32) - (a22 * a30);
        float b08 = (a20 * a33) - (a23 * a30);
        float b09 = (a21 * a32) - (a22 * a31);
        float b10 = (a21 * a33) - (a23 * a31);
        float b11 = (a22 * a33) - (a23 * a32);
        float det = (((((b00 * b11) - (b01 * b10)) + (b02 * b09)) + (b03 * b08)) - (b04 * b07)) + (b05 * b06);
        if (det == 0.0f) {
            return;
        }
        float invDet = 1.0f / det;
        float v$iv = (((a11 * b11) - (a12 * b10)) + (a13 * b09)) * invDet;
        arg0[(0 * 4) + 0] = v$iv;
        float v$iv2 = ((((-a01) * b11) + (a02 * b10)) - (a03 * b09)) * invDet;
        arg0[(0 * 4) + 1] = v$iv2;
        float v$iv3 = (((a31 * b05) - (a32 * b04)) + (a33 * b03)) * invDet;
        arg0[(0 * 4) + 2] = v$iv3;
        float v$iv4 = ((((-a21) * b05) + (a22 * b04)) - (a23 * b03)) * invDet;
        arg0[(0 * 4) + 3] = v$iv4;
        float v$iv5 = ((((-a10) * b11) + (a12 * b08)) - (a13 * b07)) * invDet;
        arg0[(1 * 4) + 0] = v$iv5;
        float v$iv6 = (((a00 * b11) - (a02 * b08)) + (a03 * b07)) * invDet;
        arg0[(1 * 4) + 1] = v$iv6;
        float v$iv7 = ((((-a30) * b05) + (a32 * b02)) - (a33 * b01)) * invDet;
        arg0[(1 * 4) + 2] = v$iv7;
        float v$iv8 = (((a20 * b05) - (a22 * b02)) + (a23 * b01)) * invDet;
        arg0[(1 * 4) + 3] = v$iv8;
        float v$iv9 = (((a10 * b10) - (a11 * b08)) + (a13 * b06)) * invDet;
        arg0[(2 * 4) + 0] = v$iv9;
        float v$iv10 = ((((-a00) * b10) + (a01 * b08)) - (a03 * b06)) * invDet;
        arg0[(2 * 4) + 1] = v$iv10;
        float v$iv11 = (((a30 * b04) - (a31 * b02)) + (a33 * b00)) * invDet;
        arg0[(2 * 4) + 2] = v$iv11;
        float v$iv12 = ((((-a20) * b04) + (a21 * b02)) - (a23 * b00)) * invDet;
        arg0[(2 * 4) + 3] = v$iv12;
        float v$iv13 = ((((-a10) * b09) + (a11 * b07)) - (a12 * b06)) * invDet;
        arg0[(3 * 4) + 0] = v$iv13;
        float v$iv14 = (((a00 * b09) - (a01 * b07)) + (a02 * b06)) * invDet;
        arg0[(3 * 4) + 1] = v$iv14;
        float v$iv15 = ((((-a30) * b03) + (a31 * b01)) - (a32 * b00)) * invDet;
        arg0[(3 * 4) + 2] = v$iv15;
        float v$iv16 = (((a20 * b03) - (a21 * b01)) + (a22 * b00)) * invDet;
        arg0[(3 * 4) + 3] = v$iv16;
    }

    /* renamed from: reset-impl */
    public static final void m3183resetimpl(float[] arg0) {
        int c = 0;
        while (c < 4) {
            int r = 0;
            while (r < 4) {
                float v$iv = c == r ? 1.0f : 0.0f;
                arg0[(r * 4) + c] = v$iv;
                r++;
            }
            c++;
        }
    }

    /* renamed from: setFrom-58bKbWc */
    public static final void m3190setFrom58bKbWc(float[] arg0, float[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        for (int i = 0; i < 16; i++) {
            arg0[i] = matrix[i];
        }
    }

    /* renamed from: rotateX-impl */
    public static final void m3184rotateXimpl(float[] arg0, float degrees) {
        float c = (float) Math.cos((degrees * 3.141592653589793d) / 180.0d);
        float s = (float) Math.sin((degrees * 3.141592653589793d) / 180.0d);
        float a01 = arg0[(0 * 4) + 1];
        float a02 = arg0[(0 * 4) + 2];
        float v01 = (a01 * c) - (a02 * s);
        float v02 = (a01 * s) + (a02 * c);
        float a11 = arg0[(1 * 4) + 1];
        float a12 = arg0[(1 * 4) + 2];
        float v11 = (a11 * c) - (a12 * s);
        float v12 = (a11 * s) + (a12 * c);
        float a21 = arg0[(2 * 4) + 1];
        float a22 = arg0[(2 * 4) + 2];
        float v21 = (a21 * c) - (a22 * s);
        float v22 = (a21 * s) + (a22 * c);
        float a31 = arg0[(3 * 4) + 1];
        float a32 = arg0[(3 * 4) + 2];
        float v31 = (a31 * c) - (a32 * s);
        float v32 = (a31 * s) + (a32 * c);
        arg0[(0 * 4) + 1] = v01;
        arg0[(0 * 4) + 2] = v02;
        arg0[(1 * 4) + 1] = v11;
        arg0[(1 * 4) + 2] = v12;
        arg0[(2 * 4) + 1] = v21;
        arg0[(2 * 4) + 2] = v22;
        arg0[(3 * 4) + 1] = v31;
        arg0[(3 * 4) + 2] = v32;
    }

    /* renamed from: rotateY-impl */
    public static final void m3185rotateYimpl(float[] arg0, float degrees) {
        float c = (float) Math.cos((degrees * 3.141592653589793d) / 180.0d);
        float s = (float) Math.sin((degrees * 3.141592653589793d) / 180.0d);
        float a00 = arg0[(0 * 4) + 0];
        float a02 = arg0[(0 * 4) + 2];
        float v00 = (a00 * c) + (a02 * s);
        float v02 = ((-a00) * s) + (a02 * c);
        float a10 = arg0[(1 * 4) + 0];
        float a12 = arg0[(1 * 4) + 2];
        float v10 = (a10 * c) + (a12 * s);
        float v12 = ((-a10) * s) + (a12 * c);
        float a20 = arg0[(2 * 4) + 0];
        float a22 = arg0[(2 * 4) + 2];
        float v20 = (a20 * c) + (a22 * s);
        float v22 = ((-a20) * s) + (a22 * c);
        float a30 = arg0[(3 * 4) + 0];
        float a32 = arg0[(3 * 4) + 2];
        float v30 = (a30 * c) + (a32 * s);
        float v32 = ((-a30) * s) + (a32 * c);
        arg0[(0 * 4) + 0] = v00;
        arg0[(0 * 4) + 2] = v02;
        arg0[(1 * 4) + 0] = v10;
        arg0[(1 * 4) + 2] = v12;
        arg0[(2 * 4) + 0] = v20;
        arg0[(2 * 4) + 2] = v22;
        arg0[(3 * 4) + 0] = v30;
        arg0[(3 * 4) + 2] = v32;
    }

    /* renamed from: rotateZ-impl */
    public static final void m3186rotateZimpl(float[] arg0, float degrees) {
        float c = (float) Math.cos((degrees * 3.141592653589793d) / 180.0d);
        float s = (float) Math.sin((degrees * 3.141592653589793d) / 180.0d);
        float a00 = arg0[(0 * 4) + 0];
        float a10 = arg0[(1 * 4) + 0];
        float v00 = (c * a00) + (s * a10);
        float v10 = ((-s) * a00) + (c * a10);
        float a01 = arg0[(0 * 4) + 1];
        float a11 = arg0[(1 * 4) + 1];
        float v01 = (c * a01) + (s * a11);
        float v11 = ((-s) * a01) + (c * a11);
        float a02 = arg0[(0 * 4) + 2];
        float a12 = arg0[(1 * 4) + 2];
        float v02 = (c * a02) + (s * a12);
        float v12 = ((-s) * a02) + (c * a12);
        float a03 = arg0[(0 * 4) + 3];
        float a13 = arg0[(1 * 4) + 3];
        float v03 = (c * a03) + (s * a13);
        float v13 = ((-s) * a03) + (c * a13);
        arg0[(0 * 4) + 0] = v00;
        arg0[(0 * 4) + 1] = v01;
        arg0[(0 * 4) + 2] = v02;
        arg0[(0 * 4) + 3] = v03;
        arg0[(1 * 4) + 0] = v10;
        arg0[(1 * 4) + 1] = v11;
        arg0[(1 * 4) + 2] = v12;
        arg0[(1 * 4) + 3] = v13;
    }

    /* renamed from: scale-impl$default */
    public static /* synthetic */ void m3188scaleimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        m3187scaleimpl(fArr, f, f2, f3);
    }

    /* renamed from: scale-impl */
    public static final void m3187scaleimpl(float[] arg0, float x, float y, float z) {
        float v$iv = arg0[(0 * 4) + 0] * x;
        arg0[(0 * 4) + 0] = v$iv;
        float v$iv2 = arg0[(0 * 4) + 1] * x;
        arg0[(0 * 4) + 1] = v$iv2;
        float v$iv3 = arg0[(0 * 4) + 2] * x;
        arg0[(0 * 4) + 2] = v$iv3;
        float v$iv4 = arg0[(0 * 4) + 3] * x;
        arg0[(0 * 4) + 3] = v$iv4;
        float v$iv5 = arg0[(1 * 4) + 0] * y;
        arg0[(1 * 4) + 0] = v$iv5;
        float v$iv6 = arg0[(1 * 4) + 1] * y;
        arg0[(1 * 4) + 1] = v$iv6;
        float v$iv7 = arg0[(1 * 4) + 2] * y;
        arg0[(1 * 4) + 2] = v$iv7;
        float v$iv8 = arg0[(1 * 4) + 3] * y;
        arg0[(1 * 4) + 3] = v$iv8;
        float v$iv9 = arg0[(2 * 4) + 0] * z;
        arg0[(2 * 4) + 0] = v$iv9;
        float v$iv10 = arg0[(2 * 4) + 1] * z;
        arg0[(2 * 4) + 1] = v$iv10;
        float v$iv11 = arg0[(2 * 4) + 2] * z;
        arg0[(2 * 4) + 2] = v$iv11;
        float v$iv12 = arg0[(2 * 4) + 3] * z;
        arg0[(2 * 4) + 3] = v$iv12;
    }

    /* renamed from: translate-impl$default */
    public static /* synthetic */ void m3194translateimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        m3193translateimpl(fArr, f, f2, f3);
    }

    /* renamed from: translate-impl */
    public static final void m3193translateimpl(float[] arg0, float x, float y, float z) {
        float t1 = (arg0[(0 * 4) + 0] * x) + (arg0[(1 * 4) + 0] * y) + (arg0[(2 * 4) + 0] * z) + arg0[(3 * 4) + 0];
        float t2 = (arg0[(0 * 4) + 1] * x) + (arg0[(1 * 4) + 1] * y) + (arg0[(2 * 4) + 1] * z) + arg0[(3 * 4) + 1];
        float t3 = (arg0[(0 * 4) + 2] * x) + (arg0[(1 * 4) + 2] * y) + (arg0[(2 * 4) + 2] * z) + arg0[(3 * 4) + 2];
        float t4 = (arg0[(0 * 4) + 3] * x) + (arg0[(1 * 4) + 3] * y) + (arg0[(2 * 4) + 3] * z) + arg0[(3 * 4) + 3];
        arg0[(3 * 4) + 0] = t1;
        arg0[(3 * 4) + 1] = t2;
        arg0[(3 * 4) + 2] = t3;
        arg0[(3 * 4) + 3] = t4;
    }
}
