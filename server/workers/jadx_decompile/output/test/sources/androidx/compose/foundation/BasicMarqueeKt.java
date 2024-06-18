package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicMarquee.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aK\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0%2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0001H\u0002\u001aU\u0010&\u001a\u00020'*\u00020'2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+\"\u001c\u0010\u0000\u001a\u00020\u00018GX\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018GX\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u001c\u0010\t\u001a\u00020\n8GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r\"!\u0010\u000e\u001a\u00020\u000f8GX\u0087\u0004ø\u0001\u0000¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"DefaultMarqueeDelayMillis", "", "getDefaultMarqueeDelayMillis$annotations", "()V", "getDefaultMarqueeDelayMillis", "()I", "DefaultMarqueeIterations", "getDefaultMarqueeIterations$annotations", "getDefaultMarqueeIterations", "DefaultMarqueeSpacing", "Landroidx/compose/foundation/MarqueeSpacing;", "getDefaultMarqueeSpacing$annotations", "getDefaultMarqueeSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "DefaultMarqueeVelocity", "Landroidx/compose/ui/unit/Dp;", "getDefaultMarqueeVelocity$annotations", "getDefaultMarqueeVelocity", "()F", "F", "MarqueeSpacing", "spacing", "MarqueeSpacing-0680j_4", "(F)Landroidx/compose/foundation/MarqueeSpacing;", "createMarqueeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "iterations", "targetValue", "initialDelayMillis", "delayMillis", "velocity", "density", "Landroidx/compose/ui/unit/Density;", "createMarqueeAnimationSpec-Z4HSEVQ", "(IFIIFLandroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/AnimationSpec;", "velocityBasedTween", "Landroidx/compose/animation/core/TweenSpec;", "basicMarquee", "Landroidx/compose/ui/Modifier;", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "basicMarquee-1Mj1MLw", "(Landroidx/compose/ui/Modifier;IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BasicMarqueeKt {
    private static final int DefaultMarqueeIterations = 3;
    private static final int DefaultMarqueeDelayMillis = 1200;
    private static final MarqueeSpacing DefaultMarqueeSpacing = MarqueeSpacing.INSTANCE.fractionOfContainer(0.33333334f);
    private static final float DefaultMarqueeVelocity = Dp.m5218constructorimpl(30);

    public static /* synthetic */ void getDefaultMarqueeDelayMillis$annotations() {
    }

    public static /* synthetic */ void getDefaultMarqueeIterations$annotations() {
    }

    public static /* synthetic */ void getDefaultMarqueeSpacing$annotations() {
    }

    public static /* synthetic */ void getDefaultMarqueeVelocity$annotations() {
    }

    public static final int getDefaultMarqueeIterations() {
        return DefaultMarqueeIterations;
    }

    public static final int getDefaultMarqueeDelayMillis() {
        return DefaultMarqueeDelayMillis;
    }

    public static final MarqueeSpacing getDefaultMarqueeSpacing() {
        return DefaultMarqueeSpacing;
    }

    public static final float getDefaultMarqueeVelocity() {
        return DefaultMarqueeVelocity;
    }

    /* renamed from: basicMarquee-1Mj1MLw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m169basicMarquee1Mj1MLw$default(Modifier modifier, int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f, int i5, Object obj) {
        int i6;
        if ((i5 & 1) != 0) {
            i = DefaultMarqueeIterations;
        }
        int m234getImmediatelyZbEOnfQ = (i5 & 2) != 0 ? MarqueeAnimationMode.INSTANCE.m234getImmediatelyZbEOnfQ() : i2;
        int i7 = (i5 & 4) != 0 ? DefaultMarqueeDelayMillis : i3;
        if ((i5 & 8) != 0) {
            i6 = MarqueeAnimationMode.m228equalsimpl0(m234getImmediatelyZbEOnfQ, MarqueeAnimationMode.INSTANCE.m234getImmediatelyZbEOnfQ()) ? i7 : 0;
        } else {
            i6 = i4;
        }
        return m168basicMarquee1Mj1MLw(modifier, i, m234getImmediatelyZbEOnfQ, i7, i6, (i5 & 16) != 0 ? DefaultMarqueeSpacing : marqueeSpacing, (i5 & 32) != 0 ? DefaultMarqueeVelocity : f);
    }

    /* renamed from: basicMarquee-1Mj1MLw, reason: not valid java name */
    public static final Modifier m168basicMarquee1Mj1MLw(Modifier basicMarquee, int iterations, int animationMode, int delayMillis, int initialDelayMillis, MarqueeSpacing spacing, float velocity) {
        Intrinsics.checkNotNullParameter(basicMarquee, "$this$basicMarquee");
        Intrinsics.checkNotNullParameter(spacing, "spacing");
        return basicMarquee.then(new MarqueeModifierElement(iterations, animationMode, delayMillis, initialDelayMillis, spacing, velocity, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createMarqueeAnimationSpec-Z4HSEVQ, reason: not valid java name */
    public static final AnimationSpec<Float> m170createMarqueeAnimationSpecZ4HSEVQ(int iterations, float targetValue, int initialDelayMillis, int delayMillis, float velocity, Density density) {
        float pxPerSec = density.mo329toPx0680j_4(velocity);
        TweenSpec singleSpec = velocityBasedTween(Math.abs(pxPerSec), targetValue, delayMillis);
        long startOffset = StartOffset.m115constructorimpl$default((-delayMillis) + initialDelayMillis, 0, 2, null);
        if (iterations == Integer.MAX_VALUE) {
            return AnimationSpecKt.m95infiniteRepeatable9IiC70o$default(singleSpec, null, startOffset, 2, null);
        }
        return AnimationSpecKt.m97repeatable91I0pcU$default(iterations, singleSpec, null, startOffset, 4, null);
    }

    private static final TweenSpec<Float> velocityBasedTween(float velocity, float targetValue, int delayMillis) {
        float pxPerMilli = velocity / 1000.0f;
        return AnimationSpecKt.tween((int) Math.ceil(targetValue / pxPerMilli), delayMillis, EasingKt.getLinearEasing());
    }

    /* renamed from: MarqueeSpacing-0680j_4, reason: not valid java name */
    public static final MarqueeSpacing m166MarqueeSpacing0680j_4(final float spacing) {
        return new MarqueeSpacing() { // from class: androidx.compose.foundation.BasicMarqueeKt$MarqueeSpacing$1
            @Override // androidx.compose.foundation.MarqueeSpacing
            public final int calculateSpacing(Density MarqueeSpacing, int i, int i2) {
                Intrinsics.checkNotNullParameter(MarqueeSpacing, "$this$MarqueeSpacing");
                return MarqueeSpacing.mo323roundToPx0680j_4(spacing);
            }
        };
    }
}
