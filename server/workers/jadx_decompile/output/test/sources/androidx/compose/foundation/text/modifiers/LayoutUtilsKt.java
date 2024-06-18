package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: LayoutUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m843finalConstraintstfFHcEY(long constraints, boolean softWrap, int overflow, float maxIntrinsicWidth) {
        return ConstraintsKt.Constraints$default(0, m845finalMaxWidthtfFHcEY(constraints, softWrap, overflow, maxIntrinsicWidth), 0, Constraints.m5173getMaxHeightimpl(constraints), 5, null);
    }

    /* renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m845finalMaxWidthtfFHcEY(long constraints, boolean softWrap, int overflow, float maxIntrinsicWidth) {
        int maxWidth;
        boolean widthMatters = softWrap || TextOverflow.m5130equalsimpl0(overflow, TextOverflow.INSTANCE.m5138getEllipsisgIe3tQ8());
        if (widthMatters && Constraints.m5170getHasBoundedWidthimpl(constraints)) {
            maxWidth = Constraints.m5174getMaxWidthimpl(constraints);
        } else {
            maxWidth = Integer.MAX_VALUE;
        }
        if (Constraints.m5176getMinWidthimpl(constraints) == maxWidth) {
            return maxWidth;
        }
        return RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(maxIntrinsicWidth), Constraints.m5176getMinWidthimpl(constraints), maxWidth);
    }

    /* renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m844finalMaxLinesxdlQI24(boolean softWrap, int overflow, int maxLinesIn) {
        boolean overwriteMaxLines = !softWrap && TextOverflow.m5130equalsimpl0(overflow, TextOverflow.INSTANCE.m5138getEllipsisgIe3tQ8());
        if (overwriteMaxLines) {
            return 1;
        }
        return RangesKt.coerceAtLeast(maxLinesIn, 1);
    }
}
