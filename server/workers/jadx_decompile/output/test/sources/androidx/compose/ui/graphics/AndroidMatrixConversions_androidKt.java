package androidx.compose.ui.graphics;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidMatrixConversions.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\t"}, d2 = {"setFrom", "", "Landroid/graphics/Matrix;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidMatrixConversions_androidKt {
    /* renamed from: setFrom-tU-YjHk, reason: not valid java name */
    public static final void m2822setFromtUYjHk(float[] setFrom, android.graphics.Matrix matrix) {
        Intrinsics.checkNotNullParameter(setFrom, "$this$setFrom");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        matrix.getValues(setFrom);
        float scaleX = setFrom[0];
        float skewX = setFrom[1];
        float translateX = setFrom[2];
        float skewY = setFrom[3];
        float scaleY = setFrom[4];
        float translateY = setFrom[5];
        float persp0 = setFrom[6];
        float persp1 = setFrom[7];
        float persp2 = setFrom[8];
        setFrom[0] = scaleX;
        setFrom[1] = skewY;
        setFrom[2] = 0.0f;
        setFrom[3] = persp0;
        setFrom[4] = skewX;
        setFrom[5] = scaleY;
        setFrom[6] = 0.0f;
        setFrom[7] = persp1;
        setFrom[8] = 0.0f;
        setFrom[9] = 0.0f;
        setFrom[10] = 1.0f;
        setFrom[11] = 0.0f;
        setFrom[12] = translateX;
        setFrom[13] = translateY;
        setFrom[14] = 0.0f;
        setFrom[15] = persp2;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e6  */
    /* renamed from: setFrom-EL8BTi8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2821setFromEL8BTi8(android.graphics.Matrix r24, float[] r25) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt.m2821setFromEL8BTi8(android.graphics.Matrix, float[]):void");
    }
}
