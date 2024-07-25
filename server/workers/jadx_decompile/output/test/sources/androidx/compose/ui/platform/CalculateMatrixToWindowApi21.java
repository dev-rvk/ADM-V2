package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ!\u0010\u0011\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0016\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi21;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "()V", "tmpLocation", "", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "calculateMatrixToWindow", "", "view", "Landroid/view/View;", "matrix", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "transformMatrixToWindow", "transformMatrixToWindow-EL8BTi8", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation = new int[2];
    private final float[] tmpMatrix = Matrix.m3174constructorimpl$default(null, 1, null);

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo4493calculateMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Matrix.m3183resetimpl(matrix);
        m4496transformMatrixToWindowEL8BTi8(view, matrix);
    }

    /* renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m4496transformMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m4496transformMatrixToWindowEL8BTi8((View) parent, matrix);
            m4495preTranslate3XD1CNM(matrix, -view.getScrollX(), -view.getScrollY());
            m4495preTranslate3XD1CNM(matrix, view.getLeft(), view.getTop());
        } else {
            int[] pos = this.tmpLocation;
            view.getLocationInWindow(pos);
            m4495preTranslate3XD1CNM(matrix, -view.getScrollX(), -view.getScrollY());
            m4495preTranslate3XD1CNM(matrix, pos[0], pos[1]);
        }
        android.graphics.Matrix viewMatrix = view.getMatrix();
        if (!viewMatrix.isIdentity()) {
            Intrinsics.checkNotNullExpressionValue(viewMatrix, "viewMatrix");
            m4494preConcattUYjHk(matrix, viewMatrix);
        }
    }

    /* renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m4494preConcattUYjHk(float[] $this$preConcat_u2dtU_u2dYjHk, android.graphics.Matrix other) {
        AndroidMatrixConversions_androidKt.m2822setFromtUYjHk(this.tmpMatrix, other);
        AndroidComposeView_androidKt.m4492preTransformJiSxe2E($this$preConcat_u2dtU_u2dYjHk, this.tmpMatrix);
    }

    /* renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m4495preTranslate3XD1CNM(float[] $this$preTranslate_u2d3XD1CNM, float x, float y) {
        Matrix.m3183resetimpl(this.tmpMatrix);
        Matrix.m3194translateimpl$default(this.tmpMatrix, x, y, 0.0f, 4, null);
        AndroidComposeView_androidKt.m4492preTransformJiSxe2E($this$preTranslate_u2d3XD1CNM, this.tmpMatrix);
    }
}
