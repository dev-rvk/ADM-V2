package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimateXAsStateComposeAnimation.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001\"B7\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/tooling/ComposeAnimation;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "animationObject", "Landroidx/compose/animation/core/Animatable;", "(Landroidx/compose/ui/tooling/animation/ToolingState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/Animatable;)V", "getAnimationObject", "()Landroidx/compose/animation/core/Animatable;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "label", "", "getLabel", "()Ljava/lang/String;", "states", "", "", "getStates", "()Ljava/util/Set;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "type", "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "setState", "", "value", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimateXAsStateComposeAnimation<T, V extends AnimationVector> implements ComposeAnimation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean apiAvailable;
    private final Animatable<T, V> animationObject;
    private final AnimationSpec<T> animationSpec;
    private final String label;
    private final Set<Object> states;
    private final ToolingState<T> toolingState;
    private final ComposeAnimationType type;

    public /* synthetic */ AnimateXAsStateComposeAnimation(ToolingState toolingState, AnimationSpec animationSpec, Animatable animatable, DefaultConstructorMarker defaultConstructorMarker) {
        this(toolingState, animationSpec, animatable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x002f, code lost:
    
        if (r2 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private AnimateXAsStateComposeAnimation(androidx.compose.ui.tooling.animation.ToolingState<T> r5, androidx.compose.animation.core.AnimationSpec<T> r6, androidx.compose.animation.core.Animatable<T, V> r7) {
        /*
            r4 = this;
            r4.<init>()
            r4.toolingState = r5
            r4.animationSpec = r6
            r4.animationObject = r7
            androidx.compose.animation.tooling.ComposeAnimationType r0 = androidx.compose.animation.tooling.ComposeAnimationType.ANIMATE_X_AS_STATE
            r4.type = r0
            androidx.compose.animation.core.Animatable r0 = r4.m5144getAnimationObject()
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Any"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r1 = 0
            java.lang.Class r2 = r0.getClass()
            java.lang.Object[] r2 = r2.getEnumConstants()
            if (r2 == 0) goto L31
            java.lang.String r3 = "enumConstants"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.util.Set r2 = kotlin.collections.ArraysKt.toSet(r2)
            if (r2 != 0) goto L35
        L31:
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r0)
        L35:
            r4.states = r2
            androidx.compose.animation.core.Animatable r0 = r4.m5144getAnimationObject()
            java.lang.String r0 = r0.getLabel()
            r4.label = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.AnimateXAsStateComposeAnimation.<init>(androidx.compose.ui.tooling.animation.ToolingState, androidx.compose.animation.core.AnimationSpec, androidx.compose.animation.core.Animatable):void");
    }

    public final ToolingState<T> getToolingState() {
        return this.toolingState;
    }

    public final AnimationSpec<T> getAnimationSpec() {
        return this.animationSpec;
    }

    /* renamed from: getAnimationObject, reason: merged with bridge method [inline-methods] */
    public Animatable<T, V> m5144getAnimationObject() {
        return this.animationObject;
    }

    public ComposeAnimationType getType() {
        return this.type;
    }

    public Set<Object> getStates() {
        return this.states;
    }

    public String getLabel() {
        return this.label;
    }

    public final void setState(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.toolingState.setValue(value);
    }

    /* compiled from: AnimateXAsStateComposeAnimation.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J7\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f\"\u0004\b\u0002\u0010\r\"\b\b\u0003\u0010\u000e*\u00020\u000f*\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u0010H\u0000¢\u0006\u0002\b\u0011R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation$Companion;", "", "()V", "<set-?>", "", "apiAvailable", "getApiAvailable", "()Z", "testOverrideAvailability", "", "override", "parse", "Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "parse$ui_tooling_release", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getApiAvailable() {
            return AnimateXAsStateComposeAnimation.apiAvailable;
        }

        public final <T, V extends AnimationVector> AnimateXAsStateComposeAnimation<?, ?> parse$ui_tooling_release(AnimationSearch.AnimateXAsStateSearchInfo<T, V> animateXAsStateSearchInfo) {
            Intrinsics.checkNotNullParameter(animateXAsStateSearchInfo, "<this>");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (getApiAvailable() && animateXAsStateSearchInfo.getAnimatable().getValue() != null) {
                return new AnimateXAsStateComposeAnimation<>(animateXAsStateSearchInfo.getToolingState(), animateXAsStateSearchInfo.getAnimationSpec(), animateXAsStateSearchInfo.getAnimatable(), defaultConstructorMarker);
            }
            return null;
        }

        public final void testOverrideAvailability(boolean override) {
            AnimateXAsStateComposeAnimation.apiAvailable = override;
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
            if (Intrinsics.areEqual(values[i].name(), "UNSUPPORTED")) {
                z = true;
                break;
            }
            i++;
        }
        apiAvailable = z;
    }
}
