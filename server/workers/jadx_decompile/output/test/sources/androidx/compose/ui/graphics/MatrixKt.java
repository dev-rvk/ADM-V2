package androidx.compose.ui.graphics;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Matrix.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u000b*\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "isIdentity", "", "isIdentity-58bKbWc", "([F)Z", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MatrixKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dot-p89u6pk, reason: not valid java name */
    public static final float m3197dotp89u6pk(float[] m1, int row, float[] m2, int column) {
        return (m1[(row * 4) + 0] * m2[(0 * 4) + column]) + (m1[(row * 4) + 1] * m2[(1 * 4) + column]) + (m1[(row * 4) + 2] * m2[(2 * 4) + column]) + (m1[(row * 4) + 3] * m2[(3 * 4) + column]);
    }

    /* renamed from: isIdentity-58bKbWc, reason: not valid java name */
    public static final boolean m3198isIdentity58bKbWc(float[] isIdentity) {
        Intrinsics.checkNotNullParameter(isIdentity, "$this$isIdentity");
        int row = 0;
        while (row < 4) {
            int column = 0;
            while (column < 4) {
                float expected = row == column ? 1.0f : 0.0f;
                if (!(isIdentity[(row * 4) + column] == expected)) {
                    return false;
                }
                column++;
            }
            row++;
        }
        return true;
    }
}
