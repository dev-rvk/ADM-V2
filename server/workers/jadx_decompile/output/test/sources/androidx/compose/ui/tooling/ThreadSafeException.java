package androidx.compose.ui.tooling;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreviewUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/tooling/ThreadSafeException;", "", "()V", "exception", "", "lock", "set", "", "throwable", "throwIfPresent", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ThreadSafeException {
    private Throwable exception;
    private final Object lock = new Object();

    public final void set(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        synchronized (this.lock) {
            this.exception = throwable;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void throwIfPresent() {
        synchronized (this.lock) {
            Throwable it = this.exception;
            if (it != null) {
                this.exception = null;
                throw it;
            }
        }
    }
}
