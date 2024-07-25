package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContentComposeAnimation.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0016B-\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation;", "T", "Landroidx/compose/animation/tooling/ComposeAnimation;", "Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;", "animationObject", "Landroidx/compose/animation/core/Transition;", "states", "", "", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/util/Set;Ljava/lang/String;)V", "getAnimationObject", "()Landroidx/compose/animation/core/Transition;", "getLabel", "()Ljava/lang/String;", "getStates", "()Ljava/util/Set;", "type", "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimatedContentComposeAnimation<T> implements ComposeAnimation, TransitionBasedAnimation<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean apiAvailable;
    private final Transition<T> animationObject;
    private final String label;
    private final Set<Object> states;
    private final ComposeAnimationType type;

    public /* synthetic */ AnimatedContentComposeAnimation(Transition transition, Set set, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(transition, set, str);
    }

    private AnimatedContentComposeAnimation(Transition<T> transition, Set<? extends Object> set, String label) {
        this.animationObject = transition;
        this.states = set;
        this.label = label;
        this.type = ComposeAnimationType.ANIMATED_CONTENT;
    }

    @Override // androidx.compose.ui.tooling.animation.TransitionBasedAnimation
    /* renamed from: getAnimationObject, reason: merged with bridge method [inline-methods] */
    public Transition<T> m5145getAnimationObject() {
        return this.animationObject;
    }

    public Set<Object> getStates() {
        return this.states;
    }

    public String getLabel() {
        return this.label;
    }

    public ComposeAnimationType getType() {
        return this.type;
    }

    /* compiled from: AnimatedContentComposeAnimation.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u0006\u0012\u0002\b\u00030\rR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation$Companion;", "", "()V", "<set-?>", "", "apiAvailable", "getApiAvailable", "()Z", "testOverrideAvailability", "", "override", "parseAnimatedContent", "Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getApiAvailable() {
            return AnimatedContentComposeAnimation.apiAvailable;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        
            if (r3 == null) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation<?> parseAnimatedContent(androidx.compose.animation.core.Transition<?> r7) {
            /*
                r6 = this;
                java.lang.String r0 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                boolean r0 = r6.getApiAvailable()
                r1 = 0
                if (r0 != 0) goto Ld
                return r1
            Ld:
                java.lang.Object r0 = r7.getCurrentState()
                if (r0 == 0) goto L45
                r2 = 0
                java.lang.Class r3 = r0.getClass()
                java.lang.Object[] r3 = r3.getEnumConstants()
                if (r3 == 0) goto L29
                java.lang.String r4 = "enumConstants"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                java.util.Set r3 = kotlin.collections.ArraysKt.toSet(r3)
                if (r3 != 0) goto L2d
            L29:
                java.util.Set r3 = kotlin.collections.SetsKt.setOf(r0)
            L2d:
                androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation r4 = new androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation
                java.lang.String r5 = r7.getLabel()
                if (r5 != 0) goto L41
                java.lang.Class r5 = r0.getClass()
                kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
                java.lang.String r5 = r5.getSimpleName()
            L41:
                r4.<init>(r7, r3, r5, r1)
                r1 = r4
            L45:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation.Companion.parseAnimatedContent(androidx.compose.animation.core.Transition):androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation");
        }

        public final void testOverrideAvailability(boolean override) {
            AnimatedContentComposeAnimation.apiAvailable = override;
        }
    }

    static {
        ComposeAnimationType[] values = ComposeAnimationType.values();
        int length = values.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (Intrinsics.areEqual(values[i].name(), "ANIMATED_CONTENT")) {
                z = true;
                break;
            }
            i++;
        }
        apiAvailable = z;
    }
}
