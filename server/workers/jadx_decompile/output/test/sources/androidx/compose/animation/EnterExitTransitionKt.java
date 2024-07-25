package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aT\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001b\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u0010\u001f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0011\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a\"\u0010#\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\b\b\u0002\u0010$\u001a\u00020\u0004H\u0007\u001a\"\u0010%\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\b\b\u0002\u0010'\u001a\u00020\u0004H\u0007\u001a9\u0010(\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a9\u0010-\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001aT\u00101\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001aT\u00104\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\b0\u0016H\u0007ø\u0001\u0000\u001aT\u00106\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u0010\u0013\u001a\u00020\u00142#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u00108\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u00109\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010:\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010<\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a>\u0010>\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u0016H\u0007ø\u0001\u0000\u001a@\u0010@\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a@\u0010B\u001a\u00020&2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102#\b\u0002\u0010C\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u0016H\u0007ø\u0001\u0000\u001a/\u0010D\u001a\u00020E*\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001aB\u0010M\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u000e\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0P2\u0006\u0010S\u001a\u00020KH\u0002\u001aB\u0010T\u001a\u00020E*\u00020E2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0F2\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0P2\u0006\u0010S\u001a\u00020KH\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020\u0012H\u0002\u001a\f\u0010V\u001a\u00020\u001c*\u00020 H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006W²\u0006\n\u0010X\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010Y\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010Z\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010[\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\\\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\\\u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"DefaultAlpha", "Landroidx/compose/runtime/MutableFloatState;", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "shrinkExpand", "transition", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "labelPrefix", "slideInOut", "Landroidx/compose/animation/Slide;", "toAlignment", "animation_release", "shouldAnimateAlpha", "shouldAnimateScale", "alpha", "scale", "shouldAnimate"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
            return m50invoke__ExYCQ(transformOrigin.getPackedValue());
        }

        /* renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m50invoke__ExYCQ(long it) {
            return new AnimationVector2D(TransformOrigin.m3328getPivotFractionXimpl(it), TransformOrigin.m3329getPivotFractionYimpl(it));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
            return TransformOrigin.m3320boximpl(m51invokeLIALnN8(animationVector2D));
        }

        /* renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m51invokeLIALnN8(AnimationVector2D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return TransformOriginKt.TransformOrigin(it.getV1(), it.getV2());
        }
    });
    private static final MutableFloatState DefaultAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5327boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);

    /* compiled from: EnterExitTransition.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> animationSpec, float initialAlpha) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(initialAlpha, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> animationSpec, float targetAlpha) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(targetAlpha, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5327boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> initialOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffset, "initialOffset");
        return new EnterTransitionImpl(new TransitionData(null, new Slide(initialOffset, animationSpec), null, null, 13, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5327boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> targetOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffset, "targetOffset");
        return new ExitTransitionImpl(new TransitionData(null, new Slide(targetOffset, animationSpec), null, null, 13, null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m47scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m3333getCenterSzJe1aQ();
        }
        return m46scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m46scaleInL8ZKhE(FiniteAnimationSpec<Float> animationSpec, float initialScale, long transformOrigin) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(initialScale, transformOrigin, animationSpec, null), 7, null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m49scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m3333getCenterSzJe1aQ();
        }
        return m48scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m48scaleOutL8ZKhE(FiniteAnimationSpec<Float> animationSpec, float targetScale, long transformOrigin) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(targetScale, transformOrigin, animationSpec, null), 7, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandIn$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m5370boximpl(m53invokemzRDjE0(intSize.getPackedValue()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m53invokemzRDjE0(long it) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> animationSpec, Alignment expandFrom, boolean clip, Function1<? super IntSize, IntSize> initialSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(expandFrom, initialSize, animationSpec, clip), null, 11, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m5370boximpl(m56invokemzRDjE0(intSize.getPackedValue()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m56invokemzRDjE0(long it) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> animationSpec, Alignment shrinkTowards, boolean clip, Function1<? super IntSize, IntSize> targetSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(shrinkTowards, targetSize, animationSpec, clip), null, 11, null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal expandFrom, boolean clip, final Function1<? super Integer, Integer> initialWidth) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialWidth, "initialWidth");
        return expandIn(animationSpec, toAlignment(expandFrom), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m5370boximpl(m52invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m52invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(initialWidth.invoke(Integer.valueOf(IntSize.m5378getWidthimpl(it))).intValue(), IntSize.m5377getHeightimpl(it));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical expandFrom, boolean clip, final Function1<? super Integer, Integer> initialHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialHeight, "initialHeight");
        return expandIn(animationSpec, toAlignment(expandFrom), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m5370boximpl(m54invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m54invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(IntSize.m5378getWidthimpl(it), initialHeight.invoke(Integer.valueOf(IntSize.m5377getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal shrinkTowards, boolean clip, final Function1<? super Integer, Integer> targetWidth) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetWidth, "targetWidth");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m5370boximpl(m55invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m55invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(targetWidth.invoke(Integer.valueOf(IntSize.m5378getWidthimpl(it))).intValue(), IntSize.m5377getHeightimpl(it));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5370boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
                public final Integer invoke(int it) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical shrinkTowards, boolean clip, final Function1<? super Integer, Integer> targetHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetHeight, "targetHeight");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), clip, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m5370boximpl(m57invokemzRDjE0(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m57invokemzRDjE0(long it) {
                return IntSizeKt.IntSize(IntSize.m5378getWidthimpl(it), targetHeight.invoke(Integer.valueOf(IntSize.m5377getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5327boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> initialOffsetX) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffsetX, "initialOffsetX");
        return slideIn(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m5327boximpl(m58invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m58invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(initialOffsetX.invoke(Integer.valueOf(IntSize.m5378getWidthimpl(it))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5327boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> initialOffsetY) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffsetY, "initialOffsetY");
        return slideIn(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m5327boximpl(m59invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m59invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(0, initialOffsetY.invoke(Integer.valueOf(IntSize.m5377getHeightimpl(it))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5327boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> targetOffsetX) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffsetX, "targetOffsetX");
        return slideOut(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m5327boximpl(m60invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m60invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(targetOffsetX.invoke(Integer.valueOf(IntSize.m5378getWidthimpl(it))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5327boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1
                public final Integer invoke(int it) {
                    return Integer.valueOf((-it) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> targetOffsetY) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffsetY, "targetOffsetY");
        return slideOut(animationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m5327boximpl(m61invokemHKZG7I(intSize.getPackedValue()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m61invokemHKZG7I(long it) {
                return IntOffsetKt.IntOffset(0, targetOffsetY.invoke(Integer.valueOf(IntSize.m5377getHeightimpl(it))).intValue());
            }
        });
    }

    private static final Alignment toAlignment(Alignment.Horizontal $this$toAlignment) {
        return Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getStart()) ? Alignment.INSTANCE.getCenterStart() : Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getEnd()) ? Alignment.INSTANCE.getCenterEnd() : Alignment.INSTANCE.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical $this$toAlignment) {
        return Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getTop()) ? Alignment.INSTANCE.getTopCenter() : Intrinsics.areEqual($this$toAlignment, Alignment.INSTANCE.getBottom()) ? Alignment.INSTANCE.getBottomCenter() : Alignment.INSTANCE.getCenter();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:74:0x0490. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:102:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0682  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x05a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.Modifier createModifier(androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r37, final androidx.compose.animation.EnterTransition r38, final androidx.compose.animation.ExitTransition r39, java.lang.String r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            Method dump skipped, instructions count: 1982
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createModifier(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    private static final boolean createModifier$lambda$1(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    private static final void createModifier$lambda$2(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    private static final boolean createModifier$lambda$4(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    private static final void createModifier$lambda$5(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float createModifier$lambda$8(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float createModifier$lambda$11(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long createModifier$lambda$13(State<TransformOrigin> state) {
        Object thisObj$iv = state.getValue();
        return ((TransformOrigin) thisObj$iv).getPackedValue();
    }

    private static final Modifier slideInOut(Modifier $this$slideInOut, final Transition<EnterExitState> transition, final State<Slide> state, final State<Slide> state2, final String labelPrefix) {
        return ComposedModifierKt.composed$default($this$slideInOut, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            private static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object key1$iv;
                Modifier modifier;
                Object value$iv$iv;
                Object value$iv$iv2;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(158379472);
                ComposerKt.sourceInformation($composer, "C952@41279L46,964@41704L33,962@41628L119,966@41771L88:EnterExitTransition.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(158379472, $changed, -1, "androidx.compose.animation.slideInOut.<anonymous> (EnterExitTransition.kt:949)");
                }
                Object key1$iv2 = transition;
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(key1$iv2);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    key1$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    $composer.updateRememberedValue(key1$iv);
                } else {
                    key1$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                MutableState shouldAnimate$delegate = (MutableState) key1$iv;
                if (transition.getCurrentState() == transition.getTargetState() && !transition.isSeeking()) {
                    invoke$lambda$2(shouldAnimate$delegate, false);
                } else if (state.getValue() != null || state2.getValue() != null) {
                    invoke$lambda$2(shouldAnimate$delegate, true);
                }
                if (invoke$lambda$1(shouldAnimate$delegate)) {
                    Transition<EnterExitState> transition2 = transition;
                    TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
                    String str = labelPrefix;
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv2 = $composer.rememberedValue();
                    if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = str + " slide";
                        $composer.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv2;
                    }
                    $composer.endReplaceableGroup();
                    Transition.DeferredAnimation animation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition2, vectorConverter, (String) value$iv$iv, $composer, 448, 0);
                    Object key1$iv3 = transition;
                    State<Slide> state3 = state;
                    State<Slide> state4 = state2;
                    $composer.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer.changed(key1$iv3);
                    Object it$iv$iv3 = $composer.rememberedValue();
                    if (invalid$iv$iv2 || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = new SlideModifier(animation, state3, state4);
                        $composer.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv3;
                    }
                    $composer.endReplaceableGroup();
                    SlideModifier modifier2 = (SlideModifier) value$iv$iv2;
                    modifier = composed.then(modifier2);
                } else {
                    modifier = composed;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifier;
            }
        }, 1, null);
    }

    private static final Modifier shrinkExpand(Modifier $this$shrinkExpand, final Transition<EnterExitState> transition, final State<ChangeSize> state, final State<ChangeSize> state2, final String labelPrefix) {
        return ComposedModifierKt.composed$default($this$shrinkExpand, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
                MutableState<Boolean> $this$getValue$iv = mutableState;
                return $this$getValue$iv.getValue().booleanValue();
            }

            private static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean value) {
                mutableState.setValue(Boolean.valueOf(value));
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x0233  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x0264  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0288  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x0238  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, int r29) {
                /*
                    Method dump skipped, instructions count: 678
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }
        }, 1, null);
    }
}
