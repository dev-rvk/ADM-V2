package androidx.compose.animation;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0011\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0087\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/EnterTransition;", "", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "equals", "", "other", "hashCode", "", "plus", "enter", "toString", "", "Companion", "Landroidx/compose/animation/EnterTransitionImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class EnterTransition {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final EnterTransition None = new EnterTransitionImpl(new TransitionData(null, null, null, null, 15, null));

    public /* synthetic */ EnterTransition(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract TransitionData getData$animation_release();

    private EnterTransition() {
    }

    public final EnterTransition plus(EnterTransition enter) {
        Intrinsics.checkNotNullParameter(enter, "enter");
        Fade fade = getData$animation_release().getFade();
        if (fade == null) {
            fade = enter.getData$animation_release().getFade();
        }
        Slide slide = getData$animation_release().getSlide();
        if (slide == null) {
            slide = enter.getData$animation_release().getSlide();
        }
        ChangeSize changeSize = getData$animation_release().getChangeSize();
        if (changeSize == null) {
            changeSize = enter.getData$animation_release().getChangeSize();
        }
        Scale scale = getData$animation_release().getScale();
        if (scale == null) {
            scale = enter.getData$animation_release().getScale();
        }
        return new EnterTransitionImpl(new TransitionData(fade, slide, changeSize, scale));
    }

    public String toString() {
        if (Intrinsics.areEqual(this, None)) {
            return "EnterTransition.None";
        }
        TransitionData $this$toString_u24lambda_u240 = getData$animation_release();
        StringBuilder append = new StringBuilder().append("EnterTransition: \nFade - ");
        Fade fade = $this$toString_u24lambda_u240.getFade();
        StringBuilder append2 = append.append(fade != null ? fade.toString() : null).append(",\nSlide - ");
        Slide slide = $this$toString_u24lambda_u240.getSlide();
        StringBuilder append3 = append2.append(slide != null ? slide.toString() : null).append(",\nShrink - ");
        ChangeSize changeSize = $this$toString_u24lambda_u240.getChangeSize();
        StringBuilder append4 = append3.append(changeSize != null ? changeSize.toString() : null).append(",\nScale - ");
        Scale scale = $this$toString_u24lambda_u240.getScale();
        return append4.append(scale != null ? scale.toString() : null).toString();
    }

    public boolean equals(Object other) {
        return (other instanceof EnterTransition) && Intrinsics.areEqual(((EnterTransition) other).getData$animation_release(), getData$animation_release());
    }

    public int hashCode() {
        return getData$animation_release().hashCode();
    }

    /* compiled from: EnterExitTransition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/EnterTransition$Companion;", "", "()V", "None", "Landroidx/compose/animation/EnterTransition;", "getNone", "()Landroidx/compose/animation/EnterTransition;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EnterTransition getNone() {
            return EnterTransition.None;
        }
    }
}
