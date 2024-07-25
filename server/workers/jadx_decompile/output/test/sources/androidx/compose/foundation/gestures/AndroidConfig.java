package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidScrollable.android.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/AndroidConfig;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "()V", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/Density;", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidConfig implements ScrollConfig {
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long mo247calculateMouseWheelScroll8xgXZGE(Density calculateMouseWheelScroll, PointerEvent event, long bounds) {
        Intrinsics.checkNotNullParameter(calculateMouseWheelScroll, "$this$calculateMouseWheelScroll");
        Intrinsics.checkNotNullParameter(event, "event");
        List $this$fastFold$iv = event.getChanges();
        Offset m2699boximpl = Offset.m2699boximpl(Offset.INSTANCE.m2726getZeroF1C5BW0());
        int index$iv$iv = 0;
        int size = $this$fastFold$iv.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastFold$iv.get(index$iv$iv);
            PointerInputChange c = (PointerInputChange) item$iv$iv;
            long acc = m2699boximpl.getPackedValue();
            m2699boximpl = Offset.m2699boximpl(Offset.m2715plusMKHz9U(acc, c.getScrollDelta()));
            index$iv$iv++;
            $this$fastFold$iv = $this$fastFold$iv;
        }
        return Offset.m2717timestuRUvjQ(m2699boximpl.getPackedValue(), -calculateMouseWheelScroll.mo329toPx0680j_4(Dp.m5218constructorimpl(64)));
    }
}
