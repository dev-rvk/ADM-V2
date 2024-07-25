package androidx.compose.ui.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* compiled from: MathHelpers.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"lerp", "", "start", "stop", "fraction", "", "", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MathHelpersKt {
    public static final float lerp(float start, float stop, float fraction) {
        return ((1 - fraction) * start) + (fraction * stop);
    }

    public static final int lerp(int start, int stop, float fraction) {
        return MathKt.roundToInt((stop - start) * fraction) + start;
    }

    public static final long lerp(long start, long stop, float fraction) {
        return MathKt.roundToLong((stop - start) * fraction) + start;
    }
}
