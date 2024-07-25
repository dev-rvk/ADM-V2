package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ModifierUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\t"}, d2 = {"maxWidthForTextLayout", "", "Landroidx/compose/ui/unit/Constraints;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxWidthForTextLayout-R2G3SPE", "(JZI)I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ModifierUtilsKt {
    /* renamed from: maxWidthForTextLayout-R2G3SPE, reason: not valid java name */
    public static final int m847maxWidthForTextLayoutR2G3SPE(long $this$maxWidthForTextLayout_u2dR2G3SPE, boolean softWrap, int overflow) {
        boolean widthMatters = softWrap || TextOverflow.m5130equalsimpl0(overflow, TextOverflow.INSTANCE.m5138getEllipsisgIe3tQ8());
        if (widthMatters && Constraints.m5170getHasBoundedWidthimpl($this$maxWidthForTextLayout_u2dR2G3SPE)) {
            int maxWidth = Constraints.m5174getMaxWidthimpl($this$maxWidthForTextLayout_u2dR2G3SPE);
            return maxWidth;
        }
        return Integer.MAX_VALUE;
    }
}
