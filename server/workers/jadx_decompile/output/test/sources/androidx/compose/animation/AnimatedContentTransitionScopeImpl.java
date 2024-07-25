package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002UVB%\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0004\b>\u0010?JN\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u0002002\f\u0010C\u001a\b\u0012\u0004\u0012\u0002060D2!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020G0FH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJN\u0010M\u001a\u00020N2\u0006\u0010B\u001a\u0002002\f\u0010C\u001a\b\u0012\u0004\u0012\u0002060D2!\u0010O\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020G0FH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020=*\u00020=2\b\u0010S\u001a\u0004\u0018\u00010TH\u0096\u0004R%\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0080\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u00020\f8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR4\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010#R)\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0'X\u0080\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u001aR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/*\u0002008BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b1\u00102R\u001b\u00103\u001a\u00020/*\u0002008BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b4\u00102\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W²\u0006\u0010\u0010X\u001a\u00020/\"\u0004\b\u0000\u0010\u0001X\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "S", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "transition", "Landroidx/compose/animation/core/Transition;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/unit/LayoutDirection;)V", "animatedSize", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/IntSize;", "getAnimatedSize$animation_release", "()Landroidx/compose/runtime/State;", "setAnimatedSize$animation_release", "(Landroidx/compose/runtime/State;)V", "getContentAlignment$animation_release", "()Landroidx/compose/ui/Alignment;", "setContentAlignment$animation_release", "(Landroidx/compose/ui/Alignment;)V", "currentSize", "getCurrentSize-YbymL2g", "()J", "initialState", "getInitialState", "()Ljava/lang/Object;", "getLayoutDirection$animation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$animation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "measuredSize", "getMeasuredSize-YbymL2g$animation_release", "setMeasuredSize-ozmzZPI$animation_release", "(J)V", "measuredSize$delegate", "Landroidx/compose/runtime/MutableState;", "targetSizeMap", "", "getTargetSizeMap$animation_release", "()Ljava/util/Map;", "targetState", "getTargetState", "getTransition$animation_release", "()Landroidx/compose/animation/core/Transition;", "isLeft", "", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "isLeft-gWo6LJ4", "(I)Z", "isRight", "isRight-gWo6LJ4", "calculateOffset", "Landroidx/compose/ui/unit/IntOffset;", "fullSize", "calculateOffset-emnUabE", "(JJ)J", "createSizeAnimationModifier", "Landroidx/compose/ui/Modifier;", "contentTransform", "Landroidx/compose/animation/ContentTransform;", "createSizeAnimationModifier$animation_release", "(Landroidx/compose/animation/ContentTransform;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "using", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "ChildData", "SizeModifier", "animation_release", "shouldAnimateSize"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl<S> implements AnimatedContentTransitionScope<S> {
    private State<IntSize> animatedSize;
    private Alignment contentAlignment;
    private LayoutDirection layoutDirection;

    /* renamed from: measuredSize$delegate, reason: from kotlin metadata */
    private final MutableState measuredSize;
    private final Map<S, State<IntSize>> targetSizeMap;
    private final Transition<S> transition;

    public AnimatedContentTransitionScopeImpl(Transition<S> transition, Alignment contentAlignment, LayoutDirection layoutDirection) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(contentAlignment, "contentAlignment");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.transition = transition;
        this.contentAlignment = contentAlignment;
        this.layoutDirection = layoutDirection;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m5370boximpl(IntSize.INSTANCE.m5383getZeroYbymL2g()), null, 2, null);
        this.measuredSize = mutableStateOf$default;
        this.targetSizeMap = new LinkedHashMap();
    }

    public final Transition<S> getTransition$animation_release() {
        return this.transition;
    }

    /* renamed from: getContentAlignment$animation_release, reason: from getter */
    public final Alignment getContentAlignment() {
        return this.contentAlignment;
    }

    public final void setContentAlignment$animation_release(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.contentAlignment = alignment;
    }

    /* renamed from: getLayoutDirection$animation_release, reason: from getter */
    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final void setLayoutDirection$animation_release(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public ContentTransform using(ContentTransform $this$using, SizeTransform sizeTransform) {
        Intrinsics.checkNotNullParameter($this$using, "<this>");
        $this$using.setSizeTransform$animation_release(sizeTransform);
        return $this$using;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    /* renamed from: slideIntoContainer-mOhB8PU */
    public EnterTransition mo18slideIntoContainermOhB8PU(int towards, FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> initialOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(initialOffset, "initialOffset");
        return m37isLeftgWo6LJ4(towards) ? EnterExitTransitionKt.slideInHorizontally(animationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$slideIntoContainer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                long m36getCurrentSizeYbymL2g;
                long m36getCurrentSizeYbymL2g2;
                long m35calculateOffsetemnUabE;
                Function1<Integer, Integer> function1 = initialOffset;
                m36getCurrentSizeYbymL2g = this.m36getCurrentSizeYbymL2g();
                int m5378getWidthimpl = IntSize.m5378getWidthimpl(m36getCurrentSizeYbymL2g);
                AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this;
                long IntSize = IntSizeKt.IntSize(it, it);
                m36getCurrentSizeYbymL2g2 = this.m36getCurrentSizeYbymL2g();
                m35calculateOffsetemnUabE = animatedContentTransitionScopeImpl.m35calculateOffsetemnUabE(IntSize, m36getCurrentSizeYbymL2g2);
                return function1.invoke(Integer.valueOf(m5378getWidthimpl - IntOffset.m5336getXimpl(m35calculateOffsetemnUabE)));
            }
        }) : m38isRightgWo6LJ4(towards) ? EnterExitTransitionKt.slideInHorizontally(animationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$slideIntoContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                long m36getCurrentSizeYbymL2g;
                long m35calculateOffsetemnUabE;
                Function1<Integer, Integer> function1 = initialOffset;
                AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this;
                long IntSize = IntSizeKt.IntSize(it, it);
                m36getCurrentSizeYbymL2g = this.m36getCurrentSizeYbymL2g();
                m35calculateOffsetemnUabE = animatedContentTransitionScopeImpl.m35calculateOffsetemnUabE(IntSize, m36getCurrentSizeYbymL2g);
                return function1.invoke(Integer.valueOf((-IntOffset.m5336getXimpl(m35calculateOffsetemnUabE)) - it));
            }
        }) : AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0(towards, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m32getUpDKzdypw()) ? EnterExitTransitionKt.slideInVertically(animationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$slideIntoContainer$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                long m36getCurrentSizeYbymL2g;
                long m36getCurrentSizeYbymL2g2;
                long m35calculateOffsetemnUabE;
                Function1<Integer, Integer> function1 = initialOffset;
                m36getCurrentSizeYbymL2g = this.m36getCurrentSizeYbymL2g();
                int m5377getHeightimpl = IntSize.m5377getHeightimpl(m36getCurrentSizeYbymL2g);
                AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this;
                long IntSize = IntSizeKt.IntSize(it, it);
                m36getCurrentSizeYbymL2g2 = this.m36getCurrentSizeYbymL2g();
                m35calculateOffsetemnUabE = animatedContentTransitionScopeImpl.m35calculateOffsetemnUabE(IntSize, m36getCurrentSizeYbymL2g2);
                return function1.invoke(Integer.valueOf(m5377getHeightimpl - IntOffset.m5337getYimpl(m35calculateOffsetemnUabE)));
            }
        }) : AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0(towards, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m27getDownDKzdypw()) ? EnterExitTransitionKt.slideInVertically(animationSpec, new Function1<Integer, Integer>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$slideIntoContainer$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                long m36getCurrentSizeYbymL2g;
                long m35calculateOffsetemnUabE;
                Function1<Integer, Integer> function1 = initialOffset;
                AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this;
                long IntSize = IntSizeKt.IntSize(it, it);
                m36getCurrentSizeYbymL2g = this.m36getCurrentSizeYbymL2g();
                m35calculateOffsetemnUabE = animatedContentTransitionScopeImpl.m35calculateOffsetemnUabE(IntSize, m36getCurrentSizeYbymL2g);
                return function1.invoke(Integer.valueOf((-IntOffset.m5337getYimpl(m35calculateOffsetemnUabE)) - it));
            }
        }) : EnterTransition.INSTANCE.getNone();
    }

    /* renamed from: isLeft-gWo6LJ4, reason: not valid java name */
    private final boolean m37isLeftgWo6LJ4(int $this$isLeft) {
        return AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0($this$isLeft, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m29getLeftDKzdypw()) || (AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0($this$isLeft, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m31getStartDKzdypw()) && this.layoutDirection == LayoutDirection.Ltr) || (AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0($this$isLeft, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m28getEndDKzdypw()) && this.layoutDirection == LayoutDirection.Rtl);
    }

    /* renamed from: isRight-gWo6LJ4, reason: not valid java name */
    private final boolean m38isRightgWo6LJ4(int $this$isRight) {
        return AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0($this$isRight, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m30getRightDKzdypw()) || (AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0($this$isRight, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m31getStartDKzdypw()) && this.layoutDirection == LayoutDirection.Rtl) || (AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0($this$isRight, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m28getEndDKzdypw()) && this.layoutDirection == LayoutDirection.Ltr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateOffset-emnUabE, reason: not valid java name */
    public final long m35calculateOffsetemnUabE(long fullSize, long currentSize) {
        return this.contentAlignment.mo2600alignKFBX0sM(fullSize, currentSize, LayoutDirection.Ltr);
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    /* renamed from: slideOutOfContainer-mOhB8PU */
    public ExitTransition mo19slideOutOfContainermOhB8PU(int towards, FiniteAnimationSpec<IntOffset> animationSpec, final Function1<? super Integer, Integer> targetOffset) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(targetOffset, "targetOffset");
        return m37isLeftgWo6LJ4(towards) ? EnterExitTransitionKt.slideOutHorizontally(animationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$slideOutOfContainer$1
            final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                long m35calculateOffsetemnUabE;
                State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                long targetSize = state != null ? ((IntSize) state.getValue()).getPackedValue() : IntSize.INSTANCE.m5383getZeroYbymL2g();
                Function1<Integer, Integer> function1 = targetOffset;
                m35calculateOffsetemnUabE = this.this$0.m35calculateOffsetemnUabE(IntSizeKt.IntSize(it, it), targetSize);
                return function1.invoke(Integer.valueOf((-IntOffset.m5336getXimpl(m35calculateOffsetemnUabE)) - it));
            }
        }) : m38isRightgWo6LJ4(towards) ? EnterExitTransitionKt.slideOutHorizontally(animationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$slideOutOfContainer$2
            final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                long m35calculateOffsetemnUabE;
                State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                long targetSize = state != null ? ((IntSize) state.getValue()).getPackedValue() : IntSize.INSTANCE.m5383getZeroYbymL2g();
                Function1<Integer, Integer> function1 = targetOffset;
                m35calculateOffsetemnUabE = this.this$0.m35calculateOffsetemnUabE(IntSizeKt.IntSize(it, it), targetSize);
                return function1.invoke(Integer.valueOf((-IntOffset.m5336getXimpl(m35calculateOffsetemnUabE)) + IntSize.m5378getWidthimpl(targetSize)));
            }
        }) : AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0(towards, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m32getUpDKzdypw()) ? EnterExitTransitionKt.slideOutVertically(animationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$slideOutOfContainer$3
            final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                long m35calculateOffsetemnUabE;
                State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                long targetSize = state != null ? ((IntSize) state.getValue()).getPackedValue() : IntSize.INSTANCE.m5383getZeroYbymL2g();
                Function1<Integer, Integer> function1 = targetOffset;
                m35calculateOffsetemnUabE = this.this$0.m35calculateOffsetemnUabE(IntSizeKt.IntSize(it, it), targetSize);
                return function1.invoke(Integer.valueOf((-IntOffset.m5337getYimpl(m35calculateOffsetemnUabE)) - it));
            }
        }) : AnimatedContentTransitionScope.SlideDirection.m23equalsimpl0(towards, AnimatedContentTransitionScope.SlideDirection.INSTANCE.m27getDownDKzdypw()) ? EnterExitTransitionKt.slideOutVertically(animationSpec, new Function1<Integer, Integer>(this) { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$slideOutOfContainer$4
            final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                long m35calculateOffsetemnUabE;
                State state = (State) this.this$0.getTargetSizeMap$animation_release().get(this.this$0.getTransition$animation_release().getTargetState());
                long targetSize = state != null ? ((IntSize) state.getValue()).getPackedValue() : IntSize.INSTANCE.m5383getZeroYbymL2g();
                Function1<Integer, Integer> function1 = targetOffset;
                m35calculateOffsetemnUabE = this.this$0.m35calculateOffsetemnUabE(IntSizeKt.IntSize(it, it), targetSize);
                return function1.invoke(Integer.valueOf((-IntOffset.m5337getYimpl(m35calculateOffsetemnUabE)) + IntSize.m5377getHeightimpl(targetSize)));
            }
        }) : ExitTransition.INSTANCE.getNone();
    }

    /* renamed from: getMeasuredSize-YbymL2g$animation_release, reason: not valid java name */
    public final long m39getMeasuredSizeYbymL2g$animation_release() {
        State $this$getValue$iv = this.measuredSize;
        return ((IntSize) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: setMeasuredSize-ozmzZPI$animation_release, reason: not valid java name */
    public final void m40setMeasuredSizeozmzZPI$animation_release(long j) {
        MutableState $this$setValue$iv = this.measuredSize;
        $this$setValue$iv.setValue(IntSize.m5370boximpl(j));
    }

    public final Map<S, State<IntSize>> getTargetSizeMap$animation_release() {
        return this.targetSizeMap;
    }

    public final State<IntSize> getAnimatedSize$animation_release() {
        return this.animatedSize;
    }

    public final void setAnimatedSize$animation_release(State<IntSize> state) {
        this.animatedSize = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCurrentSize-YbymL2g, reason: not valid java name */
    public final long m36getCurrentSizeYbymL2g() {
        State<IntSize> state = this.animatedSize;
        return state != null ? state.getValue().getPackedValue() : m39getMeasuredSizeYbymL2g$animation_release();
    }

    public final Modifier createSizeAnimationModifier$animation_release(ContentTransform contentTransform, Composer $composer, int $changed) {
        Object value$iv$iv;
        Modifier.Companion companion;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(contentTransform, "contentTransform");
        $composer.startReplaceableGroup(93755870);
        ComposerKt.sourceInformation($composer, "C(createSizeAnimationModifier)557@26192L40,558@26261L52,568@26730L48,569@26791L205:AnimatedContent.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(93755870, $changed, -1, "androidx.compose.animation.AnimatedContentTransitionScopeImpl.createSizeAnimationModifier (AnimatedContent.kt:554)");
        }
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(this);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState shouldAnimateSize$delegate = (MutableState) value$iv$iv;
        State sizeTransform = SnapshotStateKt.rememberUpdatedState(contentTransform.getSizeTransform(), $composer, 0);
        if (Intrinsics.areEqual(this.transition.getCurrentState(), this.transition.getTargetState())) {
            createSizeAnimationModifier$lambda$3(shouldAnimateSize$delegate, false);
        } else if (sizeTransform.getValue() != null) {
            createSizeAnimationModifier$lambda$3(shouldAnimateSize$delegate, true);
        }
        if (createSizeAnimationModifier$lambda$2(shouldAnimateSize$delegate)) {
            Transition.DeferredAnimation sizeAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), null, $composer, 64, 2);
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer.changed(sizeAnimation);
            Object it$iv$iv2 = $composer.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                SizeTransform sizeTransform2 = (SizeTransform) sizeTransform.getValue();
                value$iv$iv2 = ((sizeTransform2 == null || sizeTransform2.getClip()) ? false : true ? Modifier.INSTANCE : ClipKt.clipToBounds(Modifier.INSTANCE)).then(new SizeModifier(this, sizeAnimation, sizeTransform));
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer.endReplaceableGroup();
            companion = (Modifier) value$iv$iv2;
        } else {
            this.animatedSize = null;
            companion = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return companion;
    }

    private static final boolean createSizeAnimationModifier$lambda$2(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    private static final void createSizeAnimationModifier$lambda$3(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* compiled from: AnimatedContent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0016\u0010\u0010\u001a\u00020\u000b*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$ChildData;", "Landroidx/compose/ui/layout/ParentDataModifier;", "isTarget", "", "(Z)V", "()Z", "setTarget", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class ChildData implements ParentDataModifier {
        private boolean isTarget;

        public static /* synthetic */ ChildData copy$default(ChildData childData, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = childData.isTarget;
            }
            return childData.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsTarget() {
            return this.isTarget;
        }

        public final ChildData copy(boolean isTarget) {
            return new ChildData(isTarget);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ChildData) && this.isTarget == ((ChildData) other).isTarget;
        }

        public int hashCode() {
            boolean z = this.isTarget;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ChildData(isTarget=" + this.isTarget + ')';
        }

        public ChildData(boolean isTarget) {
            this.isTarget = isTarget;
        }

        public final boolean isTarget() {
            return this.isTarget;
        }

        public final void setTarget(boolean z) {
            this.isTarget = z;
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
            Intrinsics.checkNotNullParameter($this$modifyParentData, "<this>");
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedContent.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B6\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bø\u0001\u0000¢\u0006\u0002\u0010\nJ)\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00028\u00000\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifier;", "Landroidx/compose/animation/LayoutModifierWithPassThroughIntrinsics;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "sizeTransform", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSizeTransform", "()Landroidx/compose/runtime/State;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class SizeModifier extends LayoutModifierWithPassThroughIntrinsics {
        private final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
        private final State<SizeTransform> sizeTransform;
        final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public SizeModifier(AnimatedContentTransitionScopeImpl this$0, Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation, State<? extends SizeTransform> sizeTransform) {
            Intrinsics.checkNotNullParameter(sizeAnimation, "sizeAnimation");
            Intrinsics.checkNotNullParameter(sizeTransform, "sizeTransform");
            this.this$0 = this$0;
            this.sizeAnimation = sizeAnimation;
            this.sizeTransform = sizeTransform;
        }

        public final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
            return this.sizeAnimation;
        }

        public final State<SizeTransform> getSizeTransform() {
            return this.sizeTransform;
        }

        @Override // androidx.compose.ui.layout.LayoutModifier
        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public MeasureResult mo41measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
            Intrinsics.checkNotNullParameter(measure, "$this$measure");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            final Placeable mo4186measureBRTryo0 = measurable.mo4186measureBRTryo0(j);
            Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation = this.sizeAnimation;
            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this.this$0;
            Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>> function1 = new Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<S> animate) {
                    FiniteAnimationSpec<IntSize> mo79createAnimationSpecTemP2vQ;
                    Intrinsics.checkNotNullParameter(animate, "$this$animate");
                    State<IntSize> state = animatedContentTransitionScopeImpl.getTargetSizeMap$animation_release().get(animate.getInitialState());
                    long initial = state != null ? state.getValue().getPackedValue() : IntSize.INSTANCE.m5383getZeroYbymL2g();
                    State<IntSize> state2 = animatedContentTransitionScopeImpl.getTargetSizeMap$animation_release().get(animate.getTargetState());
                    long target = state2 != null ? state2.getValue().getPackedValue() : IntSize.INSTANCE.m5383getZeroYbymL2g();
                    SizeTransform value = this.getSizeTransform().getValue();
                    return (value == null || (mo79createAnimationSpecTemP2vQ = value.mo79createAnimationSpecTemP2vQ(initial, target)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : mo79createAnimationSpecTemP2vQ;
                }
            };
            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl2 = this.this$0;
            State<IntSize> animate = deferredAnimation.animate(function1, new Function1<S, IntSize>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(Object obj) {
                    return IntSize.m5370boximpl(m42invokeYEO4UFw(obj));
                }

                /* renamed from: invoke-YEO4UFw, reason: not valid java name */
                public final long m42invokeYEO4UFw(S s) {
                    State<IntSize> state = animatedContentTransitionScopeImpl2.getTargetSizeMap$animation_release().get(s);
                    return state != null ? state.getValue().getPackedValue() : IntSize.INSTANCE.m5383getZeroYbymL2g();
                }
            });
            this.this$0.setAnimatedSize$animation_release(animate);
            final long mo2600alignKFBX0sM = this.this$0.getContentAlignment().mo2600alignKFBX0sM(IntSizeKt.IntSize(mo4186measureBRTryo0.getWidth(), mo4186measureBRTryo0.getHeight()), animate.getValue().getPackedValue(), LayoutDirection.Ltr);
            return MeasureScope.layout$default(measure, IntSize.m5378getWidthimpl(animate.getValue().getPackedValue()), IntSize.m5377getHeightimpl(animate.getValue().getPackedValue()), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope layout) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Placeable.PlacementScope.m4243place70tqf50$default(layout, Placeable.this, mo2600alignKFBX0sM, 0.0f, 2, null);
                }
            }, 4, null);
        }
    }
}
