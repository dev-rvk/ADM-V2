package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedVisibilityComposeAnimation.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¨\u0006\u0004"}, d2 = {"parseAnimatedVisibility", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimatedVisibilityComposeAnimationKt {
    public static final AnimatedVisibilityComposeAnimation parseAnimatedVisibility(Transition<Boolean> transition) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        String label = transition.getLabel();
        if (label == null) {
            label = "AnimatedVisibility";
        }
        return new AnimatedVisibilityComposeAnimation(transition, label);
    }
}
