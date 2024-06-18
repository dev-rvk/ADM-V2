package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: TextFieldPressGestureFilter.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"tapPressTextFieldModifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onTap", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldPressGestureFilterKt {
    public static /* synthetic */ Modifier tapPressTextFieldModifier$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return tapPressTextFieldModifier(modifier, mutableInteractionSource, z, function1);
    }

    public static final Modifier tapPressTextFieldModifier(Modifier $this$tapPressTextFieldModifier, final MutableInteractionSource interactionSource, boolean enabled, final Function1<? super Offset, Unit> onTap) {
        Intrinsics.checkNotNullParameter($this$tapPressTextFieldModifier, "<this>");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        return enabled ? ComposedModifierKt.composed$default($this$tapPressTextFieldModifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv$iv;
                Object value$iv$iv;
                Object value$iv$iv2;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-102778667);
                ComposerKt.sourceInformation($composer, "C40@1611L24,41@1665L58,42@1745L27,43@1813L279,43@1777L315:TextFieldPressGestureFilter.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-102778667, $changed, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:39)");
                }
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
                CoroutineScope scope = wrapper$iv.getCoroutineScope();
                $composer.endReplaceableGroup();
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                final MutableState pressedInteraction = (MutableState) value$iv$iv;
                State onTapState = SnapshotStateKt.rememberUpdatedState(onTap, $composer, 0);
                MutableInteractionSource mutableInteractionSource = interactionSource;
                Object key2$iv = interactionSource;
                final MutableInteractionSource mutableInteractionSource2 = interactionSource;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(pressedInteraction) | $composer.changed(key2$iv);
                Object it$iv$iv2 = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            final MutableState<PressInteraction.Press> mutableState = pressedInteraction;
                            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    PressInteraction.Press oldValue = (PressInteraction.Press) MutableState.this.getValue();
                                    if (oldValue == null) {
                                        return;
                                    }
                                    PressInteraction.Cancel interaction = new PressInteraction.Cancel(oldValue);
                                    if (mutableInteractionSource3 != null) {
                                        mutableInteractionSource3.tryEmit(interaction);
                                    }
                                    MutableState.this.setValue(null);
                                }
                            };
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer.endReplaceableGroup();
                EffectsKt.DisposableEffect(mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv2, $composer, 0);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, interactionSource, new AnonymousClass2(scope, pressedInteraction, interactionSource, onTapState, null));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return pointerInput;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TextFieldPressGestureFilter.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2", f = "TextFieldPressGestureFilter.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ State<Function1<Offset, Unit>> $onTapState;
                final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                final /* synthetic */ CoroutineScope $scope;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(CoroutineScope coroutineScope, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, State<? extends Function1<? super Offset, Unit>> state, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$scope = coroutineScope;
                    this.$pressedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                    this.$onTapState = state;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$scope, this.$pressedInteraction, this.$interactionSource, this.$onTapState, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TextFieldPressGestureFilter.kt */
                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1", f = "TextFieldPressGestureFilter.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                    final /* synthetic */ CoroutineScope $scope;
                    /* synthetic */ long J$0;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(CoroutineScope coroutineScope, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
                        super(3, continuation);
                        this.$scope = coroutineScope;
                        this.$pressedInteraction = mutableState;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                        return m823invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
                    }

                    /* renamed from: invoke-d-4ec7I, reason: not valid java name */
                    public final Object m823invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, continuation);
                        anonymousClass1.L$0 = pressGestureScope;
                        anonymousClass1.J$0 = j;
                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TextFieldPressGestureFilter.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1", f = "TextFieldPressGestureFilter.kt", i = {1}, l = {LockFreeTaskQueueCore.FROZEN_SHIFT, 64}, m = "invokeSuspend", n = {"interaction"}, s = {"L$0"})
                    /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        final /* synthetic */ long $it;
                        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00181(MutableState<PressInteraction.Press> mutableState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super C00181> continuation) {
                            super(2, continuation);
                            this.$pressedInteraction = mutableState;
                            this.$it = j;
                            this.$interactionSource = mutableInteractionSource;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00181(this.$pressedInteraction, this.$it, this.$interactionSource, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
                        /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                            /*
                                r9 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r9.label
                                r2 = 0
                                switch(r1) {
                                    case 0: goto L25;
                                    case 1: goto L1b;
                                    case 2: goto L12;
                                    default: goto La;
                                }
                            La:
                                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r10.<init>(r0)
                                throw r10
                            L12:
                                r0 = r9
                                java.lang.Object r1 = r0.L$0
                                androidx.compose.foundation.interaction.PressInteraction$Press r1 = (androidx.compose.foundation.interaction.PressInteraction.Press) r1
                                kotlin.ResultKt.throwOnFailure(r10)
                                goto L79
                            L1b:
                                r1 = r9
                                r3 = 0
                                java.lang.Object r4 = r1.L$0
                                androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
                                kotlin.ResultKt.throwOnFailure(r10)
                                goto L51
                            L25:
                                kotlin.ResultKt.throwOnFailure(r10)
                                r1 = r9
                                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r3 = r1.$pressedInteraction
                                java.lang.Object r3 = r3.getValue()
                                androidx.compose.foundation.interaction.PressInteraction$Press r3 = (androidx.compose.foundation.interaction.PressInteraction.Press) r3
                                if (r3 == 0) goto L59
                                androidx.compose.foundation.interaction.MutableInteractionSource r4 = r1.$interactionSource
                                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r5 = r1.$pressedInteraction
                                r6 = 0
                                androidx.compose.foundation.interaction.PressInteraction$Cancel r7 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                                r7.<init>(r3)
                                r3 = r7
                                if (r4 == 0) goto L54
                                r7 = r3
                                androidx.compose.foundation.interaction.Interaction r7 = (androidx.compose.foundation.interaction.Interaction) r7
                                r1.L$0 = r5
                                r8 = 1
                                r1.label = r8
                                java.lang.Object r3 = r4.emit(r7, r1)
                                if (r3 != r0) goto L4f
                                return r0
                            L4f:
                                r4 = r5
                                r3 = r6
                            L51:
                                r6 = r3
                                r5 = r4
                            L54:
                                r5.setValue(r2)
                            L59:
                                androidx.compose.foundation.interaction.PressInteraction$Press r3 = new androidx.compose.foundation.interaction.PressInteraction$Press
                                long r4 = r1.$it
                                r3.<init>(r4, r2)
                                r2 = r3
                                androidx.compose.foundation.interaction.MutableInteractionSource r3 = r1.$interactionSource
                                if (r3 == 0) goto L7b
                                r4 = r2
                                androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
                                r5 = r1
                                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                                r1.L$0 = r2
                                r6 = 2
                                r1.label = r6
                                java.lang.Object r3 = r3.emit(r4, r5)
                                if (r3 != r0) goto L77
                                return r0
                            L77:
                                r0 = r1
                                r1 = r2
                            L79:
                                r2 = r1
                                r1 = r0
                            L7b:
                                androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r0 = r1.$pressedInteraction
                                r0.setValue(r2)
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1.AnonymousClass2.AnonymousClass1.C00181.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TextFieldPressGestureFilter.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$2", f = "TextFieldPressGestureFilter.kt", i = {}, l = {Base64.mimeLineLength}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$2, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static final class C00192 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                        final /* synthetic */ boolean $success;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00192(MutableState<PressInteraction.Press> mutableState, boolean z, MutableInteractionSource mutableInteractionSource, Continuation<? super C00192> continuation) {
                            super(2, continuation);
                            this.$pressedInteraction = mutableState;
                            this.$success = z;
                            this.$interactionSource = mutableInteractionSource;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00192(this.$pressedInteraction, this.$success, this.$interactionSource, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00192) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            MutableState<PressInteraction.Press> mutableState;
                            PressInteraction cancel;
                            C00192 c00192;
                            MutableState<PressInteraction.Press> mutableState2;
                            C00192 c001922;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    PressInteraction.Press oldValue = this.$pressedInteraction.getValue();
                                    if (oldValue != null) {
                                        boolean z = this.$success;
                                        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                        mutableState = this.$pressedInteraction;
                                        if (z) {
                                            cancel = new PressInteraction.Release(oldValue);
                                        } else {
                                            cancel = new PressInteraction.Cancel(oldValue);
                                        }
                                        PressInteraction interaction = cancel;
                                        if (mutableInteractionSource != null) {
                                            this.L$0 = mutableState;
                                            this.label = 1;
                                            if (mutableInteractionSource.emit(interaction, this) != coroutine_suspended) {
                                                c00192 = this;
                                                mutableState2 = mutableState;
                                                c001922 = null;
                                                mutableState = mutableState2;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        }
                                        mutableState.setValue(null);
                                    }
                                    return Unit.INSTANCE;
                                case 1:
                                    c00192 = this;
                                    c001922 = null;
                                    mutableState2 = (MutableState) c00192.L$0;
                                    ResultKt.throwOnFailure($result);
                                    mutableState = mutableState2;
                                    mutableState.setValue(null);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object $result) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                anonymousClass1 = this;
                                PressGestureScope $this$detectTapAndPress = (PressGestureScope) anonymousClass1.L$0;
                                long it = anonymousClass1.J$0;
                                BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$scope, null, null, new C00181(anonymousClass1.$pressedInteraction, it, anonymousClass1.$interactionSource, null), 3, null);
                                anonymousClass1.label = 1;
                                Object tryAwaitRelease = $this$detectTapAndPress.tryAwaitRelease(anonymousClass1);
                                if (tryAwaitRelease != coroutine_suspended) {
                                    $result = tryAwaitRelease;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            case 1:
                                ResultKt.throwOnFailure($result);
                                anonymousClass1 = this;
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean success = ((Boolean) $result).booleanValue();
                        BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$scope, null, null, new C00192(anonymousClass1.$pressedInteraction, success, anonymousClass1.$interactionSource, null), 3, null);
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, null);
                            final State<Function1<Offset, Unit>> state = this.$onTapState;
                            this.label = 1;
                            if (TapGestureDetectorKt.detectTapAndPress($this$pointerInput, anonymousClass1, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier.1.2.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m824invokek4lQ0M(offset.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                public final void m824invokek4lQ0M(long it) {
                                    state.getValue().invoke(Offset.m2699boximpl(it));
                                }
                            }, this) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        }, 1, null) : $this$tapPressTextFieldModifier;
    }
}
