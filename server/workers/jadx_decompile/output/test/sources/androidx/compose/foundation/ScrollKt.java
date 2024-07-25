package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scroll.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001a6\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002\u001a2\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t¨\u0006\u0011"}, d2 = {"rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "horizontalScroll", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "scroll", "isScrollable", "isVertical", "verticalScroll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ScrollKt {
    public static final ScrollState rememberScrollState(final int initial, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1464256199);
        ComposerKt.sourceInformation($composer, "C(rememberScrollState)73@3370L46,73@3326L90:Scroll.kt#71ulvw");
        if ((i & 1) != 0) {
            initial = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1464256199, $changed, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:72)");
        }
        Object[] objArr = new Object[0];
        Saver<ScrollState, ?> saver = ScrollState.INSTANCE.getSaver();
        Object key1$iv = Integer.valueOf(initial);
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Function0<ScrollState>() { // from class: androidx.compose.foundation.ScrollKt$rememberScrollState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ScrollState invoke() {
                    return new ScrollState(initial);
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        ScrollState scrollState = (ScrollState) RememberSaveableKt.m2596rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return scrollState;
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return verticalScroll(modifier, scrollState, z, flingBehavior, z2);
    }

    public static final Modifier verticalScroll(Modifier $this$verticalScroll, ScrollState state, boolean enabled, FlingBehavior flingBehavior, boolean reverseScrolling) {
        Intrinsics.checkNotNullParameter($this$verticalScroll, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return scroll($this$verticalScroll, state, reverseScrolling, flingBehavior, enabled, true);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return horizontalScroll(modifier, scrollState, z, flingBehavior, z2);
    }

    public static final Modifier horizontalScroll(Modifier $this$horizontalScroll, ScrollState state, boolean enabled, FlingBehavior flingBehavior, boolean reverseScrolling) {
        Intrinsics.checkNotNullParameter($this$horizontalScroll, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return scroll($this$horizontalScroll, state, reverseScrolling, flingBehavior, enabled, false);
    }

    private static final Modifier scroll(Modifier $this$scroll, final ScrollState state, final boolean reverseScrolling, final FlingBehavior flingBehavior, final boolean isScrollable, final boolean isVertical) {
        return ComposedModifierKt.composed($this$scroll, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ScrollKt$scroll$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("scroll");
                $this$null.getProperties().set("state", ScrollState.this);
                $this$null.getProperties().set("reverseScrolling", Boolean.valueOf(reverseScrolling));
                $this$null.getProperties().set("flingBehavior", flingBehavior);
                $this$null.getProperties().set("isScrollable", Boolean.valueOf(isScrollable));
                $this$null.getProperties().set("isVertical", Boolean.valueOf(isVertical));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(1478351300);
                ComposerKt.sourceInformation($composer, "C267@9967L18,268@10015L24,301@11508L7:Scroll.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1478351300, $changed, -1, "androidx.compose.foundation.scroll.<anonymous> (Scroll.kt:266)");
                }
                OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect($composer, 6);
                $composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer, "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp");
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv$iv = $composer.rememberedValue();
                if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                    $composer.updateRememberedValue(value$iv$iv$iv);
                } else {
                    value$iv$iv$iv = it$iv$iv$iv;
                }
                $composer.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                final CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                $composer.endReplaceableGroup();
                Modifier.Companion companion = Modifier.INSTANCE;
                final boolean z = reverseScrolling;
                final boolean z2 = isVertical;
                final boolean z3 = isScrollable;
                final ScrollState scrollState = state;
                Modifier semantics = SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics2) {
                        Intrinsics.checkNotNullParameter(semantics2, "$this$semantics");
                        SemanticsPropertiesKt.setTraversalGroup(semantics2, true);
                        final ScrollState scrollState2 = scrollState;
                        Function0<Float> function0 = new Function0<Float>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(ScrollState.this.getValue());
                            }
                        };
                        final ScrollState scrollState3 = scrollState;
                        ScrollAxisRange accessibilityScrollState = new ScrollAxisRange(function0, new Function0<Float>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(ScrollState.this.getMaxValue());
                            }
                        }, z);
                        if (z2) {
                            SemanticsPropertiesKt.setVerticalScrollAxisRange(semantics2, accessibilityScrollState);
                        } else {
                            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semantics2, accessibilityScrollState);
                        }
                        if (z3) {
                            final CoroutineScope coroutineScope2 = coroutineScope;
                            final boolean z4 = z2;
                            final ScrollState scrollState4 = scrollState;
                            SemanticsPropertiesKt.scrollBy$default(semantics2, null, new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Boolean invoke(Float f, Float f2) {
                                    return invoke(f.floatValue(), f2.floatValue());
                                }

                                public final Boolean invoke(float x, float y) {
                                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C00021(z4, scrollState4, y, x, null), 3, null);
                                    return true;
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: Scroll.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                                @DebugMetadata(c = "androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1", f = "Scroll.kt", i = {}, l = {288, 290}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1, reason: invalid class name and collision with other inner class name */
                                /* loaded from: classes.dex */
                                public static final class C00021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ boolean $isVertical;
                                    final /* synthetic */ ScrollState $state;
                                    final /* synthetic */ float $x;
                                    final /* synthetic */ float $y;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C00021(boolean z, ScrollState scrollState, float f, float f2, Continuation<? super C00021> continuation) {
                                        super(2, continuation);
                                        this.$isVertical = z;
                                        this.$state = scrollState;
                                        this.$y = f;
                                        this.$x = f2;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00021(this.$isVertical, this.$state, this.$y, this.$x, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                if (this.$isVertical) {
                                                    ScrollState scrollState = this.$state;
                                                    Intrinsics.checkNotNull(scrollState, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                                    this.label = 1;
                                                    if (ScrollExtensionsKt.animateScrollBy$default(scrollState, this.$y, null, this, 2, null) != coroutine_suspended) {
                                                        break;
                                                    } else {
                                                        return coroutine_suspended;
                                                    }
                                                } else {
                                                    ScrollState scrollState2 = this.$state;
                                                    Intrinsics.checkNotNull(scrollState2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                                    this.label = 2;
                                                    if (ScrollExtensionsKt.animateScrollBy$default(scrollState2, this.$x, null, this, 2, null) != coroutine_suspended) {
                                                        break;
                                                    } else {
                                                        return coroutine_suspended;
                                                    }
                                                }
                                            case 1:
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            case 2:
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                            }, 1, null);
                        }
                    }
                }, 1, null);
                Orientation orientation = isVertical ? Orientation.Vertical : Orientation.Horizontal;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier scrolling = ScrollableKt.scrollable(companion2, state, orientation, overscrollEffect, isScrollable, scrollableDefaults.reverseDirection((LayoutDirection) consume, orientation, reverseScrolling), flingBehavior, state.getInternalInteractionSource());
                ScrollingLayoutElement layout = new ScrollingLayoutElement(state, reverseScrolling, isVertical);
                Modifier then = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(semantics, orientation), overscrollEffect).then(scrolling).then(layout);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return then;
            }
        });
    }
}
