package androidx.compose.ui.tooling.animation;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TransitionComposeAnimation.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000¨\u0006\u0003"}, d2 = {"parse", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TransitionComposeAnimationKt {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if (r2 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.tooling.animation.TransitionComposeAnimation<?> parse(androidx.compose.animation.core.Transition<?> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.Object r0 = r5.getCurrentState()
            if (r0 == 0) goto L3d
            r1 = 0
            java.lang.Class r2 = r0.getClass()
            java.lang.Object[] r2 = r2.getEnumConstants()
            if (r2 == 0) goto L21
            java.lang.String r3 = "enumConstants"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.util.Set r2 = kotlin.collections.ArraysKt.toSet(r2)
            if (r2 != 0) goto L25
        L21:
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r0)
        L25:
            androidx.compose.ui.tooling.animation.TransitionComposeAnimation r3 = new androidx.compose.ui.tooling.animation.TransitionComposeAnimation
            java.lang.String r4 = r5.getLabel()
            if (r4 != 0) goto L39
            java.lang.Class r4 = r0.getClass()
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            java.lang.String r4 = r4.getSimpleName()
        L39:
            r3.<init>(r5, r2, r4)
            goto L3e
        L3d:
            r3 = 0
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.TransitionComposeAnimationKt.parse(androidx.compose.animation.core.Transition):androidx.compose.ui.tooling.animation.TransitionComposeAnimation");
    }
}
