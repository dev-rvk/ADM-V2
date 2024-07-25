package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorizedAnimationSpec.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\b\u0017\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB*\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ%\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0002J-\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/compose/animation/core/VectorizedInfiniteRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animation", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "initialOffsetNanos", "isInfinite", "", "()Z", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "repetitionPlayTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VectorizedInfiniteRepeatableSpec<V extends AnimationVector> implements VectorizedAnimationSpec<V> {
    public static final int $stable = 8;
    private final VectorizedDurationBasedAnimationSpec<V> animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final RepeatMode repeatMode;

    public /* synthetic */ VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(vectorizedDurationBasedAnimationSpec, repeatMode, j);
    }

    private VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec<V> animation, RepeatMode repeatMode, long initialStartOffset) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(repeatMode, "repeatMode");
        this.animation = animation;
        this.repeatMode = repeatMode;
        this.durationNanos = (this.animation.getDelayMillis() + this.animation.getDurationMillis()) * AnimationKt.MillisToNanos;
        this.initialOffsetNanos = AnimationKt.MillisToNanos * initialStartOffset;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ VectorizedInfiniteRepeatableSpec(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec r7, androidx.compose.animation.core.RepeatMode r8, long r9, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r12 = r11 & 2
            if (r12 == 0) goto L8
            androidx.compose.animation.core.RepeatMode r8 = androidx.compose.animation.core.RepeatMode.Restart
            r2 = r8
            goto L9
        L8:
            r2 = r8
        L9:
            r8 = r11 & 4
            if (r8 == 0) goto L16
            r8 = 0
            r9 = 0
            r10 = 2
            long r9 = androidx.compose.animation.core.StartOffset.m115constructorimpl$default(r9, r9, r10, r8)
            r3 = r9
            goto L17
        L16:
            r3 = r9
        L17:
            r5 = 0
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.VectorizedInfiniteRepeatableSpec.<init>(androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public /* synthetic */ VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vectorizedDurationBasedAnimationSpec, (i & 2) != 0 ? RepeatMode.Restart : repeatMode);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the constructor that accepts start offset.")
    public /* synthetic */ VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec animation, RepeatMode repeatMode) {
        this(animation, repeatMode, StartOffset.m115constructorimpl$default(0, 0, 2, null), (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(repeatMode, "repeatMode");
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return true;
    }

    /* renamed from: getDurationNanos$animation_core_release, reason: from getter */
    public final long getDurationNanos() {
        return this.durationNanos;
    }

    private final long repetitionPlayTimeNanos(long playTimeNanos) {
        if (this.initialOffsetNanos + playTimeNanos <= 0) {
            return 0L;
        }
        long postOffsetPlayTimeNanos = this.initialOffsetNanos + playTimeNanos;
        long repeatsCount = postOffsetPlayTimeNanos / this.durationNanos;
        if (this.repeatMode == RepeatMode.Restart || repeatsCount % 2 == 0) {
            return postOffsetPlayTimeNanos - (this.durationNanos * repeatsCount);
        }
        return ((1 + repeatsCount) * this.durationNanos) - postOffsetPlayTimeNanos;
    }

    private final V repetitionStartVelocity(long playTimeNanos, V start, V startVelocity, V end) {
        if (this.initialOffsetNanos + playTimeNanos > this.durationNanos) {
            return getVelocityFromNanos(this.durationNanos - this.initialOffsetNanos, start, startVelocity, end);
        }
        return startVelocity;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        return this.animation.getValueFromNanos(repetitionPlayTimeNanos(playTimeNanos), initialValue, targetValue, repetitionStartVelocity(playTimeNanos, initialValue, initialVelocity, targetValue));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        return this.animation.getVelocityFromNanos(repetitionPlayTimeNanos(playTimeNanos), initialValue, targetValue, repetitionStartVelocity(playTimeNanos, initialValue, initialVelocity, targetValue));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        return Long.MAX_VALUE;
    }
}
