package androidx.compose.material.pullrefresh;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: PullRefreshState.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\tH\u0002J\b\u00108\u001a\u00020\tH\u0002J\u0015\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0014H\u0000¢\u0006\u0002\b@J\u0015\u0010A\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\bDR+\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R+\u0010 \u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001b\u0010$\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b%\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010(\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u000fR\u0011\u00100\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b1\u0010\u000fR\u0014\u00102\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0017R\u0014\u0010\n\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u000f¨\u0006E"}, d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshState;", "", "animationScope", "Lkotlinx/coroutines/CoroutineScope;", "onRefreshState", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "", "refreshingOffset", "", "threshold", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/State;FF)V", "<set-?>", "_position", "get_position", "()F", "set_position", "(F)V", "_position$delegate", "Landroidx/compose/runtime/MutableFloatState;", "", "_refreshing", "get_refreshing", "()Z", "set_refreshing", "(Z)V", "_refreshing$delegate", "Landroidx/compose/runtime/MutableState;", "_refreshingOffset", "get_refreshingOffset", "set_refreshingOffset", "_refreshingOffset$delegate", "_threshold", "get_threshold", "set_threshold", "_threshold$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "adjustedDistancePulled$delegate", "Landroidx/compose/runtime/State;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "position", "getPosition$material_release", NotificationCompat.CATEGORY_PROGRESS, "getProgress", "refreshing", "getRefreshing$material_release", "getThreshold$material_release", "animateIndicatorTo", "Lkotlinx/coroutines/Job;", "offset", "calculateIndicatorPosition", "onPull", "pullDelta", "onPull$material_release", "onRelease", "velocity", "onRelease$material_release", "setRefreshing", "setRefreshing$material_release", "setRefreshingOffset", "setRefreshingOffset$material_release", "setThreshold", "setThreshold$material_release", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PullRefreshState {
    public static final int $stable = 8;

    /* renamed from: _position$delegate, reason: from kotlin metadata */
    private final MutableFloatState _position;

    /* renamed from: _refreshing$delegate, reason: from kotlin metadata */
    private final MutableState _refreshing;

    /* renamed from: _refreshingOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState _refreshingOffset;

    /* renamed from: _threshold$delegate, reason: from kotlin metadata */
    private final MutableFloatState _threshold;

    /* renamed from: adjustedDistancePulled$delegate, reason: from kotlin metadata */
    private final State adjustedDistancePulled;
    private final CoroutineScope animationScope;

    /* renamed from: distancePulled$delegate, reason: from kotlin metadata */
    private final MutableFloatState distancePulled;
    private final MutatorMutex mutatorMutex;
    private final State<Function0<Unit>> onRefreshState;

    /* JADX WARN: Multi-variable type inference failed */
    public PullRefreshState(CoroutineScope animationScope, State<? extends Function0<Unit>> onRefreshState, float refreshingOffset, float threshold) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(animationScope, "animationScope");
        Intrinsics.checkNotNullParameter(onRefreshState, "onRefreshState");
        this.animationScope = animationScope;
        this.onRefreshState = onRefreshState;
        this.adjustedDistancePulled = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshState$adjustedDistancePulled$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float distancePulled;
                distancePulled = PullRefreshState.this.getDistancePulled();
                return Float.valueOf(distancePulled * 0.5f);
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this._refreshing = mutableStateOf$default;
        this._position = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.distancePulled = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this._threshold = PrimitiveSnapshotStateKt.mutableFloatStateOf(threshold);
        this._refreshingOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(refreshingOffset);
        this.mutatorMutex = new MutatorMutex();
    }

    public final float getProgress() {
        return getAdjustedDistancePulled() / getThreshold$material_release();
    }

    public final boolean getRefreshing$material_release() {
        return get_refreshing();
    }

    public final float getPosition$material_release() {
        return get_position();
    }

    public final float getThreshold$material_release() {
        return get_threshold();
    }

    private final float getAdjustedDistancePulled() {
        State $this$getValue$iv = this.adjustedDistancePulled;
        return ((Number) $this$getValue$iv.getValue()).floatValue();
    }

    private final boolean get_refreshing() {
        State $this$getValue$iv = this._refreshing;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private final void set_refreshing(boolean z) {
        MutableState $this$setValue$iv = this._refreshing;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float get_position() {
        FloatState $this$getValue$iv = this._position;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_position(float f) {
        MutableFloatState $this$setValue$iv = this._position;
        $this$setValue$iv.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getDistancePulled() {
        FloatState $this$getValue$iv = this.distancePulled;
        return $this$getValue$iv.getFloatValue();
    }

    private final void setDistancePulled(float f) {
        MutableFloatState $this$setValue$iv = this.distancePulled;
        $this$setValue$iv.setFloatValue(f);
    }

    private final float get_threshold() {
        FloatState $this$getValue$iv = this._threshold;
        return $this$getValue$iv.getFloatValue();
    }

    private final void set_threshold(float f) {
        MutableFloatState $this$setValue$iv = this._threshold;
        $this$setValue$iv.setFloatValue(f);
    }

    private final float get_refreshingOffset() {
        FloatState $this$getValue$iv = this._refreshingOffset;
        return $this$getValue$iv.getFloatValue();
    }

    private final void set_refreshingOffset(float f) {
        MutableFloatState $this$setValue$iv = this._refreshingOffset;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float onPull$material_release(float pullDelta) {
        if (get_refreshing()) {
            return 0.0f;
        }
        float newOffset = RangesKt.coerceAtLeast(getDistancePulled() + pullDelta, 0.0f);
        float dragConsumed = newOffset - getDistancePulled();
        setDistancePulled(newOffset);
        set_position(calculateIndicatorPosition());
        return dragConsumed;
    }

    public final float onRelease$material_release(float velocity) {
        float consumed;
        if (getRefreshing$material_release()) {
            return 0.0f;
        }
        if (getAdjustedDistancePulled() > getThreshold$material_release()) {
            this.onRefreshState.getValue().invoke();
        }
        animateIndicatorTo(0.0f);
        if (getDistancePulled() == 0.0f) {
            consumed = 0.0f;
        } else {
            consumed = velocity < 0.0f ? 0.0f : velocity;
        }
        setDistancePulled(0.0f);
        return consumed;
    }

    public final void setRefreshing$material_release(boolean refreshing) {
        if (get_refreshing() != refreshing) {
            set_refreshing(refreshing);
            setDistancePulled(0.0f);
            animateIndicatorTo(refreshing ? get_refreshingOffset() : 0.0f);
        }
    }

    public final void setThreshold$material_release(float threshold) {
        set_threshold(threshold);
    }

    public final void setRefreshingOffset$material_release(float refreshingOffset) {
        if (!(get_refreshingOffset() == refreshingOffset)) {
            set_refreshingOffset(refreshingOffset);
            if (getRefreshing$material_release()) {
                animateIndicatorTo(refreshingOffset);
            }
        }
    }

    private final Job animateIndicatorTo(float offset) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.animationScope, null, null, new PullRefreshState$animateIndicatorTo$1(this, offset, null), 3, null);
        return launch$default;
    }

    private final float calculateIndicatorPosition() {
        if (getAdjustedDistancePulled() > getThreshold$material_release()) {
            float overshootPercent = Math.abs(getProgress()) - 1.0f;
            float linearTension = RangesKt.coerceIn(overshootPercent, 0.0f, 2.0f);
            float tensionPercent = linearTension - (((float) Math.pow(linearTension, 2)) / 4);
            float extraOffset = getThreshold$material_release() * tensionPercent;
            float overshootPercent2 = getThreshold$material_release() + extraOffset;
            return overshootPercent2;
        }
        float overshootPercent3 = getAdjustedDistancePulled();
        return overshootPercent3;
    }
}
