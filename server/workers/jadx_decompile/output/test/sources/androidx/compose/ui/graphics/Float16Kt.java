package androidx.compose.ui.graphics;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Float16.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"max", "Landroidx/compose/ui/graphics/Float16;", "x", "y", "max-AoSsdG0", "(SS)S", "min", "min-AoSsdG0", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Float16Kt {
    /* renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m3092minAoSsdG0(short x, short y) {
        if (Float16.m3064isNaNimpl(x) || Float16.m3064isNaNimpl(y)) {
            return Float16.INSTANCE.m3086getNaNslo4al4();
        }
        return Float16.m3051compareTo41bOqos(x, y) <= 0 ? x : y;
    }

    /* renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m3091maxAoSsdG0(short x, short y) {
        if (Float16.m3064isNaNimpl(x) || Float16.m3064isNaNimpl(y)) {
            return Float16.INSTANCE.m3086getNaNslo4al4();
        }
        return Float16.m3051compareTo41bOqos(x, y) >= 0 ? x : y;
    }
}
