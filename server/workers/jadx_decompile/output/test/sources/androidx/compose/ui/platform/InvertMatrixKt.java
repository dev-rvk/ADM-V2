package androidx.compose.ui.platform;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvertMatrix.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"invertTo", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class InvertMatrixKt {
    /* renamed from: invertTo-JiSxe2E, reason: not valid java name */
    public static final boolean m4517invertToJiSxe2E(float[] invertTo, float[] other) {
        Intrinsics.checkNotNullParameter(invertTo, "$this$invertTo");
        Intrinsics.checkNotNullParameter(other, "other");
        float a00 = invertTo[(0 * 4) + 0];
        float a01 = invertTo[(0 * 4) + 1];
        float a02 = invertTo[(0 * 4) + 2];
        float a03 = invertTo[(0 * 4) + 3];
        float a10 = invertTo[(1 * 4) + 0];
        float a11 = invertTo[(1 * 4) + 1];
        float a12 = invertTo[(1 * 4) + 2];
        float a13 = invertTo[(1 * 4) + 3];
        float a20 = invertTo[(2 * 4) + 0];
        float a21 = invertTo[(2 * 4) + 1];
        float a22 = invertTo[(2 * 4) + 2];
        float a23 = invertTo[(2 * 4) + 3];
        float a30 = invertTo[(3 * 4) + 0];
        float a31 = invertTo[(3 * 4) + 1];
        float a32 = invertTo[(3 * 4) + 2];
        float a33 = invertTo[(3 * 4) + 3];
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
            return false;
        }
        float invDet = 1.0f / det;
        float v$iv = (((a11 * b11) - (a12 * b10)) + (a13 * b09)) * invDet;
        other[(0 * 4) + 0] = v$iv;
        float v$iv2 = ((((-a01) * b11) + (a02 * b10)) - (a03 * b09)) * invDet;
        other[(0 * 4) + 1] = v$iv2;
        float v$iv3 = (((a31 * b05) - (a32 * b04)) + (a33 * b03)) * invDet;
        other[(0 * 4) + 2] = v$iv3;
        float v$iv4 = ((((-a21) * b05) + (a22 * b04)) - (a23 * b03)) * invDet;
        other[(0 * 4) + 3] = v$iv4;
        float v$iv5 = ((((-a10) * b11) + (a12 * b08)) - (a13 * b07)) * invDet;
        other[(1 * 4) + 0] = v$iv5;
        float v$iv6 = (((a00 * b11) - (a02 * b08)) + (a03 * b07)) * invDet;
        other[(1 * 4) + 1] = v$iv6;
        float v$iv7 = ((((-a30) * b05) + (a32 * b02)) - (a33 * b01)) * invDet;
        other[(1 * 4) + 2] = v$iv7;
        float v$iv8 = (((a20 * b05) - (a22 * b02)) + (a23 * b01)) * invDet;
        other[(1 * 4) + 3] = v$iv8;
        float v$iv9 = (((a10 * b10) - (a11 * b08)) + (a13 * b06)) * invDet;
        other[(2 * 4) + 0] = v$iv9;
        float v$iv10 = ((((-a00) * b10) + (a01 * b08)) - (a03 * b06)) * invDet;
        other[(2 * 4) + 1] = v$iv10;
        float v$iv11 = (((a30 * b04) - (a31 * b02)) + (a33 * b00)) * invDet;
        other[(2 * 4) + 2] = v$iv11;
        float v$iv12 = ((((-a20) * b04) + (a21 * b02)) - (a23 * b00)) * invDet;
        other[(2 * 4) + 3] = v$iv12;
        float v$iv13 = ((((-a10) * b09) + (a11 * b07)) - (a12 * b06)) * invDet;
        other[(3 * 4) + 0] = v$iv13;
        float v$iv14 = (((a00 * b09) - (a01 * b07)) + (a02 * b06)) * invDet;
        other[(3 * 4) + 1] = v$iv14;
        float v$iv15 = ((((-a30) * b03) + (a31 * b01)) - (a32 * b00)) * invDet;
        other[(3 * 4) + 2] = v$iv15;
        float v$iv16 = (((a20 * b03) - (a21 * b01)) + (a22 * b00)) * invDet;
        other[(3 * 4) + 3] = v$iv16;
        return true;
    }
}
