package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EdgeEffectCompat.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0004R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/EdgeEffectCompat;", "", "()V", "distanceCompat", "", "Landroid/widget/EdgeEffect;", "getDistanceCompat", "(Landroid/widget/EdgeEffect;)F", "create", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onAbsorbCompat", "", "velocity", "", "onPullDistanceCompat", "deltaDistance", "displacement", "onReleaseWithOppositeDelta", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    public static final EdgeEffectCompat INSTANCE = new EdgeEffectCompat();

    private EdgeEffectCompat() {
    }

    public final EdgeEffect create(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.create(context, attrs);
        }
        return new GlowEdgeEffectCompat(context);
    }

    public final float onPullDistanceCompat(EdgeEffect $this$onPullDistanceCompat, float deltaDistance, float displacement) {
        Intrinsics.checkNotNullParameter($this$onPullDistanceCompat, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.onPullDistance($this$onPullDistanceCompat, deltaDistance, displacement);
        }
        $this$onPullDistanceCompat.onPull(deltaDistance, displacement);
        return deltaDistance;
    }

    public final void onAbsorbCompat(EdgeEffect $this$onAbsorbCompat, int velocity) {
        Intrinsics.checkNotNullParameter($this$onAbsorbCompat, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            $this$onAbsorbCompat.onAbsorb(velocity);
        } else if ($this$onAbsorbCompat.isFinished()) {
            $this$onAbsorbCompat.onAbsorb(velocity);
        }
    }

    public final void onReleaseWithOppositeDelta(EdgeEffect $this$onReleaseWithOppositeDelta, float delta) {
        Intrinsics.checkNotNullParameter($this$onReleaseWithOppositeDelta, "<this>");
        if ($this$onReleaseWithOppositeDelta instanceof GlowEdgeEffectCompat) {
            ((GlowEdgeEffectCompat) $this$onReleaseWithOppositeDelta).releaseWithOppositeDelta(delta);
        } else {
            $this$onReleaseWithOppositeDelta.onRelease();
        }
    }

    public final float getDistanceCompat(EdgeEffect $this$distanceCompat) {
        Intrinsics.checkNotNullParameter($this$distanceCompat, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.getDistance($this$distanceCompat);
        }
        return 0.0f;
    }
}
